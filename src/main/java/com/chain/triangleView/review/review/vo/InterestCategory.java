package com.chain.triangleView.review.review.vo;

import java.io.Serializable;

public class InterestCategory implements Serializable{
	private int userNo;
	private int categoryCOde;
	
	public InterestCategory() {
		super();
	}

	public InterestCategory(int userNo, int categoryCOde) {
		super();
		this.userNo = userNo;
		this.categoryCOde = categoryCOde;
	}

	public int getUserNo() {
		return userNo;
	}

	public int getCategoryCOde() {
		return categoryCOde;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public void setCategoryCOde(int categoryCOde) {
		this.categoryCOde = categoryCOde;
	}

	@Override
	public String toString() {
		return "InterestCategory [userNo=" + userNo + ", categoryCOde=" + categoryCOde + "]";
	}
	
}
