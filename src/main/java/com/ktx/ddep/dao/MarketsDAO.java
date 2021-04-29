package com.ktx.ddep.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.Market;
import com.ktx.ddep.vo.MarketList;

public interface MarketsDAO {

	// 210127 양 no로 마켓 정보 얻어오기
	public Market selectOne(int memberNo);

	/* 02.01_ 오경택 해당마켓 정보출력 */
	public Map<String, Object> selectMarket(int no);

	// 21-02-02 18:08 이소현
	public Map<String, Object> selectUserLocationMarkets(int no);

	// 21-02-10 01:03 수정 _resultType=hashmap으로 / 21-02-07 23:25 이소현 _ 재료 선택 후 나타나는장터 목록
	public List<Map<String, Object>> selectSelectedItemMarketList(MarketList marketList);

}// MarketsDAO end