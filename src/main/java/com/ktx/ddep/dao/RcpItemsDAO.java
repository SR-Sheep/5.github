package com.ktx.ddep.dao;

import java.util.List;

import com.ktx.ddep.vo.RcpItem;

public interface RcpItemsDAO {
	public int deleteTmpRcpItems(int tmpRcpNo);
	public List<RcpItem> selectList(int recipeNo);
	public List<RcpItem> selectItemList(int recipeNo);
}
