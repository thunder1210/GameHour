package com.thunder.gamehour.systemconst;

/**
 * 系統常數
 */
public class SystemConst {

	/**
	 * Redis TTL緩存到期時間 (3分鐘)
	 */
	public static final int CACHE_TTL_TIME = 3;

	/**
	 * 限時房間有效時限 (15分鐘 / millisecond)
	 */
	public static final int GAME_ROOM_EFFECTIVE_TIME = 900000;

	/**
	 * 遊戲房間的交換機名稱
	 */
	public static final String GAME_ROOM_EXCHANGE = "GameRoomExchange";

	/**
	 * 遊戲房間的Routing Key
	 */
	public static final String GAME_ROOM_EXCHANGE_ROUTING_KEY = "20241210";

	/**
	 * 限時房間的Dead Letter Routing Key
	 */
	public static final String DEAD_LETTER_ROUTING_KEY = "19911210";

	/**
	 * RabbitMQ 交換機型態
	 */
	public static final String EXCHANGE_TYPE_TOPIC = "topic";
	public static final String EXCHANGE_TYPE_DIRECT = "direct";
	public static final String EXCHANGE_TYPE_FANOUT = "fanOut";

	/**
	 * 空字串
	 */
	public static final String EMPTY_STRING = "";

	/**
	 * 共用時間格式
	 */
	public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * Private Constructor to prevent direct instantiation
	 */
	private SystemConst() {
	}

}
