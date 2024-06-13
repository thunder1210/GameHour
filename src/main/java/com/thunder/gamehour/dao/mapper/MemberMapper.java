package com.thunder.gamehour.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.thunder.gamehour.dao.model.Member;
import com.thunder.gamehour.dao.model.dto.MemberIntestestedGame;

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
	 * 更新會員所在的遊戲房間狀態
	 * 
	 * @param roomNumber 房間號碼
	 * @param memberId   會員ID
	 */
	void updateMemberCurrentRoomStatus(@Param("roomNumber") String roomNumber, @Param("memberId") int memberId);

	/**
	 * 查詢正在線上的會員
	 * 
	 * @return 線上會員List
	 */
	List<Member> getOnlineMembers();

	/**
	 * 查找會員以及喜愛的遊戲和遊戲房
	 * 
	 * @param memberId 會員ID
	 * @return 查詢結果(MemberIntestestedGame物件)
	 */
	MemberIntestestedGame getMemberWithFavGameAndRoom(@Param("memberId") Long memberId);

}
