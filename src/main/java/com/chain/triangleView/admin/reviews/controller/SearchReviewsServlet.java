package com.chain.triangleView.admin.reviews.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.admin.aCompany.aCompany.service.CompanyService;
import com.chain.triangleView.admin.member.vo.PageInfo;
import com.chain.triangleView.admin.reviews.reviews.service.ReviewService;
import com.chain.triangleView.admin.reviews.reviews.vo.Review;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchReviewsServlet
 */
public class SearchReviewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchReviewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option");
		String searchWord = request.getParameter("searchWord");
		String categoryType="0";
		String rwcontentType="100";
		String rwType="2";
		
		int currentPage; // 현재 페이지를 표시할 변수
		int limit; // 한 페이지에 게시글이 몇 개 보여질 것인지 표시
		int maxPage; // 전체 페이지 에서 가장 마지막 페이지
		int startPage; // 한 번에 표시될 페이지가 시작할 페이지
		int endPage;
		int listCount = 0;// 한 번에 표시될 페이지가 끝나는 페이지

		ArrayList<Review> reviews = null;
		// 게시판은 1페이지부터 시작한다.
				currentPage = 1;

				// 한 페이지에 보여질 목록 갯수
				limit = 5;

				// 전체 목록 갯수를 리턴받음
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		
		if(option.equals("userNo")){
			
			reviews = new ReviewService().searchReviewUserNo(searchWord);
			map.put("review", reviews);
			map.put("searchWord",searchWord);
		}else if(option.equals("rwNo")){
			
			reviews = new ReviewService().searchReviewRwNo(searchWord);
			map.put("review", reviews);
			map.put("searchWord",searchWord);
		}else if(option.equals("categoryType")){
			
			if(searchWord.equals("자유")){
				categoryType="1";
			}else if(searchWord.equals("it/가전")){
				categoryType="2";
			}else if(searchWord.equals("뷰티")){
				categoryType="3";
			}else if(searchWord.equals("금융")){
				categoryType="4";
			}else if(searchWord.equals("스포츠")){
				categoryType="5";
			}else if(searchWord.equals("취미")){
				categoryType="6";
			}else if(searchWord.equals("게임")){
				categoryType="7";
			}else if(searchWord.equals("음악")){
				categoryType="8";
			}else if(searchWord.equals("인생")){
				categoryType="9";
			}
					
			reviews = new ReviewService().searchCategoryType(categoryType);
			map.put("review", reviews);
			map.put("categoryType", categoryType);
			
		}else if(option.equals("rwCount")){
			reviews = new ReviewService().searchRwCount(searchWord);
			map.put("review", reviews);
			map.put("rwCount", searchWord);
		}else if(option.equals("rwcontentType")){
			
			if(searchWord.equals("글")){
				rwcontentType="0";
			}else if(searchWord.equals("카드")){
				rwcontentType="1";
			}else if(searchWord.equals("동영상")){
				rwcontentType="2";
			}
			reviews = new ReviewService().searchRwcontentType(rwcontentType);
			map.put("review", reviews);
			map.put("rwcontentType",rwcontentType);
			
		
		}else if(option.equals("rwType")){
			
			if(searchWord.equals("일반")){
				rwType="0";
			}else if(searchWord.equals("제휴")){
				rwType="1";
			}
			reviews = new ReviewService().searchrwType(rwType);
			map.put("review", reviews);
			map.put("rwType", rwType);
			
		}else if(option.equals("writedate")){
			reviews = new ReviewService().searchWritedate(searchWord);
			map.put("review", reviews);
			map.put("searchWord", searchWord);
		}else if(option.equals("selectAll")){
			
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			listCount = new ReviewService().getlistCount();
			maxPage = (int) ((double) listCount / limit + 0.9);

			// 시작페이지 계산
			startPage = (((int) ((double) currentPage / limit + 0.9)) - 1) * limit + 1;

			// 목록 아래쪽에 보여질 마지막 페이지 수
			endPage = startPage + limit - 1;

			if (maxPage < endPage) {
				endPage = maxPage;
			}

			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);

			
			
			
			reviews = new ReviewService().searchAll(currentPage, limit);
			map.put("option", option);
			map.put("pi", pi);
			map.put("review", reviews);
			
			
		}
			
			
		map.put("searchWord", searchWord);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(map, response.getWriter());
		//자동인코딩/디코딩
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
