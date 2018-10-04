package com.chain.triangleView.notice.notice.vo.notice;

import java.util.Date;

public class Notice {

	private int noticeCode;				//공고코드
	private int noticeNo;				//글번호
	private String noticeTitle;			//글제목
	private int noticeWriter;			//작성자
	private Date noticeDate;			//작성일시
	private String noticeContent;		//글내용
	private int categoryCode;			//카테고리코드
	private int noticeCount;			//조회수
	private int deadlinePerson;			//마감인원
	private String productArea;			//상품지역
	private String noticeState;			//공고상태
	private Date noticeStartDate;		//공고시작시간
	private Date noticeEndDate;			//공고종료시간
	private int serviceNo; 				//등록번호
	private String caution;				//주의사항
	private String fileName;			//저장파일이름
	private String categoryCodeName;    //카테고리네임변경
	private int fileSeqNo;              //파일순서
	private int noticeYPerson;		    //공고 선정 인원수
	private String offerProduct;        //제공상품명
	private String productName;         //상품명

	public Notice(){}

	public Notice(int noticeCode, int noticeNo, String noticeTitle, int noticeWriter, Date noticeDate,
			String noticeContent, int categoryCode, int noticeCount, int deadlinePerson, String productArea,
			String noticeState, Date noticeStartDate, Date noticeEndDate, int serviceNo, String caution,
			String fileName, String categoryCodeName, int fileSeqNo, int noticeYPerson, String offerProduct,
			String productName) {
		super();
		this.noticeCode = noticeCode;
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
		this.categoryCode = categoryCode;
		this.noticeCount = noticeCount;
		this.deadlinePerson = deadlinePerson;
		this.productArea = productArea;
		this.noticeState = noticeState;
		this.noticeStartDate = noticeStartDate;
		this.noticeEndDate = noticeEndDate;
		this.serviceNo = serviceNo;
		this.caution = caution;
		this.fileName = fileName;
		this.categoryCodeName = categoryCodeName;
		this.fileSeqNo = fileSeqNo;
		this.noticeYPerson = noticeYPerson;
		this.offerProduct = offerProduct;
		this.productName = productName;
	}

	public int getNoticeCode() {
		return noticeCode;
	}

	public void setNoticeCode(int noticeCode) {
		this.noticeCode = noticeCode;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public int getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(int noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public int getNoticeCount() {
		return noticeCount;
	}

	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}

	public int getDeadlinePerson() {
		return deadlinePerson;
	}

	public void setDeadlinePerson(int deadlinePerson) {
		this.deadlinePerson = deadlinePerson;
	}

	public String getProductArea() {
		return productArea;
	}

	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}

	public String getNoticeState() {
		return noticeState;
	}

	public void setNoticeState(String noticeState) {
		this.noticeState = noticeState;
	}

	public Date getNoticeStartDate() {
		return noticeStartDate;
	}

	public void setNoticeStartDate(Date noticeStartDate) {
		this.noticeStartDate = noticeStartDate;
	}

	public Date getNoticeEndDate() {
		return noticeEndDate;
	}

	public void setNoticeEndDate(Date noticeEndDate) {
		this.noticeEndDate = noticeEndDate;
	}

	public int getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCategoryCodeName() {
		return categoryCodeName;
	}

	public void setCategoryCodeName(String categoryCodeName) {
		this.categoryCodeName = categoryCodeName;
	}

	public int getFileSeqNo() {
		return fileSeqNo;
	}

	public void setFileSeqNo(int fileSeqNo) {
		this.fileSeqNo = fileSeqNo;
	}

	public int getNoticeYPerson() {
		return noticeYPerson;
	}

	public void setNoticeYPerson(int noticeYPerson) {
		this.noticeYPerson = noticeYPerson;
	}

	public String getOfferProduct() {
		return offerProduct;
	}

	public void setOfferProduct(String offerProduct) {
		this.offerProduct = offerProduct;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Notice [noticeCode=" + noticeCode + ", noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle
				+ ", noticeWriter=" + noticeWriter + ", noticeDate=" + noticeDate + ", noticeContent=" + noticeContent
				+ ", categoryCode=" + categoryCode + ", noticeCount=" + noticeCount + ", deadlinePerson="
				+ deadlinePerson + ", productArea=" + productArea + ", noticeState=" + noticeState
				+ ", noticeStartDate=" + noticeStartDate + ", noticeEndDate=" + noticeEndDate + ", serviceNo="
				+ serviceNo + ", caution=" + caution + ", fileName=" + fileName + ", categoryCodeName="
				+ categoryCodeName + ", fileSeqNo=" + fileSeqNo + ", noticeYPerson=" + noticeYPerson + ", offerProduct="
				+ offerProduct + ", productName=" + productName + "]";
	}

}