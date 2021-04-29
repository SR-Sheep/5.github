package com.ktx.ddep.vo;

import java.util.List;

import com.ktx.ddep.dao.MarketTimesDAO;

//21-02-07 21:14 이소현 _ 장터 select box 결과 값 얻어오려고?
public class MarketList {

	private int marketNo;
	private String name, nickname, profileImg, img, sido, gugun, dong, item;
	private Double serviceIdx, lat, lng;
	private List<MarketTime> times;
	
	public MarketList() {
		// TODO Auto-generated constructor stub
	}
	
	
	//21-02-07 23:35 이소현 _ GetSelectedItemMarket 서블릿에서 이용
	public MarketList(String sido, String gugun, String dong, String item) {
		super();
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.item = item;
	}

	

	public List<MarketTime> getTimes() {
		return times;
	}


	public void setTimes(List<MarketTime> times) {
		this.times = times;
	}


	public int getMarketNo() {
		return marketNo;
	}


	public void setMarketNo(int marketNo) {
		this.marketNo = marketNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public Double getServiceIdx() {
		return serviceIdx;
	}


	public void setServiceIdx(Double serviceIdx) {
		this.serviceIdx = serviceIdx;
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

}//MarketList end
