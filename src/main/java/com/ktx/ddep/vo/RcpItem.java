package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class RcpItem {
	
	private int no,itemNo,recipeNo,count,price;
	private Timestamp regdate;
	//김 재료 이름
	private String name;
	//김 재료 단위
	private char measure;
	
	public char getMeasure() {
		return measure;
	}

	public void setMeasure(char measure) {
		this.measure = measure;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RcpItem() {
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getRecipeNo() {
		return recipeNo;
	}

	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	

}
