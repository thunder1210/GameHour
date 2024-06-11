package com.thunder.gamehour.dao.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 遊戲類型
 */
@Getter
@Setter
public class GameType {

	/**
	 * 遊戲類型ID
	 */
	private Long id;

	/**
	 * 遊戲類型名稱(中文)
	 */
	private String typeNameChn;

	/**
	 * 遊戲類型名稱(英文)
	 */
	private String typeNameEng;

}
