package com.chain.triangleView.admin.point.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.admin.point.point.service.PointService;
import com.chain.triangleView.admin.point.point.vo.Point;
import com.google.gson.Gson;

/**
 * Servlet implementation class PaybackChartServlet2
 */
public class PaybackChartServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaybackChartServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Point> points =null;
		
		points = new PointService().dailyPointPayback();
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//자동인코딩/디코딩
		new Gson().toJson(points, response.getWriter());
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
