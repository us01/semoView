package com.chain.triangleView.admin.member.vo;

import java.sql.Date;

public class BlackMember {
	
	
	private int blackCode;
	private int userNo;
	private String blackReason;
	private Date blackTime;
	private int rwNo;
	private int commentNo;
	private String phone;
	private String nick;
	
	public BlackMember(){}

	public BlackMember(int blackCode, int userNo, String blackReason, Date blackTime, int rwNo, int commentNo,
			String phone, String nick) {
		super();
		this.blackCode = blackCode;
		this.userNo = userNo;
		this.blackReason = blackReason;
		this.blackTime = blackTime;
		this.rwNo = rwNo;
		this.commentNo = commentNo;
		this.phone = phone;
		this.nick = nick;
	}

	public int getBlackCode() {
		return blackCode;
	}

	public void setBlackCode(int blackCode) {
		this.blackCode = blackCode;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getBlackReason() {
		return blackReason;
	}

	public void setBlackReason(String blackReason) {
		this.blackReason = blackReason;
	}

	public Date getBlackTime() {
		return blackTime;
	}

	public void setBlackTime(Date blackTime) {
		this.blackTime = blackTime;
	}

	public int getRwNo() {
		return rwNo;
	}

	public void setRwNo(int rwNo) {
		this.rwNo = rwNo;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "BlackMember [blackCode=" + blackCode + ", userNo=" + userNo + ", blackReason=" + blackReason
				+ ", blackTime=" + blackTime + ", reNo=" + rwNo + ", commentNo=" + commentNo + ", phone=" + phone
				+ ", nick=" + nick + "]";
	}

	
	
	
	
	

}
