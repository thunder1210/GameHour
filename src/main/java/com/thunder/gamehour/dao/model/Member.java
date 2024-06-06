package com.thunder.gamehour.dao.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 會員資料
 */
@Getter
@Setter
public class Member {

	/**
	 * 會員ID
	 */
	private Long memberId;

	/**
	 * 會員帳號
	 */
	private String memberAccount;

	/**
	 * 會員Password
	 */
	private String memberPassword;

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
	 * 會員當前所在房間
	 */
	private String memberCurrentRoom;

	/**
	 * 會員喜好遊戲類型
	 */
	private String favoriteGameType;

}
