package com.chain.triangleView.review.review.service;

import com.chain.triangleView.member.member.memberDao.MemberDao;
import com.chain.triangleView.member.member.vo.Attachment;
import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.review.review.reviewDao.ReviewDao;
import com.chain.triangleView.review.review.vo.CardFormImages;
import com.chain.triangleView.review.review.vo.Form;
import com.chain.triangleView.review.review.vo.Review;
import com.chain.triangleView.review.review.vo.RwComment;

import static com.chain.triangleView.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class ReviewService {
   
   public ArrayList<Review> logoutMainListSelect() {
      Connection con = getConnection();
      
      ArrayList<Review> reviewList = null;
      reviewList = new ReviewDao().logoutMainListSelect(con);
      
      close(con);
      
      return reviewList;
   }

   public HashMap<String, Object> loadOneRevie(int rwNo, int userNo) {
      Connection con = getConnection();
      
      HashMap<String, Object> reviewForm = new HashMap<String, Object>();
      ArrayList<CardFormImages> cardImageList = null;
      
      Form form = new ReviewDao().loadOneForm(con, rwNo, userNo);
      
      if(form != null){
         reviewForm.put("form", form);
         
         if(form.getRwContentType() == 1){
            cardImageList = new ReviewDao().loadOneFormCardImg(con, rwNo);
            
            if(cardImageList != null){
               reviewForm.put("cardImageList", cardImageList);
            }
         }
         ArrayList<RwComment> rwComment = new ReviewDao().loadOneFormComment(con, rwNo);
         
         reviewForm.put("rwComment", rwComment);
      }
      
      close(con);
      
      return reviewForm;
   }

   public ArrayList<Review> selectInterestReview(int userNo) {
      Connection con = getConnection();
      
      ArrayList<Review> reviewList = null;
      reviewList = new ReviewDao().selectInterestReview(con, userNo);
      
      close(con);
      
      return reviewList;
   }

   public ArrayList<Review> searchHashSelect(String searchHash) {
      Connection con = getConnection();
      
      ArrayList<Review> searchReviewList = new ReviewDao().searchHashSelect(con, searchHash);
      
      close(con);
      
      return searchReviewList;
   }
   
   public int write2Review(Review rw, Member m, ArrayList<Attachment> fileList, String[] resultHashSplit, String categoryHashResult) {
      Connection con = getConnection();
      int result = 0;
      int result1 = new ReviewDao().write2Review(con,rw,m);
      int result2 = 0;
      int result3 = 0;
      int result4 = 0;
      
      if(result1 > 0){
         Review rwNoCheck = new ReviewDao().reviewNoCheck(con, m);   
         
         for(int i =0; i < resultHashSplit.length; i++){
            String resultHash = resultHashSplit[i];
            result3 = new ReviewDao().insertHashtag(con,rwNoCheck,resultHash);
         }
         result4 = new ReviewDao().insertHashtag(con,rwNoCheck,categoryHashResult);
         
         if(fileList != null){
            
            result2 = new ReviewDao().insertWriteAttachment(con,fileList,m,rwNoCheck);
         }
      }
      
      
      if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0){
         commit(con);
         result = 1;
      }else{
         rollback(con);
      }
      
      close(con);
      
      return result;
   }

   public int write3Review(Review rw, Member m, ArrayList<Attachment> fileList, String[] resultHashSplit, String categoryHashResult) {
      Connection con = getConnection();
      int result = 0;
      int result1 = new ReviewDao().write3Review(con,rw,m);
      int result2 = 0;
      int result3 = 0;
      int result4 = 0;

      
      if(result1 > 0){
         Review rwNoCheck = new ReviewDao().reviewNoCheck(con, m);   
         
         for(int i =0; i < resultHashSplit.length; i++){
            String resultHash = resultHashSplit[i];
            result3 = new ReviewDao().insertHashtag(con,rwNoCheck,resultHash);
         }
         result4 = new ReviewDao().insertHashtag(con,rwNoCheck,categoryHashResult);
         
         if(fileList != null){
            
            result2 = new ReviewDao().insertWriteAttachment(con,fileList,m,rwNoCheck);
         }
      }
      
      
      if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0){
         commit(con);
         result = 1;
      }else{
         rollback(con);
      }
      
      close(con);
      
      return result;
   }

   public ArrayList<Review> userHomeReviewSelect(String userId) {
      Connection con = getConnection();
      
      ArrayList<Review> userReviewList = new ReviewDao().userHomeReviewSelect(con, userId);
      
      close(con);
      
      return userReviewList;
   }

   public int addComment(int rwNo, int commentNo, int userNo, String commentContent) {
      Connection con = getConnection();
         
      int result = new ReviewDao().addComment(con, rwNo, commentNo, userNo, commentContent);
      
      if(result > 0){
         commit(con);
      }else{
         rollback(con);
      }
      
      close(con);
      
      return result;
   }

   public int write1Review(Review rw, Member m, ArrayList<Attachment> fileList, String[] resultHashSplit, String categoryHashResult) {
   Connection con = getConnection();
      
      int result = 0;
      int result1 = new ReviewDao().write1Review(con,rw,m);
      int result2 = 0;
      int result3 = 0;
      int result4 = 0;
      
      if(result1 > 0){
         Review rwNoCheck = new ReviewDao().reviewNoCheck(con, m);   
         
         for(int i =0; i < resultHashSplit.length; i++){
            String resultHash = resultHashSplit[i];
            result3 = new ReviewDao().insertHashtag(con,rwNoCheck,resultHash);
         }
         result4 = new ReviewDao().insertHashtag(con,rwNoCheck,categoryHashResult);
         
         if(fileList != null){
            
            result2 = new ReviewDao().insertWriteAttachment(con,fileList,m,rwNoCheck);
         }
      }
      
      
         
      if(result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0){
         commit(con);
         result = 1;
      }else{
         rollback(con);
      }
      
      

      close(con);

      return result;
   
   }

   public ArrayList<RwComment> loadOneFormComment(int rwNo) {
      Connection con = getConnection();
      
      ArrayList<RwComment> rwComment = new ReviewDao().loadOneFormComment(con, rwNo);
      
      close(con);
      
      return rwComment;
   }

   public int addLikeReview(int userNo, int rwNo) {
      Connection con = getConnection();
      
      int result = new ReviewDao().addLikeReview(con, userNo, rwNo);
      
      if(result > 0){
         commit(con);
      }else{
         rollback(con);
      }
      
      close(con);
      
      return result;
   }

   public HashMap<String, Object> write1Detail(int rwNo) {
      Connection con = getConnection();
      
      HashMap<String, Object> hmap = null;
      
      int result = new ReviewDao().updateCount(con, rwNo);
      
      if(result > 0 ){
         commit(con);
         //hmap = new ReviewDao().selectThumbnailListMap(con,rwNo);
      }else{
         rollback(con);
      }
      
      close(con);
      
      
      return hmap;

   }

   public HashMap<String, Object> write1Select(int rwNo) {
      Connection con = getConnection();
      
      HashMap<String, Object> hmap = null;

      int result = new ReviewDao().writeSelect(con,rwNo);
      if(result > 0){
         commit(con);
         hmap = new ReviewDao().selectContent(con,rwNo);
      }else{
         rollback(con);
      }
      
      close(con);
      
      return hmap;
   }

   public HashMap<String, Object> write2Select(int rwNo) {
      Connection con = getConnection();
      
      HashMap<String, Object> hmap = null;

      int result = new ReviewDao().writeSelect(con,rwNo);
      if(result > 0){
         commit(con);
         hmap = new ReviewDao().selectContent(con,rwNo);
      }else{
         rollback(con);
      }
      
      close(con);
      
      return hmap;
   }

   public HashMap<String, Object> write3Select(int rwNo) {
      Connection con = getConnection();
      
      HashMap<String, Object> hmap = null;

      int result = new ReviewDao().writeSelect(con,rwNo);
      if(result > 0){
         commit(con);
         hmap = new ReviewDao().selectContent(con,rwNo);
      }else{
         rollback(con);
      }
      
      close(con);
      
      return hmap;
   }

   public int updateWrite3(Review rw, Member m, String[] resultHashSplit, String categoryHashResult) {
      Connection con = getConnection();
      int result2 =0;
      int result3 =0;
      int result = new ReviewDao().updateWrite(con,rw);
      
      int result1 = new ReviewDao().deleteHashtag(con,rw);

      for(int i =0; i < resultHashSplit.length; i++){
         String resultHash = resultHashSplit[i];
         result2 = new ReviewDao().updateHashtag(con,rw,resultHash);
      }
         result3 = new ReviewDao().updateHashtag(con,rw,categoryHashResult);

      if(result > 0){
         commit(con);
      }else{
         rollback(con);
      }
      
      close(con);

      return result;
   }   
  
   public int updateRwCount(int rwNo) {
      Connection con = getConnection();
      
      int result = new ReviewDao().updateRwCount(con, rwNo);
      
      if(result > 0) {
         
         commit(con);
      }else {
         
         rollback(con);
      }
      close(con);
      
      return result;
   }

   public int findTodayRwCount(int rwNo) {
      Connection con = getConnection();
      
      int result = new ReviewDao().findTodayRwCount(con, rwNo);
      
      if(result > 0) {
         
         commit(con);
      }else {
         
         rollback(con);
      }
      close(con);
      
      return result;
   }      

   public int updateTodayRwCount(int rwNo) {
      Connection con = getConnection();
      
      int result = new ReviewDao().updateTodayRwCount(con, rwNo);
      
      if(result > 0) {
         
         commit(con);
      }else {
         
         rollback(con);
      }
      close(con);
      
      return result;
   }

   public int insertTodayRwCount(int rwNo) {
   
      Connection con = getConnection();
      
      int result = new ReviewDao().insertTodayRwCount(con, rwNo);
      
      if(result > 0) {
         
         commit(con);
      }else {
         
         rollback(con);
      }
      close(con);
      
      return result;
   }

   public String orderQuery(int userNo, String sinceTime, String untilTime, String term, String recent, String like, String hits,
         String text, String card, String vedio) {
      
      String query = "";
      
      if(!sinceTime.equals("") || !untilTime.equals("")){
         query += " AND WRITEDATE BETWEEN TO_DATE('" + sinceTime + "') AND TO_DATE('" + untilTime + "') ";
      }else if(term != null){
         if(term.equals("oneDay")){
            query += " AND WRITEDATE BETWEEN SYSDATE - 1 AND SYSDATE ";
         }else if(term.equals("oneWeek")){
            query += " AND WRITEDATE BETWEEN SYSDATE - 7 AND SYSDATE ";
         }else if(term.equals("oneMonth")){
            query += "AND  WRITEDATE BETWEEN ADD_MONTHS(SYSDATE, -1) AND SYSDATE ";
         }
      }
      
      if(text != null && card != null && vedio == null) {
         
         query += " AND  RWCONTENTTYPE IN (0, 1) " ;
      }else if(text != null && vedio != null  && card == null) {
         
         query += " AND  RWCONTENTTYPE IN (0, 2) " ;
      }else if(text == null && vedio != null  && card != null) {
         
         query += " AND  RWCONTENTTYPE IN (1, 2) " ;
      }else if(text != null && vedio != null  && card != null) {
         
         query += " AND  RWCONTENTTYPE IN (0, 1, 2) " ;
      }else if(text != null){
         
         query += " AND RWCONTENTTYPE = 0 ";
      }else if(card != null){
   
         query += " AND  RWCONTENTTYPE = 1 " ;
      }else if(vedio != null){
         
         query += " AND  RWCONTENTTYPE = 2 " ;
      }
      
      //마지막 order by 부분
      if(recent != null){
         query += " ORDER BY WRITEDATE DESC";
      }else if(like != null){
         query += " ORDER BY LIKECOUNT DESC" ;
      }else if(hits != null){
         query += " ORDER BY RWCOUNT DESC" ;
      }
      
      return query;
   }

   public ArrayList<Review> searchSettingSelect(String searchHash, String query, String follower, String company, int userNo) {
      Connection con = getConnection();
      ArrayList<Review> searchReviewList = null;
      
      if(follower != null) {
         
         searchReviewList = new ReviewDao().searchSettingFollowSelect(con, searchHash, query, follower, company, userNo);
      }else {
         
         searchReviewList = new ReviewDao().searchSettingSelect(con, searchHash, query, company);
      }
      
      close(con);
      
      return searchReviewList;
   }

   public int updateWrite1(Review rw, Member m, ArrayList<Attachment> fileList, String[] resultHashSplit,
         String categoryHashResult) {
      
      Connection con = getConnection();
      
      int result = new ReviewDao().updateWrite(con,rw);
      
      if(result > 0 ){
         if(fileList.size() != 0){
            int result1 = new ReviewDao().deleteWrite(con,rw);
            commit(con);
            
            int result2 = new ReviewDao().insertWriteAttachment(con, fileList, m, rw);
            commit(con);
         }
         
            int result3 = new ReviewDao().deleteHashtag(con,rw);
         for(int i =1; i < resultHashSplit.length; i++){
            String resultHash = resultHashSplit[i];
            int result4 = new ReviewDao().updateHashtag(con,rw,resultHash);
         }
         int result5 = new ReviewDao().updateHashtag(con,rw,categoryHashResult);
         
         commit(con);
      }
      
      close(con);

      return result;
   }

   public int findSentiment(String searchReviewData) {
      
      Connection con = getConnection();
      
      int result = new ReviewDao().findSentiment(con, searchReviewData);
      
      close(con);
      
      return result;
   }

   public int[] selectSentiment(String searchReviewData) {
      
      Connection con = getConnection();
      int[] result = {0, 0, 0};
      result = new ReviewDao().selectSentiment(con, searchReviewData);
      
      close(con);
      
      return result;
   }

   public void insertSentiment(String searchReviewData, int[] feel) {
      
      Connection con = getConnection();
      
      int result = new ReviewDao().insertSentiment(con, searchReviewData, feel);
      
      if(result > 0) {
         
         commit(con);
      }else {
         
         rollback(con);
      }
      
      close(con);
   }

   public Review insertPointInfo(String ip, Review rw) {
      Connection con = getConnection();
      int result1 = 0;
      Review rwResult = null;
      int result = new ReviewDao().checkPointIp(con,ip,rw);
      if(result > 0 ){
      
         rollback(con);
      }else{
         result1 = new ReviewDao().insertPointInfo(con,ip,rw);   
         int result2 = new MemberDao().updatePoint(con,rw);
         rwResult = new ReviewDao().findCoorlink(con,rw);
         commit(con);
      }
      
      close(con);
      
      return rwResult;
   }   
}