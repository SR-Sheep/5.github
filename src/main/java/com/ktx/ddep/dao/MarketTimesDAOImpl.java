package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.MarketTime;
@Repository
public class MarketTimesDAOImpl implements MarketTimesDAO{
	
	@Autowired
	private SqlSession session;

	/* 02.01_ 오경택 장터의 시간출력*/
	@Override
	public List<MarketTime> selectTime(int no) {
		return session.selectList("marketTimes.time",no);
	}

}//MarketTimesDAO end
