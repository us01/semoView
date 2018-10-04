package com.chain.triangleView.review.controller;

import java.io.IOException;
import java.rmi.server.SocketSecurityException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.review.review.service.ReviewService;

public class loadOneReviewForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loadOneReviewForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rwNo = Integer.parseInt(request.getParameter("rwNo"));
		int rwContentType = Integer.parseInt(request.getParameter("rwContentType"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		HashMap<String, Object> reviewForm = new ReviewService().loadOneRevie(rwNo, userNo);
		
		if(reviewForm != null){
			int result = new ReviewService().updateRwCount(rwNo);
			
			if(result > 0) {
				int result2 = new ReviewService().findTodayRwCount(rwNo);
				
				if(result2 > 0) {
					 new ReviewService().updateTodayRwCount(rwNo);
				}else {
					 new ReviewService().insertTodayRwCount(rwNo);
				}
			}
			
			request.setAttribute("reviewForm", reviewForm);
			
			if(rwContentType == 0){
				request.getRequestDispatcher("/views/reviewFormPage/textForm.jsp").forward(request, response);
			}else if(rwContentType == 1){
				request.getRequestDispatcher("/views/reviewFormPage/cardForm.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("/views/reviewFormPage/videoForm.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "리뷰 폼 읽어오기 실패");
			request.getRequestDispatcher("/views/errorPage/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
