package com.chain.triangleView.notice.notice.vo.notice;

public class Application {
	private int noticePCode;
	private int noticeCode;
	private int userNo;
	private String noticeYN;
	private String userId;
	private String nick;
	private String noticeTitle;
	private String OfferProduct;
	private String intro;
	private String fileName;
	
	
	public Application(){}


	
	
	
	
	public Application(int noticePCode, int noticeCode, int userNo, String noticeYN, String userId, String nick,
			String noticeTitle, String offerProduct, String intro, String fileName) {
		super();
		this.noticePCode = noticePCode;
		this.noticeCode = noticeCode;
		this.userNo = userNo;
		this.noticeYN = noticeYN;
		this.userId = userId;
		this.nick = nick;
		this.noticeTitle = noticeTitle;
		OfferProduct = offerProduct;
		this.intro = intro;
		this.fileName = fileName;
	}
	public Application(int noticePCode, int noticeCode, int userNo, String noticeYN, String userId, String nick,
			String noticeTitle, String offerProduct) {
		super();
		this.noticePCode = noticePCode;
		this.noticeCode = noticeCode;
		this.userNo = userNo;
		this.noticeYN = noticeYN;
		this.userId = userId;
		this.nick = nick;
		this.noticeTitle = noticeTitle;
		OfferProduct = offerProduct;
	}






	public int getNoticePCode() {
		return noticePCode;
	}






	public int getNoticeCode() {
		return noticeCode;
	}






	public int getUserNo() {
		return userNo;
	}






	public String getNoticeYN() {
		return noticeYN;
	}






	public String getUserId() {
		return userId;
	}






	public String getNick() {
		return nick;
	}






	public String getNoticeTitle() {
		return noticeTitle;
	}






	public String getOfferProduct() {
		return OfferProduct;
	}






	public String getIntro() {
		return intro;
	}






	public String getFileName() {
		return fileName;
	}






	public void setNoticePCode(int noticePCode) {
		this.noticePCode = noticePCode;
	}






	public void setNoticeCode(int noticeCode) {
		this.noticeCode = noticeCode;
	}






	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}






	public void setNoticeYN(String noticeYN) {
		this.noticeYN = noticeYN;
	}






	public void setUserId(String userId) {
		this.userId = userId;
	}






	public void setNick(String nick) {
		this.nick = nick;
	}






	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}






	public void setOfferProduct(String offerProduct) {
		OfferProduct = offerProduct;
	}






	public void setIntro(String intro) {
		this.intro = intro;
	}






	public void setFileName(String fileName) {
		this.fileName = fileName;
	}






	@Override
	public String toString() {
		return "Application [noticePCode=" + noticePCode + ", noticeCode=" + noticeCode + ", userNo=" + userNo
				+ ", noticeYN=" + noticeYN + ", userId=" + userId + ", nick=" + nick + ", noticeTitle=" + noticeTitle
				+ ", OfferProduct=" + OfferProduct + ", intro=" + intro + ", fileName=" + fileName + "]";
	}


	
}
