package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ktx.ddep.vo.Member;
import com.ktx.ddep.vo.PageVO;
import com.ktx.ddep.vo.Point;

public interface PointsDAO {
	public List<Member> selectWeeklyRankList(Point point);
	public List<Point> selectList(PageVO pageVO);
	public int insertRvPoint(Point point);
}
