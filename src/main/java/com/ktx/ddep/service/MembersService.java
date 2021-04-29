package com.ktx.ddep.service;

import java.util.Map;

import com.ktx.ddep.vo.Address;
import com.ktx.ddep.vo.Member;

public interface MembersService {

	// 유저 정보 받아오기
	public Map<String, Object> userInfo(int no);

	// 로그인 하기
	public Member login(Member member);

	// 프로필 사진 변경
	public int changeProfile(Member member);

	// 주간랭킹
	public Map<String, Object> weeklyRanking(Member loginMember);
	
	//전체랭킹
	public Map<String, Object> totalRanking(Member loginMember, int page);

	// 닉네임 변경
	public int changeNickname(Member member);

	// 닉네임 체크
	public boolean checkNickname(String nickname);

	// 주소 변경
	public void changeAddress(Address address);

}