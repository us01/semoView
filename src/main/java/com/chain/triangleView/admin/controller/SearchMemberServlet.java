package com.chain.triangleView.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.admin.member.service.MemberService;
import com.chain.triangleView.admin.member.vo.Member;
import com.chain.triangleView.admin.member.vo.PageInfo;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchMemberServlet
 */
public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchMemberServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = request.getParameter("option");
		String searchWord = request.getParameter("searchWord");
		int currentPage; // 현재 페이지를 표시할 변수
		int limit; // 한 페이지에 게시글이 몇 개 보여질 것인지 표시
		int maxPage; // 전체 페이지 에서 가장 마지막 페이지
		int startPage; // 한 번에 표시될 페이지가 시작할 페이지
		int endPage;
		int listCount = 0;// 한 번에 표시될 페이지가 끝나는 페이지
		ArrayList<Member> members = null;
		// 게시판은 1페이지부터 시작한다.
		currentPage = 1;

		// 한 페이지에 보여질 목록 갯수
		limit = 5;

		// 전체 목록 갯수를 리턴받음

		HashMap<String, Object> map = new HashMap<String, Object>();

		if (option.equals("name")) {

			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			listCount = new MemberService().getListName(searchWord);
			maxPage = (int) ((double) listCount / limit + 0.9);

			// 시작페이지 계산
			startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;

			// 목록 아래쪽에 보여질 마지막 페이지 수
			endPage = startPage + limit - 1;

			if (maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

			members = new MemberService().searchName(currentPage, limit, searchWord);
			map.put("option", option);
			map.put("searhWord", searchWord);
			map.put("pi", pi);
			map.put("member", members);

		} else if (option.equals("id")) {
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			listCount = new MemberService().getListId(searchWord);
			maxPage = (int) ((double) listCount / limit + 0.9);

			// 시작페이지 계산
			startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;

			// 목록 아래쪽에 보여질 마지막 페이지 수
			endPage = startPage + limit - 1;

			if (maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

			members = new MemberService().searchId(currentPage, limit, searchWord);
			map.put("option", option);
			map.put("searhWord", searchWord);
			map.put("pi", pi);
			map.put("member", members);

		} else if (option.equals("userNo")) {
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			listCount = new MemberService().getListuserNo(searchWord);
			maxPage = (int) ((double) listCount / limit + 0.9);

			// 시작페이지 계산
			startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;

			// 목록 아래쪽에 보여질 마지막 페이지 수
			endPage = startPage + limit - 1;

			if (maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

			members = new MemberService().searchUserNo(currentPage, limit, searchWord);
			map.put("option", option);
			map.put("searhWord", searchWord);
			map.put("pi", pi);
			map.put("member", members);

		} else if (option.equals("phone")) {
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			listCount = new MemberService().getListPhone(searchWord);
			maxPage = (int) ((double) listCount / limit + 0.9);

			// 시작페이지 계산
			startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;

			// 목록 아래쪽에 보여질 마지막 페이지 수
			endPage = startPage + limit - 1;

			if (maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

			members = new MemberService().searchPhone(currentPage, limit, searchWord);
			map.put("option", option);
			map.put("searhWord", searchWord);
			map.put("pi", pi);
			map.put("member", members);

		} else if (option.equals("age")) {

			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			listCount = new MemberService().getListAge(searchWord);
			maxPage = (int) ((double) listCount / limit + 0.9);

			// 시작페이지 계산
			startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;

			// 목록 아래쪽에 보여질 마지막 페이지 수
			endPage = startPage + limit - 1;

			if (maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

			members = new MemberService().searchAge(currentPage, limit, searchWord);
			map.put("option", option);
			map.put("searhWord", searchWord);
			map.put("pi", pi);
			map.put("member", members);

		} else if (option.equals("gender")) {

			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			listCount = new MemberService().getListGender(searchWord);
			maxPage = (int) ((double) listCount / limit + 0.9);

			// 시작페이지 계산
			startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;

			// 목록 아래쪽에 보여질 마지막 페이지 수
			endPage = startPage + limit - 1;

			if (maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

			members = new MemberService().searchGender(currentPage, limit, searchWord);
			map.put("option", option);
			map.put("searhWord", searchWord);
			map.put("pi", pi);
			map.put("member", members);

		} else if (option.equals("enrolldate")) {
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			listCount = new MemberService().getListEnrolldate(searchWord);
			maxPage = (int) ((double) listCount / limit + 0.9);

			// 시작페이지 계산
			startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;

			// 목록 아래쪽에 보여질 마지막 페이지 수
			endPage = startPage + limit - 1;

			if (maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

			members = new MemberService().searchEnrolldate(currentPage, limit, searchWord);
			map.put("option", option);
			map.put("searhWord", searchWord);
			map.put("pi", pi);
			map.put("member", members);
//		}else if(option.equals("searchAll")){
//			
//			if (request.getParameter("currentPage") != null) {
//				currentPage = Integer.parseInt(request.getParameter("currentPage"));
//			}
//			listCount = new MemberService().getListAll();
//			maxPage = (int) ((double) listCount / limit + 0.9);
//
//			// 시작페이지 계산
//			startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;
//
//			// 목록 아래쪽에 보여질 마지막 페이지 수
//			endPage = startPage + limit - 1;
//
//			if (maxPage < endPage) {
//				endPage = maxPage;
//			}
//
//			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
//
//			members = new MemberService().searchAll(currentPage, limit);
//			map.put("option", option);
//			
//			map.put("pi", pi);
//			map.put("member", members);
			
			
			
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		// 자동인코딩/디코딩
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
