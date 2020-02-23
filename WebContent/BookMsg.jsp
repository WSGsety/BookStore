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
            <table class="table table-striped">
            <tr>
                	<td>明细编号</td>
                    <td>图书完整名称</td>
                    <td>单价</td>
                    <td>图书描述</td>
                    <td>操作</td>
             </tr>
             
             <c:forEach var="Plist" items="${sessionScope.Plist}" varStatus="status">
             	<tr>
	            	<c:forEach var="Ilist" items="${sessionScope.Ilist}" begin="${status.index }" end="${status.index }">
	            		<td><a href="DoBook?action=BookInventory&itemid=${ Ilist.itemid}">${ Ilist.itemid}</a></td>
	            	</c:forEach>
	            	<td>${ Plist.name}</td>
	            	<c:forEach var="Ilist" items="${sessionScope.Ilist}" begin="${status.index }" end="${status.index }">
	            		<td>${ Ilist.listprice}</td>
	            	</c:forEach>
	            	<td>${ Plist.descn}</td>
	            	<c:forEach var="Ilist" items="${sessionScope.Ilist}" begin="${status.index }" end="${status.index }">
	            	<td><a href="DoCart?action=AddCart&itemid=${Ilist.itemid}&username=${sessionScope.username}">加入购物车</a></td>
	            	</c:forEach>
            	</tr>  
             </c:forEach>
            </table>
        </div>
        <!-- footer -->
    <%@ include file="Footer.jsp"%>
</body>
</html>