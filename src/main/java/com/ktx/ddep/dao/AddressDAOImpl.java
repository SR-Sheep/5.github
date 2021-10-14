package com.ktx.ddep.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.Address;

@Repository
public class AddressDAOImpl implements AddressDAO {
	@Autowired
	private SqlSession session;

	// 210127 양 no로 address 정보 얻어오기
	@Override
	public Address selectOne(int no) {
		return session.selectOne("address.selectOne", no);
	}

	// 2021-01-24 이소현
	@Override
	public int insertAddress(Address address) {

		return session.insert("address.insertAddress", address);
	}

	// 2021-02-03 17:55 양 주소 업데이트
	@Override
	public int updateAddress(Address address) {
		return session.update("address.updateAddress", address);
	}

	// 21-02-02 이소현
	@Override
	public List<String> selectSidoList() {

		return session.selectList("address.selectSidoList");
	}

	// 21-02-02 이소현
	@Override
	public List<String> selectGugunList(String sido) {

		return session.selectList("address.selectGugunList", sido);
	}

	// 21-02-02 이소현
	@Override
	public List<String> selectDongList(Address address) {

		return session.selectList("address.selectDongList", address);
	}

	// 2021-02-03 21:36 이소현 _
	@Override
	public List<Map<String, Object>> selectSelectedLocationdMarketLsit(Address address) {

		return session.selectList("address.selectSelectedLocationdMarketLsit", address);
	}

}//AddressDAOImpl end
