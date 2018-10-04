package com.chain.triangleView.review.review.vo;

import java.io.Serializable;

public class Follow implements Serializable{
	private int followUserNo;
	private int followingUserNo;
	
	public Follow() {
		super();
	}

	public Follow(int followUserNo, int followingUserNo) {
		super();
		this.followUserNo = followUserNo;
		this.followingUserNo = followingUserNo;
	}

	public int getFollowUserNo() {
		return followUserNo;
	}

	public int getFollowingUserNo() {
		return followingUserNo;
	}

	public void setFollowUserNo(int followUserNo) {
		this.followUserNo = followUserNo;
	}

	public void setFollowingUserNo(int followingUserNo) {
		this.followingUserNo = followingUserNo;
	}

	@Override
	public String toString() {
		return "Follow [followUserNo=" + followUserNo + ", followingUserNo=" + followingUserNo + "]";
	}
	
}
