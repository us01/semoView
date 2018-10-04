package com.chain.triangleView.admin.member.vo;

import java.sql.Date;

public class Member {

	
	private int userNo;
	private String userId;
	private int age;
	private String gender;
	private String nick;
	private Date enroll_date;
	private String phone;
	private Date withdraw_date;
	

	public Member(int userNo, String userId, int age, String gender, String nick, Date enroll_date, String phone,
			Date withdraw_date) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.age = age;
		this.gender = gender;
		this.nick = nick;
		this.enroll_date = enroll_date;
		this.phone = phone;
		this.withdraw_date = withdraw_date;
	}

	public Member(){}
	
	public Member(int userNo, String userId, int age, String gender, String nick, Date enroll_date, String phone) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.age = age;
		this.gender = gender;
		this.nick = nick;
		this.enroll_date = enroll_date;
		this.phone = phone;
	}


	public Date getWithdraw_date() {
		return withdraw_date;
	}
	
	public void setWithdraw_date(Date withdraw_date) {
		this.withdraw_date = withdraw_date;
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



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getNick() {
		return nick;
	}



	public void setNick(String nick) {
		this.nick = nick;
	}



	public Date getEnroll_date() {
		return enroll_date;
	}



	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", age=" + age + ", gender=" + gender + ", nick="
				+ nick + ", enroll_date=" + enroll_date + ", phone=" + phone + ", withdraw_date=" + withdraw_date + "]";
	}

	

	
	
	
	
	
	
	
	
	
}
