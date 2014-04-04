package org.common.persistence.domain;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 7396225630320437819L;
	
	// Basic field
	private Integer userId;
	private String account;
	private String password;
	private Integer totalMoney;
	private Integer stockMoney;
	private Integer totalCharge;
	private Integer buyCount;
	private Integer sellCount;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Integer getStockMoney() {
		return stockMoney;
	}

	public void setStockMoney(Integer stockMoney) {
		this.stockMoney = stockMoney;
	}

	public Integer getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(Integer totalCharge) {
		this.totalCharge = totalCharge;
	}

	public Integer getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}

	public Integer getSellCount() {
		return sellCount;
	}

	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}

}