package com.chain.triangleView.member.member.memberDao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.chain.triangleView.member.member.vo.Attachment;
import com.chain.triangleView.member.member.vo.Member;
import com.chain.triangleView.member.member.vo.MemberInterestCategory;
import com.chain.triangleView.member.member.vo.PowerReviewer;
import com.chain.triangleView.review.review.vo.Review;

import static com.chain.triangleView.common.JDBCTemplate.*;

public class MemberDao {
	private Properties prop = new Properties();

	public MemberDao(){
		String fileName = MemberDao.class.getResource("/resources/member/member-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member loginCheck(Connection con, String userId, String userPwd) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;

		String query = prop.getProperty("loginUserSelect");

		try { 
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			pstmt.setString(3, userId);
			pstmt.setString(4, userId);
			pstmt.setString(5, userPwd);

			rset = pstmt.executeQuery();

			if(rset.next()){
				loginUser = new Member();

				loginUser.setUserNo(rset.getInt("userNo"));
				loginUser.setUserId(rset.getString("userId"));
				loginUser.setUserPwd(rset.getString("userPwd"));
				loginUser.setAge(rset.getInt("age"));
				loginUser.setGender(rset.getString("gender"));
				loginUser.setThumbnail(rset.getString("FILENAME"));
				loginUser.setIntro(rset.getString("intro"));
				loginUser.setNick(rset.getString("nick"));
				loginUser.setReviewCount(rset.getInt("rwcount"));
				loginUser.setFollowCount(rset.getInt("followcount"));
				loginUser.setFollowingCount(rset.getInt("followingcount"));
				loginUser.setEnrollDate(rset.getDate("enrollDate"));
				loginUser.setWithdraw(rset.getString("withDraw"));
				loginUser.setWithdrawDate(rset.getDate("withDrawDate"));
				loginUser.setUserType(rset.getInt("userType"));
				loginUser.setPersonName(rset.getString("personName"));
				loginUser.setBusinessNo(rset.getInt("businessNo"));
				loginUser.setCopName(rset.getString("copName"));
				loginUser.setUserLevel(rset.getInt("userLevel"));
				loginUser.setAddress(rset.getString("address"));
				loginUser.setPoint(rset.getInt("point"));
				loginUser.setPostNo(rset.getInt("postNo"));
				loginUser.setPhone(rset.getString("copphone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return loginUser;
	}

	public int modifyUserPwd(Connection con, String userId, String userPwd) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("modifyUserPwd");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userPwd);
			pstmt.setString(2, userId);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertMember(Connection con, Member m) {
		PreparedStatement pstmt = null;

		int result = 0;
		String query = prop.getProperty("insertMember");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setInt(3, m.getAge());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getIntro());
			pstmt.setString(6, m.getNick());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setInt(9, m.getPostNo());


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);

		}
		System.out.println(result);

		return result;
	}

	public int NickCheck(Connection con, String nick) {
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("NickCheck");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, nick);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);

		}


		return result;
	}

	public int insertCompanyMember(Connection con, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;


		String query = prop.getProperty("insertCompanyMember");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getIntro());
			pstmt.setString(4, m.getNick());
			pstmt.setString(5, m.getPersonName());
			pstmt.setInt(6, m.getBusinessNo());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getCopName());
			pstmt.setString(9, m.getAddress());
			pstmt.setInt(10, m.getPostNo());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}

	public int selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int fid = 0;

		String query = prop.getProperty("selectCurrval");

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if(rset.next()){
				fid = rset.getInt("currval");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(stmt);
			close(rset);
		}


		return fid;
	}

	public int insertAttachment(Connection con, ArrayList<Attachment> fileList, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = prop.getProperty("insertAttachment");

		try {
			for(int i = 0; i < fileList.size(); i++){
				pstmt = con.prepareStatement(query);

				pstmt.setString(1, fileList.get(i).getOriginName());
				pstmt.setString(2,fileList.get(i).getChangeName());
				pstmt.setString(3, fileList.get(i).getFileSize());
				pstmt.setString(4, fileList.get(i).getFileType());
				pstmt.setInt(5, fileList.get(i).getUserId());

				result += pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}




		return result;

	}

	public int insertInterestCategory(Connection con, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertInterestCategory");

		try {

			for(int i =0; i < m.getCateNum().length; i++){
				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, m.getUserNo());
				pstmt.setInt(2, Integer.parseInt(m.getCateNum()[i]));
				result += pstmt.executeUpdate();
			}



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}

		return result;
	}


	public Member userNoCheck(Connection con, Member m) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;

		String query = prop.getProperty("userNoCheck");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setString(1,m.getUserId());

			rset = pstmt.executeQuery();

			if(rset.next()){
				member = new Member();

				member.setUserNo(rset.getInt("userNo"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}
		return member;
	}

	public int insertCategory1(Connection con, Member userNoCheck) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query =  prop.getProperty("insertInterestCategory");

		try {
			for(int i =0; i < userNoCheck.getCateNum().length; i++){
				pstmt = con.prepareStatement(query);

				pstmt.setInt(1, userNoCheck.getUserNo());
				pstmt.setInt(2, Integer.parseInt(userNoCheck.getCateNum()[i]));
				result += pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}

		return result;
	}

	public Member findId(Connection con, Member m) {
		PreparedStatement pstmt = null;
		Member find = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("findId");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, m.getPhone());
			
			rset = pstmt.executeQuery();
			if(rset.next()){
			find = new Member();

			find.setUserId(rset.getString("userId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}
		
		return find;
	}

	public int checkMember(Connection con, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("userNickCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, m.getNick());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
			
		}
		
		return result;
	}

	public int findPass(Connection con, Member m, String resultPass) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		
		String query = prop.getProperty("findPass");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, resultPass);
			pstmt.setString(2, m.getUserId());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);

		}
		
		return result;
	}

	public int checkId(Connection con, String id) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("checkId");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		
		return result;
	}

	public int userFollowFalse(Connection con, int meNo, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("userFollowFalse");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, meNo);
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int userFollowTrue(Connection con, int meNo, int userNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("userFollowTrue");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, meNo);
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Member> followUserList(Connection con, int userNo, int meNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> userList = null;
		
		String query = prop.getProperty("followUserList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, meNo);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, userNo);
			pstmt.setInt(4, userNo);
			
			
			rset = pstmt.executeQuery();
			
			userList = new ArrayList<Member>();
			
			while(rset.next()){
				Member m = new Member();
				
				m.setNick(rset.getString("nick"));
				m.setIntro(rset.getString("intro"));
				m.setUserNo(rset.getInt("userno"));
				m.setThumbnail(rset.getString("filename"));
				m.setUserId(rset.getString("userid"));
				m.setFollowTF(rset.getInt("followtf"));
				
				userList.add(m);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userList;
	}
	
	public ArrayList<Member> followingUserList(Connection con, int userNo, int meNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> userList = null;
		
		String query = prop.getProperty("followingUserList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, meNo);
			pstmt.setInt(3, userNo);
			
			rset = pstmt.executeQuery();
			
			userList = new ArrayList<Member>();
			
			while(rset.next()){
				Member m = new Member();
				
				m.setNick(rset.getString("nick"));
				m.setIntro(rset.getString("intro"));
				m.setUserId(rset.getString("userid"));
				m.setThumbnail(rset.getString("filename"));
				m.setUserNo(rset.getInt("userno"));
				m.setFollowTF(rset.getInt("followtf"));
				
				userList.add(m);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return userList;
	}

	public Member followCountSelect(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member followCountMember = null;
		
		String query = prop.getProperty("followCountSelect");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				followCountMember = new Member();
				
				followCountMember.setFollowCount(rset.getInt("followCount"));
				followCountMember.setFollowingCount(rset.getInt("followingCount"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return followCountMember;
	}

  public int updateMember(Connection con, Member m) {
      PreparedStatement pstmt = null;
      int result = 0;
      
      String query = prop.getProperty("updateMember");
      
      try {
         pstmt = con.prepareStatement(query);
         
         pstmt.setInt(1, m.getAge());
         pstmt.setString(2, m.getIntro());
         pstmt.setString(3, m.getNick());
         pstmt.setString(4, m.getPhone());
         pstmt.setString(5, m.getAddress());
         pstmt.setInt(6, m.getPostNo());
         pstmt.setInt(7, m.getUserNo());
         
         result = pstmt.executeUpdate();
         
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally{
         close(pstmt);
      }
      
      
      return result ;
   }
  
  public int updateAttachment(Connection con, ArrayList<Attachment> fileList, Member m) {
      PreparedStatement pstmt = null;
      int result = 0;
      String query = prop.getProperty("updateAttachment");
      
      try {
         pstmt = con.prepareStatement(query);
         
         for(int i =0; i < fileList.size(); i++){
            pstmt.setString(1, fileList.get(i).getOriginName());
            pstmt.setString(2, fileList.get(i).getChangeName());
            pstmt.setString(3, fileList.get(i).getFileSize());
            pstmt.setString(4, fileList.get(i).getFileType());
            pstmt.setInt(5, m.getUserNo());
            
            result += pstmt.executeUpdate();
            
         }
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally{
         close(pstmt);
      }
      
      return result;
   }
  
  public int updatePassword(Connection con, int userNo, String newPwd) {
      PreparedStatement pstmt = null;
      int result =0;
      
      String query = prop.getProperty("updatePassword");
      
      try {
         pstmt = con.prepareStatement(query);
         

         pstmt.setString(1, newPwd);
         pstmt.setInt(2, userNo);
         
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally{
         close(pstmt);
      }
      
      
      return result;
   }
  
  public ArrayList<MemberInterestCategory> interestCategorySelect(Connection con, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberInterestCategory> loginUserInterestCategory = null;
		String query = prop.getProperty("interestCategorySelect");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			loginUserInterestCategory = new ArrayList<MemberInterestCategory>();
			while(rset.next()){
				MemberInterestCategory mic = new MemberInterestCategory();
				
				mic.setCategoryCode(rset.getInt("categoryCode"));
				
				loginUserInterestCategory.add(mic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUserInterestCategory;
	}

	public int insertCategory(Connection con, int userNo, int categoryCode) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertCategory");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, categoryCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteCategory(Connection con, int userNo, int categoryCode) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("deleteCategory");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, categoryCode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int refundPoint(Connection con, Member m, int refundPoint) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("refundPoint");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, m.getUserNo());
			pstmt.setInt(2, refundPoint);
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}

	public int refundUpdate(Connection con, Member m, int myPoint) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("refundUpdate");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, myPoint);
			pstmt.setInt(2, m.getUserNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}

	public PowerReviewer powerReviewer(Connection con, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PowerReviewer pr = null;
		String query = prop.getProperty("powerReviewer");
	
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, m.getUserNo());
			
			rset=pstmt.executeQuery();
			
			
			while(rset.next()){
				pr = new PowerReviewer();
				
				pr.setReviewCount(rset.getString("countrw"));
				pr.setSearchNum(rset.getString("search"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(rset);
		}
		
		
		return pr;
	}

	public int updatePowerReviewer(Connection con, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updatePowerReviewer");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		
		return result;
	}

	public int updatePoint(Connection con, Review rw) {
		int result = 0;
		PreparedStatement pstmt = null;
	
		
		String query = prop.getProperty("updatePoint");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, rw.getRwNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		
		return result;
	}
}