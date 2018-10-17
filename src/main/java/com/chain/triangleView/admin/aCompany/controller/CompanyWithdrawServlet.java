package com.chain.triangleView.admin.aCompany.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.admin.aCompany.aCompany.service.CompanyService;
import com.chain.triangleView.admin.aCompany.aCompany.vo.Company;
import com.chain.triangleView.admin.member.service.MemberService;
import com.chain.triangleView.admin.member.vo.PageInfo;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchCompanyServlet
 */
public class CompanyWithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompanyWithdrawServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option");
		String searchWord = request.getParameter("searchWord");
		int currentPage; // 현재 페이지를 표시할 변수
		int limit; // 한 페이지에 게시글이 몇 개 보여질 것인지 표시
		int maxPage; // 전체 페이지 에서 가장 마지막 페이지
		int startPage; // 한 번에 표시될 페이지가 시작할 페이지
		int endPage;
		int listCount = 0;// 한 번에 표시될 페이지가 끝나는 페이지

		ArrayList<Company> company = null;
		// 게시판은 1페이지부터 시작한다.
		currentPage = 1;

		// 한 페이지에 보여질 목록 갯수
		limit = 5;

		// 전체 목록 갯수를 리턴받음

		HashMap<String, Object> map = new HashMap<String, Object>();
		
		
		
		System.out.println(searchWord);
		
		if(option.equals("userNo")){
			
			company = new CompanyService().withdrawUserNo(searchWord);
			map.put("option",option);
			map.put("searchWord",searchWord);
			map.put("company", company);
			
			
		}else if(option.equals("userid")){
			
			
		company = new CompanyService().withdrawUserId(searchWord);
		map.put("option",option);
		map.put("searchWord",searchWord);
		map.put("company", company);
		
		
		}else if(option.equals("comName")){
			
			
			company = new CompanyService().withdrawCopName(searchWord);
			map.put("company", company);
			map.put("option",option);
			map.put("searchWord",searchWord);
			
			
		}else if(option.equals("pName")){
			
			
			company = new CompanyService().withdrawPname(searchWord);
			map.put("company", company);
			map.put("option",option);
			map.put("searchWord",searchWord);
			
			
		}else if(option.equals("noCode")){
			
			
			company = new CompanyService().withdrawNoCode(searchWord);
			map.put("company", company);
			map.put("option",option);
			map.put("searchWord",searchWord);
			
		}else if(option.equals("phone")){
			
			
			company = new CompanyService().withdrawPhone(searchWord);
			map.put("option",option);
			map.put("searchWord",searchWord);
			map.put("company", company);
			
			
		}else if(option.equals("withdraw_date")){
			
			company = new CompanyService().companyWithdrawdate(searchWord);
			map.put("company", company);
			map.put("option",option);
			map.put("searchWord",searchWord);
			
			
		}else if(option.equals("notice_date")){
			
			company = new CompanyService().companyNoticedate(searchWord);
			map.put("company", company);
			map.put("option",option);
			map.put("searchWord",searchWord);
			
		}else if(option.equals("selectAll")){
			
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			listCount = new CompanyService().getWithlistCount();
			System.out.println(currentPage);
			maxPage = (int) ((double) listCount / limit + 0.9);

			// 시작페이지 계산
			startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;

			// 목록 아래쪽에 보여질 마지막 페이지 수
			endPage = startPage + limit - 1;

			if (maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

			
			
			
			company = new CompanyService().WithsearchAll(currentPage, limit);
			map.put("searchWord","");
			map.put("pi", pi);
			map.put("company",company);
			
			
			
		}
		
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//자동인코딩/디코딩
		new Gson().toJson(map, response.getWriter());
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}