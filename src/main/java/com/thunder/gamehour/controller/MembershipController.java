package com.thunder.gamehour.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thunder.gamehour.dao.model.Member;
import com.thunder.gamehour.service.MembershipService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

/**
 * 處理會員資料事務的相關API
 */
@RestController
@RequiredArgsConstructor
public class MembershipController {

	private final MembershipService membershipService;

	/**
	 * 創建新會員
	 * 
	 * @param newMember 新會員資料
	 */
	@PostMapping("/member")
	public void createNewMember(@RequestBody Member newMember) {
		membershipService.createNewMember(newMember);
	}

	/**
	 * 查詢正在線上的會員
	 * 
	 * @return 線上會員列表
	 */
	@GetMapping("/member")
	public List<Member> getOnlineMembers() {
		return membershipService.getOnlineMembers();
	}

	/**
	 * 清除線上會員列表緩存並更新
	 * 
	 * @return 線上會員列表
	 */
	@PutMapping("/member")
	public List<Member> updateOnlineMembers() {
		return membershipService.updateOnlineMembers();
	}

}
