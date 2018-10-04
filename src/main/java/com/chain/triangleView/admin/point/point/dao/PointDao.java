package com.chain.triangleView.admin.point.point.dao;

import static com.chain.triangleView.common.JDBCTemplate.close;

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

import com.chain.triangleView.admin.member.dao.MemberDao;
import com.chain.triangleView.admin.payment.payment.vo.Payment;
import com.chain.triangleView.admin.point.point.vo.Point;

public class PointDao {
	
	private Properties prop = new Properties();

	public PointDao(){
		String fileName = MemberDao.class.getResource("/resources/admin/adminPoint-query.properties").getPath();

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
	
	
	
	
	public ArrayList<Point> searchPoint(Connection con, String option, String searchWord, String FromDt, String ToDt) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Point> points = null;
		System.out.println("daoup:"+FromDt);

		String query = prop.getProperty("searchPoint");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, FromDt);
			pstmt.setString(2, ToDt);
			pstmt.setString(3, searchWord);
			rset = pstmt.executeQuery();

			points = new ArrayList<Point>();

			while (rset.next()) {

				Point p = new Point();

				p.setPayBackCode(rset.getInt("payBackCode"));
				p.setRequestDate(rset.getString("requestDate"));
				p.setRequestPay(rset.getInt("requestPay"));
				p.setUserNo(rset.getInt("userNo"));
				p.setPayBackDate(rset.getString("payBackDate"));
				p.setUserLevel(rset.getInt("userLevel"));
				p.setMyPoint(rset.getInt("myPoint"));
				p.setPayPoint(rset.getInt("payBackPoint"));
				
				points.add(p);
				

			}

			System.out.println("dao:"+points);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
			close(rset);
		}
		System.out.println("dao:"+points);
		
		return points;
	}






	public ArrayList<Point> searchUserId(Connection con, String option, String searchWord, String FromDt, String ToDt) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Point> points = null;
		System.out.println("daoup:"+FromDt);

		String query = prop.getProperty("searchUserId");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, FromDt);
			pstmt.setString(2, ToDt);
			pstmt.setString(3, searchWord);
			rset = pstmt.executeQuery();

			points = new ArrayList<Point>();

			while (rset.next()) {

				Point p = new Point();

				p.setPayBackCode(rset.getInt("payBackCode"));
				p.setRequestDate(rset.getString("requestDate"));
				p.setRequestPay(rset.getInt("requestPay"));
				p.setUserNo(rset.getInt("userNo"));
				p.setPayBackDate(rset.getString("payBackDate"));
				p.setUserLevel(rset.getInt("userLevel"));
				p.setMyPoint(rset.getInt("myPoint"));
				p.setPayPoint(rset.getInt("payBackPoint"));
				
				points.add(p);
				

			}

			System.out.println("dao:"+points);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
			close(rset);
		}
		System.out.println("dao:"+points);
		
		return points;
	}




	public ArrayList<Point> searchUserLevel(Connection con, String option, String searchWord, String FromDt,
			String ToDt) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Point> points = null;
		System.out.println("daoup:"+FromDt);

		String query = prop.getProperty("searchUserLevel");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, FromDt);
			pstmt.setString(2, ToDt);
			pstmt.setString(3, searchWord);
			rset = pstmt.executeQuery();

			points = new ArrayList<Point>();

			while (rset.next()) {

				Point p = new Point();

				p.setPayBackCode(rset.getInt("payBackCode"));
				p.setRequestDate(rset.getString("requestDate"));
				p.setRequestPay(rset.getInt("requestPay"));
				p.setUserNo(rset.getInt("userNo"));
				p.setPayBackDate(rset.getString("payBackDate"));
				p.setUserLevel(rset.getInt("userLevel"));
				p.setMyPoint(rset.getInt("myPoint"));
				p.setPayPoint(rset.getInt("payBackPoint"));
				
				points.add(p);
				

			}

			System.out.println("dao:"+points);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
			close(rset);
		}
		System.out.println("dao:"+points);
		
		return points;
	}




	public ArrayList<Point> pointPayback(Connection con) {
		ArrayList<Point> points = null;
		Statement stmt = null;
		ResultSet rset = null;
		System.out.println("daoHI");
		String query = prop.getProperty("pointPayback");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			points = new ArrayList<Point>();

			while (rset.next()) {

				Point p = new Point();

				
				p.setRequestPay(rset.getInt("requestPay"));
				
				p.setPayBackDate(rset.getString("payBackDate"));
				
				
				points.add(p);
				

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(stmt);
			close(rset);

		}

		return points;

	}




	public ArrayList<Point> dailyPointPayback(Connection con) {
		ArrayList<Point> points = null;
		Statement stmt = null;
		ResultSet rset = null;
		System.out.println("daoHI");
		String query = prop.getProperty("dailyPointPayback");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			points = new ArrayList<Point>();

			while (rset.next()) {

				Point p = new Point();

				
				
				p.setRequestPay(rset.getInt("requestPay"));
				
				p.setPayBackDate(rset.getString("payBackDate"));
				
				points.add(p);
				

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(stmt);
			close(rset);

		}

		return points;

	}




	public int getlistCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("getlistCount");
		
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






	public ArrayList<Point> selectAllCount(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Point> points = null;
		
		String query = prop.getProperty("selectAllCount"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rset = pstmt.executeQuery();
			
			points = new ArrayList<Point>();
			while (rset.next()) {

				Point p = new Point();

				p.setPayBackCode(rset.getInt("payBackCode"));
				p.setRequestDate(rset.getString("requestDate"));
				p.setRequestPay(rset.getInt("requestPay"));
				p.setUserNo(rset.getInt("userNo"));
				p.setPayBackDate(rset.getString("payBackDate"));
				p.setUserLevel(rset.getInt("userLevel"));
				p.setMyPoint(rset.getInt("myPoint"));
				p.setPayPoint(rset.getInt("payBackPoint"));
				
				points.add(p);
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+points);
		
		return points;
	
	}



	}

	
	
	
	

	


