package com.ktx.ddep.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktx.ddep.util.SqlSessionUtil;
import com.ktx.ddep.vo.Member;
import com.ktx.ddep.vo.Question;

@Repository
public class QuestionsDAOImpl implements QuestionsDAO {
	@Autowired
	private SqlSession session;
	
	// 2021-01-24 이소현
	public List<Question> selectQnaList() {
		return session.selectList("questions.selectQnaList");
	}// selectQnaList() end

	// 2021-01-24 이소현
	public int insertQuestion(Question question) {
		return session.insert("questions.insertQuestion", question);
	}// insertQuestion() end

	// 2021-01-24 이소현
	public int deleteQna(int no) {
		return session.delete("questions.deleteQna", no);
	}// deleteQna() end

	// 2021-01-29 00:08 이소현
	public List<Question> selectOneList(int no) {
		return session.selectList("questions.selectOneList", no);
	}// selectOneList() end

}// QuestionsDAO end
