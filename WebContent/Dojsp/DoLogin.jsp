<%@page import="com.wzx.daoImpl.SignonDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String username=request.getParameter("Username");
String password=request.getParameter("Password");
SignonDaoImpl sdi=new SignonDaoImpl();
boolean flag=sdi.judgeSignon(username, password);
if(flag){
	session.setAttribute("username", username);
	response.sendRedirect("Index.jsp");	
}else{
	response.sendRedirect("Error.jsp");
}
%>
<%-- <fmt:requestEncoding value="utf-8"/>
<c:if test="${fn:judgeSignon(request.Username,request.Password)}" var="a">
	<c:set value="${request.Username}" target="${sessionScope.username }"></c:set>
	<c:redirect url="Index.jsp"/>
</c:if>
<c:if test="${not a }">
	<c:redirect url="Error.jsp"/>
</c:if> --%>
</body>
</html>