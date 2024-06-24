package com.thunder.gamehour.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thunder.gamehour.dao.model.GameRoom;
import com.thunder.gamehour.dao.model.dto.SearchRoomConditionDto;
import com.thunder.gamehour.service.GameRoomService;
import com.thunder.gamehour.service.RabbitService;
import com.thunder.gamehour.systemconst.SystemConst;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 處理遊戲房間事務的相關API
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class GameRoomController {

	/**
	 * Service for rabbitMQ
	 */
	private final RabbitService rabbitService;

	/**
	 * Service for GameRoom
	 */
	private final GameRoomService gameRoomService;

	/**
	 * 創建遊戲房間
	 * 
	 * @param newGameRoom 遊戲房資料
	 */
	@PostMapping("/gameRoom")
	@Operation(summary = "創建遊戲房間")
	public void createNewMember(@Parameter(description = "新房間的創建資料") @RequestBody GameRoom newGameRoom) {
		gameRoomService.createGameRoom(newGameRoom);
	}

	/**
	 * 查詢所有線上遊戲房間
	 */
	@GetMapping("/gameRoom")
	@Operation(summary = "查詢所有線上遊戲房間")
	public List<GameRoom> getAllGameRooms() {
		return gameRoomService.getAllGameRooms();
	}

	/**
	 * 依照條件搜尋線上房間
	 */
	@PostMapping("/gameRoom/search")
	@Operation(summary = "依照條件搜尋線上房間")
	public List<GameRoom> getGameRoomWithCondition(
			@Parameter(description = "需查詢的條件") @RequestBody SearchRoomConditionDto roomSearchCondition) {
		return gameRoomService.getGameRoomWithCondition(roomSearchCondition);
	}

	/**
	 * 創建限時遊戲房間
	 * 
	 * @param newGameRoom 限時遊戲房資料
	 */
	@PostMapping("/gameRoom/limited")
	@Operation(summary = "創建限時遊戲房間")
	public void createTimeLimitedRoom(@Parameter(description = "限時房間的創建資料") @RequestBody GameRoom newGameRoom) {
		gameRoomService.createLimitedGameRoom(newGameRoom);
		try {
			rabbitService.sendOutGameRoomMessage(SystemConst.GAME_ROOM_EXCHANGE,
					SystemConst.GAME_ROOM_EXCHANGE_ROUTING_KEY, newGameRoom);
		} catch (JsonProcessingException e) {
			log.info("Json processing error when create time-limited Room", e, newGameRoom.toString());
		}
	}

}
