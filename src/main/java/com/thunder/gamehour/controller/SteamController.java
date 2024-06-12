package com.thunder.gamehour.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class SteamController {

	private static final String STEAMSPY_API_URL = "https://steamspy.com/api.php?request=top100in2weeks";

	@GetMapping("/topGames")
	public ResponseEntity<String> getTopGames() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(STEAMSPY_API_URL, String.class);
		return ResponseEntity.ok(response);
	}

}
