<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.net.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.fasterxml.jackson.databind.*" %>


<%
String fromemail = request.getParameter("fromemail");
String toemail = request.getParameter("toemail");
String message = request.getParameter("message");
String token = getToken(toemail);


String json = 
"{\"to\":\""+token+
	"\",\"notification\":{\"title\":\""+fromemail+"\",\"body\":\""+message+"\"}}";

System.out.println(json);

String msgMap = sendREST(
		"https://fcm.googleapis.com/fcm/send", json);


%>
token

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
	conn.setRequestProperty("Authorization", "key=AAAA3wq5JBs:APA91bHGLCGsqpbKuvf1W6vaNpGzKsj_B5WzLmGSDXfNBcgGZQ6aJmvT8G2e_0whEWbPFEfW2kQXPySlxZyGxXlwWN0lf_YnakmZOUDcguXj9Kbhd5ev49xOtoNEJdLZvKImgCwS7zcE"); 
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

<%! 
public String getToken(String toemail) {
	String token = null;
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/UserInfo?characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Seoul";
	String id = "root";
	String pwd = "hyejin00";

	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return null;
	}
	
	try {
	Connection conn = DriverManager.getConnection(url, id, pwd);

	Statement stmt = conn.createStatement();

	String sql = "SELECT token FROM users WHERE email='"+toemail+"'";
	System.out.println(sql);
	ResultSet rs = stmt.executeQuery(sql);
	if(rs.next()) {
		token = rs.getString("token");
	} else {

	}
	

	stmt.close();
	conn.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	return token;
}

%>