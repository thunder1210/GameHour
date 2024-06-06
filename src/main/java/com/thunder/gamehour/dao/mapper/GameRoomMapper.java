package com.thunder.gamehour.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.thunder.gamehour.dao.model.GameRoom;

/**
 * MyBatis Mapper for GameRoom operation
 */
@Mapper
public interface GameRoomMapper {

	/**
	 * 創建遊戲房間
	 * 
	 * @param gameRoom 遊戲房間資料
	 */
	void createGameRoom(@Param("gameRoom") GameRoom gameRoom);

	/**
	 * 刪除遊戲房間
	 * 
	 * @param gameRoom 遊戲房ID
	 */
	void deleteGameRoom(@Param("gameRoomId") int gameRoomId);

	/**
	 * 查詢所有線上遊戲房間
	 * 
	 * @return 遊戲房間List
	 */
	List<GameRoom> getAllGameRooms();

}
