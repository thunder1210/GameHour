package com.thunder.gamehour.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.thunder.gamehour.dao.mapper.MemberMapper;
import com.thunder.gamehour.dao.model.Member;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembershipService {

	private final MemberMapper memberMapper;

	/**
	 * 創建新會員
	 * 
	 * @param member 新會員資料
	 */
	public void createNewMember(Member member) {
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
