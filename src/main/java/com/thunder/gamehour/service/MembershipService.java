package com.thunder.gamehour.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import com.thunder.gamehour.dao.mapper.MemberMapper;
import com.thunder.gamehour.dao.model.Member;
import lombok.RequiredArgsConstructor;

/**
 * 處理會員資料相關邏輯與資料返回
 */
@Service
@RequiredArgsConstructor
public class MembershipService {

	private final MemberMapper memberMapper;

	private static final Random random = new Random();

	/**
	 * 創建新會員
	 * 
	 * @param member 新會員資料
	 */
	public void createNewMember(Member member) {

		if (member.getMemberName() == null || member.getMemberName().isBlank()) {
			member.setMemberName("訪客#".concat(String.valueOf(100000 + random.nextInt(900000))));
		}
		memberMapper.createNewMember(member);
	}

	/**
	 * 查詢正在線上的會員
	 * 
	 * @return 線上會員List
	 */
	public List<Member> getOnlineMembers() {
		return memberMapper.getOnlineMembers();
	}

}
