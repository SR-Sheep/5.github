package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class Question {

	private int no, memberNo, questionKind;
	//2021-01-24 이소현 (regdate 자료형 변경)
	private String title, content, status, regdate;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	//문의 등록
	//2021-01-27 10:44 이소현 수정
	public Question(int memberNo, int questionKind, String title, String content) {
		this.memberNo = memberNo;
		this.questionKind = questionKind;
		this.title = title;
		this.content = content;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getQuestionKind() {
		return questionKind;
	}
	public void setQuestionKind(int questionKind) {
		this.questionKind = questionKind;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	//2021-01-24 이소현
	public String getRegdate() {
		return regdate;
	}
	//2021-01-24 이소현
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
