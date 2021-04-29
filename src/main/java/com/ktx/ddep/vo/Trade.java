package com.ktx.ddep.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Trade {

	private int no, priceTotal, qty, buyerNo, paymentNo, sellNo;
	private char status;
	private Timestamp regdate;

	// ===== 0207 방 거래 대기 출력위한 멤버필드 추가 및 getter / setter ==== //

	private int unitPrice, marketNo, marketTime;
	private String sellImg, itemName, itemMeasure, marketName, marketImg;
	private Date tradeDay;

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getMarketNo() {
		return marketNo;
	}

	public void setMarketNo(int marketNo) {
		this.marketNo = marketNo;
	}

	public int getMarketTime() {
		return marketTime;
	}

	public void setMarketTime(int marketTime) {
		this.marketTime = marketTime;
	}

	public String getSellImg() {
		return sellImg;
	}

	public void setSellImg(String sellImg) {
		this.sellImg = sellImg;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemMeasure() {
		return itemMeasure;
	}

	public void setItemMeasure(String itemMeasure) {
		this.itemMeasure = itemMeasure;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketImg() {
		return marketImg;
	}

	public void setMarketImg(String marketImg) {
		this.marketImg = marketImg;
	}

	public Date getTradeDay() {
		return tradeDay;
	}

	public void setTradeDay(Date tradeDay) {
		this.tradeDay = tradeDay;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(int priceTotal) {
		this.priceTotal = priceTotal;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getBuyerNo() {
		return buyerNo;
	}

	public void setBuyerNo(int buyerNo) {
		this.buyerNo = buyerNo;
	}

	public int getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}

	public int getSellNo() {
		return sellNo;
	}

	public void setSellNo(int sellNo) {
		this.sellNo = sellNo;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

}
