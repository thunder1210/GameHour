package com.thunder.gamehour.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.thunder.gamehour.dao.model.GameType;

/**
 * MyBatis Mapper for GameType operation
 */
@Mapper
public interface GameTypeMapper {

	/**
	 * 搜尋所有遊戲類型
	 * 
	 * @return 遊戲類型List
	 */
	List<GameType> getAllGameTypes();

}
