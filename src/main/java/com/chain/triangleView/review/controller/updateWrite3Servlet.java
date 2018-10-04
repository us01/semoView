package com.chain.triangleView.review.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.chain.triangleView.common.MyFileRenamePolicy;
import com.chain.triangleView.member.member.vo.Attachment;
import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.Review;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class updateWrite3Servlet
 */
public class updateWrite3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateWrite3Servlet() {
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
	
		/*if (ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 20; // 20mb가 됨

			// 파일 길이를 위한 object생성
			File fileObj = null;
			// 파일 확장자 구하기위해 생성
			String fileExtend = null;

			// 루트체크
			String root = request.getSession().getServletContext().getRealPath("/");
			//String root = "C:/Users/jihun/git/triangleView/src/main/webapp/img/";

			// 저장경로설정
			String savePath = root + "review_upload/";

			// 파일저장이름 설정
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new MyFileRenamePolicy());

			String rwTitle = multiRequest.getParameter("title");
			
			String categoryHash ="";
			
			String rwHash = multiRequest.getParameter("hash");
			String rwComment = multiRequest.getParameter("introduce");
			Member loginUser = (Member) (request.getSession().getAttribute("loginUser"));
			int userNo = loginUser.getUserNo();

			String[] hashSplit = rwHash.split("#");
			String[] resultHashSplit = hashSplit;
			
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
			
			int rwNo = Integer.parseInt(multiRequest.getParameter("rwNo"));
			
			Review rw = new Review();
			rw.setRwHash(rwHash);
			rw.setRwComment(rwComment);
			rw.setRwNo(rwNo);
		
			
			ArrayList<String> saveFiles = new ArrayList<String>();
			ArrayList<String> originFiles = new ArrayList<String>();

			Enumeration<String> files = multiRequest.getFileNames();

			while (files.hasMoreElements()) {
				String name = files.nextElement();

				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));

				ArrayList<Attachment> fileList = new ArrayList<Attachment>();

				for (int i = originFiles.size() - 1; i >= 0; i--) {
					Attachment at = new Attachment();
					at.setFilePath(savePath);
					at.setOriginName(originFiles.get(i));
					at.setChangeName(saveFiles.get(i));

					fileObj = multiRequest.getFile(name);
					if (fileObj != null) {

						// 파일길이 구하기위한 오브젝트생성
						at.setFileSize(String.valueOf(fileObj.length()));
						fileExtend = originFiles.get(i);
						// 파일 확장자 구하기위해 생성
						at.setFileType(fileExtend.substring(at.getOriginName().lastIndexOf(".") + 1));

						fileList.add(at);
					} else {
						at.setFileSize("0");
						at.setFileType(null);
					}

				}

				Member m = new Member();
				m.setUserNo(userNo);

				int result = new ReviewService().updateWrite3(rw,m,fileList,resultHashSplit,categoryHashResult);

				if (result > 0) {
					System.out.println("굿");
					response.sendRedirect(request.getContextPath() +  "/myHome");
				} else {
					System.out.println("다시");
					request.setAttribute("msg", "글수정 실패~!!!");
					request.getRequestDispatcher("views/errorPage/errorPage.jsp").forward(request, response);
				}
			}
		}*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
