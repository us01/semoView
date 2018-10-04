package com.chain.triangleView.allian.allian.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.chain.triangleView.allian.allian.vo.Allian;
import com.chain.triangleView.allian.allian.vo.AllianData;

import static com.chain.triangleView.common.JDBCTemplate.*;

public class AllianDao {
	private Properties prop = new Properties();

	public AllianDao(){
		String fileName = AllianDao.class.getResource("/resources/allian/allian-query.properties").getPath();


		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertAllianService(Connection con, Allian a) {
		PreparedStatement pstmt = null;

		int result1 = 0;

		String query = prop.getProperty("insertAllianService");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, a.getAllianWriter());

			result1 = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}

		return result1;
	}

	public int insertAllianCoor(Connection con, Allian a, int serviceNo) {
		PreparedStatement pstmt = null;

		int result2 = 0;

		//제휴 인서트
		String query = prop.getProperty("insertAllianCoor");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setDate(1,(Date)a.getAllianStartDate());
			pstmt.setInt(2,serviceNo);
			pstmt.setDate(3,(Date)a.getAllianEndDate());

			result2 = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}


		return result2;
	}
	public int allianCodeCheck(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int allianCode = 0;

		String query = prop.getProperty("selectAllianCode");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()){
				allianCode = rset.getInt("currval");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
		}

		return allianCode;
	}

	public int updateReview(Connection con,int allianCode, int rwNo, String allianLink) {
		PreparedStatement pstmt = null;
		int result3 = 0;
		
		String query = prop.getProperty("updateReivew");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,allianLink);
			pstmt.setInt(2,allianCode);
			pstmt.setInt(3,rwNo);
			
			result3 = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		
		
		return result3;
	}

	public ArrayList<AllianData> selectAllianPage(Connection con, int noticeWriter) {
		PreparedStatement pstmt =null;
		ResultSet rset =null;
		ArrayList<AllianData> list1 = null;
		
		String query = prop.getProperty("selectAllian");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeWriter);
			
			rset = pstmt.executeQuery();
			
			list1 = new ArrayList<AllianData>();
			
			while(rset.next()){
				
				AllianData a = new AllianData();
				
				a.setRwTitle(rset.getString("RWTITLE"));
				a.setRwCount(rset.getInt("RWCOUNT"));
				a.setCoorStart(rset.getDate("COORSTART"));
				a.setCoorEnd(rset.getDate("COOREND"));
				a.setCoorCode(rset.getInt("COORCODE"));
				a.setCoorLink(rset.getString("COORLINK"));
				a.setServiceNo(rset.getInt("SERVICENO"));
				a.setUserId(rset.getString("USERID"));
				a.setNick(rset.getString("NICK"));
				a.setLikeCount(rset.getInt("LIKECOUNT"));
				
				
				list1.add(a);
				
				System.out.println("list1Dao" + list1);
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
		}
		
		
		return list1;
	}

}
