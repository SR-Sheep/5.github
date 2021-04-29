package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.PageVO;
import com.ktx.ddep.vo.Rcp;
@Repository
public class RcpsSavedDAOImpl implements RcpsSavedDAO{
	
	
	//21-02-08 06:42 양 스크랩수 불러오기
//	public static int count(int no) {
//		SqlSession session = null;
//		try {
//			session = SqlSessionUtil.getSession();
//			return session.selectOne("rcpsSaved.count",no);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
//		return 0;
//	}
	
	
	//21-02-18 04:28 김 - 양 스크랩수 불러오기 스프링 전환
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int count(int no) {
		return session.selectOne("rcpsSaved.count", no);
	}
	

}
