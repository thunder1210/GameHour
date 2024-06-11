package com.thunder.gamehour.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.thunder.gamehour.dao.mapper.GameTypeMapper;
import com.thunder.gamehour.dao.model.GameType;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameTypeService {

	private final GameTypeMapper gameTypeMapper;

	/**
	 * 搜尋所有遊戲類型
	 * 
	 * @return 遊戲類型List
	 */
	public List<GameType> getAllGameTypes() {
		return gameTypeMapper.getAllGameTypes();
	}

}
