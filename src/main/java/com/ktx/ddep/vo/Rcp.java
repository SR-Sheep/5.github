package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class Rcp {
	
	private int no,memberNo,rcpsAvg, viewCount,
				scrapCount,//21-02-08 06:38 양 스크랩수 추가
				itemCount;//21-02-09 10:09 양 재료수 추가				
	private String title,img,content,ribbonItem;					
	private Timestamp regdate;
	private char status;
	// 방,김 내가 쓴 레시피에서 내 정보 출력..
    private String nickname, profileImg;
    
    //김
    private int price;
        
    // 0204 방 요리후기 업데이트 위한 생성자
   	public Rcp(int no, int rcpsAvg) {
   		super();
   		this.no = no;
   		this.rcpsAvg = rcpsAvg;
   	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getRcpsAvg() {
		return rcpsAvg;
	}

	public void setRcpsAvg(int rcpsAvg) {
		this.rcpsAvg = rcpsAvg;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Rcp() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getRibbonItem() {
		return ribbonItem;
	}

	public void setRibbonItem(String ribbonItem) {
		this.ribbonItem = ribbonItem;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getScrapCount() {
		return scrapCount;
	}

	public void setScrapCount(int scrapCount) {
		this.scrapCount = scrapCount;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	
	

}
