package com.thunder.gamehour.comsumer;

import java.util.Map.Entry;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSONObject;
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
	 * @param message
	 */
	@RabbitListener(queues = "webSocketQueue")
	public void listenOnWebScoketQueue1(String message) {
		for (Entry<String, Session> entry : SystemConst.SESSION_POOL.entrySet()) {
			try {
				String processedMessage = message.replace("\\", "");
				JSONObject jsonObject = JSONObject.parseObject(processedMessage);
				entry.getValue().getAsyncRemote().sendText(jsonObject.toString());
				log.info("Hello1");
			} catch (Exception e) {
				log.info("MessageHandler-1 Error happened while handling" + message, e);
			}
		}
	}

	/**
	 * 消費需要發送的WebSocket Message (MessageHandler-2)
	 * 
	 * @param message
	 */
	@RabbitListener(queues = "webSocketQueue")
	public void listenOnWebScoketQueue2(String message) {
		for (Entry<String, Session> entry : SystemConst.SESSION_POOL.entrySet()) {
			try {
				JSONObject jsonObject = JSONObject.parseObject(message.replace("\\", ""));
				entry.getValue().getAsyncRemote().sendText(JSONObject.toJSONString(jsonObject));
				log.info("Hello2");
			} catch (Exception e) {
				log.info("MessageHandler-2 Error happened while handling" + message, e);
			}
		}
	}

	/**
	 * 消費需要發送的WebSocket Message (MessageHandler-3)
	 * 
	 * @param message
	 */
	@RabbitListener(queues = "webSocketQueue")
	public void listenOnWebScoketQueue3(String message) {
		for (Entry<String, Session> entry : SystemConst.SESSION_POOL.entrySet()) {
			try {
				JSONObject jsonObject = JSONObject.parseObject(message.replace("\\", ""));
				entry.getValue().getAsyncRemote().sendText(JSONObject.toJSONString(jsonObject));
				log.info("Hello3");
			} catch (Exception e) {
				log.info("MessageHandler-3 Error happened while handling" + message, e);
			}
		}
	}

}
