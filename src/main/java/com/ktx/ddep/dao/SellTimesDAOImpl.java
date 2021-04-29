package com.ktx.ddep.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;

//0218 방
@Repository
public class SellTimesDAOImpl implements SellTimesDAO{
	@Autowired
	private SqlSession session;
	
	// 02.01_ 오경택 승인요청한 판매자들의 정보(프로필 사진, 닉네임)
	@Override
	public List<Map<String, Object>> selectMemberInfoList(int marketNo) {
		return session.selectList("sellTimes.memberInfo",marketNo);
	}
	
	// 02.01_ 오경택 승인요청한 판매자들의 시간표
	@Override
	public List<Map<String, Object>> selectRequestSellTime(Map<String, Object> map) {
		return session.selectList("sellTimes.sellTimeList",map);
	}
		
	// 02.01_ 오경택 판매요청한 아이템
	@Override
	public List<Map<String, Object>> selectRequestSellList(Map<String, Object> map) {
		return session.selectList("sellTimes.requestItemList",map);
	}
	
	
	

}
