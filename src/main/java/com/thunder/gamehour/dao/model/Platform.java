package com.thunder.gamehour.dao.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 遊戲平台資料
 */
@Getter
@Setter
public class Platform {

	/**
	 * 平台ID
	 */
	private Long id;

	/**
	 * 平台名稱
	 */
	private String name;

	/**
	 * 平台LOGO
	 */
	private String logo;

	/**
	 * 平台啟用狀態
	 */
	private Boolean availability;

}
