package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.SellImg;
@Repository
public class SellImgsDAOImpl implements SellImgsDAO{

//	// 0207 방 판매 이미지 불러오기
//	public static List<SellImg> selectSellImgs(int sellNo) {
//		
//		SqlSession session = null;
//	
//		try {
//			session = SqlSessionUtil.getSession();
//			return session.selectList("sellImgs.selectSellImgs", sellNo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
//					
//		return null;
//	}
//	
//	public static int insertSellImgs(SellImg sellImg) {
//		
//		SqlSession session = null;
//		
//		try {
//			session = SqlSessionUtil.getSession();
//			return session.insert("sellImgs.insertSellImgs", sellImg);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}
//		
//		return 0;
//	}
	
	//21-02-18 05:03 김
	@Autowired
	private SqlSession session;
	
	//21-02-18 05:03 김
	//방 판매 이미지 입력
	@Override
	public int insertSellImgs(SellImg sellImg) {
		return session.insert("sellImgs.insertSellImgs", sellImg);
	}
	//21-02-18 05:03 김
	@Override
	public SellImg selectSellImgs(int sellNo) {
	return session.selectOne("sellImgs.selectSellImgs", sellNo);
	}
	
}
