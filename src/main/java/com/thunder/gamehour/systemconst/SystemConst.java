package com.thunder.gamehour.systemconst;

import java.time.Duration;

/**
 * 系統常數
 */
public class SystemConst {

	/**
	 * 緩存到期時間 (15分鐘 / millisecond)
	 */
	public static final int CACHE_TTL_TIME = 900000;

	/**
	 * 線上會員列表緩存時間 (3分鐘)
	 */
	public static final Duration ONLINE_MEMBER_LIST_CACHE_TIME = Duration.ofMinutes(3);

	/**
	 * 限時房間有效時限 (15分鐘 / millisecond)
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

	/**
	 * 空字串
	 */
	public static final String EMPTY_STRING = "";

}
