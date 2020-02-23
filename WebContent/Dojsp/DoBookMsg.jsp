<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.wzx.entity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wzx.entity.Item"%>
<%@page import="com.wzx.daoImpl.ProductDaoImpl"%>
<%@page import="com.wzx.daoImpl.ItemDaoImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String productid=request.getParameter("productid");
System.out.print(productid);
ProductDaoImpl pdi = new ProductDaoImpl();
ItemDaoImpl idi = new ItemDaoImpl();
ArrayList<Product> plist = pdi.findProduct(productid);
ArrayList<Item> ilist = idi.findPrice(productid);
session.setAttribute("Plist", plist);
session.setAttribute("Ilist", ilist);
response.sendRedirect("BookMsg.jsp");
%>
</body>
</html>