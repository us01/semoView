package com.chain.triangleView.admin.aCompany.aCompany.dao;

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
import com.chain.triangleView.admin.member.vo.Member;


public class CompanyDao {

	private Properties prop = new Properties();
	
	public CompanyDao(){
		
		String fileName = CompanyDao.class.getResource("/resources/admin/adminCompany-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		



	public ArrayList<Company> searchUserNo(Connection con, String searchWord) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("searchUserNo");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userId"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setEnroll_date(rset.getDate("enrolldate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				System.out.println(c.getUserId());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> searchUserId(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("searchUserId");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setEnroll_date(rset.getDate("enrolldate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> searchcopName(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("searchUsercopName");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setEnroll_date(rset.getDate("enrolldate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> searchpName(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("searchpName");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setEnroll_date(rset.getDate("enrolldate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> searchnoCode(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("searchnoCode");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setEnroll_date(rset.getDate("enrolldate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> searchphone(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("searchphone");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setEnroll_date(rset.getDate("enrolldate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> searchNoticedate(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("searchNoticedate");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setEnroll_date(rset.getDate("enrolldate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				System.out.println("======="+c.getUserId());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> searchEnrolldate(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("searchEnrolldate");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setEnroll_date(rset.getDate("enrolldate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> withdrawUserNo(Connection con, String searchWord) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("withdrawUserNo");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userId"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setWithdraw_date(rset.getDate("withdrawdate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				System.out.println(c.getUserId());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> withdrawUserId(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("withdrawUserId");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setWithdraw_date(rset.getDate("withdrawdate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> withdrawPname(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("withdrawPname");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setWithdraw_date(rset.getDate("withdrawdate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> withdrawCopName(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("withdrawCopName");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setWithdraw_date(rset.getDate("withdrawdate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> withdrawNoCode(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("withdrawNoCode");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setWithdraw_date(rset.getDate("withdrawdate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> withdrawPhone(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("withdrawPhone");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setWithdraw_date(rset.getDate("withdrawdate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	}




	public ArrayList<Company> companyWithdrawdate(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("companyWithdrawdate");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setWithdraw_date(rset.getDate("withdrawdate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	
	}




	public ArrayList<Company> companyNoticedate(Connection con, String searchWord) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("companyNoticedate");
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset =pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setWithdraw_date(rset.getDate("withdrawdate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("dao:"+com);
		
		
		
		return com;
	
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
		
		System.out.println("dao:"+listCount);
		return listCount;
	
	}




	public ArrayList<Company> searchAll(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("searchAll"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rset = pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setEnroll_date(rset.getDate("enrolldate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+com);
		
		return com;
	
	}




	public int getWithlistCount(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("getWithlistCount");
		
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




	public ArrayList<Company> WithsearchAll(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Company> com = null;
		
		String query = prop.getProperty("WithsearchAll"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rset = pstmt.executeQuery();
			
			com = new ArrayList<Company>();
			while(rset.next()){
				
				Company c = new Company();
				
				c.setUserNo(rset.getInt("userNo"));
				c.setUserId(rset.getString("userid"));
				c.setComName(rset.getString("copname"));
				c.setpName(rset.getString("offerproduct"));
				c.setPhone(rset.getString("copphone"));
				c.setNoCode(rset.getInt("noticecode"));
				c.setWithdraw_date(rset.getDate("withdrawdate"));
				c.setNotice_date(rset.getDate("noticedate"));
				System.out.println(c.getNoCode());
				com.add(c);
				
				
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+com);
		
		return com;
	
	}
	


	



}