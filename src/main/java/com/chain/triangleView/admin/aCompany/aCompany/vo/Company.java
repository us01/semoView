package com.chain.triangleView.admin.aCompany.aCompany.vo;

import java.sql.Date;

public class Company {
	
	private int userNo;
	private String userId;
	private String comName;
	private String pName;
	private int noCode;
	private String phone;
	private Date enroll_date;
	private Date notice_date;
	private Date withdraw_date;
	
	
	
	public Company(){}
	
	


	public Date getWithdraw_date() {
		return withdraw_date;
	}




	public void setWithdraw_date(Date withdraw_date) {
		this.withdraw_date = withdraw_date;
	}




	public Company(int userNo, String userId, String comName, String pName, int noCode, String phone, Date enroll_date,
			Date notice_date, Date withdraw_date) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.comName = comName;
		this.pName = pName;
		this.noCode = noCode;
		this.phone = phone;
		this.enroll_date = enroll_date;
		this.notice_date = notice_date;
		this.withdraw_date = withdraw_date;
	}




	public Company(int userNo, String userId, String comName, String pName, int noCode, String phone, Date enroll_date,
			Date notice_date) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.comName = comName;
		this.pName = pName;
		this.noCode = noCode;
		this.phone = phone;
		this.enroll_date = enroll_date;
		this.notice_date = notice_date;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getComName() {
		return comName;
	}


	public void setComName(String comName) {
		this.comName = comName;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getNoCode() {
		return noCode;
	}


	public void setNoCode(int noCode) {
		this.noCode = noCode;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getEnroll_date() {
		return enroll_date;
	}


	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}


	public Date getNotice_date() {
		return notice_date;
	}


	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}


	@Override
	public String toString() {
		return "Company [userNo=" + userNo + ", userId=" + userId + ", comName=" + comName + ", pName=" + pName
				+ ", noCode=" + noCode + ", phone=" + phone + ", enroll_date=" + enroll_date + ", notice_date="
				+ notice_date + ", withdraw_date=" + withdraw_date + "]";
	}
	
	
	
	
	
	

}
