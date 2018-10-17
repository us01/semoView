package com.chain.triangleView.admin.member.dao;

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

import com.chain.triangleView.admin.member.vo.BlackMember;
import com.chain.triangleView.admin.member.vo.Member;
import com.chain.triangleView.admin.payment.payment.vo.Payment;

public class BlackMemberDao {

	private Properties prop = new Properties();
	
	public BlackMemberDao(){
		
		String fileName = MemberDao.class.getResource("/resources/admin/adminBlackMember-query.properties").getPath();
		
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
	
	public ArrayList<BlackMember> searchBlackcode(Connection con, String searchWord) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BlackMember> blacks = null;
		
		String query = prop.getProperty("searchBlackcode"); 
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset = pstmt.executeQuery();
			
			blacks = new ArrayList<BlackMember>();
			while(rset.next()){
				BlackMember bm = new BlackMember();
				bm.setBlackCode(rset.getInt("blackcode"));
				bm.setUserNo(rset.getInt("userno"));
				bm.setPhone(rset.getString("copphone"));
				bm.setNick(rset.getString("nick"));
				bm.setBlackReason(rset.getString("blackreason"));
				bm.setBlackTime(rset.getDate("blackTime"));
				bm.setRwNo(rset.getInt("rwNo"));
				bm.setCommentNo(rset.getInt("commentNo"));
				
				
				
				
				
				
				blacks.add(bm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return blacks;
	}

	public ArrayList<BlackMember> searchBlackuserNo(Connection con, String searchWord) {
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BlackMember> blacks = null;
		
		String query = prop.getProperty("searchBlackuserNo"); 
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset = pstmt.executeQuery();
			
			blacks = new ArrayList<BlackMember>();
			while(rset.next()){
				BlackMember bm = new BlackMember();
				bm.setBlackCode(rset.getInt("blackcode"));
				bm.setUserNo(rset.getInt("userno"));
				bm.setPhone(rset.getString("copphone"));
				bm.setNick(rset.getString("nick"));
				bm.setBlackReason(rset.getString("blackreason"));
				bm.setBlackTime(rset.getDate("blackTime"));
				bm.setRwNo(rset.getInt("rwNo"));
				bm.setCommentNo(rset.getInt("commentNo"));
				
				
				
				
				
				
				blacks.add(bm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return blacks;
	}

	public ArrayList<BlackMember> searchPhone(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BlackMember> blacks = null;
		
		String query = prop.getProperty("searchPhone"); 
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset = pstmt.executeQuery();
			
			blacks = new ArrayList<BlackMember>();
			while(rset.next()){
				BlackMember bm = new BlackMember();
				bm.setBlackCode(rset.getInt("blackcode"));
				bm.setUserNo(rset.getInt("userno"));
				bm.setPhone(rset.getString("copphone"));
				bm.setNick(rset.getString("nick"));
				bm.setBlackReason(rset.getString("blackreason"));
				bm.setBlackTime(rset.getDate("blackTime"));
				bm.setRwNo(rset.getInt("rwNo"));
				bm.setCommentNo(rset.getInt("commentNo"));
				
				
				
				
				
				
				blacks.add(bm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return blacks;
	}

	public ArrayList<BlackMember> searchrwNo(Connection con, String searchWord) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BlackMember> blacks = null;
		
		String query = prop.getProperty("searchrwNo"); 
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset = pstmt.executeQuery();
			
			blacks = new ArrayList<BlackMember>();
			while(rset.next()){
				BlackMember bm = new BlackMember();
				bm.setBlackCode(rset.getInt("blackcode"));
				bm.setUserNo(rset.getInt("userno"));
				bm.setPhone(rset.getString("copphone"));
				bm.setNick(rset.getString("nick"));
				bm.setBlackReason(rset.getString("blackreason"));
				bm.setBlackTime(rset.getDate("blackTime"));
				bm.setRwNo(rset.getInt("rwNo"));
				bm.setCommentNo(rset.getInt("commentNo"));
				
				
				
				
				
				
				blacks.add(bm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return blacks;
	}

	public ArrayList<BlackMember> searchcommentNo(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BlackMember> blacks = null;
		
		String query = prop.getProperty("searchcommentNo"); 
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset = pstmt.executeQuery();
			
			blacks = new ArrayList<BlackMember>();
			while(rset.next()){
				BlackMember bm = new BlackMember();
				bm.setBlackCode(rset.getInt("blackcode"));
				bm.setUserNo(rset.getInt("userno"));
				bm.setPhone(rset.getString("copphone"));
				bm.setNick(rset.getString("nick"));
				bm.setBlackReason(rset.getString("blackreason"));
				bm.setBlackTime(rset.getDate("blackTime"));
				bm.setRwNo(rset.getInt("rwNo"));
				bm.setCommentNo(rset.getInt("commentNo"));
				
				
				
				
				
				
				blacks.add(bm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return blacks;
	}

	public ArrayList<BlackMember> searchblackTime(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BlackMember> blacks = null;
		
		String query = prop.getProperty("searchblackTime"); 
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset = pstmt.executeQuery();
			
			blacks = new ArrayList<BlackMember>();
			while(rset.next()){
				BlackMember bm = new BlackMember();
				bm.setBlackCode(rset.getInt("blackcode"));
				bm.setUserNo(rset.getInt("userno"));
				bm.setPhone(rset.getString("copphone"));
				bm.setNick(rset.getString("nick"));
				bm.setBlackReason(rset.getString("blackreason"));
				bm.setBlackTime(rset.getDate("blackTime"));
				bm.setRwNo(rset.getInt("rwNo"));
				bm.setCommentNo(rset.getInt("commentNo"));
				
				
				
				
				
				
				blacks.add(bm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return blacks;
	}

	public ArrayList<BlackMember> searchblackNick(Connection con, String searchWord) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BlackMember> blacks = null;
		
		String query = prop.getProperty("searchblackNick"); 
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchWord);
			
			rset = pstmt.executeQuery();
			
			blacks = new ArrayList<BlackMember>();
			while(rset.next()){
				BlackMember bm = new BlackMember();
				bm.setBlackCode(rset.getInt("blackcode"));
				bm.setUserNo(rset.getInt("userno"));
				bm.setPhone(rset.getString("copphone"));
				bm.setNick(rset.getString("nick"));
				bm.setBlackReason(rset.getString("blackreason"));
				bm.setBlackTime(rset.getDate("blackTime"));
				bm.setRwNo(rset.getInt("rwNo"));
				bm.setCommentNo(rset.getInt("commentNo"));
				
				
				
				
				
				
				blacks.add(bm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return blacks;
	}

	public ArrayList<BlackMember> searchAll(Connection con) {
		ArrayList<BlackMember> blacks = null;
		Statement stmt = null;
		ResultSet rset = null;
		System.out.println("daoHI");
		String query = prop.getProperty("searchAll");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			blacks = new ArrayList<BlackMember>();
			while(rset.next()){
				BlackMember bm = new BlackMember();
				bm.setBlackCode(rset.getInt("blackcode"));
				bm.setUserNo(rset.getInt("userno"));
				bm.setPhone(rset.getString("copphone"));
				bm.setNick(rset.getString("nick"));
				bm.setBlackReason(rset.getString("blackreason"));
				bm.setBlackTime(rset.getDate("blackTime"));
				bm.setRwNo(rset.getInt("rwNo"));
				bm.setCommentNo(rset.getInt("commentNo"));
				
				
				
				
				
				
				blacks.add(bm);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(stmt);
			close(rset);

		}

		return blacks;

	}
	
	
	}
		
		



