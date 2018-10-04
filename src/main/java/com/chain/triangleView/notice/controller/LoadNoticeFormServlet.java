package com.chain.triangleView.notice.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.notice.notice.service.NoticeService;

/**
 * Servlet implementation class LoadNoticeFormServlet
 */
public class LoadNoticeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadNoticeFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		System.out.println("userId :" + userId);
		System.out.println("noticeNo :" + noticeNo);
		
		
		HashMap<String,Object> noticeForm = new NoticeService().loadNoticeFrom(noticeNo);
		
		if(noticeForm != null){
			request.setAttribute("noticeForm", noticeForm);
			request.getRequestDispatcher("/views/company/noticePage.jsp").forward(request, response);
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
