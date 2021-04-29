package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.RcpSauce;
import com.ktx.ddep.vo.RcpStep;
@Repository
public class RcpStepsDAOImpl implements RcpStepsDAO{

//	public static List<RcpStep> selectList(int recipeNo) {		
//
//			SqlSession session = null;
//
//			try {
//				session = SqlSessionUtil.getSession();
//				return session.selectList("rcpSteps.selectList", recipeNo);
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				session.close();
//			}
//
//			return null;
//		
//	}//selectList end
//	
//	//0130 방 임저레 연결된 요리순서 삭제
//	public static int deleteTmpRcpSteps(int tmpRcpNo) {
//		
//		SqlSession session = null;
//		try {
//			session=SqlSessionUtil.getSession();
//			return session.delete("rcpSteps.deleteTmpRcpSteps", tmpRcpNo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(session!=null) {
//				session.close();
//			} //if end
//		} //try catch finally
//		return 0;
//	}
	
	//21-02-18 04:46 김
	@Autowired
	private SqlSession session;
	
	//임시저장 레시피 삭제
	@Override
	public int deleteTmpRcpSteps(int tmpRcpNo) {
		return session.delete("rcpSteps.deleteTmpRcpSteps", tmpRcpNo);
	}
	//레시피 상세 요리순서 
	@Override
	public List<RcpStep> selectList(int recipeNo) {
		return session.selectList("rcpSteps.selectList", recipeNo);
	}
	
}//RcpStepsDAO end
