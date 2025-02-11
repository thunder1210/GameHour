package com.thunder.gamehour.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

/**
 * 處理頁面跳轉相關API
 */
@Controller
@RequiredArgsConstructor
public class PageController {

	/**
	 * 跳轉首頁
	 * 
	 * @return index page
	 */
	@GetMapping("index")
	public String goIndex() {
		return "index";
	}

}
