package com.thunder.gamehour.config;

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
public class RabbitInitializer {

	private final RabbitService rabbitService;

	/**
	 * Application啟動時自動創建Rabbit Queue
	 */
	@PostConstruct
	public void applicationInit() {
		rabbitService.createExchange(SystemConst.GAME_ROOM_EXCHANGE, SystemConst.EXCHANGE_TYPE_DIRECT);
		rabbitService.createRabbitQueue("tempGameRoomQueue");
		rabbitService.createRabbitQueue("deadLetterGameRoomQueue");
	}

}
