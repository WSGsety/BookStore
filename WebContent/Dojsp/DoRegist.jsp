<%@page import="com.wzx.util.DataBase"%>
<%@page import="com.wzx.daoImpl.AccountDaoImpl"%>
<%@page import="com.wzx.daoImpl.SignonDaoImpl"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String userid=request.getParameter("userid");
String nowpassword=request.getParameter("nowpassword");
String repeatpassword=request.getParameter("repeatpassword");

String firstname=request.getParameter("firstname");
String lastname=request.getParameter("lastname");
String status=request.getParameter("status");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
String addr1=request.getParameter("address1");
String addr2=request.getParameter("address2");
String city=request.getParameter("city");
String state=request.getParameter("state");
String zip=request.getParameter("zip");
String country=request.getParameter("country");


DataBase db=new DataBase();
boolean flag=db.exeuteDml2(userid,nowpassword,email,firstname,lastname,status,addr1,addr2,city,state,zip,country,phone);
if(flag){
	response.sendRedirect("Index.jsp");	
}else{
	response.sendRedirect("Regist.jsp");
}



%>
</body>
</html>