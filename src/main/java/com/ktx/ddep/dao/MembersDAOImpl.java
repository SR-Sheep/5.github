package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.Address;
import com.ktx.ddep.vo.Member;
import com.ktx.ddep.vo.PageVO;
import com.ktx.ddep.vo.Point;

@Repository
public class MembersDAOImpl implements MembersDAO {
	@Autowired
	private SqlSession session;

	// 20210122 양 전체 랭킹 페이지 처리
	public List<Member> selectTotalRankerList(PageVO PageVO) {
		return session.selectList("members.selectTotalRankerList", PageVO);
	}

	// 20210126 양 주간 랭킹 받아오기
	public List<Member> selectWeeklyRankList(Point point) {
		return session.selectList("members.selectWeeklyRankList", point);
	}

	// 20210122 양 전체 랭킹 페이지처리를 위한 총 member수
	public int selectTotal() {
		return session.selectOne("members.selectTotal");
	}

	// 210125 양 로그인
	public Member selectLogin(Member member) {
		return session.selectOne("members.selectLogin", member);
	}

	// 210127 양 no로 member정보 얻어오기
	public Member selectOne(int no) {
		return session.selectOne("members.selectOne", no);
	}

	// 210127 양 no로 주간 랭킹 정보 얻어오기
	public Member selectWeeklyRankOne(Point point) {
		return session.selectOne("members.selectWeeklyRankOne", point);
	}

	// 210127 양 no로 전체 랭킹 정보 얻어오기
	public Member selectTotalRankerOne(int memberNo) {
		return session.selectOne("members.selectTotalRankerOne", memberNo);
	}

	// 2021-01-23 이소현
	public int selectCheckEmail(String email) {
		return session.selectOne("members.selectCheckEmail", email);
	}// selectCheckEmail() end

	// 2021-01-23 이소현
	public int selectCheckNickname(String nickname) {
		return session.selectOne("members.selectCheckNickname", nickname);
	}// selectCheckNickname() end

	// 2021-01-24 이소현
	public int insertJoinMember(Member member) {
		return session.insert("members.insertJoinMember", member);
	}// insertJoinMember() end

	// 2021-01-31 02:23 이소현
	public List<Address> selectUserLocation(int no) {
		return session.selectList("members.selectUserLocation", no);
	}// selectCheckEmail() end

	/* ■□■□■□■□■□■□ 0202부터 신규 작성 □■□■□■□■□■□■ */

	// 2021-02-02 13:48 양 프로필 이미지 업데이트
	public int updateProfileImg(Member member) {
		return session.update("members.updateProfileImg", member);
	}// updateProfileImg() end

	// 2021-02-02 13:49 양 프로필 기본이미지로 업데이트
	public int updateProfileImgDefault(int no) {
		return session.update("members.updateProfileImgDefault", no);
	}// updateProfileImgDefault() end

	// 2021-02-02 15:11 양 닉네임 변경
	public int updateNickname(Member member) {
		return session.update("members.updateNickname", member);
	}// updateNickname() end
}
