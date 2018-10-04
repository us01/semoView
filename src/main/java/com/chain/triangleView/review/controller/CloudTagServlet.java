package com.chain.triangleView.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.NLP.NLPfiltering;
import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.Review;
import com.google.cloud.language.v1.Token;
import com.google.gson.Gson;

/**
 * Servlet implementation class CloudTagServlet
 */
public class CloudTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CloudTagServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String searchHash = request.getParameter("searchHash");
		ArrayList<Review> reviewList =  new ReviewService().searchHashSelect(searchHash);
		HashMap<String, Integer> nlpText = null;
		List<Token> tokenList = null;

		int searchCount = 0;
		if(request.getSession().getAttribute("searchCount2") != null) {

			searchCount = (Integer) request.getSession().getAttribute("searchCount2") + 1;
			request.getSession().setAttribute("searchCount2", searchCount);
		}else {

			request.getSession().setAttribute("searchCount2", searchCount);
		}

		if(reviewList != null) {

			nlpText = new HashMap<String, Integer>();

			for(int i=0; i < 10  && reviewList.size() > i && reviewList.get(i) != null; i++){
				
				if((Integer) request.getSession().getAttribute("searchCount2") != searchCount) {
					
					nlpText = new HashMap<String, Integer>();
					break;
				}else {
					
					tokenList = new NLPfiltering().get_syntax(reviewList.get(i).getRwComment().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));

					for (Token token : tokenList) {

						String value = token.getText().getContent();
						if(nlpText.containsKey(value)) {

							nlpText.put(value, nlpText.get(value)+3); 
						}else {

							nlpText.put(value, 1);
						}
					}
				}
			}

		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		new Gson().toJson(nlpText, response.getWriter());	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
