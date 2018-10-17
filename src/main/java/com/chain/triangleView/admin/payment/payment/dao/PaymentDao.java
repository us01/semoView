package com.chain.triangleView.admin.payment.payment.dao;

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
import com.chain.triangleView.admin.reviews.reviews.vo.Review;

public class PaymentDao {

	private Properties prop = new Properties();

	public PaymentDao() {

		String fileName = MemberDao.class.getResource("/resources/admin/adminPayment-query.properties").getPath();

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

	public ArrayList<Payment> searchPayDetailCode(Connection con, String searchWord,String FromDt,String ToDt) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Payment> payment = null;
		System.out.println("daoup:"+FromDt);

		String query = prop.getProperty("searchPayDetailCode");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, FromDt);
			pstmt.setString(2, ToDt);
			pstmt.setString(3, searchWord);
			rset = pstmt.executeQuery();

			payment = new ArrayList<Payment>();

			while (rset.next()) {

				Payment p = new Payment();

				p.setPayDetailCode(rset.getString("payDetailCode"));
				p.setCopName(rset.getString("copName"));
				p.setUserNo(rset.getInt("userNo"));
				p.setServiceType(rset.getInt("serviceType"));
				p.setMoney(rset.getInt("money"));
				p.setPayType(rset.getInt("payType"));
				p.setPayStatus(rset.getInt("payStatus"));
				p.setPayDate(rset.getString("paydate"));

				payment.add(p);
				

			}

			System.out.println("dao:"+payment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
			close(rset);
		}
		return payment;
	}



	public ArrayList<Payment> searchcopName(Connection con, String searchWord,String FromDt,String ToDt) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Payment> payment = null;

		String query = prop.getProperty("searchcopName");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, FromDt);
			pstmt.setString(2, ToDt);
			pstmt.setString(3, searchWord);
			rset = pstmt.executeQuery();

			payment = new ArrayList<Payment>();

			while (rset.next()) {

				Payment p = new Payment();

				p.setPayDetailCode(rset.getString("payDetailCode"));
				p.setCopName(rset.getString("copName"));
				p.setUserNo(rset.getInt("userNo"));
				p.setServiceType(rset.getInt("serviceType"));
				p.setMoney(rset.getInt("money"));
				p.setPayType(rset.getInt("payType"));
				p.setPayStatus(rset.getInt("payStatus"));
				p.setPayDate(rset.getString("paydate"));

				payment.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
			close(rset);
		}
		return payment;
	}

	public ArrayList<Payment> searchUserNo(Connection con, String searchWord,String FromDt,String ToDt) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Payment> payment = null;

		String query = prop.getProperty("searchUserNo");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, FromDt);
			pstmt.setString(2, ToDt);
			pstmt.setString(3, searchWord);
			rset = pstmt.executeQuery();

			payment = new ArrayList<Payment>();

			while (rset.next()) {

				Payment p = new Payment();

				p.setPayDetailCode(rset.getString("payDetailCode"));
				p.setCopName(rset.getString("copName"));
				p.setUserNo(rset.getInt("userNo"));
				p.setServiceType(rset.getInt("serviceType"));
				p.setMoney(rset.getInt("money"));
				p.setPayType(rset.getInt("payType"));
				p.setPayStatus(rset.getInt("payStatus"));
				p.setPayDate(rset.getString("paydate"));

				payment.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
			close(rset);
		}
		return payment;
	}

	public ArrayList<Payment> searchServiceType(Connection con, String serviceType,String FromDt,String ToDt) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Payment> payment = null;

		String query = prop.getProperty("searchServiceType");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, FromDt);
			pstmt.setString(2, ToDt);
			pstmt.setString(3, serviceType);
			rset = pstmt.executeQuery();

			payment = new ArrayList<Payment>();

			while (rset.next()) {

				Payment p = new Payment();

				p.setPayDetailCode(rset.getString("payDetailCode"));
				p.setCopName(rset.getString("copName"));
				p.setUserNo(rset.getInt("userNo"));
				p.setServiceType(rset.getInt("serviceType"));
				p.setMoney(rset.getInt("money"));
				p.setPayType(rset.getInt("payType"));
				p.setPayStatus(rset.getInt("payStatus"));
				p.setPayDate(rset.getString("paydate"));

				payment.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
			close(rset);
		}
		return payment;
	}

	public ArrayList<Payment> searchPayType(Connection con, String payType,String FromDt,String ToDt) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Payment> payment = null;

		String query = prop.getProperty("searchPayType");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, FromDt);
			pstmt.setString(2, ToDt);
			pstmt.setString(3, payType);
			rset = pstmt.executeQuery();

			payment = new ArrayList<Payment>();

			while (rset.next()) {

				Payment p = new Payment();

				p.setPayDetailCode(rset.getString("payDetailCode"));
				p.setCopName(rset.getString("copName"));
				p.setUserNo(rset.getInt("userNo"));
				p.setServiceType(rset.getInt("serviceType"));
				p.setMoney(rset.getInt("money"));
				p.setPayType(rset.getInt("payType"));
				p.setPayStatus(rset.getInt("payStatus"));
				p.setPayDate(rset.getString("paydate"));

				payment.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
			close(rset);
		}
		return payment;
	}

	public ArrayList<Payment> searchpayStatus(Connection con, String payStatus,String FromDt,String ToDt) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Payment> payment = null;

		String query = prop.getProperty("searchpayStatus");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, FromDt);
			pstmt.setString(2, ToDt);
			pstmt.setString(3, payStatus);
			rset = pstmt.executeQuery();

			payment = new ArrayList<Payment>();

			while (rset.next()) {

				Payment p = new Payment();

				p.setPayDetailCode(rset.getString("payDetailCode"));
				p.setCopName(rset.getString("copName"));
				p.setUserNo(rset.getInt("userNo"));
				p.setServiceType(rset.getInt("serviceType"));
				p.setMoney(rset.getInt("money"));
				p.setPayType(rset.getInt("payType"));
				p.setPayStatus(rset.getInt("payStatus"));
				p.setPayDate(rset.getString("paydate"));

				payment.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
			close(rset);
		}
		return payment;
	}

	public ArrayList<Payment> paymentMargin(Connection con) {
		ArrayList<Payment> payments = null;
		Statement stmt = null;
		ResultSet rset = null;
		System.out.println("daoHI");
		String query = prop.getProperty("paymentMargin");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			payments = new ArrayList<Payment>();
			while (rset.next()) {

				Payment p = new Payment();

				
				p.setMoney(rset.getInt("money"));
				p.setPayDate(rset.getString("payDate"));

				payments.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(stmt);
			close(rset);

		}

		return payments;

	}

	public ArrayList<Payment> paymentMargin2(Connection con) {
		ArrayList<Payment> payments = null;
		Statement stmt = null;
		ResultSet rset = null;
		System.out.println("daoHI");
		String query = prop.getProperty("paymentMargin2");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			payments = new ArrayList<Payment>();
			while (rset.next()) {

				Payment p = new Payment();

				
				p.setCopName(rset.getString("copName"));
				
				p.setMoney(rset.getInt("money"));
				
				payments.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(stmt);
			close(rset);

		}

		return payments;

	}

	public ArrayList<Payment> paymentMargin3(Connection con) {
		ArrayList<Payment> payments = null;
		Statement stmt = null;
		ResultSet rset = null;
		System.out.println("daoHI");
		String query = prop.getProperty("paymentMargin2");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			payments = new ArrayList<Payment>();
			while (rset.next()) {

				Payment p = new Payment();

				
				p.setCopName(rset.getString("copName"));
				
				p.setMoney(rset.getInt("money"));
				
				payments.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(stmt);
			close(rset);

		}

		return payments;

	}


	public ArrayList<Payment> paymentMargin4(Connection con) {
		ArrayList<Payment> payments = null;
		Statement stmt = null;
		ResultSet rset = null;
		System.out.println("daoHI");
		String query = prop.getProperty("paymentMargin4");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			payments = new ArrayList<Payment>();
			while (rset.next()) {

				Payment p = new Payment();

				
				p.setMoney(rset.getInt("money"));
				p.setPayDate(rset.getString("payDate"));

				payments.add(p);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(stmt);
			close(rset);

		}

		return payments;

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

	public ArrayList<Payment> selectAllCount(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Payment> payments = null;
		
		String query = prop.getProperty("selectAllCount"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rset = pstmt.executeQuery();
			
			payments = new ArrayList<Payment>();
			while (rset.next()) {

				Payment p = new Payment();

				p.setPayDetailCode(rset.getString("payDetailCode"));
				p.setCopName(rset.getString("copName"));
				p.setUserNo(rset.getInt("userNo"));
				p.setServiceType(rset.getInt("serviceType"));
				p.setMoney(rset.getInt("money"));
				p.setPayType(rset.getInt("payType"));
				p.setPayStatus(rset.getInt("payStatus"));
				p.setPayDate(rset.getString("paydate"));

				payments.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+payments);
		
		return payments;
	
	}

	

	




	
	
	

}