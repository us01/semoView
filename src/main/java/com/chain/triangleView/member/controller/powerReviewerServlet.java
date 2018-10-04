package com.chain.triangleView.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chain.triangleView.member.member.service.MemberService;
import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.member.member.vo.PowerReviewer;

/**
 * Servlet implementation class powerReviewerServlet
 */
public class powerReviewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public powerReviewerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		//System.out.println(userNo);
		
		Member m = new Member();
		m.setUserNo(userNo);
		
		PowerReviewer pr = new PowerReviewer();
		pr.setuserNo(userNo);
		
		pr = new MemberService().powerReviewer(m);
		
		if(pr != null){
			Member loginUser = new MemberService().loginCheck(((Member)request.getSession().getAttribute("loginUser")).getUserId(), ((Member)request.getSession().getAttribute("loginUser")).getUserPwd());
			
			//System.out.println("하나:" + pr.getReviewCount());
			//System.out.println("둘 : " + pr.getSearchNum());
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			request.setAttribute("pr", pr);
			request.getRequestDispatcher("views/setting/powerReviewer.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "데이터 조회 실패!");
			request.getRequestDispatcher("views/errorPage/errorPage.jsp").forward(request, response);
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
