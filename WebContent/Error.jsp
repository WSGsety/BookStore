<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding = "utf-8"%>
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
       .b{
        	font-size:50px;
        }
    </style>
</head>
<body>
	<!--header-->
<%@ include file="Header.jsp"%>
	<div align="center" class="b">用户名密码错误，请重新<a href="Login.jsp">登陆</a>或<a href="Regist.jsp">注册</a></div>
<!--中间下部-->
     <%@ include file="Footer.jsp"%> 
</body>
</html>