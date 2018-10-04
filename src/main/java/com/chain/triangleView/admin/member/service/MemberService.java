package com.chain.triangleView.admin.member.service;

import static com.chain.triangleView.common.JDBCTemplate.close;
import static com.chain.triangleView.common.JDBCTemplate.commit;
import static com.chain.triangleView.common.JDBCTemplate.getConnection;
import static com.chain.triangleView.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.chain.triangleView.admin.member.dao.MemberDao;
import com.chain.triangleView.admin.member.vo.Member;

public class MemberService {

	public ArrayList<Member> searchName(int currentPage,int limit,String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Member> members = new MemberDao().searchName(currentPage,limit,con,searchWord);
		
		close(con);
		 
		return members;
	}

	public ArrayList<Member> searchId(int currentPage,int limit,String searchWord){
		
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().searchId(con,searchWord,currentPage,limit);
		close(con);
		
		
		
		
		return members;
	}

	



	public int enrollblack(int userNo, int rwNo, int cNo, String reason) {
		
		Connection con =getConnection();
		int result=new MemberDao().enrollblack(con,userNo,rwNo,cNo,reason);
		
		if(result>0){
			commit(con);
			
			
		}else{
			
			rollback(con);
		}
		
		close(con);
		
		
		return result;
		
		
	}

	public int cancleBlack(int userNo) {
		

		Connection con =getConnection();
		int result=new MemberDao().cancleBlack(con,userNo);
		
		
		if(result>0){
			commit(con);
			
			
		}else{
			
			rollback(con);
		}
		
		close(con);
		
		
		
		return result;
	
	}


	public ArrayList<Member> withdrawUserNo(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Member> members = new MemberDao().withdrawUserNo(currentPage,limit,con, searchWord);
		
		close(con);
		
		return members;
	}

	public ArrayList<Member> withdrawPhone(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Member> members = new MemberDao().withdrawPhone(currentPage,limit,con, searchWord);
		
		close(con);
		
		return members;
	}


	
	public ArrayList<Member> withdrawEnrolldate(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Member> members = new MemberDao().withdrawEnrolldate(con, searchWord);
		
		close(con);
		
		return members;
	}

	public ArrayList<Member> withdrawWithdrawdate(String searchWord) {
		Connection con = getConnection();
		
		ArrayList<Member> members = new MemberDao().withdrawWithdrawdate(con, searchWord);
		
		close(con);
		
		return members;
	}



	public  int getListName(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getListName(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public int getListId(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getListId(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public int getListuserNo(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getListuserNo(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Member> searchUserNo(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().searchUserNo(con,searchWord,currentPage,limit);
		close(con);
		
		
		return members;
	}

	public int getListPhone(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getListPhone(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Member> searchPhone(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().searchPhone(con,searchWord,currentPage,limit);
		close(con);
		
		
		return members;
	}

	public int getListAge(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getListAge(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Member> searchAge(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().searchAge(con,searchWord,currentPage,limit);
		close(con);
		
		
		return members;
	}

	public int getListGender(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getListGender(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Member> searchGender(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().searchGender(con,searchWord,currentPage,limit);
		close(con);
		
		
		return members;
	}

	public int getListEnrolldate(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getListEnrolldate(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Member> searchEnrolldate(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().searchEnrolldate(con,searchWord,currentPage,limit);
		close(con);
		
		
		return members;
	}

	public int getWithListName(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getWithListName(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Member> withdrawName(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().withdrawName(con,searchWord,currentPage,limit);
		close(con);
		
		
		return members;
	}

	public int getWithListId(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getWithListId(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Member> withdrawUserId(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().withdrawUserId(con,searchWord,currentPage,limit);
		close(con);
		
		
		return members;
	}

	public int getWithListUserNo(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getWithListUserNo(con,searchWord);
		
		close(con);
		
		return listCount;
		
	}

	public int getWithListPhone(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getWithListPhone(con,searchWord);
		
		close(con);
		
		return listCount;
		
	}

	public int getWithListAge(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getWithListAge(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Member> withdrawAge(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().withdrawAge(con,searchWord,currentPage,limit);
		close(con);
		
		
		return members;
	}

	public int getWithListGender(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getWithListGender(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Member> withdrawGender(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().withdrawGender(con,searchWord,currentPage,limit);
		close(con);
		
		
		return members;
	}

	public int getWithListEnrolldate(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getWithListEnrolldate(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Member> withdrawEnrolldate(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().withdrawEnrolldate(con,searchWord,currentPage,limit);
		close(con);
		
		
		return members;
		
		
	}

	public int getWithListWithdrawDate(String searchWord) {
		Connection con = getConnection();

		int listCount = new MemberDao().getWithListWithdrawDate(con,searchWord);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Member> withListWithdrawDate(int currentPage, int limit, String searchWord) {
		Connection con = getConnection();
		ArrayList<Member> members = new MemberDao().withListWithdrawDate(con,searchWord,currentPage,limit);
		close(con);
		
		
		return members;
		
		
	}

	public int getListAll() {
		
		Connection con = getConnection();

		int listCount = new MemberDao().getListAll(con);
		
		close(con);
		
		return listCount;
	}

	


	

	
	

	
}


