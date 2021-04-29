package com.ktx.ddep.dao;

import java.util.List;

import com.ktx.ddep.vo.RcpRv;

public interface RcpsOpenDAO {
	
	public List<RcpRv> selectOpenedRcps(int memberNo);
	public RcpRv selectOpenedRcpForRv(RcpRv openedRcp);

}
