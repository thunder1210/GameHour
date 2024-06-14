package com.thunder.gamehour.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.thunder.gamehour.dao.mapper.GameMapper;
import com.thunder.gamehour.dao.model.Game;
import lombok.RequiredArgsConstructor;

/**
 * 處理[遊戲]相關邏輯與資料返回
 */
@Service
@RequiredArgsConstructor
public class GameService {

	/**
	 * Mapper for Game
	 */
	private final GameMapper gameMapper;

	/**
	 * 依照關鍵字搜尋遊戲
	 * 
	 * @param keyword 搜尋內容
	 * @return 搜尋結果
	 */
	public List<Game> getGameByName(String keyword) {
		return gameMapper.getGameByName(keyword);
	}

}
