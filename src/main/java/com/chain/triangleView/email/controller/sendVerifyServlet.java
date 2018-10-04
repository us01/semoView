package com.chain.triangleView.email.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.email.CrunchifyJavaMailExample;
import com.chain.triangleView.member.member.service.MemberService;
import com.chain.triangleView.member.member.vo.Member;

/**
 * Servlet implementation class sendVerifyServlet
 */
public class sendVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendVerifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int result = 0;
		int resultNum = 0;
		System.out.println(id);
		
		result = new MemberService().checkId(id);
		CrunchifyJavaMailExample cjme = new CrunchifyJavaMailExample();
		
		if(result>0){
			resultNum = 0;
			request.setAttribute("resultNum", resultNum);
			response.getWriter().println(resultNum);
		}else{
			try {
				int ran = (int)(Math.random() * 90000) + 10000;
				cjme.generateAndSendEmail(id,ran);
				resultNum = ran;
				
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("resultNum", resultNum);
			response.getWriter().println(resultNum);
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
