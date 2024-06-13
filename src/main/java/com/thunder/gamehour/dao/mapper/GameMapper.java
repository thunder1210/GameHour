package com.thunder.gamehour.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.thunder.gamehour.dao.model.Game;

/**
 * MyBatis Mapper for Game data operation
 */
@Mapper
public interface GameMapper {

	/**
	 * 依照關鍵字搜尋遊戲
	 * 
	 * @param keyword 搜尋內容
	 * @return 搜尋結果
	 */
	List<Game> getGameByName(String keyword);

	/**
	 * 依照會員喜好搜尋遊戲
	 * 
	 * @param favoriteGameType 喜好類型編號
	 * @return 搜尋結果
	 */
	List<Game> getGameByFavoriteType(@Param("favoriteGameType") String favoriteGameType);
}
