package com.thunder.gamehour.config;

import org.springframework.stereotype.Component;
import com.alibaba.fastjson2.JSONObject;
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
	private Session session;

	/**
	 * User Id
	 */
	private String userId;

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
			SystemConst.WEB_SOCKET.add(this);
			SystemConst.SESSION_POOL.put(userId, session);
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
			SystemConst.WEB_SOCKET.remove(this);
			SystemConst.SESSION_POOL.remove(this.userId);
			log.info("[WebSocket] user: " + this.userId + "left");
		} catch (Exception e) {
			log.error("error while" + userId + "trying to leave", e);
		}
	}

	/**
	 * 收到訊息的處理
	 * 
	 * @param userId 用戶ID
	 * @param body   收到的訊息
	 */
	@OnMessage
	public void onMessage(@PathParam("myUserId") String userId, String body) {
		JSONObject jsonObject = JSONObject.parseObject(body);
		jsonObject.put("userId", userId);
		sendOutMessage(JSONObject.toJSONString(jsonObject));
	}

	/**
	 * Sendout Public Message
	 * 
	 * @param message 訊息內容
	 */
	public void sendOutMessage(String message) {
		for (WebSocketServer webSocket : SystemConst.WEB_SOCKET) {
			if (webSocket.session.isOpen()) {
				webSocket.session.getAsyncRemote().sendText(message);
			}
		}

	}
}