package com.chain.triangleView.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.member.member.service.MemberService;

public class UserFollowFalse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserFollowFalse() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int meNo = Integer.parseInt(request.getParameter("meNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		int result = new MemberService().userFollowFalse(meNo, userNo);
		
		response.setCharacterEncoding("UTF-8");
		
		if(result > 0){
			response.getWriter().print("팔로우");
		}else {
			response.getWriter().print("팔로우 실패");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
