package com.ktx.ddep.vo;

import java.sql.Timestamp;

public class Address {

	private int no;
	private String sido, gugun, dong, detailAddress;
	private Double lat, lng;
	private Timestamp regdate;
	

	public Address() {
		// TODO Auto-generated constructor stub
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getSido() {
		return sido;
	}


	public void setSido(String sido) {
		this.sido = sido;
	}


	public String getGugun() {
		return gugun;
	}


	public void setGugun(String gugun) {
		this.gugun = gugun;
	}


	public String getDong() {
		return dong;
	}


	public void setDong(String dong) {
		this.dong = dong;
	}


	public String getDetailAddress() {
		return detailAddress;
	}


	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}


	public Double getLat() {
		return lat;
	}


	public void setLat(Double lat) {
		this.lat = lat;
	}


	public Double getLng() {
		return lng;
	}


	public void setLng(Double lng) {
		this.lng = lng;
	}


	public Timestamp getRegdate() {
		return regdate;
	}


	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	//210127 양 전체 주소 불러오기 함수
	public String getTotalAddress(){
		//21-02-04 gugun이 null일 경우 추가 
		if(getGugun()!=null) {
			return getSido()+" "+getGugun()+" "+getDong()+" "+getDetailAddress();
		}else {
			return getSido()+" "+getDong()+" "+getDetailAddress();
		}//if else end
	}
	
	//2021-01-23 이소현
		//회원가입 할 때, 필요
		public Address(String sido, String gugun, String dong, Double lat, Double lng) {

			this.sido = sido;
			this.gugun = gugun;
			this.dong = dong;
			this.lat = lat;
			this.lng = lng;
		}
		//21-02-01 23:33 이소현 _ GetDongList servlet 에서 사용
		public Address(String sido, String gugun) {
			this.sido = sido;
			this.gugun = gugun;
		}
		
		//21-02-03 16:20 이소현 _ GetMarketList servlet 에서 사용
		public Address(String sido, String gugun, String dong) {
			this.sido = sido;
			this.gugun = gugun;
			this.dong = dong;
		}
	
	
}//Address end
