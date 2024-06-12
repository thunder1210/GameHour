package com.thunder.gamehour.dao.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 遊戲
 */
@Getter
@Setter
public class Game {

	/**
	 * 遊戲ID
	 */
	private Long id;

	/**
	 * 遊戲名稱(中文)
	 */
	private String chnName;

	/**
	 * 遊戲名稱(英文)
	 */
	private String engName;

	/**
	 * 遊戲平台
	 */
	private int platform;

	/**
	 * 發行日期
	 */
	private String releaseDate;

	/**
	 * 遊戲類型
	 */
	private int gameType;
}
