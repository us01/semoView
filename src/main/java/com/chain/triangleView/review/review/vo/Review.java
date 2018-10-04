package com.chain.triangleView.review.review.vo;

import java.sql.Date;

public class Review {
	private String nick;
	private String userId;
	private int todayRwCount;
	private int likeCount;
	private int categoryType;
	private String rwContent;
	private String rwTitle;
	private String modifyYn;
	private String thumbnail;
	private Date modifyDate;
	private Date writerDate;
	private String coorLink;
	private int rwContentType;
	private int rwCount;
	private String rwHash;
	private String rwComment;
	private int rwType;
	private int coorCode;
	private int rwSupport;
	private int rwNo;
	private int rwGrade;
	
	public Review() {
		super();
	}

	public Review(String nick, String userId, int todayRwCount, int likeCount, int categoryType, String rwContent,
			String rwTitle, String modifyYn, String thumbnail, Date modifyDate, Date writerDate, String coorLink,
			int rwContentType, int rwCount, String rwHash, String rwComment, int rwType, int coorCode, int rwSupport,
			int rwNo, int rwGrade) {
		super();
		this.nick = nick;
		this.userId = userId;
		this.todayRwCount = todayRwCount;
		this.likeCount = likeCount;
		this.categoryType = categoryType;
		this.rwContent = rwContent;
		this.rwTitle = rwTitle;
		this.modifyYn = modifyYn;
		this.thumbnail = thumbnail;
		this.modifyDate = modifyDate;
		this.writerDate = writerDate;
		this.coorLink = coorLink;
		this.rwContentType = rwContentType;
		this.rwCount = rwCount;
		this.rwHash = rwHash;
		this.rwComment = rwComment;
		this.rwType = rwType;
		this.coorCode = coorCode;
		this.rwSupport = rwSupport;
		this.rwNo = rwNo;
		this.rwGrade = rwGrade;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTodayRwCount() {
		return todayRwCount;
	}

	public void setTodayRwCount(int todayRwCount) {
		this.todayRwCount = todayRwCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(int categoryType) {
		this.categoryType = categoryType;
	}

	public String getRwContent() {
		return rwContent;
	}

	public void setRwContent(String rwContent) {
		this.rwContent = rwContent;
	}

	public String getRwTitle() {
		return rwTitle;
	}

	public void setRwTitle(String rwTitle) {
		this.rwTitle = rwTitle;
	}

	public String getModifyYn() {
		return modifyYn;
	}

	public void setModifyYn(String modifyYn) {
		this.modifyYn = modifyYn;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Date getWriterDate() {
		return writerDate;
	}

	public void setWriterDate(Date writerDate) {
		this.writerDate = writerDate;
	}

	public String getCoorLink() {
		return coorLink;
	}

	public void setCoorLink(String coorLink) {
		this.coorLink = coorLink;
	}

	public int getRwContentType() {
		return rwContentType;
	}

	public void setRwContentType(int rwContentType) {
		this.rwContentType = rwContentType;
	}

	public int getRwCount() {
		return rwCount;
	}

	public void setRwCount(int rwCount) {
		this.rwCount = rwCount;
	}

	public String getRwHash() {
		return rwHash;
	}

	public void setRwHash(String rwHash) {
		this.rwHash = rwHash;
	}

	public String getRwComment() {
		return rwComment;
	}

	public void setRwComment(String rwComment) {
		this.rwComment = rwComment;
	}

	public int getRwType() {
		return rwType;
	}

	public void setRwType(int rwType) {
		this.rwType = rwType;
	}

	public int getCoorCode() {
		return coorCode;
	}

	public void setCoorCode(int coorCode) {
		this.coorCode = coorCode;
	}

	public int getRwSupport() {
		return rwSupport;
	}

	public void setRwSupport(int rwSupport) {
		this.rwSupport = rwSupport;
	}

	public int getRwNo() {
		return rwNo;
	}

	public void setRwNo(int rwNo) {
		this.rwNo = rwNo;
	}

	public int getRwGrade() {
		return rwGrade;
	}

	public void setRwGrade(int rwGrade) {
		this.rwGrade = rwGrade;
	}

	@Override
	public String toString() {
		return "Review [nick=" + nick + ", userId=" + userId + ", todayRwCount=" + todayRwCount + ", likeCount="
				+ likeCount + ", categoryType=" + categoryType + ", rwContent=" + rwContent + ", rwTitle=" + rwTitle
				+ ", modifyYn=" + modifyYn + ", thumbnail=" + thumbnail + ", modifyDate=" + modifyDate + ", writerDate="
				+ writerDate + ", coorLink=" + coorLink + ", rwContentType=" + rwContentType + ", rwCount=" + rwCount
				+ ", rwHash=" + rwHash + ", rwComment=" + rwComment + ", rwType=" + rwType + ", coorCode=" + coorCode
				+ ", rwSupport=" + rwSupport + ", rwNo=" + rwNo + ", rwGrade=" + rwGrade + "]";
	}

}