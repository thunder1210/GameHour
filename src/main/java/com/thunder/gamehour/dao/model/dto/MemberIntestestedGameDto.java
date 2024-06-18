package com.thunder.gamehour.dao.model.dto;

import java.util.List;

import com.thunder.gamehour.dao.model.Game;
import com.thunder.gamehour.dao.model.GameRoom;

import lombok.Getter;
import lombok.Setter;

/**
 * 存取會員所感興趣的所有遊戲以及相關遊戲房
 */
@Getter
@Setter
public class MemberIntestestedGameDto {

	/**
	 * 會員ID
	 */
	private Long memberId;

	/**
	 * 會員性別
	 */
	private String memberGender;

	/**
	 * 會員姓名
	 */
	private String memberName;

	/**
	 * 會員在線狀態
	 */
	private Boolean memberOnlineStatus;

	/**
	 * 會員喜好遊戲類型
	 */
	private String favoriteGameType;

	/**
	 * 會員所感興趣的所有遊戲
	 */
	private List<Game> interestedGames;

	/**
	 * 會員感興趣的遊戲的相關房間
	 */
	private List<GameRoom> interestedGameRooms;

}
