package com.thunder.gamehour.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.thunder.gamehour.dao.model.Member;

/**
 * MyBatis Mapper for Member data operation
 */
@Mapper
public interface MemberMapper {

	/**
	 * 創建新會員
	 * 
	 * @param member 新會員資料
	 */
	void createNewMember(@Param("member") Member member);

	/**
	 * 查詢正在線上的會員
	 * 
	 * @return 線上會員List
	 */
	List<Member> getOnlineMembers();

}
