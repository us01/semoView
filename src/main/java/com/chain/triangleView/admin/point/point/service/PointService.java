package com.chain.triangleView.admin.point.point.service;

import static com.chain.triangleView.common.JDBCTemplate.close;
import static com.chain.triangleView.common.JDBCTemplate.commit;
import static com.chain.triangleView.common.JDBCTemplate.getConnection;
import static com.chain.triangleView.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.chain.triangleView.admin.payment.payment.dao.PaymentDao;
import com.chain.triangleView.admin.point.point.dao.PointDao;
import com.chain.triangleView.admin.point.point.vo.Point;

public class PointService {

	public ArrayList<Point> searchPoint(String option, String searchWord, String FromDt, String ToDt) {
		
		Connection con = getConnection();
		
		ArrayList<Point> points = new PointDao().searchPoint(con,option,searchWord,FromDt,ToDt);
		
		if(points != null){
			commit(con);
		}else{
			rollback(con);
		}
		close(con);
		System.out.println("service"+points);
		return points;
		
	}




	public ArrayList<Point> searchUserId(String option, String searchWord, String FromDt, String ToDt) {
		Connection con = getConnection();
		
		ArrayList<Point> points = new PointDao().searchUserId(con,option,searchWord,FromDt,ToDt);
		
		if(points != null){
			commit(con);
		}else{
			rollback(con);
		}
		close(con);
		System.out.println("service"+points);
		return points;
		
	}
	public ArrayList<Point> searchUserLevel(String option, String searchWord, String FromDt, String ToDt) {
		Connection con = getConnection();
		
		ArrayList<Point> points = new PointDao().searchUserLevel(con,option,searchWord,FromDt,ToDt);
		
		if(points != null){
			commit(con);
		}else{
			rollback(con);
		}
		close(con);
		System.out.println("service"+points);
		return points;
	}



	public ArrayList<Point> pointPayback() {
		Connection con = getConnection();
		ArrayList<Point> points = new PointDao().pointPayback(con);
		if(points != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+points);
		close(con);
		
		
		return points;
	}



	public ArrayList<Point> dailyPointPayback() {
		
		
		Connection con = getConnection();
		ArrayList<Point> points = new PointDao().dailyPointPayback(con);
		if(points != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+points);
		close(con);
		
		
		return points;
	
	}




	public int getlistCount() {
		Connection con = getConnection();

		int listCount = new PointDao().getlistCount(con);
		
		close(con);
		
		return listCount;
	}




	public ArrayList<Point> selectAllCount(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Point> points = new PointDao().selectAllCount(con,currentPage,limit);
		if(points != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+points);
		close(con);
		
		
		return points;
	}


}
