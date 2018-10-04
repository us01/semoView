package com.chain.triangleView.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.NLP.NLPfiltering;
import com.chain.triangleView.crolling.Crolling;
import com.chain.triangleView.review.review.service.ReviewService;
import com.google.cloud.language.v1.Sentiment;
import com.google.gson.Gson;

import twitter4j.Status;

/**
 * Servlet implementation class CrollingAndNLPServlet
 */
public class CrollingAndNLPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrollingAndNLPServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int[] feel = {0, 0, 0};
		String searchReviewData =  request.getParameter("searchReviewData");
		Map<String, Integer> feels = new HashMap<String, Integer>();
		int searchCount = 0;
		int searchStop = 0;

		if(request.getSession().getAttribute("searchCount") != null) {

			searchCount = (Integer) request.getSession().getAttribute("searchCount") + 1;
			request.getSession().setAttribute("searchCount", searchCount);
		}else {

			request.getSession().setAttribute("searchCount", searchCount);
		}

		if(searchReviewData != "") {

			int findSenti = new ReviewService().findSentiment(searchReviewData);
			if(findSenti > 0) {

				feel = new ReviewService().selectSentiment(searchReviewData);
			}else {
				Crolling crolling = new Crolling();

				ArrayList<Status> list = crolling.crolling_twitter(searchReviewData);

				if(list != null) {
					for(Status status : list) {

						if((Integer) request.getSession().getAttribute("searchCount") != searchCount) {

							searchStop = 1;
						}else {
							if(status.getText() != null) {
								Sentiment sn = NLPfiltering.get_sentiment(status.getText());		

								if(sn.getScore() >= 0.6) {

									feel[0]++;
								}else if(sn.getScore() < 0.6 && sn.getScore() > -0.2) {

									feel[1]++;
								}else {

									feel[2]++;
								}
							}
						}
					}
				}
				new ReviewService().insertSentiment(searchReviewData, feel);
			}
		}
		feels.put("good", feel[0]);
		feels.put("soso", feel[1]);
		feels.put("bad", feel[2]);
		feels.put("isStop", searchStop);


		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		new Gson().toJson(feels, response.getWriter());			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
