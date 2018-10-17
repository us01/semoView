package com.chain.triangleView.admin.payment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.admin.member.vo.PageInfo;
import com.chain.triangleView.admin.payment.payment.service.PaymentService;
import com.chain.triangleView.admin.payment.payment.vo.Payment;
import com.chain.triangleView.admin.reviews.reviews.service.ReviewService;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchPaymentServlet
 */
public class SearchPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option");
		String searchWord=request.getParameter("searchWord");
		String FromDt=request.getParameter("FromDt");
		System.out.println("servlet"+FromDt);
		String ToDt = request.getParameter("ToDt");
		String serviceType="2";
		String payType="2";
		String payStatus="2";
		
		int currentPage; // 현재 페이지를 표시할 변수
		int limit; // 한 페이지에 게시글이 몇 개 보여질 것인지 표시
		int maxPage; // 전체 페이지 에서 가장 마지막 페이지
		int startPage; // 한 번에 표시될 페이지가 시작할 페이지
		int endPage;
		int listCount = 0;// 한 번에 표시될 페이지가 끝나는 페이지
		
		
		ArrayList<Payment> payment = null;
		
		// 게시판은 1페이지부터 시작한다.
		currentPage = 1;

		// 한 페이지에 보여질 목록 갯수
		limit = 5;

		// 전체 목록 갯수를 리턴받음
HashMap<String, Object> map = new HashMap<String, Object>();
		
		
		System.out.println("servlet페이지:"+currentPage);
		
		if(option.equals("payDetailCode")){
			payment=new PaymentService().searchPayDetailCode(searchWord,FromDt,ToDt);
			map.put("payment",payment);
			map.put("FromDt", FromDt);
			map.put("ToDt", ToDt);
			map.put("searchWord", searchWord);
			
		}else if(option.equals("copName")){
			payment=new PaymentService().searchcopName(searchWord,FromDt,ToDt);
			map.put("payment",payment);
			map.put("FromDt", FromDt);
			map.put("ToDt", ToDt);
			map.put("searchWord", searchWord);
		}else if(option.equals("userNo")){
			payment=new PaymentService().searchUserNo(searchWord,FromDt,ToDt);
			map.put("payment",payment);
			map.put("FromDt", FromDt);
			map.put("ToDt", ToDt);
			map.put("searchWord", searchWord);
		}else if(option.equals("serviceType")){
			if(searchWord.equals("공고")){
				serviceType="0";
			}else if(searchWord.equals("제휴")){
				serviceType="1";
		}
			payment=new PaymentService().searchServiceType(serviceType,FromDt,ToDt);
			map.put("payment",payment);
			map.put("FromDt", FromDt);
			map.put("ToDt", ToDt);
			map.put("serviceType", serviceType);
			
			
		}else if(option.equals("payType")){
			
			if(searchWord.equals("카드")){
				payType="0";
			}else if(searchWord.equals("무통장")){
				payType="1";
			}
			
			payment=new PaymentService().searchPayType(payType,FromDt,ToDt);
			map.put("payment",payment);
			
			map.put("FromDt", FromDt);
			map.put("ToDt", ToDt);
			map.put("payType", payType);
		}else if(option.equals("payStatus")){
			
			if(searchWord.equals("결제")){
				payStatus="0";
			}else if(searchWord.equals("환불")){
				payStatus="1";
			}
			payment=new PaymentService().searchpayStatus(payStatus,FromDt,ToDt);
			map.put("payment",payment);
			map.put("payStatus", payStatus);
			map.put("FromDt", FromDt);
			map.put("ToDt", ToDt);
			
		}else if(option.equals("selectAll")){
			if (request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			listCount = new PaymentService().getlistCount();
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

			
			
			
			payment = new PaymentService().selectAllCount(currentPage, limit);
			map.put("option", option);
			map.put("pi", pi);
			map.put("payment",payment);
			
			
			
		}
	
		map.put("searchWord", searchWord);
		
		
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