package com.thunder.gamehour.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.thunder.gamehour.service.GameRoomService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GameRoomComsumer {

	private final GameRoomService gameRoomService;

	/**
	 * 死信佇列：當收到Message時刪除已失效的限時遊戲房間
	 * 
	 * @param message 遊戲房ID
	 */
	@RabbitListener(queues = "deadLetterGameRoomQueue")
	public void listenRedQueue(String message) {
		gameRoomService.deleteGameRoom(Integer.valueOf(message));
	}

}
