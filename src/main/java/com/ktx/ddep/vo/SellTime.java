package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class SellTime {
	private int no,marketTimeNo,sellNo;
	private Timestamp regdate;
	
	public SellTime() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getMarketTimeNo() {
		return marketTimeNo;
	}

	public void setMarketTimeNo(int marketTimeNo) {
		this.marketTimeNo = marketTimeNo;
	}

	public int getSellNo() {
		return sellNo;
	}

	public void setSellNo(int sellNo) {
		this.sellNo = sellNo;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
}
