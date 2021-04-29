package com.ktx.ddep.dao;

import java.util.List;
import java.util.Map;

import com.ktx.ddep.vo.Sell;

//0218 방

public interface SellsDAO {
	
	//방
	public int insertItem(Sell sell);
	
	//0201경택
	public List<Map<String, Object>> selectSellList(int no);
}
