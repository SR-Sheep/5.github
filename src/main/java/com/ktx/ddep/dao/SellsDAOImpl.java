package com.ktx.ddep.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.Sell;


// 0218 방 
@Repository
public class SellsDAOImpl implements SellsDAO {
	@Autowired
	private SqlSession session;
	
	//방 판매등록
	@Override
	public int insertItem(Sell sell) {
		return session.insert("sells.insertSellItems", sell);
	}
	
	@Override
	public List<Map<String, Object>> selectSellList(int no) {
		return session.selectList("sells.sellList", no);
	}
	
}
