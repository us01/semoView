package com.chain.triangleView.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.notice.notice.service.NoticeService;

/**
 * Servlet implementation class NoticeYPersonServlet
 */
public class NoticeYPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeYPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeCode = Integer.parseInt(request.getParameter("noticeCode"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		System.out.println("noticeY :"  + noticeCode);
		System.out.println("userNoY :" + userNo );
		int result = 0;
		
		
		result = new NoticeService().updateNoticeY(noticeCode,userNo);
		
		String page = "";
		
		if(result > 0){
			response.sendRedirect(request.getContextPath() + "/noticeList");
		}else{
			System.out.println("페이지 뿌리기 실패!!");
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
