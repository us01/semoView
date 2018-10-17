package com.chain.triangleView.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LoginWrapper extends HttpServletRequestWrapper{
	public LoginWrapper(HttpServletRequest request){
		super(request);	
	}
	
	@Override
	public String getParameter(String key){
		String value = "";
		
		if(key != null && key.equals("userPwd")){
			value = getSha512(super.getParameter("userPwd"));
		}else if(key != null && key.equals("userPwdCheck")){
			value = getSha512(super.getParameter("userPwdCheck"));
		}else{
			value = super.getParameter(key);
		}
		
		return value;
	}
	
	public static void main(String[] args){
		System.out.println(getSha512("admin"));
	}

	private static String getSha512(String pwd) {
		String encPwd = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
			
			encPwd = Base64.getEncoder().encodeToString(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encPwd;
	}
	
	
}
