package com.chain.triangleView.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.CardFormImages;
import com.chain.triangleView.review.review.vo.Review;

/**
 * Servlet implementation class write3SelectServlet
 */
public class write3SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public write3SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rwNo = Integer.parseInt(request.getParameter("rwNo"));
		
		/*int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();*/
		
		HashMap<String, Object> hmap = new ReviewService().write3Select(rwNo);
		
		//System.out.println(hmap);
		
		Review rw = (Review)hmap.get("review");
		ArrayList<CardFormImages> fileList = (ArrayList<CardFormImages>)hmap.get("CardFormImages");
		
		String page="";
		if(hmap != null){
			page="views/writeForm/write3Update.jsp";
			request.setAttribute("rw", rw);
			request.setAttribute("fileList", fileList);
			request.getRequestDispatcher("views/writeForm/write3Update.jsp").forward(request, response);
		}else{
			page="views/errorPage/errorPage.jsp";
			request.setAttribute("msg", "회원정보 변경 실패");
		}
		//response.sendRedirect(page);
		/*RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
