package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class RcpSauce {	
	
	private int no, recipeNo;
	private String measureCount, sauceName;
	private Timestamp regdate;
	
	public RcpSauce() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRecipeNo() {
		return recipeNo;
	}

	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}

	public String getMeasureCount() {
		return measureCount;
	}

	public void setMeasureCount(String measureCount) {
		this.measureCount = measureCount;
	}

	public String getSauceName() {
		return sauceName;
	}

	public void setSauceName(String sauceName) {
		this.sauceName = sauceName;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
	

}
