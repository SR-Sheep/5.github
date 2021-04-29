package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class Grade {

	private int no;
	private char grade;
	private Timestamp regdate;
	
	public Grade() {
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
}//Grade end
