package com.thunder.gamehour.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thunder.gamehour.dao.model.GameRoom;
import com.thunder.gamehour.dao.model.RoomSearchCondition;
import com.thunder.gamehour.service.GameRoomService;
import com.thunder.gamehour.service.RabbitService;
import com.thunder.gamehour.systemconst.SystemConst;
import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 處理遊戲房間事務的相關API
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class GameRoomController {

	private final RabbitService rabbitService;

	private final GameRoomService gameRoomService;

	/**
	 * 創建遊戲房間
	 * 
	 * @param newGameRoom 遊戲房資料
	 */
	@PostMapping("/gameRoom")
	public void createNewMember(@RequestBody GameRoom newGameRoom) {
		gameRoomService.createGameRoom(newGameRoom);
	}

	/**
	 * 查詢所有線上遊戲房間
	 */
	@GetMapping("/gameRoom")
	public List<GameRoom> getGameRoomWithCondition(@RequestBody RoomSearchCondition roomSearchCondition) {
		return gameRoomService.getGameRoomWithCondition(roomSearchCondition);
	}

	/**
	 * 依照條件搜尋線上房間
	 */
	@PostMapping("/gameRoom/search")
	public List<GameRoom> getAllGameRooms() {
		return gameRoomService.getAllGameRooms();
	}

	/**
	 * 創建限時遊戲房間
	 * 
	 * @param member 限時遊戲房資料
	 */
	@PostMapping("/gameRoom/limited")
	public void createTimeLimitedRoom(@RequestBody GameRoom newGameRoom) {
		gameRoomService.createLimetedGameRoom(newGameRoom);
		try {
			rabbitService.sendOutGameRoomMessage(SystemConst.GAME_ROOM_EXCHANGE,
					SystemConst.GAME_ROOM_EXCHANGE_ROUTING_KEY, newGameRoom);
		} catch (JsonProcessingException e) {
			log.info(e + newGameRoom.toString());
		}
	}

}
