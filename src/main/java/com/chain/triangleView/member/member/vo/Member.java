package com.chain.triangleView.member.member.vo;

import java.sql.Date;
import java.util.Arrays;

public class Member {
	private int userNo;    //회원번호
	private String userId;  //회원아이디
	private String nick;    //회원닉네임
	private String userPwd; //회원비밀번호
	private int reviewCount; //게시글 수
	private int followCount; //팔로우 수
	private int followingCount; //팔로워 수
	private int followTF;   //회원과의 관계
	private String thumbnail; //프로필 사진 이름
	private int age;        //나이
	private String gender;  //성별
	private int postNo;     //우편번호
	private String address; //주소
	private Date enrollDate; //가입일
	private String withdraw; //탈퇴여부
	private Date withdrawDate; //탈퇴일
	private int userType; //유저타입(일반/기업)
	private int point;       //포인트
	private String[] category; //카테고리
	private String[] cateNum;   //카테고리번호(다중입력가능)   
	private String intro;   //자기소개
	private String phone;   //핸드폰번호

	//기업회원일경우
	private String personName; //담당자이름
	private int businessNo;    //사업자등록번호
	private String copName;    //기업이름

	//일반회원일경우
	private int userLevel;       //등급(일반/파워리뷰어 -> 가입일떈 일반)

	public Member(){}

	public Member(int userNo, String userId, String nick, String userPwd, int reviewCount, int followCount,
			int followingCount, int followTF, String thumbnail, int age, String gender, int postNo, String address,
			Date enrollDate, String withdraw, Date withdrawDate, int userType, int point, String[] category,
			String[] cateNum, String intro, String phone, String personName, int businessNo, String copName,
			int userLevel) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.nick = nick;
		this.userPwd = userPwd;
		this.reviewCount = reviewCount;
		this.followCount = followCount;
		this.followingCount = followingCount;
		this.followTF = followTF;
		this.thumbnail = thumbnail;
		this.age = age;
		this.gender = gender;
		this.postNo = postNo;
		this.address = address;
		this.enrollDate = enrollDate;
		this.withdraw = withdraw;
		this.withdrawDate = withdrawDate;
		this.userType = userType;
		this.point = point;
		this.category = category;
		this.cateNum = cateNum;
		this.intro = intro;
		this.phone = phone;
		this.personName = personName;
		this.businessNo = businessNo;
		this.copName = copName;
		this.userLevel = userLevel;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getFollowCount() {
		return followCount;
	}

	public void setFollowCount(int followCount) {
		this.followCount = followCount;
	}

	public int getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}

	public int getFollowTF() {
		return followTF;
	}

	public void setFollowTF(int followTF) {
		this.followTF = followTF;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}

	public Date getWithdrawDate() {
		return withdrawDate;
	}

	public void setWithdrawDate(Date withdrawDate) {
		this.withdrawDate = withdrawDate;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public String[] getCateNum() {
		return cateNum;
	}

	public void setCateNum(String[] cateNum) {
		this.cateNum = cateNum;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(int businessNo) {
		this.businessNo = businessNo;
	}

	public String getCopName() {
		return copName;
	}

	public void setCopName(String copName) {
		this.copName = copName;
	}

	public int getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", nick=" + nick + ", userPwd=" + userPwd
				+ ", reviewCount=" + reviewCount + ", followCount=" + followCount + ", followingCount=" + followingCount
				+ ", followTF=" + followTF + ", thumbnail=" + thumbnail + ", age=" + age + ", gender=" + gender
				+ ", postNo=" + postNo + ", address=" + address + ", enrollDate=" + enrollDate + ", withdraw="
				+ withdraw + ", withdrawDate=" + withdrawDate + ", userType=" + userType + ", point=" + point
				+ ", category=" + Arrays.toString(category) + ", cateNum=" + Arrays.toString(cateNum) + ", intro="
				+ intro + ", phone=" + phone + ", personName=" + personName + ", businessNo=" + businessNo
				+ ", copName=" + copName + ", userLevel=" + userLevel + "]";
	}

}