package com.ktx.ddep.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Point {

	private int no, memberNo, pointAmount, referenceKey,
				/*210125 양 주간랭킹 처리를 위해 추가함*/sumPoint,rankNum;
	private Date accuUseDate, 
	/* 210124 양 주간 랭킹 처리를 위해 추가함   */startDate, endDate;

	


	private Timestamp regdate;
	private char pointType, pointsStatus;
	
	
	// 0202 방 요리후기 포인트 적립 - 생성자 오버라이딩
		public Point(int memberNo, int referenceKey) {
			super();
			this.memberNo = memberNo;
			this.referenceKey = referenceKey;
		}
	
	public int getSumpoint() {
		return sumPoint;
	}
	public void setSumpoint(int sumpoint) {
		this.sumPoint = sumpoint;
	}
	public int getRankNum() {
		return rankNum;
	}
	public void setRankNum(int rankNum) {
		this.rankNum = rankNum;
	}
	
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
	public int getPointAmount() {
		return pointAmount;
	}
	public void setPointAmount(int pointAmount) {
		this.pointAmount = pointAmount;
	}
	public int getReferenceKey() {
		return referenceKey;
	}
	public void setReferenceKey(int referenceKey) {
		this.referenceKey = referenceKey;
	}
	public Date getAccuUseDate() {
		return accuUseDate;
	}
	public void setAccuUseDate(Date accuUseDate) {
		this.accuUseDate = accuUseDate;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public char getPointType() {
		return pointType;
	}
	public void setPointType(char pointType) {
		this.pointType = pointType;
	}
	public char getPointsStatus() {
		return pointsStatus;
	}
	public void setPointsStatus(char pointsStatus) {
		this.pointsStatus = pointsStatus;
	}
	
	
	public Point() {
	}
	
	/* 210124 양 주간 랭킹 처리를 위해 추가함   */
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Point(String startDate ,String endDate) {
		this.startDate =Date.valueOf(startDate);
		this.endDate =Date.valueOf(endDate);
	}
}
