package com.thunder.gamehour.service;

import java.util.List;
import java.util.Random;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.thunder.gamehour.dao.mapper.MemberMapper;
import com.thunder.gamehour.dao.model.Member;
import com.thunder.gamehour.dao.model.dto.MemberIntestestedGameDto;

import lombok.RequiredArgsConstructor;

/**
 * 處理[會員資料]相關邏輯與資料返回
 */
@Service
@RequiredArgsConstructor
public class MembershipService {

	/**
	 * Mapper for Member
	 */
	private final MemberMapper memberMapper;

	/**
	 * Java randome Number Generater
	 */
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
	 * 查找會員以及喜愛的遊戲和遊戲房
	 * 
	 * @param memberId 會員ID
	 * @return 查詢結果(MemberIntestestedGame物件)
	 */
	public MemberIntestestedGameDto getMemberWithFavGameAndRoom(Long memberId) {
		return memberMapper.getMemberWithFavGameAndRoom(memberId);
	}

	/**
	 * 查詢正在線上的會員並存入緩存
	 * 
	 * @return 線上會員列表
	 */
	@Cacheable(value = "onlineMemberList", keyGenerator = "myKeyGenerator")
	public List<Member> getOnlineMembers() {
		return memberMapper.getOnlineMembers();
	}

	/**
	 * 更新線上會員列表緩存
	 * 
	 * @return 線上會員列表
	 */
	@CachePut(value = "onlineMemberList", keyGenerator = "myKeyGenerator")
	public List<Member> updateOnlineMembers() {
		return memberMapper.getOnlineMembers();
	}

}
