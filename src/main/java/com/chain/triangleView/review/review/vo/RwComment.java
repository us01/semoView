package com.chain.triangleView.review.review.vo;

import java.io.Serializable;
import java.sql.Date;

public class RwComment implements Serializable{
	private int rwNo;
	private String commentContent;
	private int commentNo;
	private Boolean parentCommentNo;
	private String thumbnail;
	private String rwDate;
	private int userNo;
	private String nick;
	
	public RwComment() {
		super();
	}

	public RwComment(int rwNo, String commentContent, int commentNo, Boolean parentCommentNo, String thumbnail,
			String rwDate, int userNo, String nick) {
		super();
		this.rwNo = rwNo;
		this.commentContent = commentContent;
		this.commentNo = commentNo;
		this.parentCommentNo = parentCommentNo;
		this.thumbnail = thumbnail;
		this.rwDate = rwDate;
		this.userNo = userNo;
		this.nick = nick;
	}

	public int getRwNo() {
		return rwNo;
	}

	public void setRwNo(int rwNo) {
		this.rwNo = rwNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public Boolean getParentCommentNo() {
		return parentCommentNo;
	}

	public void setParentCommentNo(Boolean parentCommentNo) {
		this.parentCommentNo = parentCommentNo;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getRwDate() {
		return rwDate;
	}

	public void setRwDate(String rwDate) {
		this.rwDate = rwDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "RwComment [rwNo=" + rwNo + ", commentContent=" + commentContent + ", commentNo=" + commentNo
				+ ", parentCommentNo=" + parentCommentNo + ", thumbnail=" + thumbnail + ", rwDate=" + rwDate
				+ ", userNo=" + userNo + ", nick=" + nick + "]";
	}
	
}
