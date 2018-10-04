package com.chain.triangleView.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.admin.member.service.MemberService;
import com.chain.triangleView.admin.member.vo.BlackMember;
import com.chain.triangleView.admin.member.vo.Member;
import com.google.gson.Gson;

/**
 * Servlet implementation class EnrollBlackServlet
 */
public class EnrollBlackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollBlackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int  userNo = Integer.parseInt(request.getParameter("userNo"));
		int rwNo=Integer.parseInt(request.getParameter("rwNo"));
		int cNo=Integer.parseInt(request.getParameter("cNo"));
		String reason=request.getParameter("reason");
		
		int result = new MemberService().enrollblack(userNo,rwNo,cNo,reason);
		
		response.getWriter().println(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
