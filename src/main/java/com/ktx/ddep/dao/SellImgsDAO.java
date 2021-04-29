package com.ktx.ddep.dao;

import com.ktx.ddep.vo.SellImg;

public interface SellImgsDAO {
	
	//21-02-18 04:59 김
	//누구 파트인지 모르겠음.
	public SellImg selectSellImgs(int sellNo);
	
	//21-02-18 04:59 김
	//(방 판매 이미지 입력)
	public int insertSellImgs(SellImg sellImg);

}
