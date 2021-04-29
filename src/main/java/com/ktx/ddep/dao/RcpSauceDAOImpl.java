package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.RcpSauce;
@Repository
public class RcpSauceDAOImpl implements RcpSauceDAO {
	
	@Autowired
	private SqlSession session;

	// 0130 방 임저레 연결된 양념 삭제
	public int deleteTmpRcpSauce(int tmpRcpNo) {

		return session.delete("rcpSauce.deleteTmpRcpSauce", tmpRcpNo);
	}

	public List<RcpSauce> selectList(int recipeNo) {

		return session.selectList("rcpSauce.selectList", recipeNo);

	}// selectList end
}
