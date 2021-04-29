package com.ktx.ddep.dao;

import java.util.List;

import com.ktx.ddep.vo.Question;

public interface QuestionsDAO {
	public List<Question> selectQnaList();
	public int insertQuestion(Question question);
	public int deleteQna(int no);
	public List<Question> selectOneList(int no);
}
