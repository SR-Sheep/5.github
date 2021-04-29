package com.ktx.ddep.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.Address;
import com.ktx.ddep.vo.Item;

@Repository
public class ItemsDAOImpl implements ItemsDAO{
	@Autowired
	private SqlSession session;
	
	@Override
	public Item selectCheckItem(Item item) {
		return session.selectOne("items.selectCheckItem", item);
	}
	
	@Override
	public int insertItem(Item item) {
		return session.insert("items.insertItem", item);
	}
	
	
	//21-02-05 19:31 이소현 _ 특정 주소를 가진 장터에서 판매되는 재료 리스트 	
	@Override
	public List<Map<String, Object>> selectSellingItemList(Address address) {
		return session.selectList("items.selectSellingItemList", address);
	}
	
}//ItemsDAOImpl end
