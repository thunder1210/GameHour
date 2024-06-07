package com.thunder.gamehour.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thunder.gamehour.dao.model.GameRoom;
import com.thunder.gamehour.service.GameRoomService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Comsumer from RabbitMQ queue
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class GameRoomComsumer {

	private final ObjectMapper objectMapper;

	private final GameRoomService gameRoomService;

	/**
	 * [deadLetterGameRoomQueue佇列]
	 * 
	 * 當收到Message時，刪除已過期的限時遊戲房間
	 * 
	 * @param message 遊戲房ID
	 */
	@RabbitListener(queues = "deadLetterGameRoomQueue")
	public void listenRedQueue(String message) {
		try {
			gameRoomService.deleteRoomByHostAndRoomName(objectMapper.readValue(message, GameRoom.class));
		} catch (JsonProcessingException e) {
			log.info(e + message);
		}
	}

}
