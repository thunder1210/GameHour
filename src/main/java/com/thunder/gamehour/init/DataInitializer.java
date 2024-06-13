package com.thunder.gamehour.init;

import java.util.List;
import org.springframework.data.redis.core.RedisTemplate;
import com.thunder.gamehour.dao.model.GameType;
import com.thunder.gamehour.service.GameTypeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

/**
 * 應用啟動的初始資料設定
 */
@RequiredArgsConstructor
public class DataInitializer {

	private final GameTypeService gameTypeService;

	private final RedisTemplate<String, Object> redisTemplate;

	/**
	 * 啟動時創建GamyTypeList
	 */
	@PostConstruct
	public void addGameType() {
		List<GameType> gameTypeList = gameTypeService.getAllGameTypes();
		for (GameType item : gameTypeList) {
			redisTemplate.opsForList().rightPush("gameTypeList", item);
		}
	}

}
