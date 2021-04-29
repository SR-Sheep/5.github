package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class ReprMarket {
	
	private int no, reporterNo, tradeNo, suspectNo;
	private String content;
	private Timestamp regdate;
	
	public ReprMarket() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getReporterNo() {
		return reporterNo;
	}

	public void setReporterNo(int reporterNo) {
		this.reporterNo = reporterNo;
	}

	public int getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(int tradeNo) {
		this.tradeNo = tradeNo;
	}

	public int getSuspectNo() {
		return suspectNo;
	}

	public void setSuspectNo(int suspectNo) {
		this.suspectNo = suspectNo;
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
