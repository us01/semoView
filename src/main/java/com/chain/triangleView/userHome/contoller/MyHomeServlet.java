package com.chain.triangleView.userHome.contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.userHome.userHome.service.UserHomeService;
import com.chain.triangleView.userHome.userHome.vo.HomeMember;
import com.chain.triangleView.userHome.userHome.vo.HomeReview;
import com.google.gson.Gson;

public class MyHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyHomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if((Member)request.getSession().getAttribute("loginUser") != null){
			HashMap<String, Object> userHome = new HashMap<String, Object>();
			
			HomeMember member = new UserHomeService().UserMemberSelect(((Member)(request.getSession().getAttribute("loginUser"))).getUserId(), ((Member)(request.getSession().getAttribute("loginUser"))).getUserId());
			
			if(member != null){
				userHome.put("member", member);
				
				int currentPage;
				int limit = 8;
				
				if(request.getParameter("currentPage") != null){
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}else{
					currentPage = 1;
				}
				
				userHome.put("currentPage", currentPage);
						
				ArrayList<HomeReview> reviews = new UserHomeService().userReviewSelect(((Member)(request.getSession().getAttribute("loginUser"))).getUserId(), currentPage, limit);
				
				userHome.put("reviews", reviews);
				
				if(currentPage == 1){
					request.setAttribute("userHome", userHome);
					request.getRequestDispatcher("/views/myPage/myHome.jsp").forward(request, response);
				}else{
					response.setContentType("application/json");
					new Gson().toJson(userHome, response.getWriter());
				}
			}else{
				request.setAttribute("msg", "MyHome 회원 정보 조회에 실패 했어요");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "MyHome 회원 정보 조회에 실패 했어요");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
