package com.chain.triangleView.member.member.service;


import static com.chain.triangleView.common.JDBCTemplate.*;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;

import com.chain.triangleView.member.member.memberDao.MemberDao;
import com.chain.triangleView.member.member.vo.Attachment;
import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.member.member.vo.MemberInterestCategory;
import com.chain.triangleView.member.member.vo.PowerReviewer;


public class MemberService {

	public Member loginCheck(String userId, String userPwd) {
		Connection con = getConnection();
		
		Member member = new MemberDao().loginCheck(con, userId, userPwd);
		
		close(con);
		
		return member;
	}

	public int modifyUserPwd(String userId, String userPwd) {
		Connection con = getConnection();
		
		int result = new MemberDao().modifyUserPwd(con,userId, userPwd);
		
		close(con);
		
		return result;
	}

	public int insertMember(Member m, ArrayList<Attachment> fileList) {
			Connection con = getConnection();
			int result = 0;
			int result1 = new MemberDao().insertMember(con,m);
			
			//멤버 번호를 받아오자
			if(result1 >0){
				Member member = new MemberDao().userNoCheck(con, m);
				for(int i =0; i < fileList.size(); i++){
					fileList.get(i).setUserId(member.getUserNo());
				}
			}
			
			//첨부파일테이블에 넣기
			if(fileList != null){
				
				int result2 = new MemberDao().insertAttachment(con,fileList,m);
			}
			
			if(result1 > 0){
				commit(con);
				result = 1;
			}else{
				rollback(con);
			}

			close(con);

			return result;

	}
	
	public int insertCompanyMember(Member m, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		int result = 0;
		int result1 = new MemberDao().insertCompanyMember(con,m);
		
		//멤버 번호를 받아오자
		if(result1 >0){
			Member member = new MemberDao().userNoCheck(con, m);
			for(int i =0; i < fileList.size(); i++){
				fileList.get(i).setUserId(member.getUserNo());
			}
		}
		//첨부파일테이블에 넣기
		if (fileList != null) {
			
			int result2 = new MemberDao().insertAttachment(con, fileList, m);
		}
		
		if(result1 > 0){
			commit(con);
			result = 1;
		}else{
			rollback(con);
		}

		close(con);

		return result;
		
	}

	public int NickCheck(String nick) {
		Connection con = getConnection();
		int result=new MemberDao().NickCheck(con,nick);
		
		
		close(con);
		
		return result;

	}


	public Member userNoCheck(Member m) {
		Connection con = getConnection();
		
		
		Member member = new MemberDao().userNoCheck(con,m);
		
		close(con);
		
		return member;
	}

	public int insertCategory1(Member userNoCheck) {
		Connection con = getConnection();
		
		int result = new MemberDao().insertCategory1(con,userNoCheck);
		close(con);
		
		
		return result;
	}

	public Member findId(Member m) {
		Connection con = getConnection();
		
		Member find = new MemberDao().findId(con,m);
		close(con);
		
		return find;
	}

	public int checkMember(Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().checkMember(con, m);
		close(con);
		
		
		return result;
	}

	public int findPass(Member m, String resultPass) {
		Connection con = getConnection();
		int result = 0;
		
		result = new MemberDao().findPass(con,m,resultPass);
		close(con);
		
		return result;
	}


	public int checkId(String id) {
		Connection con = getConnection();
		int result = 0;
		
		result = new MemberDao().checkId(con,id);
		
		close(con);
		
		return result;
	}

	public int userFollowFalse(int meNo, int userNo) {
		Connection con = getConnection();
			
		int result = new MemberDao().userFollowFalse(con, meNo, userNo);
		
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}	
	
	public int userFollowTrue(int meNo, int userNo) {
		Connection con = getConnection();
			
		int result = new MemberDao().userFollowTrue(con, meNo, userNo);
		
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ArrayList<Member> followUserList(int userNo, int meNo) {
		Connection con = getConnection();
		
		ArrayList<Member> userList = new MemberDao().followUserList(con, userNo, meNo);
		
		close(con);
		
		return userList;
	}
	
	public ArrayList<Member> followingUserList(int userNo, int meNo) {
		Connection con = getConnection();
		
		ArrayList<Member> userList = new MemberDao().followingUserList(con, userNo, meNo);
		
		close(con);
		
		return userList;
	}

	public Member followCountSelect(int userNo) {
		Connection con = getConnection();
		
		Member followCountMember = new MemberDao().followCountSelect(con, userNo);
		
		close(con);
		
		return followCountMember;
	}

  public int updateMember(Member m, ArrayList<Attachment> fileList) {
      Connection con = getConnection();
      int result = 0;
      

      int result1 = new MemberDao().updateMember(con,m);
      
      int result2 = new MemberDao().updateAttachment(con, fileList, m);
      
      
      if(result1 > 0){
         commit(con);
         result = 1;
      }else{
         rollback(con);
      }
      
      
      close(con);
      return result;
   }
      
	public ArrayList<MemberInterestCategory> interestCategorySelect(int userNo) {
		Connection con = getConnection();
		
		ArrayList<MemberInterestCategory>  loginUserInterestCategory = new MemberDao().interestCategorySelect(con, userNo);
		
		close(con);
		
		return loginUserInterestCategory;
	}

	public int insertCategory(int userNo, int categoryCode) {
		Connection con = getConnection();
		
		int result = new MemberDao().insertCategory(con, userNo, categoryCode);
		
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public int updatePassword(int userNo, String newPwd) {
		Connection con = getConnection();
    
		int result = new MemberDao().updatePassword(con,userNo,newPwd);
    
		close(con);
		
		return result;
	}

	public int deleteCategory(int userNo, int categoryCode) {
		Connection con = getConnection();
		
		int result = new MemberDao().deleteCategory(con, userNo, categoryCode);
		
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int refundPoint(Member m, int refundPoint, int myPoint) {
		Connection con = getConnection();
		
		
		
		int result = new MemberDao().refundPoint(con,m,refundPoint);
	
		int result1 = new MemberDao().refundUpdate(con,m,myPoint);
	
		if(result > 0 && result1 > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public PowerReviewer powerReviewer(Member m) {
		Connection con = getConnection();
		PowerReviewer pr = new MemberDao().powerReviewer(con,m);
		
		close(con);
		
		return pr;
	}

	public int updatePowerReviewer(int userNo) {
		Connection con = getConnection();
		
		int result = new MemberDao().updatePowerReviewer(con,userNo);
		
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		close(con);
		
		return result;
	}
}
