package com.chain.triangleView.review.hotreivew.dao;

import static com.chain.triangleView.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
public class LoginHotReviewDao {

private Properties prop = new Properties();
	
	public LoginHotReviewDao(){
		String fileName = LoginHotReviewDao.class.getResource("/resources/review/review-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<HashMap<String, Object>> selectHotReivewList(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<HashMap<String,Object>> list = null;
		HashMap<String, Object> hmap = null;
		String query = prop.getProperty("logoutMainHotListSelect");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();	
				hmap.put("rwno", rset.getInt("rwno"));
				hmap.put("rwtitle", rset.getString("rwtitle"));
				hmap.put("nick", rset.getString("nick"));
				hmap.put("rwcontenttype", rset.getInt("rwcontenttype"));
				hmap.put("filename", rset.getString("filename"));
				hmap.put("filePath", "review_upload");
				
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
}
