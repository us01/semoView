package com.chain.triangleView.SNS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SNScheck {

	public String sns_check(int ran, String phone) {

		  String type = "sms";
          String login_url = "http://ec2-52-78-178-179.ap-northeast-2.compute.amazonaws.com/SMS/sms.php";
          if (type.equals("sms")) {
              try {
                  String user_id = phone;
                  String pin = Integer.toString(ran);
                  String count = "0";
                  URL url = new URL(login_url);
                  HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                  httpURLConnection.setRequestMethod("POST");
                  httpURLConnection.setDoOutput(true);
                  httpURLConnection.setDoInput(true);
                  OutputStream outputStream = httpURLConnection.getOutputStream();
                  BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                  String post_data =
                          URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(user_id, "UTF-8")
                                  + "&" + URLEncoder.encode("pin", "UTF-8") + "=" + URLEncoder.encode(pin, "UTF-8")
                                  + "&" + URLEncoder.encode("count", "UTF-8") + "=" + URLEncoder.encode(count, "UTF-8");
                  bufferedWriter.write(post_data);
                  bufferedWriter.flush();
                  bufferedWriter.close();
                  outputStream.close();
                  InputStream inputStream = httpURLConnection.getInputStream();
                  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                  String json = "";
                  StringBuilder sb = new StringBuilder();
                  while ((json = bufferedReader.readLine()) != null) {
                      sb.append(json + "\n");
                  }
                  String result = sb.toString().trim();
                  bufferedReader.close();
                  inputStream.close();
                  httpURLConnection.disconnect();
                  return result;
              } catch (MalformedURLException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return null;
	}
}
