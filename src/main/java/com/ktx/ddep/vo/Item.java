package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class Item {

	private int no;
	private String name;
	private Timestamp regdate;
	private char measure;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public char getMeasure() {
		return measure;
	}

	public void setMeasure(char measure) {
		this.measure = measure;
	}
	
	public Item(String name, char measure) {
		super();
		this.name = name;
		this.measure = measure;
	}
	
}//Item end