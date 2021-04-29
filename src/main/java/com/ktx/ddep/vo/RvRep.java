package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class RvRep {	
	private int no,reviewNo,type;
	private String content;
	private Timestamp regDate;
	
	public RvRep(int reviewNo, int type, String content) {
		super();
		this.reviewNo = reviewNo;
		this.type = type;
		this.content = content;
	}

	public RvRep() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
}
