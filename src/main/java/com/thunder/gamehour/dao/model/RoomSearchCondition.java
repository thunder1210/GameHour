package com.thunder.gamehour.dao.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 遊戲房間條件搜尋物件
 */
@Getter
@Setter
public class RoomSearchCondition {

	/**
	 * 遊戲房間類型 (一般房/限時房/全部)
	 */
	private Boolean gameRoomType;

	/**
	 * 搜尋條件1
	 */
	private String searchCondition1;

	/**
	 * 搜尋條件2
	 */
	private String searchCondition2;

	/**
	 * 搜尋條件3
	 */
	private String searchCondition3;

	/**
	 * 搜尋條件4
	 */
	private String searchCondition4;

	/**
	 * 搜尋條件5
	 */
	private String searchCondition5;
}
