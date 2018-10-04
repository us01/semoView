package com.chain.triangleView.member.member.vo;

import java.io.Serializable;

public class MemberInterestCategory implements Serializable{
	private int categoryCode;

	public MemberInterestCategory() {
		super();
	}

	public MemberInterestCategory(int categoryCode) {
		super();
		this.categoryCode = categoryCode;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	@Override
	public String toString() {
		return "MemberInterestCategory [categoryCode=" + categoryCode + "]";
	};
	
}
