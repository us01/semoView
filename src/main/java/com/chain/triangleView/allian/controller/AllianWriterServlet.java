package com.chain.triangleView.allian.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.allian.allian.service.AllianService;
import com.chain.triangleView.allian.allian.vo.Allian;
import com.chain.triangleView.member.member.vo.Member;

/**
 * Servlet implementation class AllianWriterServlet
 */
public class AllianWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllianWriterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String allianStartDate = request.getParameter("coorStart");
		String allianEndDate = request.getParameter("coorEnd");
		String allianLink = request.getParameter("coorLink");
		int allianWriter = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		int rwNo = Integer.parseInt(request.getParameter("rwNo"));
		
		System.out.println("제휴시작일자:" + allianStartDate);
		System.out.println("제휴마감날짜:" + allianEndDate);
		System.out.println("제휴 유저넘버 :" + allianWriter);
		System.out.println("제휴링크 :" + allianLink);
		int result[] = {0,0,0};
		
		//sql date 형식으로 형변환
		java.sql.Date allianStartDate1 = java.sql.Date.valueOf(allianStartDate);

		//sql date 형식으로 형변환
		java.sql.Date allianEndDate1 = java.sql.Date.valueOf(allianEndDate);
		
		Allian a = new Allian();
		
		a.setAllianStartDate(allianStartDate1);
		a.setAllianEndDate(allianEndDate1);
		a.setAllianWriter(allianWriter);
		a.setCoorLink(allianLink);
		
		result = new AllianService().insertAllianService(a,rwNo);
		System.out.println("result값은 뭐가되었니??" + result);
		
		String page = "";
		
		if(result[0] > 0){
			page = "views/pay/AllianPayMent.jsp";
			//page = "views/pay/PayMent.jsp";
			request.setAttribute("serviceNo", result[1]);
			request.setAttribute("allianCode", result[2]);
			request.setAttribute("rwNo", rwNo);
			request.setAttribute("allianLink", allianLink);
		}else{
			System.out.println("페이지 이동에 실패했습니다");
			System.out.println(result);
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
