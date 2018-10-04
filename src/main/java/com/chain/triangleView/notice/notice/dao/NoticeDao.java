package com.chain.triangleView.notice.notice.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.sql.PreparedStatement;
import static com.chain.triangleView.common.JDBCTemplate.*;

import com.chain.triangleView.notice.notice.vo.notice.Application;
import com.chain.triangleView.notice.notice.vo.notice.Attachment;
import com.chain.triangleView.notice.notice.vo.notice.Notice;
import com.chain.triangleView.notice.notice.vo.notice.ProductService;

import com.chain.triangleView.member.member.memberDao.MemberDao;

public class NoticeDao {

	private Properties prop = new Properties();
	
	public NoticeDao() {
		
		String fileName = MemberDao.class.getResource("/resources/notice/notice-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public ArrayList<HashMap<String, Object>> selectAllNotice(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String, Object> hmap = null;
		String query = prop.getProperty("selectAllNotice");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();	
				hmap.put("noticecode", rset.getInt("noticecode"));
				hmap.put("noticetitle", rset.getString("noticetitle"));
				hmap.put("categorycode", rset.getInt("categorycode"));
				hmap.put("productarea", rset.getString("productarea"));
				hmap.put("noticeenddate", rset.getString("noticeenddate"));
				hmap.put("filename", rset.getString("filename"));
				hmap.put("filePath", "notice_upload");
				
				list.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
    
		return list;
	}


	public ArrayList<HashMap<String, Object>> selectCurrNotice(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String, Object> hmap = null;
		String query = prop.getProperty("selectThumNotice");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();	
				hmap.put("noticecode", rset.getInt("noticecode"));
				hmap.put("noticetitle", rset.getString("noticetitle"));
				hmap.put("categorycode", rset.getInt("categorycode"));
				hmap.put("noticeenddate", rset.getString("noticeenddate"));
				hmap.put("deadlineperson", rset.getInt("deadlineperson"));
				hmap.put("person", rset.getInt("person"));
				hmap.put("productarea", rset.getString("productarea"));
				hmap.put("filename", rset.getString("filename"));
				hmap.put("filePath", "notice_upload");
				
				list.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
    
		return list;
	}
	
	public int insertNotice(Connection con, Notice n) {
		PreparedStatement pstmt = null;


		int result1 = 0;

		String query = prop.getProperty("insertNotice");


		try {
			pstmt = con.prepareStatement(query);


			pstmt.setString(1,n.getNoticeTitle());
			pstmt.setInt(2,n.getNoticeWriter());
			pstmt.setString(3,n.getNoticeContent());
			pstmt.setInt(4,n.getCategoryCode());
			pstmt.setInt(5,n.getDeadlinePerson());
			pstmt.setString(6,n.getProductArea());
			pstmt.setDate(7,(Date) n.getNoticeStartDate());
			pstmt.setDate(8,(Date) n.getNoticeEndDate());
			pstmt.setInt(9,n.getServiceNo());
			pstmt.setString(10,n.getCaution());
			pstmt.setString(11, n.getOfferProduct());



			result1 = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		System.out.println(result1);


		return result1;
	}


	public int insertAttachment(Connection con, Notice n, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result2 = 0;

		String query = prop.getProperty("noticeInsertAttachment");


		try {
			for(int i = 0; i < 2 ; i++){
				pstmt=con.prepareStatement(query);

				pstmt.setString(1, fileList.get(i).getOriginName());
				pstmt.setString(2, fileList.get(i).getChangeName());
				pstmt.setString(3, fileList.get(i).getFileSize());
				pstmt.setString(4, fileList.get(i).getFileType());
				pstmt.setInt(5,n.getNoticeWriter());
				pstmt.setInt(6, fileList.get(i).getNoticeCode());
				pstmt.setInt(7, i);

				result2 += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}




		return result2;
	}





	public int noticeNocheck(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int noticeCode = 0;

		String query = prop.getProperty("selectNoticeCode1");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()){
				noticeCode = rset.getInt("currval");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
		}


		return noticeCode;
	}


	public ArrayList<Notice> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice>list = null;

		String query = prop.getProperty("selectList");

		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();

			list = new ArrayList<Notice>();

			while(rset.next()){
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("NOTICENO"));
				n.setProductArea(rset.getString("PRODUCTAREA"));
				n.setFileName(rset.getString("FILENAME"));
				n.setNoticeCode(rset.getInt("NOTICECODE"));
				n.setNoticeWriter(rset.getInt("NOTICEWRITER"));
				n.setNoticeTitle(rset.getString("NOTICETITLE"));
				n.setCategoryCode(rset.getInt("CATEGORYCODE"));
				n.setDeadlinePerson(rset.getInt("DEADLINEPERSON"));
				n.setNoticeCount(rset.getInt("NOTICECOUNT"));
				n.setCaution(rset.getString("CAUTION"));
				n.setOfferProduct(rset.getString("OFFERPRODUCT"));
				n.setNoticeEndDate(rset.getDate("NOTICEENDDATE"));
				n.setNoticeYPerson(rset.getInt("PERSON"));

				if(n.getCategoryCode() == 1){
					n.setCategoryCodeName("자유");
				}else if (n.getCategoryCode() == 2){
					n.setCategoryCodeName("IT/가전");
				}else if (n.getCategoryCode() == 3){
					n.setCategoryCodeName("뷰티");
				}else if (n.getCategoryCode() == 4){
					n.setCategoryCodeName("금융");
				}else if (n.getCategoryCode() == 5){
					n.setCategoryCodeName("스포츠");
				}else if (n.getCategoryCode() == 6){
					n.setCategoryCodeName("취미");
				}else if (n.getCategoryCode() == 7){
					n.setCategoryCodeName("게임");
				}else if (n.getCategoryCode() == 8){
					n.setCategoryCodeName("음악");
				}else if (n.getCategoryCode() == 9){
					n.setCategoryCodeName("인생");
				}



				list.add(n);




			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}



		return list;
	}


	public ArrayList<Notice> categorySelect(int categoryCode, Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = null;

		String query = prop.getProperty("categorySelect");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,categoryCode);
			rset = pstmt.executeQuery();

			list = new ArrayList<Notice>();

			while(rset.next()){
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("NOTICENO"));
				n.setProductArea(rset.getString("PRODUCTAREA"));
				n.setFileName(rset.getString("FILENAME"));
				n.setNoticeCode(rset.getInt("NOTICECODE"));
				n.setNoticeWriter(rset.getInt("NOTICEWRITER"));
				n.setNoticeTitle(rset.getString("NOTICETITLE"));
				n.setCategoryCode(rset.getInt("CATEGORYCODE"));
				n.setDeadlinePerson(rset.getInt("DEADLINEPERSON"));
				n.setNoticeCount(rset.getInt("NOTICECOUNT"));
				n.setCaution(rset.getString("CAUTION"));
				n.setOfferProduct(rset.getString("OFFERPRODUCT"));
				n.setNoticeEndDate(rset.getDate("NOTICEENDDATE"));
				n.setNoticeYPerson(rset.getInt("PERSON"));

				if(n.getCategoryCode() == 1){
					n.setCategoryCodeName("자유");
				}else if (n.getCategoryCode() == 2){
					n.setCategoryCodeName("IT/가전");
				}else if (n.getCategoryCode() == 3){
					n.setCategoryCodeName("뷰티");
				}else if (n.getCategoryCode() == 4){
					n.setCategoryCodeName("금융");
				}else if (n.getCategoryCode() == 5){
					n.setCategoryCodeName("스포츠");
				}else if (n.getCategoryCode() == 6){
					n.setCategoryCodeName("취미");
				}else if (n.getCategoryCode() == 7){
					n.setCategoryCodeName("게임");
				}else if (n.getCategoryCode() == 8){
					n.setCategoryCodeName("음악");
				}else if (n.getCategoryCode() == 9){
					n.setCategoryCodeName("인생");
				}
				list.add(n);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}



		return list;
	}


	public int selectNoticeCode(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int noticeCode =  0;

		String query = prop.getProperty("selectNoticeCode");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);


			if(rset.next()){
				noticeCode = rset.getInt("currval");
			}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
		}



		return noticeCode;
	}

	//조회수 증가 쿼리
	public int UpdateCount(Connection con, int noticeNo) {
		PreparedStatement pstmt =null;
		int result = 0;

		String query = prop.getProperty("noticeUpCount");


		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			pstmt.setInt(2, noticeNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}


		return result;
	}

	//상세보기 페이지 Dao
	public ArrayList<Notice> detailsList(Connection con, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		ArrayList<Notice> list = null;

		String query = prop.getProperty("selectDetailsList");


		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeNo);

			rset = pstmt.executeQuery();

			list = new ArrayList<Notice>();

			while(rset.next()){
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("NOTICENO"));
				n.setProductArea(rset.getString("PRODUCTAREA"));
				n.setFileName(rset.getString("FILENAME"));
				n.setNoticeCode(rset.getInt("NOTICECODE"));
				n.setNoticeWriter(rset.getInt("NOTICEWRITER"));
				n.setNoticeTitle(rset.getString("NOTICETITLE"));
				n.setCategoryCode(rset.getInt("CATEGORYCODE"));
				n.setDeadlinePerson(rset.getInt("DEADLINEPERSON"));
				n.setNoticeCount(rset.getInt("NOTICECOUNT"));
				n.setCaution(rset.getString("CAUTION"));
				n.setOfferProduct(rset.getString("OFFERPRODUCT"));
				n.setNoticeEndDate(rset.getDate("NOTICEENDDATE"));
				n.setNoticeYPerson(rset.getInt("PERSON"));
				n.setNoticeStartDate(rset.getDate("NOTICESTARTDATE"));
				n.setNoticeDate(rset.getDate("NOTICEDATE"));
				n.setNoticeContent(rset.getString("NOTICECONTENT"));

				if(n.getCategoryCode() == 1){
					n.setCategoryCodeName("자유");
				}else if (n.getCategoryCode() == 2){
					n.setCategoryCodeName("IT/가전");
				}else if (n.getCategoryCode() == 3){
					n.setCategoryCodeName("뷰티");
				}else if (n.getCategoryCode() == 4){
					n.setCategoryCodeName("금융");
				}else if (n.getCategoryCode() == 5){
					n.setCategoryCodeName("스포츠");
				}else if (n.getCategoryCode() == 6){
					n.setCategoryCodeName("취미");
				}else if (n.getCategoryCode() == 7){
					n.setCategoryCodeName("게임");
				}else if (n.getCategoryCode() == 8){
					n.setCategoryCodeName("음악");
				}else if (n.getCategoryCode() == 9){
					n.setCategoryCodeName("인생");
				}
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}




		return list;
	}


	public int insertService(Connection con, ProductService p) {
		PreparedStatement pstmt = null;
		int result4 = 0;


		String query = prop.getProperty("insertService");



		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, p.getUserNo());
			pstmt.setInt(2, p.getProductNo());

			result4 = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}


		return result4;
	}


	public int insertProduct(Connection con, ProductService p) {
		PreparedStatement pstmt = null;
		int result3 = 0;


		String query = prop.getProperty("insertProduct");


		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, p.getProductName());


			result3 = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}


		return result3;
	}


	public int productNocheck(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int productNo = 0;

		String query = prop.getProperty("selectProductNo");


		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()){
				productNo = rset.getInt("currval");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
		}





		return productNo;
	}


	public int serviceNocheck(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int serviceNo = 0;

		String query = prop.getProperty("selectServiceNo");


		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()){
				serviceNo = rset.getInt("currval");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
		}


		return serviceNo;
	}


	public ArrayList<Notice> selectNoticePage(Connection con, int noticeWriter) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		ArrayList<Notice> list = null;


		String query = prop.getProperty("selectNoticePage");


		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeWriter);

			rset = pstmt.executeQuery();

			list = new ArrayList<Notice>();

			while(rset.next()){
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("NOTICENO"));
				n.setProductArea(rset.getString("PRODUCTAREA"));
				n.setFileName(rset.getString("FILENAME"));
				n.setNoticeCode(rset.getInt("NOTICECODE"));
				n.setNoticeWriter(rset.getInt("NOTICEWRITER"));
				n.setNoticeTitle(rset.getString("NOTICETITLE"));
				n.setCategoryCode(rset.getInt("CATEGORYCODE"));
				n.setDeadlinePerson(rset.getInt("DEADLINEPERSON"));
				n.setNoticeCount(rset.getInt("NOTICECOUNT"));
				n.setCaution(rset.getString("CAUTION"));
				n.setOfferProduct(rset.getString("OFFERPRODUCT"));
				n.setNoticeEndDate(rset.getDate("NOTICEENDDATE"));
				n.setNoticeYPerson(rset.getInt("PERSON"));

				if(n.getCategoryCode() == 1){
					n.setCategoryCodeName("자유");
				}else if (n.getCategoryCode() == 2){
					n.setCategoryCodeName("IT/가전");
				}else if (n.getCategoryCode() == 3){
					n.setCategoryCodeName("뷰티");
				}else if (n.getCategoryCode() == 4){
					n.setCategoryCodeName("금융");
				}else if (n.getCategoryCode() == 5){
					n.setCategoryCodeName("스포츠");
				}else if (n.getCategoryCode() == 6){
					n.setCategoryCodeName("취미");
				}else if (n.getCategoryCode() == 7){
					n.setCategoryCodeName("게임");
				}else if (n.getCategoryCode() == 8){
					n.setCategoryCodeName("음악");
				}else if (n.getCategoryCode() == 9){
					n.setCategoryCodeName("인생");
				}

				list.add(n);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}


		return list;
	}


	public int insertApplication(Connection con, int noticeCode, int noticeWriter) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertApplication");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeCode);
			pstmt.setInt(2, noticeWriter);

			System.out.println("noticeCode dao :" + noticeCode);
			System.out.println("noticeWriter dao :" + noticeWriter);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}





		return result;
	}


	public ArrayList<Application> loadOneForm(Connection con,int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Application> a  = null;

		String query = prop.getProperty("loadOneForm");




		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, noticeNo);

			rset = pstmt.executeQuery();

			a = new ArrayList<Application>();

			while(rset.next()){


				Application ap = new Application();


				ap.setUserId(rset.getString("USERID"));
				ap.setNick(rset.getString("NICK"));
				ap.setNoticeTitle(rset.getString("NOTICETITLE"));
				ap.setOfferProduct(rset.getString("OFFERPRODUCT"));
				ap.setNoticePCode(rset.getInt("NOTICEPCODE"));
				ap.setNoticeCode(rset.getInt("NOTICECODE"));
				ap.setUserNo(rset.getInt("USERNO"));
				ap.setNoticeYN(rset.getString("NOTICEYN"));

				a.add(ap);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}



		return a;
	}


	public int selectNoticeCheckCode(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int noticeCode = 0;


		String query = prop.getProperty("selectNoticeCode");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()){
				noticeCode = rset.getInt("NOTICECODE");
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
		}


		return noticeCode;
	}


	public ArrayList<Notice> selectNoticeOneList(Connection con, int noticeWriter, int noticeCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list1 = null;

		String query = prop.getProperty("noticeOneSelect");



		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1,noticeCode);

			rset = pstmt.executeQuery();

			list1 = new ArrayList<Notice>();

			while(rset.next()){
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("NOTICENO"));
				n.setNoticeTitle(rset.getString("NOTICETITLE"));
				n.setNoticeWriter(rset.getInt("NOTICEWRITER"));
				n.setCategoryCode(rset.getInt("CATEGORYCODE"));
				n.setNoticeCount(rset.getInt("NOTICECOUNT"));
				n.setDeadlinePerson(rset.getInt("DEADLINEPERSON"));
				n.setProductArea(rset.getString("PRODUCTAREA"));
				n.setCaution(rset.getString("CAUTION"));
				n.setOfferProduct(rset.getString("OFFERPRODUCT"));
				n.setNoticeCode(rset.getInt("NOTICECODE"));
				n.setFileName(rset.getString("FILENAME"));
				n.setFileSeqNo(rset.getInt("FileSeqNo"));

				if(n.getCategoryCode() == 1){
					n.setCategoryCodeName("자유");
				}else if (n.getCategoryCode() == 2){
					n.setCategoryCodeName("IT/가전");
				}else if (n.getCategoryCode() == 3){
					n.setCategoryCodeName("뷰티");
				}else if (n.getCategoryCode() == 4){
					n.setCategoryCodeName("금융");
				}else if (n.getCategoryCode() == 5){
					n.setCategoryCodeName("스포츠");
				}else if (n.getCategoryCode() == 6){
					n.setCategoryCodeName("취미");
				}else if (n.getCategoryCode() == 7){
					n.setCategoryCodeName("게임");
				}else if (n.getCategoryCode() == 8){
					n.setCategoryCodeName("음악");
				}else if (n.getCategoryCode() == 9){
					n.setCategoryCodeName("인생");
				}

				System.out.println("최종담긴값" + n);



				list1.add(n);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}



		return list1;




	}


	public int updateNotice(Connection con, int serviceNo){
		PreparedStatement pstmt = null;
		int result2 = 0;

		String query = prop.getProperty("updateNotice");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, serviceNo);

			result2 = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}

		return result2;
	}


	public ArrayList<Notice> selectMainImg(Connection con, int noticeWriter) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list3 = null;

		String query = prop.getProperty("selectMainImg");


		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1,noticeWriter);

			rset = pstmt.executeQuery();

			list3 = new ArrayList<Notice>();

			while(rset.next()){

				Notice n = new Notice();

				n.setFileName(rset.getString("FILENAME"));

				list3.add(n);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
		}

		return list3;
	}


	public ArrayList<Notice> selectNoticeNPage(Connection con, int noticeWriter) {
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		ArrayList<Notice> list4 = null;


		String query = prop.getProperty("selectNoticeNPage");


		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeWriter);

			rset = pstmt.executeQuery();

			list4 = new ArrayList<Notice>();

			while(rset.next()){
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("NOTICENO"));
				n.setProductArea(rset.getString("PRODUCTAREA"));
				n.setFileName(rset.getString("FILENAME"));
				n.setNoticeCode(rset.getInt("NOTICECODE"));
				n.setNoticeWriter(rset.getInt("NOTICEWRITER"));
				n.setNoticeTitle(rset.getString("NOTICETITLE"));
				n.setCategoryCode(rset.getInt("CATEGORYCODE"));
				n.setDeadlinePerson(rset.getInt("DEADLINEPERSON"));
				n.setNoticeCount(rset.getInt("NOTICECOUNT"));
				n.setCaution(rset.getString("CAUTION"));
				n.setOfferProduct(rset.getString("OFFERPRODUCT"));
				n.setNoticeEndDate(rset.getDate("NOTICEENDDATE"));
				n.setNoticeYPerson(rset.getInt("PERSON"));
				n.setServiceNo(rset.getInt("SERVICENO"));



				if(n.getCategoryCode() == 1){
					n.setCategoryCodeName("자유");
				}else if (n.getCategoryCode() == 2){
					n.setCategoryCodeName("IT/가전");
				}else if (n.getCategoryCode() == 3){
					n.setCategoryCodeName("뷰티");
				}else if (n.getCategoryCode() == 4){
					n.setCategoryCodeName("금융");
				}else if (n.getCategoryCode() == 5){
					n.setCategoryCodeName("스포츠");
				}else if (n.getCategoryCode() == 6){
					n.setCategoryCodeName("취미");
				}else if (n.getCategoryCode() == 7){
					n.setCategoryCodeName("게임");
				}else if (n.getCategoryCode() == 8){
					n.setCategoryCodeName("음악");
				}else if (n.getCategoryCode() == 9){
					n.setCategoryCodeName("인생");
				}

				list4.add(n);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}


		return list4;
	}


	public int updateNoticeY(Connection con, int noticeCode, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("updateNoticeY");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeCode);
			pstmt.setInt(2,userNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}

		return result;
	}


	public ArrayList<Application> selectNoticeN(Connection con, int noticeCode) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		ArrayList<Application> list1 = null;

		String query = prop.getProperty("selectNoticeN");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeCode);

			rset = pstmt.executeQuery();

			list1 = new ArrayList<Application>();

			while(rset.next()){
				Application ap = new Application();

				ap.setNoticeYN(rset.getString("NOTICECODE"));
				ap.setUserNo(rset.getInt("USERNO"));
				ap.setUserId(rset.getString("USERID"));
				ap.setNick(rset.getString("NICK"));
				ap.setIntro(rset.getString("Intro"));
				ap.setFileName(rset.getString("FileName"));

				list1.add(ap);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}


		return list1;
	}


	public ArrayList<Application> selectNoticeY(Connection con, int noticeCode) {
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		ArrayList<Application> list2 = null;

		String query = prop.getProperty("selectNoticeY");


		list2 = new ArrayList<Application>();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeCode);
			rset = pstmt.executeQuery();

			list2 = new ArrayList<Application>();

			while(rset.next()){
				Application ap = new Application();

				ap.setNoticeYN(rset.getString("NOTICECODE"));
				ap.setUserNo(rset.getInt("USERNO"));
				ap.setUserId(rset.getString("USERID"));
				ap.setNick(rset.getString("NICK"));
				ap.setIntro(rset.getString("Intro"));
				ap.setFileName(rset.getString("FileName"));

				list2.add(ap);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
			
		}

		return list2;
	}


	public int selectNoticeCodeYN(Connection con, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int noticeCode = 0;
		
		String qeury = prop.getProperty("selectNoticeCodeYN");
		try {
			pstmt = con.prepareStatement(qeury);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				noticeCode = rset.getInt("NOTICECODE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}
		
		return noticeCode;
	}
}
