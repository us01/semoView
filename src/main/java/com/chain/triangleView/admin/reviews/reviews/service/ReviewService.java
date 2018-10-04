package com.chain.triangleView.admin.reviews.reviews.service;

import static com.chain.triangleView.common.JDBCTemplate.close;
import static com.chain.triangleView.common.JDBCTemplate.commit;
import static com.chain.triangleView.common.JDBCTemplate.getConnection;
import static com.chain.triangleView.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.chain.triangleView.admin.reviews.reviews.dao.ReviewDao;
import com.chain.triangleView.admin.reviews.reviews.vo.Review;

public class ReviewService {

	public ArrayList<Review> searchReviewUserNo(String searchWord) {
		
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchReviewUserNo(con,searchWord);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		
		
		return reviews;
	}

	public int deleteReview(int rwNo, String reason) {
		
		Connection con = getConnection();
		
		int result = new ReviewDao().deleteReview(rwNo,reason,con);
		
		
		if(result>0){
			commit(con);
		}else{
			
			rollback(con);
		}
		
		close(con);
		return result;
		
	}

	public ArrayList<Review> searchReviewRwNo(String searchWord) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchReviewRwNo(con,searchWord);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}

	public ArrayList<Review> searchCategoryType(String categoryType) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchCategoryType(con,categoryType);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}

	public ArrayList<Review> searchRwCount(String searchWord) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchRwCount(con,searchWord);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;

	}

	public ArrayList<Review> searchRwcontentType(String rwcontentType) {
		
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchRwcontentType(con,rwcontentType);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}

	public ArrayList<Review> searchrwType(String rwType) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchrwType(con,rwType);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}

	public ArrayList<Review> searchWritedate(String searchWord) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchWritedate(con,searchWord);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}

	public ArrayList<Review> searchDeleteReviewUserNo(String searchWord) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchDeleteReviewUserNo(con,searchWord);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}

	public ArrayList<Review> searchDeleteReviewRwNo(String searchWord) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchDeleteReviewRwNo(con,searchWord);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}

	public ArrayList<Review> searchDeleteCategoryType(String categoryType) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchDeleteCategoryType(con,categoryType);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}

	public ArrayList<Review> searchDeleteRwCount(String searchWord) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchDeleteRwCount(con,searchWord);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}

	public ArrayList<Review> searchDeleteRwcontentType(String rwcontentType) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchDeleteRwcontentType(con,rwcontentType);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}

	public ArrayList<Review> searchDeleteCancleDate(String searchWord) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchDeleteCancleDate(con,searchWord);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;

}

	public int LiveReview(int rwNo) {
		Connection con = getConnection();
		
		int result = new ReviewDao().LiveReview(rwNo,con);
		
		
		if(result>0){
			commit(con);
		}else{
			
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public int getlistCount() {
		Connection con = getConnection();

		int listCount = new ReviewDao().getListAll(con);
		
		close(con);
		
		return listCount;
		
	}

	public ArrayList<Review> searchAll(int currentPage, int limit) {
		Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().searchAll(con,currentPage,limit);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}

	public int getDeletelistCount() {
		Connection con = getConnection();

		int listCount = new ReviewDao().getDeletelistCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Review> DeleteSearchAll(int currentPage, int limit) {
Connection con =getConnection();
		
		ArrayList<Review> reviews = new ReviewDao().DeleteSearchAll(con,currentPage,limit);
		
		if(reviews != null){
			commit(con);
		}else{
			rollback(con);
		}
		System.out.println("service:"+reviews);
		close(con);
		
		
		return reviews;
	}
	
	
	
}
