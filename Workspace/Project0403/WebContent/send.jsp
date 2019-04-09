<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.fasterxml.jackson.databind.*" %>



<%

String json = 

"{\"to\":\"fYmF2Qdq3I0:APA91bE4DlX832IpuUyxsVRYs-xKr8IkdN1JkbNRSFA8Vdn14WYuYvl0oFPTtrNNQD0dyngwtXWsoeLJ7_eo_bTv0nq5zdXH-chgqu3KpkPjh36SEgXN8CjiUHpG_U38uhDlkQVSxFnz\",\"notification\":{\"title\":\"Portugal vs. Denmark\",\"body\":\"great match!\"}}";

String msgMap = sendREST("https://fcm.googleapis.com/fcm/send", json);
%>



<%!

public static String sendREST(String sendUrl, String jsonValue) throws IllegalStateException {

String inputLine = null;
StringBuffer outResult = new StringBuffer();

  try{
	URL url = new URL(sendUrl);
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setDoOutput(true);
	conn.setRequestMethod("POST");
	conn.setRequestProperty("Content-Type", "application/json");
	conn.setRequestProperty("Authorization", "key=AAAA7AXWj7w:APA91bG4EFfeNYJOBh0JhsO3nRdTYSJOt0V_FtefwMRB-RYDPunXsrufUB8n5rJ-w9UwvVH958ci2GJHqPIGNqXi0QjIH2ktW1KY6xO7DDYKTbEe4zjDTosSPbsuCJsMBSEfM-E07hiy"); 
	conn.setConnectTimeout(10000);
	conn.setReadTimeout(10000);
      
	OutputStream os = conn.getOutputStream();
	os.write(jsonValue.getBytes("UTF-8"));
	os.flush();
    
	// 리턴된 결과 읽기
	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	while ((inputLine = in.readLine()) != null) {
		outResult.append(inputLine);
	}
    
	conn.disconnect();
  }catch(Exception e){
      e.printStackTrace();
  }	
  
  return outResult.toString();
}
%>