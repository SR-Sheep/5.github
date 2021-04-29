package com.ktx.ddep.dao;

import java.util.List;

import com.ktx.ddep.vo.RcpStep;

public interface RcpStepsDAO {
	
	//21-02-18 04:33 김
	//현수씨 부분 임시저장 레시피 삭제하기
	public int deleteTmpRcpSteps(int tmpRcpNo);
	//상언 부분 레시피 상세페이지 요리순서
	public List<RcpStep> selectList(int recipeNo);

}
