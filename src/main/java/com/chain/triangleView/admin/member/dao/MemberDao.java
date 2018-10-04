package com.chain.triangleView.admin.member.dao;

import static com.chain.triangleView.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.chain.triangleView.admin.member.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();

	public MemberDao(){
		String fileName = MemberDao.class.getResource("/resources/admin/adminMember-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public int enrollblack(Connection con, int userNo, int rwNo, int cNo, String reason) {
		
		PreparedStatement pstmt = null;
		int result=0;
		
		
		String query = prop.getProperty("enrollblack");
		
		System.out.println("dao1"+result);
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, reason);
			pstmt.setInt(3, rwNo);
			pstmt.setInt(4, cNo);
			result=pstmt.executeUpdate();
			

			System.out.println("dao2"+result);
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
			close(pstmt);
		}
		
		
		
		
		
		
		return result;
	}

	public int cancleBlack(Connection con, int userNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println("cdao"+result);
		String query = prop.getProperty("cancleBlack");
		
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close(pstmt);
		}
		
		
		
		System.out.println("dao"+result);
		
		return result;
	}

	public ArrayList<Member> withdrawName(Connection con, String searchWord, int currentPage, int limit) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("withdrawName"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}

	

	public ArrayList<Member> withdrawUserNo(int currentPage, int limit, Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("withdrawUserNo"); 
		
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}

	public ArrayList<Member> withdrawPhone(int currentPage, int limit, Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("withdrawPhone"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}
	
	public ArrayList<Member> withdrawEnrolldate(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("withdrawEnrolldate");
		
		

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userno"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setPhone(rset.getString("copphone"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setWithdraw_date(rset.getDate("withdrawdate"));
				
				
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return members;
	
	
	}

	public ArrayList<Member> withdrawWithdrawdate(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("withdrawWithdrawdate");
		
		

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userno"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setPhone(rset.getString("copphone"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setWithdraw_date(rset.getDate("withdrawdate"));
				
				
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return members;
	
	
	}


	public ArrayList<Member> searchName(int currentPage, int limit, Connection con,String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("searchName"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}



	public int getListName(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getListNameCount");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	}



	public ArrayList<Member> searchId(Connection con, String searchWord, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("searchId"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}
	



	public int getListId(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getListIdCount");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	}




	public int getListuserNo(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getListuserNo");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	}




	public ArrayList<Member> searchUserNo(Connection con, String searchWord, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("searchUserNo"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}


	public int getListPhone(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getListPhone");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	}


	public ArrayList<Member> searchPhone(Connection con, String searchWord, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("searchPhone"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}


	public int getListAge(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getListAge");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	}


	public ArrayList<Member> searchAge(Connection con, String searchWord, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("searchAge"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}





	public int getListGender(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getListGender");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	}





	public ArrayList<Member> searchGender(Connection con, String searchWord, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("searchGender"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}





	public int getListEnrolldate(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getListEnrolldate");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	}





	public ArrayList<Member> searchEnrolldate(Connection con, String searchWord, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("searchEnrolldate"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}


	public int getWithListName(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getWithListName");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	}


	public int getWithListId(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getWithListId");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	}


	public ArrayList<Member> withdrawUserId(Connection con, String searchWord, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("withdrawUserId"); 
		
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}


	public int getWithListUserNo(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getWithListUserNo");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	}


	public int getWithListPhone(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getWithListPhone");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	}


	public int getWithListAge(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getWithListAge");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	}


	public ArrayList<Member> withdrawAge(Connection con, String searchWord, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("withdrawAge"); 
		
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}


	public int getWithListGender(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getWithListGender");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	
	}


	public ArrayList<Member> withdrawGender(Connection con, String searchWord, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("withdrawGender"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}


	public int getWithListEnrolldate(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getWithListEnrolldate");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	
	}


	public ArrayList<Member> withdrawEnrolldate(Connection con, String searchWord, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("withdrawEnrolldate"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}


	public int getWithListWithdrawDate(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		int result = 0;
		
		String query = prop.getProperty("getWithListWithdrawDate");
		
		try {
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, searchWord);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				result = rset.getInt(1);
			}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	
	
	
	}


	public ArrayList<Member> withListWithdrawDate(Connection con, String searchWord, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("withListWithdrawDate"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			pstmt.setString(1, searchWord);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
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


	public ArrayList<Member> searchAll(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> members = null;
		
		String query = prop.getProperty("searchAll"); 
		
		try {
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit -1;
			
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			
			rset = pstmt.executeQuery();
			
			members = new ArrayList<Member>();
			while(rset.next()){
				Member m = new Member();
		
				m.setUserNo(rset.getInt("userNo"));
				m.setUserId(rset.getString("userid"));
				m.setAge(rset.getInt("age"));
				m.setGender(rset.getString("gender"));
				m.setNick(rset.getString("nick"));
				m.setEnroll_date(rset.getDate("enrolldate"));
				m.setPhone(rset.getString("copphone"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("Dao"+members);
		
		return members;
	}


	
	
}
	
	

	

	

	

