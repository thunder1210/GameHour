package com.thunder.gamehour.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.thunder.gamehour.dao.model.Member;
import com.thunder.gamehour.dao.model.dto.MemberIntestestedGameDto;
import com.thunder.gamehour.service.MembershipService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

/**
 * 處理會員資料事務的相關API
 */
@RestController
@RequiredArgsConstructor
public class MemberController {

	/**
	 * Service for Member
	 */
	private final MembershipService membershipService;

	/**
	 * 創建新會員
	 * 
	 * @param newMember 新會員資料
	 */
	@PostMapping("/member")
	@Operation(summary = "創建新會員")
	public void createNewMember(@Parameter(description = "註冊填寫的會員資料") @RequestBody Member newMember) {
		membershipService.createNewMember(newMember);
	}

	/**
	 * 查找會員以及喜愛的遊戲和遊戲房
	 * 
	 * @param memberId 會員ID
	 * @return 查詢結果(MemberIntestestedGame物件)
	 */
	@PostMapping("/member/favorite")
	@Operation(summary = "查找會員以及喜愛的遊戲和遊戲房")
	public MemberIntestestedGameDto getMemberWithFavGameAndRoom(
			@Parameter(description = "查找的會員ID") @RequestParam Long memberId) {
		return membershipService.getMemberWithFavGameAndRoom(memberId);
	}

	/**
	 * 查詢正在線上的會員並存入緩存
	 * 
	 * @return 線上會員列表
	 */
	@GetMapping("/member")
	@Operation(summary = "查詢正在線上的會員並存入緩存")
	public List<Member> getOnlineMembers() {
		return membershipService.getOnlineMembers();
	}

	/**
	 * 更新線上會員列表緩存
	 * 
	 * @return 線上會員列表
	 */
	@PutMapping("/member")
	@Operation(summary = "更新線上會員列表緩存")
	public List<Member> updateOnlineMembers() {
		return membershipService.updateOnlineMembers();
	}

}
