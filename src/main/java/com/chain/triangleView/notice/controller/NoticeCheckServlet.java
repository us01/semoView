package com.chain.triangleView.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.notice.notice.service.NoticeService;
import com.chain.triangleView.notice.notice.vo.notice.Notice;

/**
 * Servlet implementation class NoticeCheckServlet
 */
public class NoticeCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeCode = Integer.parseInt(request.getParameter("noticeCheck"));
		int noticeWriter = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		int result = 0;
		
		System.out.println("noticeCode: 나오닝???" + noticeCode);
		
		System.out.println("noticeWriter: 나오닝??" + noticeWriter);
		
		result = new NoticeService().insertApplication(noticeCode,noticeWriter); 
		
		
		ArrayList<Notice> list = new NoticeService().selectList();
		String page = "page";
		
		if(list != null){
			page = "views/companyNotice/announcementReviews.jsp";
			request.setAttribute("list", list);
			
		}else{
			System.out.println("노티스 리스트 조회 실패");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
