package com.thunder.gamehour.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.thunder.gamehour.dao.model.Game;

/**
 * MyBatis Mapper for Game data operation
 */
@Mapper
public interface GameMapper {

	/**
	 * 依照關鍵字搜尋遊戲
	 * 
	 * @return 搜尋結果
	 */
	List<Game> getGameByName(String keyword);

}
