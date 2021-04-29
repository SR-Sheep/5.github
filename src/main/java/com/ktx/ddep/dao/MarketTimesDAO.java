package com.ktx.ddep.dao;

import java.util.List;

import com.ktx.ddep.vo.MarketTime;

public interface MarketTimesDAO {

	
	
	/* 02.01_ 오경택 장터의 시간출력*/
	public List<MarketTime> selectTime(int no);
	
}//MarketTimesDAO end
