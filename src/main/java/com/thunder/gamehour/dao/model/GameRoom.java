package com.thunder.gamehour.dao.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 遊戲房間
 */
@Getter
@Setter
public class GameRoom {

	/**
	 * 遊戲房編號
	 */
	private Long id;

	/**
	 * 遊戲房名稱
	 */
	private String roomName;

	/**
	 * 遊戲名稱
	 */
	private String gameName;

	/**
	 * 房主會員編號
	 */
	private String host;

	/**
	 * 遊戲平台
	 */
	private String platform;

	/**
	 * 限時房間標記
	 */
	private Boolean isTimeLimited;

}
