package com.chain.triangleView.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.Review;

/**
 * Servlet implementation class coorlinkPointServlet
 */
public class coorlinkPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public coorlinkPointServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rwNo = Integer.parseInt(request.getParameter("rwNo"));
		
		String ip = request.getRemoteAddr();
		//System.out.println(ip);
		Review rw = new Review();
		rw.setRwNo(rwNo);
		
		Review rwResult = new ReviewService().insertPointInfo(ip,rw);
		
		if(rwResult != null){
			System.out.println("굿");

		}else{
			System.out.println("배드");
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
