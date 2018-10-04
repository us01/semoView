package com.chain.triangleView.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.notice.notice.service.NoticeService;
import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.Review;

public class logoutMainReviewSelectService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public logoutMainReviewSelectService() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Review> reviewList = new ReviewService().logoutMainListSelect();

		if(reviewList != null){
			
			ArrayList<HashMap<String, Object>> noticeList = new NoticeService().selectCurrNotice();

			if(noticeList != null) {
				request.setAttribute("noticeList", noticeList);
			}
			request.setAttribute("reviewList", reviewList);
			request.getRequestDispatcher("/views/main/logoutMain/logoutMain.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "메인 인기리뷰 조회 실패");
			request.getRequestDispatcher("/views/errorPage/errorPage.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
