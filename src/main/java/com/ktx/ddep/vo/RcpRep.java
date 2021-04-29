package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class RcpRep {
	//NO	CONTENT	REGDATE	RECIPE_OPEN_NO	
	private int no, recipeOpenNo;
	private String content;
	private Timestamp regdate;
	
	public RcpRep() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRecipeOpenNo() {
		return recipeOpenNo;
	}

	public void setRecipeOpenNo(int recipeOpenNo) {
		this.recipeOpenNo = recipeOpenNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	

}
