package com.thunder.gamehour.comsumer;

import java.util.Map.Entry;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thunder.gamehour.systemconst.SystemConst;

import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Consumer from WebSocket RabbitMQ queue
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketComsumer {

	/**
	 * 消費需要發送的WebSocket Message (MessageHandler-1)
	 * 
	 * @param message 存放在佇列中的訊息
	 */
	@RabbitListener(queues = "webSocketQueue")
	public void listenOnWebSocketQueue1(String message) {
		for (Entry<String, Session> entry : SystemConst.sessionPool.entrySet()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				mapper.readValue(message, String.class);
				entry.getValue().getAsyncRemote().sendText(mapper.readValue(message, String.class));
			} catch (Exception e) {
				log.info("MessageHandler-1 Error happened while handling" + message, e);
			}
		}
	}

	/**
	 * 消費需要發送的WebSocket Message (MessageHandler-2)
	 * 
	 * @param message 存放在佇列中的訊息
	 */
	@RabbitListener(queues = "webSocketQueue")
	public void listenOnWebSocketQueue2(String message) {
		for (Entry<String, Session> entry : SystemConst.sessionPool.entrySet()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				mapper.readValue(message, String.class);
				entry.getValue().getAsyncRemote().sendText(mapper.readValue(message, String.class));
			} catch (Exception e) {
				log.info("MessageHandler-1 Error happened while handling" + message, e);
			}
		}
	}

	/**
	 * 消費需要發送的WebSocket Message (MessageHandler-3)
	 * 
	 * @param message 存放在佇列中的訊息
	 */
	@RabbitListener(queues = "webSocketQueue")
	public void listenOnWebSocketQueue3(String message) {
		for (Entry<String, Session> entry : SystemConst.sessionPool.entrySet()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				mapper.readValue(message, String.class);
				entry.getValue().getAsyncRemote().sendText(mapper.readValue(message, String.class));
			} catch (Exception e) {
				log.info("MessageHandler-1 Error happened while handling" + message, e);
			}
		}
	}
}
