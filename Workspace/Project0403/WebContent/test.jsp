<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id =request.getParameter("id");

String pw =request.getParameter("pw");

System.out.println("id="+id);
System.out.println("pw="+pw);

%>

전달 받은 ID는 <%=id %>이고 PW는 <%=pw %>입니다.