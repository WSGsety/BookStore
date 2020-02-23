<%@ page import="com.wzx.entity.Category"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.wzx.daoImpl.CategoryDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--BootStrap设计的页面支持响应式的 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>书籍库</title>
<!--引入BootStrap的CSS-->
<link rel="stylesheet" href="css/bootstrap.css" />
<!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<!--引入BootStrap的JS的文件-->
<script type="text/javascript" src="js/bootstrap.js"></script>
<title>test</title>
</head>
<style type="text/css">
#func ul li {
	list-style: none;
	float: right;
	padding: 5px 10px;
	line-height: 58px;
}

a {
	color: #333;
	text-decoration: none;
}

#func ul li a:hover {
	color: grey;
	text-decoration: none;
	color: #F60;
}
</style>
<body>
	<%
		String info = (String) session.getAttribute("info");
		if (info != null) {
			out.print(info);
		}
	%>
	<!-- header -->
	<%@ include file="Header.jsp"%>
	<!--主页面-->
	<form class="form-horizontal" role="form" action="DoLogin" method="post">
		<div class="form-group">
			<label for="inputText" class="col-sm-4 control-label">Username</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputText"
					placeholder="Username" name="Username">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-4 control-label">Password</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password" name="Password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<div class="checkbox">
					<label> <input type="checkbox"> Remember me
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<button type="submit" class="btn btn-default">Sign in</button>
			</div>
		</div>
	</form>
	<!--中间下部-->
	<%@ include file="Footer.jsp"%>
</body>
</html>