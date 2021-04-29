package com.ktx.ddep.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;

public class MarketTime {

	private int no, memberNo, time;	
	private Timestamp regdate;
	//210129 빠른 시간 포맷을 위한 decimalFormat 선언
	private DecimalFormat df = new DecimalFormat("00");
	
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	public MarketTime() {
		// TODO Auto-generated constructor stub
	}
	
	//210109 양 완전한 시간 형식으로 time get하기
	public String getPerfectTime() {		
		return df.format(time).toString()+":00";
	} 

}
