package com.chain.triangleView.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chain.triangleView.member.member.service.MemberService;
import com.chain.triangleView.member.member.vo.Member;

/**
 * Servlet implementation class updatePowerReviewerServlet
 */
public class updatePowerReviewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePowerReviewerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		//System.out.println(userNo);
		
		int result = new MemberService().updatePowerReviewer(userNo);
		
		 if (result > 0) {
			 System.out.println("성공~");
         		Member loginUser = new MemberService().loginCheck(((Member)request.getSession().getAttribute("loginUser")).getUserId(), ((Member)request.getSession().getAttribute("loginUser")).getUserPwd());
				
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				request.getRequestDispatcher("views/setting/settingPage.jsp").forward(request, response);

         } else {
         	request.setAttribute("msg", "회원정보 변경 실패");
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
