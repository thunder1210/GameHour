package com.thunder.gamehour.init;

import org.springframework.stereotype.Component;
import com.thunder.gamehour.service.RabbitService;
import com.thunder.gamehour.systemconst.SystemConst;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

/**
 * RabbitMQ 隊列與交換機啟動初始設置
 */
@Component
@RequiredArgsConstructor
public class RabbitQueueInitializer {

	/**
	 * Service for rabbitMQ
	 */
	private final RabbitService rabbitService;

	/**
	 * Application啟動時自動創建Rabbit Queue
	 */
	@PostConstruct
	public void applicationInit() {

		// 創建處理遊戲房的交換機與Queue
		rabbitService.createExchange(SystemConst.GAME_ROOM_EXCHANGE, SystemConst.EXCHANGE_TYPE_DIRECT);
		rabbitService.createRabbitQueue("tempGameRoomQueue", SystemConst.GAME_ROOM_EXCHANGE);
		rabbitService.createRabbitQueue("deadLetterGameRoomQueue", SystemConst.GAME_ROOM_EXCHANGE);

		// 創建處理Websocket廣播的交換機與Queue
		rabbitService.createExchange(SystemConst.WEB_SOCKET_EXCHANGE, SystemConst.EXCHANGE_TYPE_DIRECT);
		rabbitService.createRabbitQueue("webSocketQueue", SystemConst.WEB_SOCKET_EXCHANGE);
	}

}