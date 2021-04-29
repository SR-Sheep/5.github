package com.ktx.ddep.dao;

import java.util.List;

import com.ktx.ddep.vo.RcpSauce;

public interface RcpSauceDAO {

	// 0130 방 임저레 연결된 양념 삭제
	public int deleteTmpRcpSauce(int tmpRcpNo);

	public List<RcpSauce> selectList(int recipeNo);

}
