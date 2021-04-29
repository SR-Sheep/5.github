package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.Member;
import com.ktx.ddep.vo.PageVO;
import com.ktx.ddep.vo.Point;

@Repository
public class PointsDAOImpl implements PointsDAO {
	@Autowired
	private SqlSession session;

	// 20210124 양 주간 랭킹 처리
	public List<Member> selectWeeklyRankList(Point point) {
		return session.selectList("points.selectWeeklyTotal", point);
	}

	// 21-02-07 12:36 양 포인트 내역 가져오기
	public List<Point> selectList(PageVO pageVO) {
		return session.selectList("points.selectList", pageVO);
	}

	// 0203 방 요리후기 작성 포인트 적립
	public int insertRvPoint(Point point) {
		return session.insert("points.insertRvPoint", point);
	}

}
