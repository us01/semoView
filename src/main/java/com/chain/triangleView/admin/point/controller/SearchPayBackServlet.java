package com.chain.triangleView.admin.point.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.admin.member.vo.PageInfo;
import com.chain.triangleView.admin.payment.payment.service.PaymentService;
import com.chain.triangleView.admin.point.point.service.PointService;
import com.chain.triangleView.admin.point.point.vo.Point;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchPayBackServlet
 */
public class SearchPayBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPayBackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option");
		String searchWord=request.getParameter("searchWord");
		String FromDt = request.getParameter("FromDt");
		String ToDt = request.getParameter("ToDt");
		String userLevel="2";
		
		int currentPage; // 현재 페이지를 표시할 변수
		int limit; // 한 페이지에 게시글이 몇 개 보여질 것인지 표시
		int maxPage; // 전체 페이지 에서 가장 마지막 페이지
		int startPage; // 한 번에 표시될 페이지가 시작할 페이지
		int endPage;
		int listCount = 0;// 한 번에 표시될 페이지가 끝나는 페이지
		
		
		
		ArrayList<Point> points= null;
		// 게시판은 1페이지부터 시작한다.
				currentPage = 1;

				// 한 페이지에 보여질 목록 갯수
				limit = 5;
				// 전체 목록 갯수를 리턴받음
HashMap<String, Object> map = new HashMap<String, Object>();

		System.out.println("hi 서블릿");
		
		 if(option.equals("userNo")){
			
			points = new PointService().searchPoint(option,searchWord,FromDt,ToDt);
			System.out.println("servelt:"+points);
			map.put("point",points);
			map.put("searchWord", searchWord);
			map.put("FromDt", FromDt);
			map.put("ToDt", ToDt);
			
		}else if(option.equals("userId")){
			points = new PointService().searchUserId(option,searchWord,FromDt,ToDt);
			map.put("point",points);
			map.put("searchWord", searchWord);
			map.put("FromDt", FromDt);
			map.put("ToDt", ToDt);
		}else if(option.equals("userLevel")){
			
			if(searchWord.equals("일반")){
				userLevel="0";
			}else if(searchWord.equals("파워")){
				userLevel="1";
			}
			points = new PointService().searchUserLevel(option,userLevel,FromDt,ToDt);
			map.put("point",points);
			map.put("userLevel", userLevel);
			map.put("FromDt", FromDt);
			map.put("ToDt", ToDt);
		}else if(option.equals("searchAll")){
			
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			listCount = new PointService().getlistCount();
			System.out.println("listcount 서블"+listCount);
			maxPage = (int) ((double) listCount / limit + 0.9);

			// 시작페이지 계산
			startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;

			// 목록 아래쪽에 보여질 마지막 페이지 수
			endPage = startPage + limit - 1;

			if (maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

			
			
			
			points = new PointService().selectAllCount(currentPage, limit);
			map.put("option", option);
			map.put("pi", pi);
			map.put("point",points);
			
			
			
			
		}
		
		
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//자동인코딩/디코딩
		new Gson().toJson(map, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
