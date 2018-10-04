package com.chain.triangleView.admin.member.service;

import java.sql.Connection;
import java.util.ArrayList;
import static com.chain.triangleView.common.JDBCTemplate.close;
import static com.chain.triangleView.common.JDBCTemplate.commit;
import static com.chain.triangleView.common.JDBCTemplate.getConnection;
import static com.chain.triangleView.common.JDBCTemplate.rollback;

import com.chain.triangleView.admin.member.dao.BlackMemberDao;
import com.chain.triangleView.admin.member.vo.BlackMember;

public class BlackMemberService {

	public ArrayList<BlackMember> searchBlackcode(String searchWord) {
		Connection con = getConnection();
		ArrayList<BlackMember> blacks = new BlackMemberDao().searchBlackcode(con, searchWord);

		if (blacks != null) {
			commit(con);

		} else {

			rollback(con);
		}

		close(con);
		return blacks;
	}

	public ArrayList<BlackMember> searchuserNo(String searchWord) {
		Connection con = getConnection();
		ArrayList<BlackMember> blacks = new BlackMemberDao().searchBlackuserNo(con, searchWord);

		if (blacks != null) {
			commit(con);

		} else {

			rollback(con);
		}

		close(con);
		return blacks;

	}

	public ArrayList<BlackMember> searchPhone(String searchWord) {
		Connection con = getConnection();
		ArrayList<BlackMember> blacks = new BlackMemberDao().searchPhone(con, searchWord);

		if (blacks != null) {
			commit(con);

		} else {

			rollback(con);
		}

		close(con);
		return blacks;

	}

	public ArrayList<BlackMember> searchrwNo(String searchWord) {
		Connection con = getConnection();
		ArrayList<BlackMember> blacks = new BlackMemberDao().searchrwNo(con, searchWord);

		if (blacks != null) {
			commit(con);

		} else {

			rollback(con);
		}

		close(con);
		return blacks;

	}

	public ArrayList<BlackMember> searchcommentNo(String searchWord) {
		Connection con = getConnection();
		ArrayList<BlackMember> blacks = new BlackMemberDao().searchcommentNo(con, searchWord);

		if (blacks != null) {
			commit(con);

		} else {

			rollback(con);
		}

		close(con);
		return blacks;

	}

	public ArrayList<BlackMember> searchblackTime(String searchWord) {
		Connection con = getConnection();
		ArrayList<BlackMember> blacks = new BlackMemberDao().searchblackTime(con, searchWord);

		if (blacks != null) {
			commit(con);

		} else {

			rollback(con);
		}

		close(con);
		return blacks;

	}

	public ArrayList<BlackMember> searchblackNick(String searchWord) {
		
		Connection con = getConnection();
		ArrayList<BlackMember> blacks = new BlackMemberDao().searchblackNick(con, searchWord);

		if (blacks != null) {
			commit(con);

		} else {

			rollback(con);
		}

		close(con);
		return blacks;
	}

	public ArrayList<BlackMember> searchAll() {
		Connection con = getConnection();
		System.out.println("serviceHi");
		ArrayList<BlackMember> blacks = new BlackMemberDao().searchAll(con);

		if (blacks != null) {
			commit(con);

		} else {

			rollback(con);
		}

		close(con);
		return blacks;
	}

	


}
