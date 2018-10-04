package com.chain.triangleView.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chain.triangleView.member.member.service.MemberService;
import com.chain.triangleView.member.member.vo.Member;


@WebServlet("/modifyPwd.me")
public class modifyMemberPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public modifyMemberPwdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPwdCheck = request.getParameter("userPwdCheck");
		String userPwd = request.getParameter("userPwd");
		String exisitUserPwd = ((Member)request.getSession().getAttribute("loginUser")).getUserPwd();
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		String page = "views/myPage/myHome.jsp";
		
		if(exisitUserPwd.equals(userPwdCheck)){
			int result = new MemberService().modifyUserPwd(userId, userPwd);
			
			if( result > 0){
				Member loginUser = new MemberService().loginCheck(userId, userPwd);
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				response.sendRedirect(page);
			}else{
				request.setAttribute("msg", "비밀번호 변경을 실패했어요");
			}
		}else{
			request.setAttribute("msg", "기존 비밀번호가 틀렸어요");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
