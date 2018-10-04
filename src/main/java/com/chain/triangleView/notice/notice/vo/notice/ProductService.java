package com.chain.triangleView.notice.notice.vo.notice;

public class ProductService {
	private int productNo;				//상품코드
	private String productName;			//상품명
	private int serviceNo;				//등록번호
	private int userNo;					//회원번호
	private int serviceType;			//제휴 공고 선택지
	
	public ProductService(){}

	public ProductService(int productNo, String productName, int serviceNo, int userNo, int serviceType) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.serviceNo = serviceNo;
		this.userNo = userNo;
		this.serviceType = serviceType;
	}

	public int getProductNo() {
		return productNo;
	}

	public String getProductName() {
		return productName;
	}

	public int getServiceNo() {
		return serviceNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public int getServiceType() {
		return serviceType;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public String toString() {
		return "ProductService [productNo=" + productNo + ", productName=" + productName + ", serviceNo=" + serviceNo
				+ ", userNo=" + userNo + ", serviceType=" + serviceType + "]";
	}

	
}
