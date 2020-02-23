<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding = "utf-8"%>
<%@ page import="com.wzx.entity.Category"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.wzx.daoImpl.CategoryDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!--header-->
<%@ include file="Header.jsp"%>
		<!--主页面-->
		<div class="row">
			<!--中间左边导航条-->
			<div class="col-md-3">
				<ul class="nav nav-pills nav-stacked">
					<li><a href="####" style="background-color:#69F">当前流行</a></li>
					<c:forEach var="c" items="${clist}" begin="0" end="3">
						<li><a href="DoBook?action=Book&catid=${c.catid}">${c.name }</a></li>
					</c:forEach>
				</ul>
					</div>
			<!--中间右边轮播图-->
		<div class="col-md-9">
				<div id="carousel-example-generic" class="carousel slide">
			  	<!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>
			
				  <!-- Wrapper for slides -->
				 <div class="carousel-inner">
				    <div class="item active">
				      <img src="images/a1.jpg" alt="First slide">
				    </div>
				    <div class="item">
				      <img src="images/a2.jpg" alt="Second slide">
				    </div>
				    <div class="item">
				      <img src="images/a3.jpg" alt="Three slide">
				    </div>
				 </div>
				  
			
				  <!-- Controls -->
				  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left"></span>
				  </a>
				  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right"></span>
				  </a>
				</div>
			</div>
		</div>
		<!--中间下部-->
     <%@ include file="Footer.jsp"%>      
</body>
</html>