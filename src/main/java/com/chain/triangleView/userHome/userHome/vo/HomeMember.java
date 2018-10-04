package com.chain.triangleView.userHome.userHome.vo;

public class HomeMember {
	private int userNo;    //회원번호
	private String userId;  //회원아이디
	private String nick;    //회원닉네임
	private int reviewCount; //게시글 수
	private int followCount; //팔로우 수
	private String thumbnail; //프로필 사진 이름
	private int followingCount; //팔로워 수
	private int userType; //유저타입(일반/기업)   
	private String intro;   //자기소개
	private int followTF; //내 페이지가 아닐 경우 방문 페이지 유저의 팔로우 유무
	
	public HomeMember() {
		super();
	}

	public HomeMember(int userNo, String userId, String nick, int reviewCount, int followCount, String thumbnail,
			int followingCount, int userType, String intro, int followTF) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.nick = nick;
		this.reviewCount = reviewCount;
		this.followCount = followCount;
		this.thumbnail = thumbnail;
		this.followingCount = followingCount;
		this.userType = userType;
		this.intro = intro;
		this.followTF = followTF;
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getFollowTF() {
		return followTF;
	}

	public void setFollowTF(int followTF) {
		this.followTF = followTF;
	}

	@Override
	public String toString() {
		return "HomeMember [userNo=" + userNo + ", userId=" + userId + ", nick=" + nick + ", reviewCount=" + reviewCount
				+ ", followCount=" + followCount + ", thumbnail=" + thumbnail + ", followingCount=" + followingCount
				+ ", userType=" + userType + ", intro=" + intro + ", followTF=" + followTF + "]";
	}

	
}