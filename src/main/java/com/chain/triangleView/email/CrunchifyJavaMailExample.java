package com.chain.triangleView.email;

import java.util.Properties;
import java.util.List;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class CrunchifyJavaMailExample {
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;

	public static void generateAndSendEmail(String id, int ran) throws Exception{

		Properties p = new Properties();

		p.put("mail.smtp.user", "allofmyfavorite@gmail.com"); 
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable","true");
		p.put( "mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465"); 
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		p.put("mail.smtp.socketFactory.fallback", "false");    

		Authenticator auth = new SMTPAuthenticator(id, "rldhks123@@");
		Session session = Session.getInstance(p, auth);

		MimeMessage msg = new MimeMessage(session);
		msg.setSubject("세상의 모든 리뷰 세모뷰 인증확인 메일입니다.","UTF-8");
		Address fromAddr = new InternetAddress(id); // 보내는 사람의 메일주소
		msg.setFrom(fromAddr);
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(id));
		msg.setContent("세상의 모든 리뷰 세모뷰입니다. 인증번호는  " + ran + "입니다.", "text/html;charset=utf-8");
		Transport.send(msg);
	}

	private static class SMTPAuthenticator extends javax.mail.Authenticator {

		String id;
		String pwd;

		SMTPAuthenticator(String id , String pwd){

			this.id = id;
			this.pwd = pwd;
		}

		public PasswordAuthentication getPasswordAuthentication() {

			return new PasswordAuthentication("allofmyfavorite", "rldhks123@@"); //구글아이디는 구글계정에서 @이후를 제외한 값이다. (예: abcd@gmail.com --> abcd)

		}
	} 
}