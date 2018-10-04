package com.chain.triangleView.review.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.chain.triangleView.NLP.NLPfiltering;
import com.chain.triangleView.common.MyFileRenamePolicy;
import com.chain.triangleView.member.member.vo.Attachment;
import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.review.review.service.ReviewService;
import com.chain.triangleView.review.review.vo.Review;
import com.google.cloud.language.v1.Token;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class insertWrite1Servlet
 */
public class insertWrite1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertWrite1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Token> tokenList = null;
		ArrayList<String> resultHashList = new ArrayList<String>();
		if (ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 20; // 20mb가 됨

			// 파일 길이를 위한 object생성
			File fileObj = null;
			// 파일 확장자 구하기위해 생성
			String fileExtend = null;

			String root = request.getSession().getServletContext().getRealPath("/");
			String savePath = root + "review_upload/";
			
			// 파일저장이름 설정
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new MyFileRenamePolicy());

			// 리뷰에 대한 기본적인 정보
			String rwTitle = multiRequest.getParameter("title");
			int categoryType = Integer.parseInt(multiRequest.getParameter("categoryCheck"));
			//카테고리는 해시에 추가
			String categoryHash ="";
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
			
			String rwHash = multiRequest.getParameter("hash");
			
			String rwComment = multiRequest.getParameter("introduce");
			Member loginUser = (Member) (request.getSession().getAttribute("loginUser"));
			int userNo = loginUser.getUserNo();
			int rwGrade = 0;
			if(multiRequest.getParameter("rwGrade") == null || multiRequest.getParameter("rwGrade") == ""){
				rwGrade = 0;
			}else{
				rwGrade = Integer.parseInt(multiRequest.getParameter("rwGrade"));
				
			}

			String rwContent = "";
			String companySponCheck = multiRequest.getParameter("companySpon");
			int companySpon = 0;
			if(companySponCheck == null){
				companySpon = 0;
			}else{
				companySpon = 1;
			}
			
			String[] hashSplit = rwHash.split("#");
			for(int i=0; i<hashSplit.length; i++) {

				if (hashSplit[i] != null && !hashSplit[i].equals("")) {
					hashSplit[i] = hashSplit[i].replaceAll("\\p{Z}", "");
					tokenList = new NLPfiltering().get_syntax(hashSplit[i]);
					
					MessageDigest digest;
					try {

						digest = MessageDigest.getInstance("SHA-512");
						byte[] bytes = hashSplit[i].getBytes(Charset.forName("UTF-8"));
						digest.reset();
						digest.update(bytes);
						String values =  Base64.getEncoder().encodeToString(digest.digest());
						
						resultHashList.add(values);

					} catch (NoSuchAlgorithmException e) {

						e.printStackTrace();
					}

					for (Token token : tokenList) {

						String value = token.getText().getContent();
						
						MessageDigest digest1;
						try {

							if(!value.equals(hashSplit[i])) {
								
								digest1 = MessageDigest.getInstance("SHA-512");
								byte[] bytes = value.getBytes(Charset.forName("UTF-8"));
								
								digest1.reset();
								digest1.update(bytes);
							
								String shaValue = Base64.getEncoder().encodeToString(digest1.digest());
								
								resultHashList.add(shaValue);
								
							}
						} catch (NoSuchAlgorithmException e) {

							e.printStackTrace();
						}
					}
				}else {
					hashSplit[i] = "undefined";
				}
			}
			
			String[] resultHashSplit = new String[resultHashList.size()];
			for(int i = 0; i<resultHashList.size(); i++) {

				resultHashSplit[i] = resultHashList.get(i);
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
			
			Review rw = new Review();
			rw.setRwTitle(rwTitle);
			rw.setCategoryType(categoryType);
			rw.setRwHash(rwHash);
			rw.setRwComment(rwComment);
			rw.setRwGrade(rwGrade);
			rw.setRwSupport(companySpon);
			
			// 저장한 파일의 이름을 저장할 arrayList생성
			ArrayList<String> saveFiles = new ArrayList<String>();
			// 원본 파일의 이름을 저장할 arrayList생성
			ArrayList<String> originFiles = new ArrayList<String>();

			// 파일의 이름을 반환한다.
			Enumeration<String> files = multiRequest.getFileNames();
			
			// Attachment 객체 생성하여 ArrayList객체 생성
			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			while (files.hasMoreElements()) {
				String name = files.nextElement();

				if (multiRequest.getFilesystemName(name) != null) {

					saveFiles.add(multiRequest.getFilesystemName(name));
					originFiles.add(multiRequest.getOriginalFileName(name));

					Attachment at = new Attachment();
					at.setFilePath(savePath);
					at.setOriginName(multiRequest.getOriginalFileName(name));
					at.setChangeName(multiRequest.getFilesystemName(name));
					rwContent += multiRequest.getOriginalFileName(name);
					fileObj = multiRequest.getFile(name);
					if (fileObj != null) {
						// 파일길이 구하기위한 오브젝트생성
						at.setFileSize(String.valueOf(fileObj.length()));
						fileExtend = multiRequest.getOriginalFileName(name);
						// 파일 확장자 구하기위해 생성
						at.setFileType(
								fileExtend.substring(multiRequest.getOriginalFileName(name).lastIndexOf(".") + 1));
						fileList.add(at);
					} else {
						at.setFileSize("0");
						at.setFileType(null);
					}
					rw.setRwContent(rwContent);
				}
			}
			Member m = new Member();
			m.setUserNo(userNo);

			int result = new ReviewService().write1Review(rw, m, fileList,resultHashSplit,categoryHashResult);

			if (result > 0) {
				response.sendRedirect(request.getContextPath() +  "/myHome");
			} else {
				request.setAttribute("msg", "글쓰기 실패~!!!");
				request.getRequestDispatcher("views/errorPage/errorPage.jsp").forward(request, response);
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
