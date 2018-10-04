package com.chain.triangleView.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.CardFormImages;
import com.chain.triangleView.review.review.vo.Review;

/**
 * Servlet implementation class write2SelectServlet
 */
public class write2SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public write2SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rwNo = Integer.parseInt(request.getParameter("rwNo"));
	
		HashMap<String, Object> hmap = new ReviewService().write2Select(rwNo);
		
		Review rw = (Review)hmap.get("review");
		ArrayList<CardFormImages> fileList = (ArrayList<CardFormImages>)hmap.get("CardFormImages");
		
		String page="";
		if(hmap != null){
			page="views/writeForm/write2Update.jsp";
			request.setAttribute("rw", rw);
			request.setAttribute("fileList", fileList);
			request.getRequestDispatcher("views/writeForm/write2Update.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
