package com.ktx.ddep.dao;

import java.util.List;
import java.util.Map;


//0218 방
public interface SellTimesDAO {
	// 02.01_ 오경택 승인요청한 판매자들의 정보(프로필 사진, 닉네임)
	public List<Map<String, Object>> selectMemberInfoList(int marketNo);
	
	// 02.01_ 오경택 승인요청한 판매자들의 시간표
	public List<Map<String, Object>> selectRequestSellTime(Map<String, Object> map) ;
	
	// 02.01_ 오경택 판매요청한 아이템
	public List<Map<String, Object>> selectRequestSellList(Map<String, Object> map);
	
}
