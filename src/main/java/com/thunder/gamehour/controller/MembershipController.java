package com.thunder.gamehour.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thunder.gamehour.dao.model.Member;
import com.thunder.gamehour.service.MembershipService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

/**
 * 會員資料可供呼叫的相關API
 */
@RestController
@RequiredArgsConstructor
public class MembershipController {

	private final MembershipService membershipService;

	/**
	 * 創建新會員
	 * 
	 * @param member 新會員資料
	 */
	@PostMapping("/member")
	public void createNewMember(@RequestBody Member newMember) {
		membershipService.createNewMember(newMember);
	}

	/**
	 * 查詢正在線上的會員
	 * 
	 * @return 線上會員List
	 */
	@GetMapping("/member")
	public List<Member> getOnlineMembers() {
		return membershipService.getOnlineMembers();
	}

}
