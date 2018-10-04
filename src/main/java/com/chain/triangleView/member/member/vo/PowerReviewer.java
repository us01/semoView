package com.chain.triangleView.member.member.vo;

public class PowerReviewer {
	private int userNo;
	private String searchNum;
	private String reviewCount;
	
	public PowerReviewer(){}

	public PowerReviewer(int userNo, String searchNum, String reviewCount) {
		super();
		this.userNo = userNo;
		this.searchNum = searchNum;
		this.reviewCount = reviewCount;
	}

	public int getuserNo() {
		return userNo;
	}

	public void setuserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getSearchNum() {
		return searchNum;
	}

	public void setSearchNum(String searchNum) {
		this.searchNum = searchNum;
	}

	public String getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(String reviewCount) {
		this.reviewCount = reviewCount;
	}

	@Override
	public String toString() {
		return "powerReviewer [userNo=" + userNo + ", searchNum=" + searchNum + ", reviewCount=" + reviewCount + "]";
	}
	
	
}
