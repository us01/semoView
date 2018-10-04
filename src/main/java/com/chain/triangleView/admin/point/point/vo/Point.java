package com.chain.triangleView.admin.point.point.vo;


public class Point {
	
	private int payBackCode;
	private int userNo;
	private String requestDate;
	private int requestPay;
	private String payBackDate;
	private int userLevel;
	private int myPoint;
	private int payPoint;
	
	public Point(){}

	public Point(int payBackCode, int userNo, String requestDate, int requestPay, String payBackDate, int userLevel,
			int myPoint, int payPoint) {
		super();
		this.payBackCode = payBackCode;
		this.userNo = userNo;
		this.requestDate = requestDate;
		this.requestPay = requestPay;
		this.payBackDate = payBackDate;
		this.userLevel = userLevel;
		this.myPoint = myPoint;
		this.payPoint = payPoint;
	}

	public int getPayBackCode() {
		return payBackCode;
	}

	public void setPayBackCode(int payBackCode) {
		this.payBackCode = payBackCode;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public int getRequestPay() {
		return requestPay;
	}

	public void setRequestPay(int requestPay) {
		this.requestPay = requestPay;
	}

	public String getPayBackDate() {
		return payBackDate;
	}

	public void setPayBackDate(String payBackDate) {
		this.payBackDate = payBackDate;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	public int getMyPoint() {
		return myPoint;
	}

	public void setMyPoint(int myPoint) {
		this.myPoint = myPoint;
	}

	public int getPayPoint() {
		return payPoint;
	}

	public void setPayPoint(int payPoint) {
		this.payPoint = payPoint;
	}

	@Override
	public String toString() {
		return "Point [payBackCode=" + payBackCode + ", userNo=" + userNo + ", requestDate=" + requestDate
				+ ", requestPay=" + requestPay + ", payBackDate=" + payBackDate + ", userLevel=" + userLevel
				+ ", myPoint=" + myPoint + ", payPoint=" + payPoint + "]";
	}
	
	
	
	
	
	
	
	

}
