<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%
	String email = request.getParameter("email");
	String name = request.getParameter("name");
	String token = request.getParameter("token");
	String password = request.getParameter("password");

	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/UserInfo?characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Seoul";
	String id = "root";
	String pwd = "hyejin00";

	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		return;
	}
	
	Connection conn = DriverManager.getConnection(url, id, pwd);

	Statement stmt = conn.createStatement();

	String sql = "INSERT INTO users VALUES('" + email + "','" + name + "','" + password + "','" + token + "')";

	try{
		int result = stmt.executeUpdate(sql);

		if (result == 1) {
			out.println("회원 가입 성공");
			System.out.println(email + " " +name +" "+password);
		} else {
			out.println("회원 가입 실패");
			System.out.println("fail");
			System.out.println(email + " " +name +" "+password);
		}		
	} catch(Exception e) {
		out.println(e.toString());
	}


	stmt.close();
	conn.close();
%>