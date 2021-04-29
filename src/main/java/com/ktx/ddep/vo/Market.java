package com.ktx.ddep.vo;

import java.sql.Timestamp;
import java.util.List;

public class Market {

	private int memberNo, addressNo;
	private String name, img;
	private Double serviceIdx;
	private Timestamp regdate;
	
	//21-02-05 19:05 이소현 _ ============추가====================
		private List<MarketTime> marketTimes;	
		
		
	public List<MarketTime> getMarketTimes() {
			return marketTimes;
		}

		public void setMarketTimes(List<MarketTime> marketTimes) {
			this.marketTimes = marketTimes;
		}

	public Market() {
		// TODO Auto-generated constructor stub
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
}//Market end
