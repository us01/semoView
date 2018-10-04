package com.chain.triangleView.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.admin.member.service.BlackMemberService;
import com.chain.triangleView.admin.member.vo.BlackMember;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchBlackServlet
 */
public class SearchBlackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBlackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option");
		String searchWord = request.getParameter("searchWord");
		
		ArrayList<BlackMember> blacks = null;
		
		if(option.equals("blackCode")){
			
			blacks = new BlackMemberService().searchBlackcode(searchWord);
			System.out.println("servlet" + blacks);
		}
		else if(option.equals("userNo")){
			

			blacks = new BlackMemberService().searchuserNo(searchWord);
			
		}
		else if(option.equals("phone")){
			blacks = new BlackMemberService().searchPhone(searchWord);
			
			
		}
		else if(option.equals("rwNo")){
			blacks = new BlackMemberService().searchrwNo(searchWord);
		}
		else if(option.equals("commentNo")){
			blacks = new BlackMemberService().searchcommentNo(searchWord);
		}
		else if(option.equals("blackTime")){
			blacks = new BlackMemberService().searchblackTime(searchWord);
		}
		else if(option.equals("nick")){
			blacks = new BlackMemberService().searchblackNick(searchWord);
			
		}else if(option.equals("searchAll")){
			System.out.println(option);
			blacks = new BlackMemberService().searchAll();
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//자동인코딩/디코딩
		new Gson().toJson(blacks, response.getWriter());
		
		
		
		
		
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
