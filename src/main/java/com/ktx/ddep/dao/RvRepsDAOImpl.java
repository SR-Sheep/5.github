package com.ktx.ddep.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.RvRep;
@Repository
public class RvRepsDAOImpl implements RvRepsDAO{

	
//	public static int insertReport(RvRep rvRep) {
//		
//		SqlSession session = null;
//	
//		try {
//			session = SqlSessionUtil.getSession();
//			return session.insert("rvReps.insertRvReps", rvRep);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
//					
//		return 0;
//	}
	
	//21-02-18 04:57 김 요리후기 신고하기
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertRvReps(RvRep rvRep) {
		
		return session.insert("rvReps.insertRvReps", rvRep);
	}
	
	
}
