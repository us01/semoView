package com.chain.triangleView.admin.payment.payment.service;

import static com.chain.triangleView.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chain.triangleView.admin.payment.payment.dao.PaymentDao;
import com.chain.triangleView.admin.payment.payment.vo.Payment;
import com.chain.triangleView.admin.reviews.reviews.dao.ReviewDao;
import com.chain.triangleView.admin.reviews.reviews.vo.Review;

public class PaymentService {





	public ArrayList<Payment> searchPayDetailCode(String searchWord,String FromDt,String ToDt) {
		Connection con =getConnection();
		
		ArrayList<Payment>  payments = new PaymentDao().searchPayDetailCode(con,searchWord,FromDt,ToDt);
		
		if(payments != null){
			commit(con);
		}else{
			rollback(con);
		}
		close(con);
		
		for(int i=0 ; i<payments.size(); i++){
		System.out.println("service:"+payments.get(i).getPayDetailCode());
		}
		
		return payments;
	}



	public ArrayList<Payment> searchcopName(String searchWord,String FromDt,String ToDt) {
		Connection con = getConnection();
		ArrayList<Payment> payments = new PaymentDao().searchcopName(con,searchWord,FromDt,ToDt);
		if(payments != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+payments);
		close(con);
		
		
		return payments;
	}

	public ArrayList<Payment> searchUserNo(String searchWord,String FromDt,String ToDt) {
		Connection con = getConnection();
		ArrayList<Payment> payments = new PaymentDao().searchUserNo(con,searchWord,FromDt,ToDt);
		if(payments != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+payments);
		close(con);
		
		
		return payments;
	}

	public ArrayList<Payment> searchServiceType(String serviceType,String FromDt,String ToDt) {
		
		Connection con = getConnection();
		ArrayList<Payment> payments = new PaymentDao().searchServiceType(con,serviceType,FromDt,ToDt);
		if(payments != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+payments);
		close(con);
		
		
		return payments;
	}

	public ArrayList<Payment> searchPayType(String payType,String  FromDt,String ToDt) {
		
		
		Connection con = getConnection();
		ArrayList<Payment> payments = new PaymentDao().searchPayType(con,payType,FromDt,ToDt);
		if(payments != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+payments);
		close(con);
		
		return payments;
	}

	public ArrayList<Payment> searchpayStatus(String payStatus,String FromDt,String ToDt) {
		Connection con = getConnection();
		ArrayList<Payment> payments = new PaymentDao().searchpayStatus(con,payStatus,FromDt,ToDt);
		if(payments != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+payments);
		close(con);
		
		return payments;
	}

	public ArrayList<Payment> paymentMargin() {
		Connection con = getConnection();
		ArrayList<Payment> payments = new PaymentDao().paymentMargin(con);
		if(payments != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+payments);
		close(con);
		
		return payments;
	}

	public ArrayList<Payment> paymentMargin2() {
		Connection con = getConnection();
		ArrayList<Payment> payments = new PaymentDao().paymentMargin2(con);
		if(payments != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+payments);
		close(con);
		
		return payments;
	}

	public ArrayList<Payment> paymentMargin3() {
		Connection con = getConnection();
		ArrayList<Payment> payments = new PaymentDao().paymentMargin3(con);
		if(payments != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+payments);
		close(con);
		
		return payments;

	}

	public ArrayList<Payment> paymentMargin4() {
		Connection con = getConnection();
		ArrayList<Payment> payments = new PaymentDao().paymentMargin4(con);
		if(payments != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+payments);
		close(con);
		
		return payments;

	}

	public int getlistCount() {
		Connection con = getConnection();

		int listCount = new PaymentDao().getlistCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Payment> selectAllCount(int currentPage, int limit) {
		Connection con =getConnection();
		
		
		System.out.println("servicehi");
		ArrayList<Payment> payments = new PaymentDao().selectAllCount(con,currentPage,limit);
		
		if(payments != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+payments);
		close(con);
		
		
		return payments;

	}

	
		
		
		
	}



	
	



