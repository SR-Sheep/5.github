package com.ktx.ddep.dao;

import java.util.List;
import java.util.Map;

//0218 방
public interface TradeDAO {

	/* 02.01_ 오경택 거래되고 있는상품들*/
	public List<Map<String, Object>> selectTradeList(int timeNo); 
	
	
	// 0207 방 거래대기 상품들 (유저가 판매하는 경우)
	public List<Map<String, Object>> selectTradeWaitingAsSeller(int memberNo);
	
	// 0207 방 거래대기 상품들 (유저가 구매하는 경우)
	public List<Map<String, Object>> selectTradeWaitingAsBuyer(int memberNo);
	
	// 0207 방 완료 상품들 (유저가 판매한 경우)
	public List<Map<String, Object>> selectTradeCompleteAsSeller(int memberNo);
			
	// 0207 방 완료 상품들 (유저가 구매한 경우)
	public List<Map<String, Object>> selectTradeCompleteAsBuyer(int memberNo);
}
