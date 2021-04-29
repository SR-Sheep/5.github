package com.ktx.ddep.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Sell {
	private int no,qty,minQty,maxPrice,itemNo,sellerNo;
	private String receiptImg;
	private char confirmStatus;
	private Date purchaseDatem,sellByDate;
	private Timestamp regdate;
	//0217 방  판매 번호가 판매이미지 등록 및 판매 시간대 등록 위해 sellNo 선언
		private int sellNo;
	
	public Sell() {
		// TODO Auto-generated constructor stub
	}
	
	public Sell(int qty, int minQty, int maxPrice, int itemNo, String receiptImg) {
		super();
		this.qty = qty;
		this.minQty = minQty;
		this.maxPrice = maxPrice;
		this.itemNo = itemNo;
		this.receiptImg = receiptImg;
	}
	
	
	
	public int getSellNo() {
		return sellNo;
	}

	public void setSellNo(int sellNo) {
		this.sellNo = sellNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getMinQty() {
		return minQty;
	}

	public void setMinQty(int minQty) {
		this.minQty = minQty;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getSellerNo() {
		return sellerNo;
	}

	public void setSellerNo(int sellerNo) {
		this.sellerNo = sellerNo;
	}

	public String getReceiptImg() {
		return receiptImg;
	}

	public void setReceiptImg(String receiptImg) {
		this.receiptImg = receiptImg;
	}

	public char getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(char confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public Date getPurchaseDatem() {
		return purchaseDatem;
	}

	public void setPurchaseDatem(Date purchaseDatem) {
		this.purchaseDatem = purchaseDatem;
	}

	public Date getSellByDate() {
		return sellByDate;
	}

	public void setSellByDate(Date sellByDate) {
		this.sellByDate = sellByDate;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
}
