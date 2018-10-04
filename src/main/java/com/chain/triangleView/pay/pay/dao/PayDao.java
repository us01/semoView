package com.chain.triangleView.pay.pay.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.chain.triangleView.pay.pay.vo.PayMent;

import static com.chain.triangleView.common.JDBCTemplate.*;

public class PayDao {
	private Properties prop = new Properties();
	
	public PayDao(){
		String fileName = PayDao.class.getResource("/resources/pay/pay-query.properties").getPath();
	
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertPay(Connection con, int userId, int serviceNo) {
		PreparedStatement pstmt = null;
		int result1 = 0;
		
		String query = prop.getProperty("insertPay");
		
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, serviceNo);
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result1;
	}

	public int payCodeCheck(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int payCode = 0;
		
		String query = prop.getProperty("selectPayCode");
		
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				payCode = rset.getInt("currval");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
		}
		
		return payCode;
	}

	public int insertNoticePayMent(Connection con, PayMent p) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertNoticePayMent");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,p.getAmount());
			pstmt.setInt(2, p.getPayCode());
			pstmt.setString(3,p.getImp_uid());
			pstmt.setInt(4, p.getApply_num());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
	}

	public int insertAllianPay(Connection con, int userId, int serviceNo) {
		PreparedStatement pstmt = null;
		int result1 = 0;
		String query = prop.getProperty("insertPay");
		
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, serviceNo);
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		
		return result1;
	}

	public int insertAllianPayMent(Connection con, PayMent p) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertNoticePayMent");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,p.getAmount());
			pstmt.setInt(2, p.getPayCode());
			pstmt.setString(3,p.getImp_uid());
			pstmt.setInt(4, p.getApply_num());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		return result;
	}

}
