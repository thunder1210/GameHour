package com.thunder.gamehour.dao.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameRoom {

	private Long id;

	private String roomName;

	private String gameName;

	private String host;

	private String platform;

	private String member_online_status;

	private String member_current_room;

}
