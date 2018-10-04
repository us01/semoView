package com.chain.triangleView.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.Review;

public class UserHomeReviewSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserHomeReviewSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		ArrayList<Review> userReviewList = new ReviewService().userHomeReviewSelect(userId);
		
		if(userReviewList != null){
			request.setAttribute("userReviewList", userReviewList);
			request.getRequestDispatcher("views/myPage/myHome.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "회원이 등록한 리뷰 조회 실패");
			request.getRequestDispatcher("views/errorPage/errorPage.jsp").forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
