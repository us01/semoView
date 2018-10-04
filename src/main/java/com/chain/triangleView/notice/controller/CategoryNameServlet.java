package com.chain.triangleView.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.notice.notice.service.NoticeService;
import com.chain.triangleView.notice.notice.vo.notice.Notice;

/**
 * Servlet implementation class CategoryNameServlet
 */
public class CategoryNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CategoryNameServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName = request.getParameter("categoryName");

		System.out.println("가져왔니??" + categoryName);

		int categoryCode = 0;

		if(categoryName != null){
			if(categoryName.contains("자유")){
				categoryCode = 1;
			}else if(categoryName.contains("뷰티")){
				categoryCode = 3;
			}else if(categoryName.contains("금융")){
				categoryCode = 4;
			}else if(categoryName.contains("스포츠")){
				categoryCode = 5;
			}else if(categoryName.contains("취미")){
				categoryCode = 6;
			}else if(categoryName.contains("게임")){
				categoryCode = 7;
			}else if(categoryName.contains("음악")){
				categoryCode = 8;
			}else if(categoryName.contains("인생")){
				categoryCode = 9;
			}else{
				categoryCode = 2; 
			}


			
			

			ArrayList<Notice> list = new ArrayList<Notice>();

			list = new NoticeService().categorySelect(categoryCode);
			
			if(list != null){

				request.setAttribute("list", list);

				request.getRequestDispatcher("views/companyNotice/announcementReviews.jsp").forward(request, response);

			}else{
				System.out.println("출력실패요");
			}
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
