package com.chain.triangleView.admin.payment.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.admin.payment.payment.service.PaymentService;
import com.chain.triangleView.admin.payment.payment.vo.Payment;
import com.google.gson.Gson;

/**
 * Servlet implementation class MarginChartServlet3
 */
public class MarginChartServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarginChartServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Payment> payments=null;
		payments = new PaymentService().paymentMargin3();
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//자동인코딩/디코딩
		new Gson().toJson(payments, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
