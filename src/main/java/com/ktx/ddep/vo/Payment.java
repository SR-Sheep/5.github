package com.ktx.ddep.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Payment {


	private int no, marketTimesNo;
	private Date tradeDate;
	private Timestamp regdate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getMarketTimesNo() {
		return marketTimesNo;
	}
	public void setMarketTimesNo(int marketTimesNo) {
		this.marketTimesNo = marketTimesNo;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
}
