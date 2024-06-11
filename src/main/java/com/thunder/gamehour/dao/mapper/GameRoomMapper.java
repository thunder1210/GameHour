package com.thunder.gamehour.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.thunder.gamehour.dao.model.GameRoom;
import com.thunder.gamehour.dao.model.RoomSearchCondition;

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
	void deleteRoomByHostAndRoomName(@Param("gameRoom") GameRoom gameRoom);

	/**
	 * 查詢所有線上遊戲房間
	 * 
	 * @return 遊戲房間List
	 */
	List<GameRoom> getAllGameRooms();

	/**
	 * 依照條件搜尋線上房間
	 *
	 * @param roomSearchCondition 搜尋條件
	 * @return 遊戲房間查詢結果
	 */
	List<GameRoom> getGameRoomWithCondition(@Param("roomSearchCondition") RoomSearchCondition roomSearchCondition);

}
