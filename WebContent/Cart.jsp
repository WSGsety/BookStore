<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding = "utf-8"%>
<%@ page import="com.wzx.entity.Product"%>
<%@ page import="com.wzx.entity.Item"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.wzx.daoImpl.CategoryDaoImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--BootStrap设计的页面支持响应式的 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>书籍库</title>
<!--引入BootStrap的CSS-->
<link rel="stylesheet" href="css/bootstrap.css"/>
<!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
<script type="text/javascript" src="js/jquery-1.11.3.min.js" ></script>
<!--引入BootStrap的JS的文件-->
<script type="text/javascript" src="js/bootstrap.js" ></script>
<script type="text/javascript" src="js/cart.js"></script>
<title>test</title>
<style type="text/css">
        #func ul li{
            list-style: none;
            float: right;
            padding: 5px 10px;
            line-height: 58px;
            
        }
        a{
            color:#333;
            text-decoration:none;
            }
        #func ul li a:hover{
            color: grey;
            text-decoration:none;
            color:#F60;
        }
    </style>
</head>
<body>
<!-- header -->
<%@ include file="Header.jsp"%>


<!-- 主界面 -->

<div align="center"  class="col-md-offset-2 col-md-8">
<form>
	<table class="table table-striped">
		<tr>
			<td>项目编号</td>
			<td>产品编号</td>
			<td>书名</td>
			<td>库存</td>
			<td>数量</td>
			<td>单价</td>
			<td>总价</td>
			<td>操作</td>
		</tr>
		
		<c:forEach var="cartlist" items="${sessionScope.cartlist}">
		<tr>
			<td id="item">${cartlist.itemid}</td>
			<td>${cartlist.productid}</td>
			<td>${cartlist.name}</td>
			<td>${cartlist.qty}</td>
			<td><input type="text" id="qty" value="${cartlist.num}" size="6"></td>
			<td><fmt:formatNumber type="number" value="${cartlist.listprice}" pattern="0.00"/></td>
			<td><fmt:formatNumber type="number" value="${cartlist.listprice*cartlist.num}" pattern="0.00"/></td>
			<td><a href="DoCart?action=Remove&itemid=${cartlist.itemid}">remove</a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="right">Total:<fmt:formatNumber type="number" value="${sessionScope.total}" pattern="0.00"/></td>
			<td><a href="alipay/index.jsp?WIDtotal_amount=<fmt:formatNumber type="number" value="${sessionScope.total}" pattern="0.00"/>" >结算</a></td>
		</tr>
	</table>
	</form>
</div>
        <!-- footer -->
    <%@ include file="Footer.jsp"%>
</body>
</html>