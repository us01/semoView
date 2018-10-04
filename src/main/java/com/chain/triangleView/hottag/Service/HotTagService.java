package com.chain.triangleView.hottag.Service;

import static com.chain.triangleView.common.JDBCTemplate.*;

import java.sql.Connection;

import com.chain.triangleView.hottag.dao.HotTagDao;
import com.chain.triangleView.member.member.memberDao.MemberDao;
import com.chain.triangleView.member.member.vo.Member;


public class HotTagService {

	public String[] selectHotTag() {

		Connection con = getConnection();

		String[] tags = new HotTagDao().selectHotTag(con);

		close(con);

		return tags;
	}

	public void countTag(String searchData) {
		Connection con = getConnection();

		int result1 = new HotTagDao().countTag(con, searchData);
		
		//멤버 번호를 받아오자
		if(result1 >0){
			
			int result2 = new HotTagDao().updateCountTag(con, searchData);
		}else{
			
			int result3 =  new HotTagDao().InsertCountTag(con, searchData);
		}
		
		if(result1 > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		close(con);	
	}
}
