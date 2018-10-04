package com.chain.triangleView.pay.pay.service;

import java.sql.Connection;

import com.chain.triangleView.allian.allian.dao.AllianDao;
import com.chain.triangleView.notice.notice.dao.NoticeDao;
import com.chain.triangleView.pay.pay.dao.PayDao;
import com.chain.triangleView.pay.pay.vo.PayMent;

import static com.chain.triangleView.common.JDBCTemplate.*;

public class PayService {

	public int[] insertPay(int userId, int serviceNo) {
		Connection con = getConnection();
		int result[] = {0,0};

		int result1 = new PayDao().insertPay(con,userId,serviceNo);

		if(result1 > 0){
			commit(con);
			result[0] = 1;
		}else{
			System.out.println("결제인서트실패!!");
		}
		//결제코드를 받으러 가자
		int payCode = new PayDao().payCodeCheck(con);

		result[1] = payCode;

		close(con);


		return result;
	}

	public int insertNoticePayMent(PayMent p, int serviceNo) {
		Connection con = getConnection();
		int result = 0;
		int result1 = 0;	// payInfo 인서트
		int result2 = 0;

		result1 = new PayDao().insertNoticePayMent(con,p);

		if(result1 > 0){
			System.out.println("페이인포 인서트 성공");
			//결제후 공고상태를 1에서 0으로 바꿔줌
			result2 = new NoticeDao().updateNotice(con,serviceNo);
			if(result2 > 0){
				System.out.println("업데이트 성공");
				commit(con);
				result = 1;				
			}else{
				System.out.println("업데이트 실패입니다.");
			}
		}else{
			System.out.println("결제실패입니다.");
		}

		close(con);


		return result;
	}

	public int[] insertAllianPay(int userId, int serviceNo) {
		Connection con = getConnection();
		int result[] = {0,0};

		int result1 = new PayDao().insertAllianPay(con,userId,serviceNo);

		if(result1 > 0){
			commit(con);
			result[0] = 1;
		}else{
			System.out.println("결제인서트실패!!");
		}


		int payCode = new PayDao().payCodeCheck(con);

		result[1] = payCode;

		close(con);


		return result;
	}

	public int insertAllianPayMent(PayMent p, int allianCode, int rwNo, String allianLink) {
		Connection con =getConnection();
		int result = 0;
		int result1 = 0;
		int result2 = 0;

		result1 = new PayDao().insertAllianPayMent(con,p);

		if(result1 > 0){
			System.out.println("페이인포 인서트 성공");
			//결제후 리뷰 정보 수정
			result2 = new AllianDao().updateReview(con,allianCode,rwNo,allianLink);
			System.out.println("result3몇이니??" +result2);
			if(result2 > 0){
				System.out.println("리뷰 업데이트 완료!!!");
				commit(con);
				result = 1;
			}else{
				System.out.println("리뷰 업데이트 실패에요!");
			}
			
			close(con);
		}
		return result;

	}

}
