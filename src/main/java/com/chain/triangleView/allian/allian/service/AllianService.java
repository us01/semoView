package com.chain.triangleView.allian.allian.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.chain.triangleView.allian.allian.dao.AllianDao;
import com.chain.triangleView.allian.allian.vo.Allian;
import com.chain.triangleView.allian.allian.vo.AllianData;
import com.chain.triangleView.notice.notice.dao.NoticeDao;

import static com.chain.triangleView.common.JDBCTemplate.*;

public class AllianService {


	//서비스를 먼저 등록해준다
	public int[] insertAllianService(Allian a, int rwNo) {
		Connection con = getConnection();
		int result[] = {0,0,0};
		int result1 = 0;
		//제휴 서비스 등록한다.
		result1 = new AllianDao().insertAllianService(con,a);
		System.out.println("가져왔냐??" + result1);

		//서비스가 인서트 되면 서비스시퀀스넘버를 조회하여 현재번호를 받아온다.
		if(result1 > 0){
			System.out.println("어떻게되었니??" + result1);
			int serviceNo = new NoticeDao().serviceNocheck(con);
			
			result[1] = serviceNo;
			//제휴 인서트 해주기위해 변수를 초기화해준다
			int result2 = 0;
			//서비스넘버를 조회해서 가지고 제휴를 인서트하러간다.
			result2 = new AllianDao().insertAllianCoor(con,a,serviceNo);
			
			//초기화한 변수가  0보다 커지면
			if(result2 > 0){
				//리뷰 업데이트를 위해 인서트한 제휴 시퀀스코드 조회하여 현재번호 받는다.
				int allianCode = new AllianDao().allianCodeCheck(con);
				result[2] = allianCode;
				commit(con);
				result[0] = 1;
				
			}else{
				System.out.println("제휴부분인서트실패여!!");
			}
			close(con);			
		}else{
			System.out.println("제휴서비스인서트 실패에여");
		}
		return result;
	}


}
