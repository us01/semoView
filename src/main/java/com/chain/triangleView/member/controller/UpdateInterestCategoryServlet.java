package com.chain.triangleView.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.member.member.service.MemberService;
import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.member.member.vo.MemberInterestCategory;
import com.google.gson.Gson;

public class UpdateInterestCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateInterestCategoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryCode = Integer.parseInt(request.getParameter("changeCategory"));
		char checkCode = 'N';
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		ArrayList<MemberInterestCategory> loginUserInterestCategory = null;
		int result = 0;
		
		for(int i = 0; i < ((ArrayList<MemberInterestCategory>)request.getSession().getAttribute("loginUserInterestCategory")).size(); i++){
			if(categoryCode == ((ArrayList<MemberInterestCategory>)request.getSession().getAttribute("loginUserInterestCategory")).get(i).getCategoryCode()){
				checkCode = 'Y';
			}
		}
		
		if(checkCode == 'Y'){
			result = new MemberService().deleteCategory(userNo, categoryCode);
		}else{
			result = new MemberService().insertCategory(userNo, categoryCode);
		}
		
		if(result > 0){
			loginUserInterestCategory = new MemberService().interestCategorySelect(userNo);
			
			request.getSession().removeAttribute("loginUserInterestCategory");
			request.getSession().setAttribute("loginUserInterestCategory", loginUserInterestCategory);
		}else{
			request.setAttribute("msg", "카테고리 삭제에 실패했어요");
			request.getRequestDispatcher("/triangleView/error/errorPage.jsp");
		}
		
		response.setContentType("application/json");
		new Gson().toJson(loginUserInterestCategory, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
