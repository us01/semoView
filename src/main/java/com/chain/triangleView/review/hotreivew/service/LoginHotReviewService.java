package com.chain.triangleView.review.hotreivew.service;

import static com.chain.triangleView.common.JDBCTemplate.close;
import static com.chain.triangleView.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.chain.triangleView.review.hotreivew.dao.LoginHotReviewDao;

public class LoginHotReviewService {

	public ArrayList<HashMap<String, Object>> selectHotReivewList() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> hotReviewList = new LoginHotReviewDao().selectHotReivewList(con);
		
		close(con);
		
		return hotReviewList;
		
	}

}
