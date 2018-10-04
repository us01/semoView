package com.chain.triangleView.admin.reviews.reviews.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import static com.chain.triangleView.common.JDBCTemplate.close;

import com.chain.triangleView.admin.aCompany.aCompany.vo.Company;
import com.chain.triangleView.admin.member.dao.MemberDao;
import com.chain.triangleView.admin.payment.payment.vo.Payment;
import com.chain.triangleView.admin.reviews.reviews.vo.Review;

public class ReviewDao {
	private Properties prop = new Properties();
	
	public ReviewDao(){
		String fileName = MemberDao.class.getResource("/resources/admin/adminReview-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Review> searchReviewUserNo(Connection con, String searchWord) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchReviewUserNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setRwType(rset.getInt("rwType"));
			r.setWritedate(rset.getDate("writedate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}
	
	

	public int deleteReview(int rwNo, String reason, Connection con) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteReview");
		
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, rwNo);
			pstmt.setString(2, reason);
			result=pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Review> searchReviewRwNo(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchReviewRwNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setRwType(rset.getInt("rwType"));
			r.setWritedate(rset.getDate("writedate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public ArrayList<Review> searchCategoryType(Connection con, String categoryType) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchCategoryType");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, categoryType);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setRwType(rset.getInt("rwType"));
			r.setWritedate(rset.getDate("writedate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public ArrayList<Review> searchRwCount(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchRwCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setRwType(rset.getInt("rwType"));
			r.setWritedate(rset.getDate("writedate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public ArrayList<Review> searchRwcontentType(Connection con, String rwcontentType) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchRwcontentType");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rwcontentType);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setRwType(rset.getInt("rwType"));
			r.setWritedate(rset.getDate("writedate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public ArrayList<Review> searchrwType(Connection con, String rwType) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchrwType");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rwType);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setRwType(rset.getInt("rwType"));
			r.setWritedate(rset.getDate("writedate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public ArrayList<Review> searchWritedate(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchWritedate");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setRwType(rset.getInt("rwType"));
			r.setWritedate(rset.getDate("writedate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public ArrayList<Review> searchDeleteReviewUserNo(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchDeleteReviewUserNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setCancleReason(rset.getString("canclereason"));
			r.setCancleDate(rset.getDate("cancledate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public ArrayList<Review> searchDeleteReviewRwNo(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchDeleteReviewRwNo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setCancleReason(rset.getString("canclereason"));
			r.setCancleDate(rset.getDate("cancledate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public ArrayList<Review> searchDeleteCategoryType(Connection con, String categoryType) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchDeleteCategoryType");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, categoryType);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setCancleReason(rset.getString("canclereason"));
			r.setCancleDate(rset.getDate("cancledate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public ArrayList<Review> searchDeleteRwCount(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchDeleteRwCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setCancleReason(rset.getString("canclereason"));
			r.setCancleDate(rset.getDate("cancledate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public ArrayList<Review> searchDeleteRwcontentType(Connection con, String rwcontentType) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchDeleteRwcontentType");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rwcontentType);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setCancleReason(rset.getString("canclereason"));
			r.setCancleDate(rset.getDate("cancledate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public ArrayList<Review> searchDeleteCancleDate(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchDeleteCancleDate");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			rset = pstmt.executeQuery();
			
			reviews=new ArrayList<Review>();
			
			while(rset.next()){
				
			Review r = new Review();
			
			r.setUserNo(rset.getInt("userNo"));
			r.setRwNo(rset.getInt("rwNo"));
			r.setCategoryType(rset.getInt("categoryType"));
			r.setRwCount(rset.getInt("rwCount"));
			r.setRwcontentType(rset.getInt("rwcontentType"));
			r.setCancleReason(rset.getString("canclereason"));
			r.setCancleDate(rset.getDate("cancledate"));
			r.setRwLike(rset.getInt("rwLike"));
			
			reviews.add(r);
	
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
		}
	return reviews;
	}

	public int LiveReview(int rwNo, Connection con) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("LiveReview");
		
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, rwNo);
			result=pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
		}
		return result;
	

	}

	public int getListAll(Connection con) {
		
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("getListAll");
		
		int listCount = 0;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				listCount = rset.getInt(1);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(stmt);
			close(rset);
		}
		
		
		return listCount;
		
	}

	public ArrayList<Review> searchAll(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("searchAll"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rset = pstmt.executeQuery();
			
			reviews = new ArrayList<Review>();
			while(rset.next()){
				
				Review r = new Review();
				
				r.setUserNo(rset.getInt("userNo"));
				r.setRwNo(rset.getInt("rwNo"));
				r.setCategoryType(rset.getInt("categoryType"));
				r.setRwCount(rset.getInt("rwCount"));
				r.setRwcontentType(rset.getInt("rwcontentType"));
				r.setRwType(rset.getInt("rwType"));
				r.setWritedate(rset.getDate("writedate"));
				r.setRwLike(rset.getInt("rwLike"));
				
				reviews.add(r);
		
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+reviews);
		
		return reviews;
	
	}

	public int getDeletelistCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("getDeletelistCount");
		
		int listCount = 0;
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				listCount = rset.getInt(1);
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(stmt);
			close(rset);
		}
		
		System.out.println("listcount"+listCount);
		return listCount;
		
	}

	public ArrayList<Review> DeleteSearchAll(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> reviews = null;
		
		String query = prop.getProperty("DeleteSearchAll"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rset = pstmt.executeQuery();
			
			reviews = new ArrayList<Review>();
			while(rset.next()){
				
				Review r = new Review();
				
				r.setUserNo(rset.getInt("userNo"));
				r.setRwNo(rset.getInt("rwNo"));
				r.setCategoryType(rset.getInt("categoryType"));
				r.setRwCount(rset.getInt("rwCount"));
				r.setRwcontentType(rset.getInt("rwcontentType"));
				r.setCancleReason(rset.getString("canclereason"));
				r.setCancleDate(rset.getDate("cancledate"));
				r.setRwLike(rset.getInt("rwLike"));
				
				reviews.add(r);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+reviews);
		
		return reviews;
	
	}
	

	
	

	
}
