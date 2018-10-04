package com.chain.triangleView.review.controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.member.member.service.MemberService;
import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.hottag.Service.HotTagService;
import com.chain.triangleView.notice.notice.service.NoticeService;
import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.Review;

public class SearchReviewServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public SearchReviewServlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      if(((Member)request.getSession().getAttribute("loginUser")) != null){
         Member followCountMember = new MemberService().followCountSelect(((Member)request.getSession().getAttribute("loginUser")).getUserNo());
         request.setAttribute("followCountMember", followCountMember);
      }
      
      int userNo = -1;
      
      if((Member)request.getSession().getAttribute("loginUser") != null){
         userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
      }
      
      String searchHash = request.getParameter("searchHash");
      String searchData = request.getParameter("searchData");
      String sinceTime = request.getParameter("sinceTime");
      String untilTime = request.getParameter("untilTime");
      String term = request.getParameter("Term");
      String recent = request.getParameter("recent");
      String like = request.getParameter("like");
      String hits = request.getParameter("hits");
      String text = request.getParameter("text");
      String card = request.getParameter("card");
      String video = request.getParameter("video");
      String follower = request.getParameter("follower");
      String company = request.getParameter("company");
      String query = "";

      if(sinceTime != "" || untilTime != "" || term != null ||
         recent != null || like != null || hits != null ||
         text != null || card != null ||  video != null ||
         follower != null || company != null){
         
         query = new ReviewService().orderQuery(userNo, sinceTime, untilTime, term, recent, like, hits, text, card, video);
         
         ArrayList<Review> searchReviewList = new ReviewService().searchSettingSelect(searchHash, query, follower, company, userNo);
         ArrayList<HashMap<String, Object>> noticeList = null;

         new HotTagService().countTag(searchData); 
          
         if(searchReviewList != null){
            noticeList = new NoticeService().selectAllNotice();

            if(noticeList != null) {
               request.setAttribute("selectAllNotice", noticeList);
               request.setAttribute("searchReviewList", searchReviewList);
               request.setAttribute("searchReviewData", searchData);
            }else {
               request.setAttribute("searchReviewList", searchReviewList);
               request.setAttribute("searchReviewData", searchData);
            }

            request.getRequestDispatcher("/views/main/loginMain/loginMain.jsp").forward(request, response);
         }else{
            request.setAttribute("msg", "검색한 리뷰 읽어오기 실패");
            request.getRequestDispatcher("/views/errorPage/errorPage.jsp").forward(request, response);
         }
      }else {
         
         ArrayList<Review> searchReviewList = new ReviewService().searchHashSelect(searchHash);
         ArrayList<HashMap<String, Object>> noticeList = null;
   
         new HotTagService().countTag(searchData); 
          
         if(searchReviewList != null){
            noticeList = new NoticeService().selectAllNotice();
   
            if(noticeList != null) {
               request.setAttribute("selectAllNotice", noticeList);
               request.setAttribute("searchReviewList", searchReviewList);
               request.setAttribute("searchReviewData", searchData);
            }else {
               request.setAttribute("searchReviewList", searchReviewList);
               request.setAttribute("searchReviewData", searchData);
            }
   
            request.getRequestDispatcher("/views/main/loginMain/loginMain.jsp").forward(request, response);
         }else{
            request.setAttribute("msg", "검색한 리뷰 읽어오기 실패");
            request.getRequestDispatcher("/views/errorPage/errorPage.jsp").forward(request, response);
         }
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}