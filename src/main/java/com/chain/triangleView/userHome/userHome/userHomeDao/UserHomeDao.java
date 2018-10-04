package com.chain.triangleView.userHome.userHome.userHomeDao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.chain.triangleView.review.review.reviewDao.ReviewDao;
import com.chain.triangleView.userHome.userHome.vo.HomeMember;
import com.chain.triangleView.userHome.userHome.vo.HomeReview;

import static com.chain.triangleView.common.JDBCTemplate.*;

public class UserHomeDao {
	private Properties prop = new Properties();
	
	public UserHomeDao(){
		String fileName = ReviewDao.class.getResource("/resources/userHome/userHome-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public HomeMember UserMemberSelect(Connection con, String userId, String meId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HomeMember member = null;
		String query = prop.getProperty("UserMemberSelect");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			pstmt.setString(3, userId);
			pstmt.setString(4, meId);
			pstmt.setString(5, userId);
			pstmt.setString(6, userId);
			
			rset = pstmt.executeQuery();
			
			member = new HomeMember();
			 
			if(rset.next()){
				member.setReviewCount(rset.getInt("reviewcount"));
				member.setFollowCount(rset.getInt("followCount"));
				member.setFollowTF(rset.getInt("followtf"));
				member.setFollowingCount(rset.getInt("followingCount"));
				member.setThumbnail(rset.getString("filename"));
				member.setIntro(rset.getString("intro"));
				member.setNick(rset.getString("nick"));
				member.setUserId(rset.getString("userid"));
				member.setUserNo(rset.getInt("userno"));
				member.setUserType(rset.getInt("usertype"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}

	public ArrayList<HomeReview> userReviewSelect(Connection con, String userId, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HomeReview> reviews = null;
		
		String query = prop.getProperty("userReviewSelect");
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit -1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			reviews = new ArrayList<HomeReview>();
			
			while(rset.next()){
				HomeReview r = new HomeReview();
				
				r.setNick(rset.getString("nick"));
				r.setUserNo(rset.getInt("userno"));
				r.setLikeCount(rset.getInt("likecount"));
				r.setRwCount(rset.getInt("rwcount"));
				r.setRwTitle(rset.getString("rwtitle"));
				r.setThumbnail(rset.getString("filename"));
				r.setRwContentType(rset.getInt("rwcontenttype"));
				r.setRwType(rset.getInt("rwtype"));
				r.setRwNo(rset.getInt("rwno"));
				
				reviews.add(r);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reviews;
	}

	public int getReviewCount(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int reviewCount = 0;
		
		String query  = prop.getProperty("getReviewCount");
	
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				reviewCount = rset.getInt("reviewCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return reviewCount;
	}

	public ArrayList<HomeReview> UserReviewSelect(Connection con, String userId, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<HomeReview> reviews = null;
		
		String query = prop.getProperty("UserReviewSelect");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			
			rset = pstmt.executeQuery();
			
			reviews = new ArrayList<HomeReview>();
			
			while(rset.next()){
				HomeReview r = new HomeReview();
				
				r.setNick(rset.getString("nick"));
				r.setUserNo(rset.getInt("userno"));
				r.setLikeCount(rset.getInt("likecount"));
				r.setRwCount(rset.getInt("rwcount"));
				r.setRwTitle(rset.getString("rwtitle"));
				r.setThumbnail(rset.getString("filename"));
				r.setRwContentType(rset.getInt("rwcontenttype"));
				r.setRwType(rset.getInt("rwtype"));
				r.setRwNo(rset.getInt("rwno"));
				
				reviews.add(r);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reviews;
	}

}
