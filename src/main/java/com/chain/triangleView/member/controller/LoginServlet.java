package com.chain.triangleView.member.controller;

import java.io.IOException;
import java.rmi.server.SocketSecurityException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chain.triangleView.member.member.service.MemberService;
import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.member.member.vo.MemberInterestCategory;
import com.chain.triangleView.notice.notice.service.NoticeService;
import com.chain.triangleView.notice.notice.vo.notice.Notice;
import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.Review;

@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println("userId : " + userId);
		System.out.println("userPwd : " + userPwd);
		Member loginUser = new MemberService().loginCheck(userId, userPwd);
		
		ArrayList<HashMap<String, Object>> noticeList = null;

		if(loginUser != null){
			ArrayList<MemberInterestCategory> loginUserInterestCategory = new MemberService().interestCategorySelect(loginUser.getUserNo());
			ArrayList<Review> interestReviewList = new ReviewService().selectInterestReview(loginUser.getUserNo());
			noticeList = new NoticeService().selectAllNotice();
			Member followCountMember = new MemberService().followCountSelect(loginUser.getUserNo());
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("loginUserInterestCategory", loginUserInterestCategory);
			request.setAttribute("followCountMember", followCountMember);
			request.setAttribute("interestReviewList", interestReviewList);
			if(noticeList != null) {
				request.setAttribute("selectAllNotice", noticeList);
			}
			
			request.getRequestDispatcher("/views/main/loginMain/loginMain.jsp").forward(request, response);
		}else{
			System.out.println("로그인 멤모 조회 실패");
			request.setAttribute("msg", "로그인 정보가 조회되지 않았어요"); 
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
