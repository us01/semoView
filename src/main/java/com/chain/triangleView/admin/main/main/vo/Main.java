package com.chain.triangleView.admin.main.main.vo;

public class Main {
	
	private int likeNum;
	private int dailyCount;
	private int dailyRwCount;
	private int joinCount;
	
	public Main(){}

	public Main(int likeNum, int dailyCount, int dailyRwCount, int joinCount) {
		super();
		this.likeNum = likeNum;
		this.dailyCount = dailyCount;
		this.dailyRwCount = dailyRwCount;
		this.joinCount = joinCount;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public int getDailyCount() {
		return dailyCount;
	}

	public void setDailyCount(int dailyCount) {
		this.dailyCount = dailyCount;
	}

	public int getDailyRwCount() {
		return dailyRwCount;
	}

	public void setDailyRwCount(int dailyRwCount) {
		this.dailyRwCount = dailyRwCount;
	}

	public int getJoinCount() {
		return joinCount;
	}

	public void setJoinCount(int joinCount) {
		this.joinCount = joinCount;
	}

	@Override
	public String toString() {
		return "Main [likeNum=" + likeNum + ", dailyCount=" + dailyCount + ", dailyRwCount=" + dailyRwCount
				+ ", joinCount=" + joinCount + "]";
	}
	
	
	
	

}
