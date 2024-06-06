package com.thunder.gamehour.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thunder.gamehour.dao.model.GameRoom;
import com.thunder.gamehour.service.GameRoomService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

/**
 * 遊戲房間可供呼叫的相關API
 */
@RestController
@RequiredArgsConstructor
public class GameRoomController {

	private final GameRoomService gameRoomService;

	/**
	 * 創建遊戲房間
	 * 
	 * @param member 新會員資料
	 */
	@PostMapping("/gameRoom")
	public void createNewMember(@RequestBody GameRoom newGameRoom) {
		gameRoomService.createGameRoom(newGameRoom);
	}

	/**
	 * 查詢所有線上遊戲房間
	 */
	@GetMapping("/gameRoom")
	public List<GameRoom> getAllGameRooms() {
		return gameRoomService.getAllGameRooms();
	}

}
