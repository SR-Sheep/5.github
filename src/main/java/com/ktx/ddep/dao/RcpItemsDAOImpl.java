package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.RcpItem;

@Repository
public class RcpItemsDAOImpl implements RcpItemsDAO {
	@Autowired
	private SqlSession session;

	// 0130 방 임저레 연결된 재료 삭제
	public int deleteTmpRcpItems(int tmpRcpNo) {
		return session.delete("rcpItems.deleteTmpRcpItems", tmpRcpNo);
	}

	// 김 0201
	public List<RcpItem> selectList(int recipeNo) {
		return session.selectList("rcpItems.selectList", recipeNo);
	}// selectList end

	// 김 0201
	public List<RcpItem> selectItemList(int recipeNo) {
		return session.selectList("rcpItems.selectItemList", recipeNo);
	}// selectList end
}
