package com.chain.triangleView.userHome.userHome.vo;

public class HomeReview {
	private String nick;
	private int userNo;
	private int likeCount;
	private String rwTitle;
	private String thumbnail;
	private int rwContentType;
	private int rwCount;
	private int rwType;
	private int rwNo;
	
	public HomeReview() {
		super();
	}

	public HomeReview(String nick, int userNo, int likeCount, String rwTitle, String thumbnail, int rwContentType,
			int rwCount, int rwType, int rwNo) {
		super();
		this.nick = nick;
		this.userNo = userNo;
		this.likeCount = likeCount;
		this.rwTitle = rwTitle;
		this.thumbnail = thumbnail;
		this.rwContentType = rwContentType;
		this.rwCount = rwCount;
		this.rwType = rwType;
		this.rwNo = rwNo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getRwTitle() {
		return rwTitle;
	}

	public void setRwTitle(String rwTitle) {
		this.rwTitle = rwTitle;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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

	public int getRwType() {
		return rwType;
	}

	public void setRwType(int rwType) {
		this.rwType = rwType;
	}

	public int getRwNo() {
		return rwNo;
	}

	public void setRwNo(int rwNo) {
		this.rwNo = rwNo;
	}

	@Override
	public String toString() {
		return "HomeReview [nick=" + nick + ", userNo=" + userNo + ", likeCount=" + likeCount + ", rwTitle=" + rwTitle
				+ ", thumbnail=" + thumbnail + ", rwContentType=" + rwContentType + ", rwCount=" + rwCount + ", rwType="
				+ rwType + ", rwNo=" + rwNo + "]";
	}

}
