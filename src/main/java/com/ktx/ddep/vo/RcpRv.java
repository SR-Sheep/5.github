package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class RcpRv {

	private int no, rcpsOpenNo;
	private String img, content;
	private char rate;
	private Timestamp regdate;

	// 열람레시피 테이블과 조인 위한 멤버필드(후기 작성자 번호로 마이페이지 이동 및 레시피 번호)
	private int reviewerNo, rcpNo;

	// 레시피 정보 출력 위해 레시피 테이블과 조인
	private String rcpTitle, rcpImg, rcpContent;

	// 후기 작성자 정보 얻어오기 위해 회원 테이블과 조인 (내가 쓴 레시피에 달린 후기)
	private String reviewerNickname, reviewerProfileImg;

	// 레시피 작성자 정보 얻어오기 (내가 쓴 요리후기)
	private String writerNickname, writerProfileImg;

	// 0202 방 wrtierNo가 String으로 선언되어 있어서 int로 바꿈
	private int writerNo;

	// 0202 방 요리후기 쓰기 위한 레시피 정보를 불러오기 위해 멤버필드 선언.
	// 굳이 안만들어도 되지만 의미 전달을 명확히 하기 위해서 다 만듬
	private int openedRcpNo, memberNo;

	// 0202 방 위 내용 해당하는 생성자 오버로딩
	public RcpRv(int openedRcpNo, int memberNo) {
		super();
		this.openedRcpNo = openedRcpNo;
		this.memberNo = memberNo;
	}

	public int getWriterNo() {
		return writerNo;
	}

	public void setWriterNo(int writerNo) {
		this.writerNo = writerNo;
	}

	public int getOpenedRcpNo() {
		return openedRcpNo;
	}

	public void setOpenedRcpNo(int openedRcpNo) {
		this.openedRcpNo = openedRcpNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getWriterNickname() {
		return writerNickname;
	}

	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}

	public String getWriterProfileImg() {
		return writerProfileImg;
	}

	public void setWriterProfileImg(String writerProfileImg) {
		this.writerProfileImg = writerProfileImg;
	}

	public int getReviewerNo() {
		return reviewerNo;
	}

	public String getReviewerProfileImg() {
		return reviewerProfileImg;
	}

	public void setReviewerProfileImg(String reviewerProfileImg) {
		this.reviewerProfileImg = reviewerProfileImg;
	}

	public void setReviewerNo(int reviewerNo) {
		this.reviewerNo = reviewerNo;
	}

	public int getRcpNo() {
		return rcpNo;
	}

	public void setRcpNo(int rcpNo) {
		this.rcpNo = rcpNo;
	}

	public String getRcpTitle() {
		return rcpTitle;
	}

	public void setRcpTitle(String rcpTitle) {
		this.rcpTitle = rcpTitle;
	}

	public String getRcpImg() {
		return rcpImg;
	}

	public void setRcpImg(String rcpImg) {
		this.rcpImg = rcpImg;
	}

	public String getRcpContent() {
		return rcpContent;
	}

	public void setRcpContent(String rcpContent) {
		this.rcpContent = rcpContent;
	}

	public String getReviewerNickname() {
		return reviewerNickname;
	}

	public void setReviewerNickname(String reviewerNickname) {
		this.reviewerNickname = reviewerNickname;
	}

	public RcpRv() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getRcpsOpenNo() {
		return rcpsOpenNo;
	}

	public void setRcpsOpenNo(int rcpsOpenNo) {
		this.rcpsOpenNo = rcpsOpenNo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public char getRate() {
		return rate;
	}

	public void setRate(char rate) {
		this.rate = rate;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

}
