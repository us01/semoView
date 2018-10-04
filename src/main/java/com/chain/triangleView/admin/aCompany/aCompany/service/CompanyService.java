package com.chain.triangleView.admin.aCompany.aCompany.service;

import static com.chain.triangleView.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import static com.chain.triangleView.common.JDBCTemplate.close;
import static com.chain.triangleView.common.JDBCTemplate.commit;
import static com.chain.triangleView.common.JDBCTemplate.getConnection;
import static com.chain.triangleView.common.JDBCTemplate.rollback;

import com.chain.triangleView.admin.aCompany.aCompany.dao.CompanyDao;
import com.chain.triangleView.admin.aCompany.aCompany.vo.Company;
import com.chain.triangleView.admin.member.dao.MemberDao;
import com.chain.triangleView.admin.member.vo.Member;

public class CompanyService {

	public ArrayList<Company> searchUserNo(String searchWord) {
		
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().searchUserNo(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> searchUserId(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().searchUserId(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> searchcopName(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().searchcopName(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> searchpName(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().searchpName(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> searchnoCode(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().searchnoCode(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> searchphone(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().searchphone(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> searchNoticedate(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().searchNoticedate(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> searchEnrolldate(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().searchEnrolldate(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> withdrawUserNo(String searchWord) {
		
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().withdrawUserNo(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> withdrawUserId(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().withdrawUserId(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> withdrawCopName(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().withdrawCopName(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> withdrawPname(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().withdrawPname(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> withdrawNoCode(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().withdrawNoCode(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	}



	public ArrayList<Company> withdrawPhone(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().withdrawPhone(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
	
}



	public ArrayList<Company> companyWithdrawdate(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().companyWithdrawdate(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
		
		
	}



	public ArrayList<Company> companyNoticedate(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Company> com = new CompanyDao().companyNoticedate(con,searchWord);
		
		System.out.println("service:"+com);
		close(con);
		
		return com;
		
		
	}



	public int getlistCount() {
		Connection con = getConnection();

		int listCount = new CompanyDao().getListAll(con);
		
		close(con);
		
		return listCount;
	}



	public ArrayList<Company> searchAll(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Company> com = new CompanyDao().searchAll(con,currentPage,limit);
		close(con);
		
		return com;
	}



	public int getWithlistCount() {
		Connection con = getConnection();

		int listCount = new CompanyDao().getWithlistCount(con);
		
		close(con);
		
		return listCount;
	}



	public ArrayList<Company> WithsearchAll(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Company> com = new CompanyDao().WithsearchAll(con,currentPage,limit);
		close(con);
		
		return com;
	}



	
	


}

