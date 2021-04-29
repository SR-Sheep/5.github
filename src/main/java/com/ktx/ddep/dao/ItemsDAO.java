package com.ktx.ddep.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.Address;
import com.ktx.ddep.vo.Item;

public interface ItemsDAO {

	public Item selectCheckItem(Item item);
	
	public int insertItem(Item item);

	// 21-02-05 19:31 이소현 _ 특정 주소를 가진 장터에서 판매되는 재료 리스트
	public List<Map<String, Object>> selectSellingItemList(Address address);
	
}//ItemsDAO end 
