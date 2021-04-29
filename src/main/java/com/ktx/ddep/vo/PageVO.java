package com.ktx.ddep.vo;

public class PageVO {
	
	private int start, end, memberNo;
	//21-02-13 15:58 양 키워드로 레시피 목록 검색을 위한 선언
	private String keyword;
	//21-02-13 16:27 양 필터로 레시피 정렬을 위한 선언
	private String choice;
	
	
	//21-02-05 23:50 양 포인트 목록을 들고 오기 위해 선언
	private char pointsStatus;
	
	public PageVO() {
		// TODO Auto-generated constructor stub
	}

	public PageVO(int pageNo, int numPage) {
		this.end = pageNo*numPage;
		this.start = end - numPage + 1; 
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public char getPointsStatus() {
		return pointsStatus;
	}

	public void setPointsStatus(char pointsStatus) {
		this.pointsStatus = pointsStatus;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}
	
	
	
	
	
	
	
	
	

}
