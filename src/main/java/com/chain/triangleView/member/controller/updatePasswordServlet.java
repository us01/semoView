package com.chain.triangleView.member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chain.triangleView.member.member.service.MemberService;
import com.chain.triangleView.member.member.vo.Member;

/**
 * Servlet implementation class updatePasswordServlet
 */
public class updatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldPwd = "";
		String newPwd = "";
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = request.getParameter("oldPwd").getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
			
			oldPwd = Base64.getEncoder().encodeToString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		if(((Member)request.getSession().getAttribute("loginUser")).getUserPwd().equals(oldPwd)){
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-512");
				byte[] bytes = request.getParameter("newPwd").getBytes(Charset.forName("UTF-8"));
				md.update(bytes);
				
				newPwd = Base64.getEncoder().encodeToString(md.digest());
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			int result = new MemberService().updatePassword(userNo, newPwd);
			
			if(result > 0 ){
				Member loginUser = new MemberService().loginCheck(((Member)request.getSession().getAttribute("loginUser")).getUserId(), ((Member)request.getSession().getAttribute("loginUser")).getUserPwd());
				
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				request.getRequestDispatcher("views/setting/settingPage.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "비밀번호 변경 실패");
				request.getRequestDispatcher("views/errorPage/errorPage.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "기존 비밀번호 다름");
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
