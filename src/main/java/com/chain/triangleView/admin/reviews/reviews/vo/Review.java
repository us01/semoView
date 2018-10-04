package com.chain.triangleView.admin.reviews.reviews.vo;

import java.sql.Date;

public class Review {
	
	private int userNo;
	private int rwNo;
	private int categoryType;
	private int rwCount;
	private int rwcontentType;
	private int rwType;
	private Date writedate;
	private int rwLike;
	private Date cancleDate;
	private String cancleReason;
	
	public Review(){}

	
	
	public Review(int userNo, int rwNo, int categoryType, int rwCount, int rwcontentType, int rwType, Date writedate,
			int rwLike, Date cancleDate, String cancleReason) {
		super();
		this.userNo = userNo;
		this.rwNo = rwNo;
		this.categoryType = categoryType;
		this.rwCount = rwCount;
		this.rwcontentType = rwcontentType;
		this.rwType = rwType;
		this.writedate = writedate;
		this.rwLike = rwLike;
		this.cancleDate = cancleDate;
		this.cancleReason = cancleReason;
	}



	public Review(int userNo, int rwNo, int categoryType, int rwCount, int rwcontentType, int rwType, Date writedate,
			int rwLike) {
		super();
		this.userNo = userNo;
		this.rwNo = rwNo;
		this.categoryType = categoryType;
		this.rwCount = rwCount;
		this.rwcontentType = rwcontentType;
		this.rwType = rwType;
		this.writedate = writedate;
		this.rwLike = rwLike;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getRwNo() {
		return rwNo;
	}

	public void setRwNo(int rwNo) {
		this.rwNo = rwNo;
	}

	public int getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(int categoryType) {
		this.categoryType = categoryType;
	}

	public int getRwCount() {
		return rwCount;
	}

	public void setRwCount(int rwCount) {
		this.rwCount = rwCount;
	}

	public int getRwcontentType() {
		return rwcontentType;
	}

	public void setRwcontentType(int rwcontentType) {
		this.rwcontentType = rwcontentType;
	}

	public int getRwType() {
		return rwType;
	}

	public void setRwType(int rwType) {
		this.rwType = rwType;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public int getRwLike() {
		return rwLike;
	}

	public void setRwLike(int rwLike) {
		this.rwLike = rwLike;
	}
	

	public Date getCancleDate() {
		return cancleDate;
	}



	public void setCancleDate(Date cancleDate) {
		this.cancleDate = cancleDate;
	}



	public String getCancleReason() {
		return cancleReason;
	}



	public void setCancleReason(String cancleReason) {
		this.cancleReason = cancleReason;
	}



	@Override
	public String toString() {
		return "Review [userNo=" + userNo + ", rwNo=" + rwNo + ", categoryType=" + categoryType + ", rwCount=" + rwCount
				+ ", rwcontentType=" + rwcontentType + ", rwType=" + rwType + ", writedate=" + writedate + ", rwLike="
				+ rwLike + ", cancleDate=" + cancleDate + ", cancleReason=" + cancleReason + "]";
	}
	
	
	
	

}
