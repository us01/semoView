package com.chain.triangleView.review.review.vo;

public class CardFormImages {
	private int fileCode;
	private int reviewNo;
	private String fileName;
	private int tableType;
	private int fileSeqNo;
	
	public CardFormImages() {
		super();
	}

	public CardFormImages(int fileCode, int reviewNo, String fileName, int tableType, int fileSeqNo) {
		super();
		this.fileCode = fileCode;
		this.reviewNo = reviewNo;
		this.fileName = fileName;
		this.tableType = tableType;
		this.fileSeqNo = fileSeqNo;
	}

	public int getFileCode() {
		return fileCode;
	}

	public void setFileCode(int fileCode) {
		this.fileCode = fileCode;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getTableType() {
		return tableType;
	}

	public void setTableType(int tableType) {
		this.tableType = tableType;
	}

	public int getFileSeqNo() {
		return fileSeqNo;
	}

	public void setFileSeqNo(int fileSeqNo) {
		this.fileSeqNo = fileSeqNo;
	}

	@Override
	public String toString() {
		return "CardFormImages [fileCode=" + fileCode + ", reviewNo=" + reviewNo + ", fileName=" + fileName
				+ ", tableType=" + tableType + ", fileSeqNo=" + fileSeqNo + "]";
	}
	
}
