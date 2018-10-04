package com.chain.triangleView.hottag.dao;

import static com.chain.triangleView.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class HotTagDao {

	private Properties prop = new Properties();

	public HotTagDao(){

		String fileName = HotTagDao.class.getResource("/resources/hottag/hottag-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] selectHotTag(Connection con) {

		Statement stmt = null;
		ResultSet rset = null;
		String[] tags = null;

		String query = prop.getProperty("selectTopHotTag");
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			tags = new String[10];
			int i = 0;
			while(rset.next()){

				if(i == 10) break;
				tags[i] = rset.getString("TAGNAME");
				i++;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return tags;
	}

	public int countTag(Connection con, String searchData) {

		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("foundHotTag");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchData);
			pstmt.executeQuery();

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			close(pstmt);
		}
		return result;
	}

	public int updateCountTag(Connection con, String searchData) {

		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateHotTag");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchData);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		} finally {

			close(pstmt);
		}

		return result;
	}

	public int InsertCountTag(Connection con, String searchData) {

		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertHotTag");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchData);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
		} finally {

			close(pstmt);
		}      

		return result;

	}
}
