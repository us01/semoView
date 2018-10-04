package com.chain.triangleView.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.chain.triangleView.common.MyFileRenamePolicy;
import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.notice.notice.service.NoticeService;
import com.chain.triangleView.notice.notice.vo.notice.Attachment;
import com.chain.triangleView.notice.notice.vo.notice.Notice;
import com.chain.triangleView.notice.notice.vo.notice.ProductService;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class noticeWriterServlet
 */
public class noticeWriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public noticeWriterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(ServletFileUpload.isMultipartContent(request));{
			int maxSize = 1024 * 1024 * 20; //20mb가됨
			int result[] = {0, 0};
			int result1 = 0;
			//파일 길이위한 object생성
			File fileObj = null;

			//파일 확장자 구하기 위해 생성
			String fileExtend = null;

			String root = request.getSession().getServletContext().getRealPath("/");
			//저장경로설정

			String savePath = root + "notice_upload/";

			//파일저장이름 설정
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",
					new MyFileRenamePolicy());

			int categoryCode = Integer.parseInt(multiRequest.getParameter("category"));
			String noticeTitle = multiRequest.getParameter("noticeTitle");
			String productArea = multiRequest.getParameter("productArea");
			String caution = multiRequest.getParameter("caution");
			int deadlinePerson = Integer.parseInt(multiRequest.getParameter("deadlinePerson"));
			String noticeContent = multiRequest.getParameter("noticeContent");
			String noticeStartDate = multiRequest.getParameter("noticeStartDate");
			String noticeEndDate = multiRequest.getParameter("noticeEndDate");
			String offerProduct = multiRequest.getParameter("offerProduct");
			String productName = multiRequest.getParameter("productName");
			//sql date 형식으로 형변환
			java.sql.Date noticeStartDate1 = java.sql.Date.valueOf(noticeStartDate);

			//sql date 형식으로 형변환
			java.sql.Date noticeEndDate1 = java.sql.Date.valueOf(noticeEndDate);


			//저장한 파일 이름 arrayList생성
			ArrayList<String> saveFiles = new ArrayList<String>();
			//원본 파일 이름 저장할 arrayList생성
			ArrayList<String> originFiles = new ArrayList<String>();

			//파일의 이름을 반환한다.
			Enumeration<String> files = multiRequest.getFileNames();

			//각 파일의 정보를 구해 DB에 저장할 목적의 데이터 꺼냄

			ArrayList<Attachment> fileList = new ArrayList<Attachment>();
			while(files.hasMoreElements()){
				String name = files.nextElement();

				saveFiles.add(multiRequest.getFilesystemName(name));
				originFiles.add(multiRequest.getOriginalFileName(name));


				//Attachment 객체 생성하여 ArrayList객체 생성

				for(int i = originFiles.size() -1; i >= 0; i--){
					Attachment at = new Attachment();
					at.setFilePath(savePath);
					at.setOriginName(originFiles.get(i));
					at.setChangeName(saveFiles.get(i));

					//파일길이 구하기 위한 오브젝트생성
					fileObj = multiRequest.getFile(name);
					at.setFileSize(String.valueOf(fileObj.length()));

					//파일 확장자 구하기위해 생성
					fileExtend = originFiles.get(i);
					at.setFileType(fileExtend.substring(at.getOriginName().lastIndexOf(".")+1));

					fileList.add(at);

				}

			}
			//작성자 값을 가져오기위해 세션을 사용했음

			int noticeWriter = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();

			//꺼낸값을 공고 notice 객체에 넣어준다.
			Notice n = new Notice();

			n.setNoticeTitle(noticeTitle);
			n.setNoticeWriter(noticeWriter);
			n.setNoticeContent(noticeContent);
			n.setCategoryCode(categoryCode);
			n.setDeadlinePerson(deadlinePerson);
			n.setProductArea(productArea);
			n.setNoticeStartDate(noticeStartDate1);
			n.setNoticeEndDate(noticeEndDate1);
			n.setCaution(caution);
			n.setOfferProduct(offerProduct);

			ProductService p = new ProductService();
			
			p.setProductName(productName);
			p.setUserNo(noticeWriter);
		

			//System.out.println(categoryCode);
			//System.out.println(noticeTitle);
			//System.out.println(productArea);
			//System.out.println(caution);
			//for(int i = 0; i <= file.length;i++){
			//System.out.println(file[i]);
			//System.out.println(noticeContent);	

			//System.out.println(noticeStartDate1);
			//System.out.println(noticeEndDate1);

			result = new NoticeService().insertAttachment(fileList,n,p);
			//notice no= new notice()

			String page = "";
			if(result[0] > 0){
				//page = "views/companyNotice/announcementReviews.jsp";
				  page = "views/pay/PayMent.jsp";
				  request.setAttribute("serviceNo", result[1]);

			}else{
				System.out.println("입력실패");
				System.out.println(result);
			}
			request.getRequestDispatcher(page).forward(request, response);
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
