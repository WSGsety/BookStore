<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wzx.daoImpl.ProductDaoImpl"%>
<%@page import="com.wzx.entity.Product"%>
<%@page import="com.wzx.daoImpl.CategoryDaoImpl"%>
<%@page import="com.wzx.entity.Category"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<!--BootStrap设计的页面支持响应式的 -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>书籍库</title>
		<!--引入BootStrap的CSS-->
		<link rel="stylesheet" href="css/bootstrap.css"/>
		<!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
		<script type="text/javascript" src="js/jquery-1.11.3.min.js" ></script>
		<!--引入BootStrap的JS的文件-->
		<script type="text/javascript" src="js/bootstrap.js" ></script>
<title>test</title>
</head>
<body>
<%
	String catid = null;
	ProductDaoImpl pdi = new ProductDaoImpl();
	int pageNo = 1, pageSize = 2;

	if (request.getParameter("catid") != null) {
		catid = request.getParameter("catid");
		session.setAttribute("category", catid);
	} else {
		catid = (String) session.getAttribute("category");
	}
	
	//总页数
	int pageCount = 0;
	int count = pdi.getCount(catid);
	if (count % pageSize == 0) {
		pageCount = count / pageSize;
	} else {
		pageCount = count / pageSize + 1;
	}
	session.setAttribute("pageCount", pageCount);
	
	
	
	int pageno=0;
	if (session.getAttribute("pageNo") == null || request.getParameter("catid") != null) {
		pageNo = 1;
	} else {
		pageNo = (Integer)session.getAttribute("pageNo");
		pageno=pageNo;
		pageNo = Integer.parseInt(request.getParameter("pageNo"));
	} 
	
	
	if(pageNo>pageCount || pageNo<1){
		pageNo=pageno;
	}
	
	
	
	//上下页
	String flag = request.getParameter("flag");
	
	if ("up".equals(flag)) {
		if (pageNo < pageCount) {
			pageNo++;
		} else {
			pageNo = pageCount;
		}
	} else if ("down".equals(flag)) {
		if (pageNo > 1) {
			pageNo--;
		} else {
			pageNo = 1;
		}
	}
	

	session.setAttribute("pageNo", pageNo);
	
	

	ArrayList<Product> plist = pdi.checkProduct(catid, pageNo, pageSize);
	session.setAttribute("plist", plist);
	response.sendRedirect("Book.jsp?pageCount=" + pageCount+"&pageNo="+pageNo);
%>
</body>
</html>