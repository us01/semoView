package com.chain.triangleView.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.RwComment;

public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rwNo = Integer.parseInt(request.getParameter("rwNo")); 
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String commentContent = request.getParameter("commentContent");
		
		int result = new ReviewService().addComment(rwNo, commentNo, userNo, commentContent);
		
		if(result > 0){
			ArrayList<RwComment> rwComment = new ReviewService().loadOneFormComment(rwNo);
			
			request.setAttribute("rwComment", rwComment);
			request.setAttribute("rwNo", rwNo);
			request.getRequestDispatcher("/views/reviewFormPage/commentsForm.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "리뷰 조회를 실패했어요");
			request.getRequestDispatcher("/views/errorPage/errorPage.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
