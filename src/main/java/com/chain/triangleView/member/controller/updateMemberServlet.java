package com.chain.triangleView.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.chain.triangleView.common.MyFileRenamePolicy;
import com.chain.triangleView.member.member.service.MemberService;
import com.chain.triangleView.member.member.vo.Attachment;
import com.chain.triangleView.member.member.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class updateMemberServlet
 */
public class updateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(request)) {
	         int maxSize = 1024 * 1024 * 20; // 20mb가 됨
	         
	         //파일 길이를 위한 object생성
	         File fileObj = null;
	         //파일 확장자 구하기위해 생성
	         String fileExtend = null;
	         
	         //루트체크
	         String root = request.getSession().getServletContext().getRealPath("/");
	         // System.out.println(root);
	         
	         //저장경로설정
	         String savePath = root + "thumbnail_upload/";

	         //파일저장이름 설정
	         MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
	               new MyFileRenamePolicy());
	         
	         //유저 번호 받아옴
	         int userNo = Integer.parseInt(multiRequest.getParameter("userNo"));
	         // 수정할 값입력
	         String nick = multiRequest.getParameter("nick");
	         String ageString = multiRequest.getParameter("age");
	         int age=0;
	         if(ageString.equals("") || ageString.equals(null)){
	        	 System.out.println("널이다");
	         }else{
	        	 age = Integer.parseInt(ageString); 
	         }
	         String postChange = multiRequest.getParameter("sample4_postcode");
	         int postNo = 0;
	         if(postChange.equals("") || postChange.equals(null)){
	        	 System.out.println("널값이다");
	         }else{
	        	 postNo = Integer.parseInt(postChange);
	         }
	         String address1 = multiRequest.getParameter("sample4_roadAddress");
	         String address2 = multiRequest.getParameter("sample4_jibunAddress");
	         String phone = multiRequest.getParameter("phone");
	         String intro = multiRequest.getParameter("intro");
	         
	         // 최종 주소(DB에 저장할)
	         String address = address1 + "-" + address2;
	         if(address.equals(" ")){
	        	 address = null;
	         }

	         // 객체에 값 추가
	         Member m = new Member();
	         m.setUserNo(userNo);
	         m.setNick(nick);
	         m.setAge(age);
	         m.setPostNo(postNo);
	         m.setAddress(address);
	         m.setPhone(phone);
	         m.setIntro(intro);
	         	
	         
	         // 저장한 파일의 이름을 저장할 arrayList생성
	         ArrayList<String> saveFiles = new ArrayList<String>();
	         // 원본 파일의 이름을 저장할 arrayList생성
	         ArrayList<String> originFiles = new ArrayList<String>();

	         // 파일의 이름을 반환한다.
	         Enumeration<String> files = multiRequest.getFileNames();
	         
	         // 각 파일의 정보를 구해 DB에 저장할 목적의 데이터를 꺼낸다.
	         while (files.hasMoreElements()) {
	            String name = files.nextElement();
	            
	            saveFiles.add(multiRequest.getFilesystemName(name));
	            originFiles.add(multiRequest.getOriginalFileName(name));
	            
	            
	            // Attachment 객체 생성하여 ArrayList객체 생성
	            ArrayList<Attachment> fileList = new ArrayList<Attachment>();
	      
	            for (int i = originFiles.size() - 1; i >= 0; i--) {
	               Attachment at = new Attachment();
	               at.setFilePath(savePath);
	               at.setOriginName(originFiles.get(i));
	               at.setChangeName(saveFiles.get(i));
	              
	               fileObj = multiRequest.getFile(name);
	               if(fileObj!=null){
	            	  
	            	   //파일길이 구하기위한 오브젝트생성
	            	   at.setFileSize(String.valueOf(fileObj.length()));
	            	   fileExtend = originFiles.get(i);
	            	   //파일 확장자 구하기위해 생성
	            	   at.setFileType(fileExtend.substring(at.getOriginName().lastIndexOf(".")+1));
	            	   
	            	   fileList.add(at);
	               }else{
	            	   at.setFileSize("0");
	            	   at.setFileType(null);
	               }
	            }
	            
	            int result = new MemberService().updateMember(m,fileList);

	          /*  //카테고리받기
				String[] category = multiRequest.getParameterValues("category");
				String categories = "";

				if(category != null){
					//카테고리 value값을 받아옴
					for(int i =0; i < category.length; i++){
						if(i ==0){
							categories += category[i];
						}else{
							categories += "," + category[i];
						}
					}
					//받아온 카테고리 value값을 스플릿하기
					String cateNum[] = categories.split(",");
					//체크한 번호를 객체에 담아줌
					if(cateNum != null){
						userNoCheck.setCateNum(cateNum);	
						int result2 = new MemberService().insertCategory1(userNoCheck);
					}
				}*/
	            
	            
	            if (result > 0) {
	            	Member loginUser = new MemberService().loginCheck(((Member)request.getSession().getAttribute("loginUser")).getUserId(), ((Member)request.getSession().getAttribute("loginUser")).getUserPwd());
					
					HttpSession session = request.getSession();
					session.setAttribute("loginUser", loginUser);
					request.getRequestDispatcher("views/setting/settingPage.jsp").forward(request, response);

	            } else {
	            	request.setAttribute("msg", "회원정보 변경 실패");
					request.getRequestDispatcher("views/errorPage/errorPage.jsp").forward(request, response);
	               
	            }
	         }
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
