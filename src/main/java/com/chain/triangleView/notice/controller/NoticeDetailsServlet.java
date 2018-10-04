package com.chain.triangleView.notice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.notice.notice.service.NoticeService;
import com.chain.triangleView.notice.notice.vo.notice.Notice;

/**
 * Servlet implementation class NoticeDetailsServlet
 */
public class NoticeDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("details"));
		System.out.println("noticeNo" + noticeNo);
	
		
		HashMap<String,Object>noticeDetailsForm = new NoticeService().loadNoticeDetailsForm(noticeNo);
	
		/*System.out.println("나오냠??" +noticeDetailsForm);*/
		
		String page = "";
		if(noticeDetailsForm != null){
			page ="/views/companyNotice/announcementDetails.jsp";
			request.setAttribute("noticeDetailsForm", noticeDetailsForm);
			
		}else{
			System.out.println("입력실패");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
