package com.chain.triangleView.admin.payment.payment.vo;

import java.sql.Date;
import java.sql.ResultSet;

public class Payment {
	
	private String payDetailCode;
	private String copName;
	private int userNo;
	private int serviceType;
	private int money;
	private int payType;
	private String payDate;
	private int payStatus;
	private int sumpay;
	

	public Payment(){}
	
	

	public int getSumpay() {
		return sumpay;
	}



	public void setSumpay(int sumpay) {
		this.sumpay = sumpay;
	}



	public Payment(String payDetailCode, String copName, int userNo, int serviceType, int money, int payType, String payDate,
			int payStatus, int sumpay) {
		super();
		this.payDetailCode = payDetailCode;
		this.copName = copName;
		this.userNo = userNo;
		this.serviceType = serviceType;
		this.money = money;
		this.payType = payType;
		this.payDate = payDate;
		this.payStatus = payStatus;
		this.sumpay = sumpay;
	}



	public Payment(String payDetailCode, String copName, int userNo, int serviceType, int money, int payType, String payDate,
			int payStatus) {
		super();
		this.payDetailCode = payDetailCode;
		this.copName = copName;
		this.userNo = userNo;
		this.serviceType = serviceType;
		this.money = money;
		this.payType = payType;
		this.payDate = payDate;
		this.payStatus = payStatus;
	}

	public String getPayDetailCode() {
		return payDetailCode;
	}

	public void setPayDetailCode(String payDetailCode) {
		this.payDetailCode = payDetailCode;
	}

	public String getCopName() {
		return copName;
	}

	public void setCopName(String copName) {
		this.copName = copName;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPayType() {
		return payType;
	}

	public void setPayType(int payType) {
		this.payType = payType;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	@Override
	public String toString() {
		return "Payment [payDetailCode=" + payDetailCode + ", copName=" + copName + ", userNo=" + userNo
				+ ", serviceType=" + serviceType + ", money=" + money + ", payType=" + payType + ", payDate=" + payDate
				+ ", payStatus=" + payStatus + ", sumpay=" + sumpay + "]";
	}

	


	
	
	
	
	
	
	
	
	
	
	
	

}
