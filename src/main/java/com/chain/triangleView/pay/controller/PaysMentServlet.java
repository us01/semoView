package com.chain.triangleView.pay.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.pay.pay.service.PayService;
import com.chain.triangleView.pay.pay.vo.PayMent;

/**
 * Servlet implementation class PaysMentServlet
 */
public class PaysMentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaysMentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imp_uid =request.getParameter("imp_uid");//결제번호
		int payCode = Integer.parseInt(request.getParameter("payCode"));//결제코드
		int apply_num = Integer.parseInt(request.getParameter("apply_num")); //카드승인번호
		int paid_amount = Integer.parseInt(request.getParameter("paid_amount")); //결제금액
		int allianCode = Integer.parseInt(request.getParameter("allianCode"));	 //제휴코드
		int rwNo = Integer.parseInt(request.getParameter("rwNo"));		//리뷰번호
		String allianLink = request.getParameter("allianLink");			//제휴링크
		
		System.out.println("imp_uid :" + imp_uid);
		System.out.println("payCode :" + payCode);
		System.out.println("apply_num :" + apply_num);
		System.out.println("paid_amount :" + paid_amount);
		System.out.println("allianCode :" + allianCode);
		System.out.println("rwNo :" + rwNo);
		System.out.println("allianLink" + allianLink);
		
		PayMent p = new PayMent();
		
		p.setPayCode(payCode);
		p.setAmount(paid_amount);
		p.setImp_uid(imp_uid);
		p.setApply_num(apply_num);
		
		int result = new PayService().insertAllianPayMent(p,allianCode,rwNo,allianLink);
		
		if(result > 0){
			
		}else{
			System.out.println("안된당!!");
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
