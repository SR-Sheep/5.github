package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.Rcp;
import com.ktx.ddep.vo.RcpRv;
@Repository
public class RcpRvsDAOImpl implements RcpRvsDAO {
	@Autowired
	private SqlSession session;

	// 210129 양 선택된 요리후기 갯수 불러오기
	public int countSelectRv(int no) {
		return session.selectOne("rcpRvs.countSelectRv", no);
	}

	// 방 내가쓴 레시피에 달린 요리후기
	public List<RcpRv> selectRvsToMyRcps(int memberNo) {

		return session.selectList("rcpRvs.selectRvsToMyRcps", memberNo);
	}

	// 방 내가쓴 요리후기
	public List<RcpRv> selectMyRvsToRcps(int memberNo) {

		return session.selectList("rcpRvs.selectMyRvsToRcps", memberNo);

	}

	// 0203 방 요리후기 입력
	public int insertRcpRv(RcpRv rv) {

		return session.insert("rcpRvs.insertRcpRv", rv);
	}

	// 0204 방 레시피에 대한 요리후기 및 평점 가져오기
	public List<RcpRv> selectRvsForRcp(int opensRcpNo) {

		return session.selectList("rcpRvs.selectRvsForRcp", opensRcpNo);

	}

}
