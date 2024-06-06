package com.thunder.gamehour.systemconst;

/**
 * 系統常數
 */
public class SystemConst {

	/**
	 * 緩存到期時間
	 */
	public static final int CACHE_TTL_TIME = 6000000;

	/**
	 * 限時房間有效時限
	 */
	public static final int GAME_ROOM_EFFECTIVE_TIME = 900000;

	/**
	 * 限時房間的Dead Letter Routing Key
	 */
	public static final String DEAD_LETTER_ROUTING_KEY = "19911210";

	/**
	 * 遊戲房間的交換機名稱
	 */
	public static final String GAME_ROOM_EXCHANGE = "GameRoomExchange";

	/**
	 * 遊戲房間的Routing Key
	 */
	public static final String GAME_ROOM_EXCHANGE_ROUTING_KEY = "20241210";

	/**
	 * RabbitMQ 交換機型態
	 */
	public static final String EXCHANGE_TYPE_TOPIC = "topic";
	public static final String EXCHANGE_TYPE_DIRECT = "direct";
	public static final String EXCHANGE_TYPE_FANOUT = "fanOut";

}
