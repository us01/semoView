package com.chain.triangleView.review.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.Review;

/**
 * Servlet implementation class updateWrite2Servlet
 */
public class updateWrite2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateWrite2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rwHash = request.getParameter("hash");
		String rwComment = request.getParameter("introduce");
		Member loginUser = (Member) (request.getSession().getAttribute("loginUser"));
		int userNo = loginUser.getUserNo();
		System.out.println("이게 어케 나오나 " + rwHash);
		String[] hashSplit = rwHash.split("#");
		String[] resultHashSplit = hashSplit;
		String categoryHash ="";
		int categoryType = Integer.parseInt(request.getParameter("catecate"));
		switch (categoryType) {
		case 1:
			categoryHash = "자유";
			break;
		case 2:
			categoryHash = "IT/가전";
			break;
		case 3:
			categoryHash = "음악";
			break;
		case 4:
			categoryHash = "뷰티";
			break;
		case 5:
			categoryHash = "스포츠";
			break;
		case 6:
			categoryHash = "금융";
			break;
		case 7:
			categoryHash = "게임";
			break;
		case 8:
			categoryHash = "취미";
			break;
		case 9:
			categoryHash = "인생";
			break;
		default:
			categoryHash = "오류";
			break;
		}
		
		
		for (int i = 0; i < hashSplit.length; i++) {
			if (hashSplit[i] != null) {
				String rmSpace = "";
				rmSpace = hashSplit[i];
				rmSpace = rmSpace.replaceAll("\\p{Z}", "");
				resultHashSplit[i] = rmSpace;
				MessageDigest digest;
				try {
					digest = MessageDigest.getInstance("SHA-512");
					byte[] bytes = resultHashSplit[i].getBytes(Charset.forName("UTF-8"));
					digest.reset();
					digest.update(bytes);
					resultHashSplit[i] = Base64.getEncoder().encodeToString(digest.digest());
				} catch (NoSuchAlgorithmException e) {

					e.printStackTrace();
				}
			} else {
				hashSplit[i] = "undefined";
			}
		}
		
		//카테고리처리
		String categoryHashResult = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-512");
			byte[] bytes = categoryHash.getBytes(Charset.forName("UTF-8"));
			digest.reset();
			digest.update(bytes);
			categoryHashResult = Base64.getEncoder().encodeToString(digest.digest());
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}			
		
		int rwNo = Integer.parseInt(request.getParameter("rwNo"));
		
		Review rw = new Review();
		rw.setRwHash(rwHash);
		rw.setRwComment(rwComment);
		rw.setRwNo(rwNo);
		
		Member m = new Member();
		m.setUserNo(userNo);

		int result = new ReviewService().updateWrite3(rw,m,resultHashSplit,categoryHashResult);

		if (result > 0) {
			System.out.println("굿");
			response.sendRedirect(request.getContextPath() +  "/myHome");
		} else {
			System.out.println("다시");
			request.setAttribute("msg", "글수정 실패~!!!");
			request.getRequestDispatcher("views/errorPage/errorPage.jsp").forward(request, response);
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
