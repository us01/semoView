package com.chain.triangleView.review.review.vo;

import java.io.Serializable;

public class Form implements Serializable{
	private String rwContent;
	private String writeDate;
	private String rwComment; 
	private String rwTitle;
	private int rwLikeCount;
	private String coorLink;
	private String thumbnail;
	private int likeMe;
	private int rwGrade;
	private int rwType;
	private int rwCount;
	private String rwHash;
	private String nick;
	private int rwNo;
	private int rwContentType;
	private int rwSupport;
	
	public Form() {
		super();
	}

	public Form(String rwContent, String writeDate, String rwComment, String rwTitle, int rwLikeCount, String coorLink,
			String thumbnail, int likeMe, int rwGrade, int rwType, int rwCount, String rwHash, String nick, int rwNo,
			int rwContentType, int rwSupport) {
		super();
		this.rwContent = rwContent;
		this.writeDate = writeDate;
		this.rwComment = rwComment;
		this.rwTitle = rwTitle;
		this.rwLikeCount = rwLikeCount;
		this.coorLink = coorLink;
		this.thumbnail = thumbnail;
		this.likeMe = likeMe;
		this.rwGrade = rwGrade;
		this.rwType = rwType;
		this.rwCount = rwCount;
		this.rwHash = rwHash;
		this.nick = nick;
		this.rwNo = rwNo;
		this.rwContentType = rwContentType;
		this.rwSupport = rwSupport;
	}

	public String getRwContent() {
		return rwContent;
	}

	public void setRwContent(String rwContent) {
		this.rwContent = rwContent;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getRwComment() {
		return rwComment;
	}

	public void setRwComment(String rwComment) {
		this.rwComment = rwComment;
	}

	public String getRwTitle() {
		return rwTitle;
	}

	public void setRwTitle(String rwTitle) {
		this.rwTitle = rwTitle;
	}

	public int getRwLikeCount() {
		return rwLikeCount;
	}

	public void setRwLikeCount(int rwLikeCount) {
		this.rwLikeCount = rwLikeCount;
	}

	public String getCoorLink() {
		return coorLink;
	}

	public void setCoorLink(String coorLink) {
		this.coorLink = coorLink;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getLikeMe() {
		return likeMe;
	}

	public void setLikeMe(int likeMe) {
		this.likeMe = likeMe;
	}

	public int getRwGrade() {
		return rwGrade;
	}

	public void setRwGrade(int rwGrade) {
		this.rwGrade = rwGrade;
	}

	public int getRwType() {
		return rwType;
	}

	public void setRwType(int rwType) {
		this.rwType = rwType;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getRwNo() {
		return rwNo;
	}

	public void setRwNo(int rwNo) {
		this.rwNo = rwNo;
	}

	public int getRwContentType() {
		return rwContentType;
	}

	public void setRwContentType(int rwContentType) {
		this.rwContentType = rwContentType;
	}

	public int getRwSupport() {
		return rwSupport;
	}

	public void setRwSupport(int rwSupport) {
		this.rwSupport = rwSupport;
	}

	@Override
	public String toString() {
		return "Form [rwContent=" + rwContent + ", writeDate=" + writeDate + ", rwComment=" + rwComment + ", rwTitle="
				+ rwTitle + ", rwLikeCount=" + rwLikeCount + ", coorLink=" + coorLink + ", thumbnail=" + thumbnail
				+ ", likeMe=" + likeMe + ", rwGrade=" + rwGrade + ", rwType=" + rwType + ", rwCount=" + rwCount
				+ ", rwHash=" + rwHash + ", nick=" + nick + ", rwNo=" + rwNo + ", rwContentType=" + rwContentType
				+ ", rwSupport=" + rwSupport + "]";
	}
	
}
