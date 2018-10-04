package com.chain.triangleView.pay.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.pay.pay.service.PayService;

/**
 * Servlet implementation class PayServlet
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int serviceNo = Integer.parseInt(request.getParameter("serviceNo"));	
			System.out.println("serviceNo :" + serviceNo);
		int userId = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		int result[] = {0,0};
		
		result = new PayService().insertPay(userId,serviceNo);
		
		String page = "";
		if(result[0] > 0){
			page = "views/pay/pay.jsp";
			request.setAttribute("payCode", result[1]);
			request.setAttribute("serviceNo", serviceNo);
		}else{
			System.out.println("입력실패");
			System.out.println(result);
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
