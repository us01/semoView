package com.chain.triangleView.pay.pay.vo;

public class Pay {
	private int payCode;	//결제코드
	private int productNo;	//상품번호
	private int userNo;		//회원번호
	private int serviceNo;	//서비스번호
	
	public Pay(){}

	public Pay(int payCode, int productNo, int userNo, int serviceNo) {
		super();
		this.payCode = payCode;
		this.productNo = productNo;
		this.userNo = userNo;
		this.serviceNo = serviceNo;
	}

	public int getPayCode() {
		return payCode;
	}

	public int getProductNo() {
		return productNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public int getServiceNo() {
		return serviceNo;
	}

	public void setPayCode(int payCode) {
		this.payCode = payCode;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}

	@Override
	public String toString() {
		return "Pay [payCode=" + payCode + ", productNo=" + productNo + ", userNo=" + userNo + ", serviceNo="
				+ serviceNo + "]";
	}
	
	
}
