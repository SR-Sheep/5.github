package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.RcpRv;
@Repository
public class RcpsOpenDAOImpl implements RcpsOpenDAO {
	@Autowired
	private SqlSession session;

	public List<RcpRv> selectOpenedRcps(int memberNo) {
		return session.selectList("rcpsOpen.selectOpenedRcps", memberNo);
	}

	public RcpRv selectOpenedRcpForRv(RcpRv openedRcp) {

		return session.selectOne("rcpsOpen.selectOpenedRcpForRv", openedRcp);
	}

}
