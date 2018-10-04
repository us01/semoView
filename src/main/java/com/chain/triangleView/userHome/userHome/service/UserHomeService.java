package com.chain.triangleView.userHome.userHome.service;

import com.chain.triangleView.userHome.userHome.userHomeDao.UserHomeDao;
import com.chain.triangleView.userHome.userHome.vo.HomeMember;
import com.chain.triangleView.userHome.userHome.vo.HomeReview;

import static com.chain.triangleView.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class UserHomeService {

	public HomeMember UserMemberSelect(String userId, String meId) {
		Connection con = getConnection();
		
		HomeMember member = new UserHomeDao().UserMemberSelect(con, userId, meId);
		
		close(con);
		
		return member;
	}

	public int getReviewCount(String userId) {
		Connection con = getConnection();
		
		int reviewCount = new UserHomeDao().getReviewCount(con, userId);
		
		close(con);
		
		return reviewCount;
	}

	public ArrayList<HomeReview> userReviewSelect(String userId, int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<HomeReview> reviews = new UserHomeDao().userReviewSelect(con, userId, currentPage, limit);
		
		close(con);
		
		return reviews;
	}
	
}
