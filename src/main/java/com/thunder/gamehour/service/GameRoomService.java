package com.thunder.gamehour.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.thunder.gamehour.dao.mapper.GameRoomMapper;
import com.thunder.gamehour.dao.mapper.MemberMapper;
import com.thunder.gamehour.dao.model.GameRoom;
import com.thunder.gamehour.dao.model.RoomSearchCondition;
import lombok.RequiredArgsConstructor;

/**
 * 處理遊戲房間相關邏輯與資料返回
 */
@Service
@RequiredArgsConstructor
public class GameRoomService {

	private final MemberMapper memberMapper;

	private final GameRoomMapper gameRoomMapper;

	/**
	 * 創建遊戲房間
	 * 
	 * @param gameRoom 新遊戲房間資料
	 */
	public void createGameRoom(GameRoom gameRoom) {
		gameRoomMapper.createGameRoom(gameRoom);
	}

	/**
	 * 創建限時遊戲房間
	 * 
	 * @param gameRoom 限時遊戲房資料
	 */
	public void createLimitedGameRoom(GameRoom gameRoom) {
		gameRoomMapper.createGameRoom(gameRoom);
		memberMapper.updateMemberCurrentRoomStatus(gameRoom.getId(), gameRoom.getHost());
	}

	/**
	 * 刪除遊戲房間
	 * 
	 * @param gameRoom 遊戲房ID
	 */
	public void deleteRoomByHostAndRoomName(GameRoom gameRoom) {
		gameRoomMapper.deleteRoomByHostAndRoomName(gameRoom);
	}

	/**
	 * 查詢所有線上遊戲房間
	 * 
	 * @return 遊戲房間List
	 */
	public List<GameRoom> getAllGameRooms() {
		return gameRoomMapper.getAllGameRooms();
	}

	/**
	 * 依照條件搜尋線上房間
	 *
	 * @param roomSearchCondition 搜尋條件
	 * @return 遊戲房間查詢結果
	 */
	public List<GameRoom> getGameRoomWithCondition(
			@Param("roomSearchCondition") RoomSearchCondition roomSearchCondition) {
		return gameRoomMapper.getGameRoomWithCondition(roomSearchCondition);
	}

}
