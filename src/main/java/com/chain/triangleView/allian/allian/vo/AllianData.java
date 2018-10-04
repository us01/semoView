package com.chain.triangleView.allian.allian.vo;

import java.util.Date;

public class AllianData {
	private String rwTitle;	//제휴걸린 리뷰제목
	private int rwCount;	//제휴걸린 리뷰 조회수
	private Date coorStart;	//제휴 시작날짜
	private Date coorEnd;	//제휴 마감날짜
	private int coorCode;	//제휴 코드
	private String coorLink;//제휴 링크
	private int serviceNo;	//서비스넘버
	private String userId;	//제휴 리뷰 글쓴이 아이디
	private String nick;	//제휴 리뷰 글쓴 닉네임
	private int likeCount;	//제휴 리뷰 좋아요수
	
	public AllianData(){}

	public AllianData(String rwTitle, int rwCount, Date coorStart, Date coorEnd, int coorCode, String coorLink,
			int serviceNo, String userId, String nick, int likeCount) {
		super();
		this.rwTitle = rwTitle;
		this.rwCount = rwCount;
		this.coorStart = coorStart;
		this.coorEnd = coorEnd;
		this.coorCode = coorCode;
		this.coorLink = coorLink;
		this.serviceNo = serviceNo;
		this.userId = userId;
		this.nick = nick;
		this.likeCount = likeCount;
	}

	public String getRwTitle() {
		return rwTitle;
	}

	public int getRwCount() {
		return rwCount;
	}

	public Date getCoorStart() {
		return coorStart;
	}

	public Date getCoorEnd() {
		return coorEnd;
	}

	public int getCoorCode() {
		return coorCode;
	}

	public String getCoorLink() {
		return coorLink;
	}

	public int getServiceNo() {
		return serviceNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getNick() {
		return nick;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setRwTitle(String rwTitle) {
		this.rwTitle = rwTitle;
	}

	public void setRwCount(int rwCount) {
		this.rwCount = rwCount;
	}

	public void setCoorStart(Date coorStart) {
		this.coorStart = coorStart;
	}

	public void setCoorEnd(Date coorEnd) {
		this.coorEnd = coorEnd;
	}

	public void setCoorCode(int coorCode) {
		this.coorCode = coorCode;
	}

	public void setCoorLink(String coorLink) {
		this.coorLink = coorLink;
	}

	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	@Override
	public String toString() {
		return "AllianData [rwTitle=" + rwTitle + ", rwCount=" + rwCount + ", coorStart=" + coorStart + ", coorEnd="
				+ coorEnd + ", coorCode=" + coorCode + ", coorLink=" + coorLink + ", serviceNo=" + serviceNo
				+ ", userId=" + userId + ", nick=" + nick + ", likeCount=" + likeCount + "]";
	}
	
	
}