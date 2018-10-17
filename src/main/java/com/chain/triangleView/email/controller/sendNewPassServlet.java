package com.chain.triangleView.email.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chain.triangleView.email.CrunchifyJavaMailExampleTwo;
import com.chain.triangleView.member.member.service.MemberService;
import com.chain.triangleView.member.member.vo.Member;

/**
 * Servlet implementation class sendNewPassServlet
 */
public class sendNewPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendNewPassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		int ran = (int)(Math.random() * 90000) + 10000; 
		
		String ranNum = Integer.toString(ran);
		
		String resultPass = "";
        MessageDigest digest;
        
        try {
			digest = MessageDigest.getInstance("SHA-512");
			byte[] bytes = ranNum.getBytes(Charset.forName("UTF-8"));
			digest.reset();
			digest.update(bytes);
			resultPass = Base64.getEncoder().encodeToString(digest.digest());
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        
		Member m = new Member();
		m.setUserId(id);
		
		int check = 0;
		check = new MemberService().findPass(m,resultPass);
		
		if(check>0){
			System.out.println("굿");
			CrunchifyJavaMailExampleTwo cjme2 = new CrunchifyJavaMailExampleTwo();
			try {
				cjme2.generateAndSendEmail(id,ran);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			System.out.println("안되에에에");
		}
		request.setAttribute("ran", ran);
		response.getWriter().println(ran);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
