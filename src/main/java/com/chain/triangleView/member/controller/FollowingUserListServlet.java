package com.chain.triangleView.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.member.member.service.MemberService;
import com.chain.triangleView.member.member.vo.Member;

public class FollowingUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FollowingUserListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int meNo = Integer.parseInt(request.getParameter("meNo"));
		
		ArrayList<Member> userList = new MemberService().followingUserList(userNo, meNo);
		
		if(userList != null){
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("views/followPage/followingUserPage.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "팔로워 회원 조회를 실패했어요");
			request.getRequestDispatcher("views/errorPage/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
