package com.chain.triangleView.notice.notice.vo.notice;

import java.sql.Date;

public class Attachment {
	private int fid;				//primary key
	private int userId;				//올린유저번호
	private String originName;			//원본파일이름
	private String changeName;			//변경된 파일 이름
	private String filePath;			//저장경로
	private Date uploadDate;			//일자
	private String status;				//삭제여부
	private String fileSize;			//사이즈
	private String fileType;			//타입
	private int noticeCode;				//공고코드

	public Attachment(){}

	public Attachment(int fid, int userId, String originName, String changeName, String filePath, Date uploadDate,
			String status, String fileSize, String fileType, int noticeCode) {
		super();
		this.fid = fid;
		this.userId = userId;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.status = status;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.noticeCode = noticeCode;
	}

	public Attachment(int fid, int userId, String originName, String changeName, String filePath, Date uploadDate,
			String status, String fileSize, String fileType) {
		super();
		this.fid = fid;
		this.userId = userId;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.status = status;
		this.fileSize = fileSize;
		this.fileType = fileType;
	}

	public Attachment(int fid, String originName, String changeName, String filePath, Date uploadDate, String status,
			String fileSize, String fileType) {
		super();
		this.fid = fid;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.status = status;
		this.fileSize = fileSize;
		this.fileType = fileType;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getNoticeCode() {
		return noticeCode;
	}

	public void setNoticeCode(int noticeCode) {
		this.noticeCode = noticeCode;
	}

	@Override
	public String toString() {
		return "Attachment [fid=" + fid + ", userId=" + userId + ", originName=" + originName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate + ", status=" + status
				+ ", fileSize=" + fileSize + ", fileType=" + fileType + ", noticeCode=" + noticeCode + "]";
	}
}
