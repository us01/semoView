package com.chain.triangleView.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ReviewWrapper extends HttpServletRequestWrapper{
	
	public ReviewWrapper(HttpServletRequest request) {
		super(request);
	}
	
	public String getParameter(String key){
		String value="";
		
		if(key != null && key.equals("searchHash")){
			value = getSha512(super.getParameter("searchHash"));
		}else{
			value = super.getParameter(key);
		}
		
		return value;
	}
	
	public static void main(String[] args){
		System.out.println(getSha512("1"));
	}
	
	private static String getSha512(String searchHash) {
		String encSearchHash = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = searchHash.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
			
			encSearchHash = Base64.getEncoder().encodeToString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		
		return encSearchHash;
	}
	
}
