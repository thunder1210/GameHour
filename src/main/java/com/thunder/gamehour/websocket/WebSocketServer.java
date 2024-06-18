package com.thunder.gamehour.websocket;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.thunder.gamehour.service.RabbitService;
import com.thunder.gamehour.systemconst.SystemConst;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@ServerEndpoint("/webSocketServer/{myUserId}")
public class WebSocketServer {

	/**
	 * 與Client的連接對話
	 */
	@SuppressWarnings("unused")
	private Session session;

	/**
	 * User Id
	 */
	private String userId;

	/**
	 * Service for rabbitMQ
	 */
	private static RabbitService rabbitService;


	/**
	 * WebSocket開啟連線
	 * 
	 * @param session 連線的Session會話
	 * @param userId  User ID
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam("myUserId") String userId) {
		try {
			this.session = session;
			this.userId = userId;
			SystemConst.webSocketSet.add(this);
			SystemConst.sessionPool.put(userId, session);
			log.info("[WebSocket] user: " + userId + "joined");
		} catch (Exception e) {
			log.error("error while" + userId + "trying to join", e);
		}
	}

	/**
	 * WebSocket連線關閉
	 */
	@OnClose
	public void onClose() {
		try {
			SystemConst.webSocketSet.remove(this);
			SystemConst.sessionPool.remove(this.userId);
			log.info("[WebSocket] user: " + this.userId + "left");
		} catch (Exception e) {
			log.error("error while" + userId + "trying to leave", e);
		}
	}

	/**
	 * 收到訊息的處理
	 * 
	 * @param body   收到的訊息
	 */
	@OnMessage
	public void onMessage(String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		jsonObject.put("userId", userId);
		try {
			rabbitService.sendOutWebSocketMessage(SystemConst.WEB_SOCKET_EXCHANGE, SystemConst.WEB_SOCKET_ROUTING_KEY,
					jsonObject.toString());
		} catch (JsonProcessingException e) {
			log.info("Json processing error when create time-limited Room", e, body);
		}
	}

}