package com.thunder.gamehour.init;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.thunder.gamehour.dao.model.GameType;
import com.thunder.gamehour.service.GameTypeService;
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

	private final RabbitService rabbitService;

	private final GameTypeService gameTypeService;

	private final RedisTemplate<String, Object> redisTemplate;

	/**
	 * Application啟動時自動創建Rabbit Queue
	 */
	@PostConstruct
	public void applicationInit() {
		rabbitService.createExchange(SystemConst.GAME_ROOM_EXCHANGE, SystemConst.EXCHANGE_TYPE_DIRECT);
		rabbitService.createRabbitQueue("tempGameRoomQueue");
		rabbitService.createRabbitQueue("deadLetterGameRoomQueue");
	}

	/**
	 * Application啟動時創建GamyTypeList
	 */
	@PostConstruct
	public void addGameType() {
		List<GameType> gameTypeList = gameTypeService.getAllGameTypes();
		for (GameType item : gameTypeList) {
			redisTemplate.opsForList().rightPush("gameTypeList", item);
		}
	}

}