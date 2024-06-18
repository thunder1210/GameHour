package com.thunder.gamehour.systemconst;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import com.thunder.gamehour.websocket.WebSocketServer;

import jakarta.websocket.Session;

/**
 * 系統常數
 */
public class SystemConst {

	// Redis相關 =====================================================

	/**
	 * Redis TTL緩存到期時間 (3分鐘)
	 */
	public static final int CACHE_TTL_TIME = 3;

	// RabbitMQ相關 =====================================================

	/**
	 * 限時房間有效時限 (15分鐘 / millisecond)
	 */
	public static final int GAME_ROOM_EFFECTIVE_TIME = 900000;

	/**
	 * WEB_SOCKET 訊息有效時限 (15分鐘 / millisecond)
	 */
	public static final int WEB_SOCKET_EXPIRE_TIME = 600000;

	/**
	 * WEB_SOCKET 單則訊息大小限制 (10MB)
	 */
	public static final int WEB_SOCKET_BYTE_LENGTH = 10485760;

	/**
	 * 遊戲房間的交換機名稱
	 */
	public static final String GAME_ROOM_EXCHANGE = "GameRoomExchange";

	/**
	 * 分派Websocket的交換機名稱
	 */
	public static final String WEB_SOCKET_EXCHANGE = "WebSocketExchange";

	/**
	 * 遊戲房間的Routing Key
	 */
	public static final String GAME_ROOM_EXCHANGE_ROUTING_KEY = "20241210";

	/**
	 * 限時房間的Dead Letter Routing Key
	 */
	public static final String DEAD_LETTER_ROUTING_KEY = "19911210";

	/**
	 * WebSocket的Routing Key
	 */
	public static final String WEB_SOCKET_ROUTING_KEY = "20240617";

	/**
	 * RabbitMQ 交換機型態
	 */
	public static final String EXCHANGE_TYPE_TOPIC = "topic";
	public static final String EXCHANGE_TYPE_DIRECT = "direct";
	public static final String EXCHANGE_TYPE_FANOUT = "fanOut";

	// WebSocket相關 =====================================================

	/**
	 * WebSocketServer Set
	 */
	public static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

	/**
	 * 與Websocket連線的線上會員
	 */
	public static ConcurrentHashMap<String, Session> sessionPool = new ConcurrentHashMap<String, Session>();

	// 系統共用字串 =====================================================

	/**
	 * 空字串
	 */
	public static final String EMPTY_STRING = "";

	/**
	 * 共用時間格式
	 */
	public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	// prevent direct instantiation ======================================

	/**
	 * Private Constructor to prevent direct instantiation
	 */
	private SystemConst() {
	}

}
