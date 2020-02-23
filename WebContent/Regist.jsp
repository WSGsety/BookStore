<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ page import="com.wzx.entity.Category"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.wzx.daoImpl.CategoryDaoImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--BootStrap设计的页面支持响应式的 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>书籍库</title>
<!--引入BootStrap的CSS-->
<link rel="stylesheet" href="css/bootstrap.css"/>
<!--引入JQuery的JS文件：JQuery的JS文件要在BootStrap的js的文件的前面引入-->
<script type="text/javascript" src="js/jquery-1.11.3.min.js" ></script>
<!--引入BootStrap的JS的文件-->
<script type="text/javascript" src="js/bootstrap.js" ></script>
<title>Insert title here</title>
</head>
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
<body>
       
		<!--header-->
<%@ include file="Header.jsp"%>

<!-- 中间 -->
    <h3 align="center">User Information</h3>
	<form class="form-horizontal" role="form" action="DoRegist" method="post">
		<div class="form-group">
			<label for="inputuserid" class="col-sm-4 control-label">User id</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputuserid" placeholder="User id" name="userid">
			</div>
		</div>
        <div class="form-group">
			<label for="nowpassword" class="col-sm-4 control-label">Now Password</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="nowpassword" placeholder="Now Password" name="nowpassword">
			</div>
		</div>
        <div class="form-group">
			<label for="repeatpassword" class="col-sm-4 control-label">Repeat Password</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" id="repeatpassword" placeholder="Repeat Password" name="repeatpassword">
			</div>
		</div>
		
		
		
        <h3 align="center">Account Information</h3>
		<div class="form-group">
			<label for="inputfirstname" class="col-sm-4 control-label">First Name</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputfirstname" placeholder="Firstname" name="firstname">
			</div>
		</div>
        <div class="form-group">
			<label for="inputlastname" class="col-sm-4 control-label">Last Name</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputlastname" placeholder="Lastname" name="lastname">
			</div>
		</div>
		<div class="form-group">
			<label for="inputstatus" class="col-sm-4 control-label">Status</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputstatus" placeholder="Status" name="status">
			</div>
		</div>
        <div class="form-group">
			<label for="inputemail" class="col-sm-4 control-label">Email</label>
			<div class="col-sm-4">
				<input type="email" class="form-control" id="inputemail" placeholder="Email" name="email">
			</div>
		</div>
        <div class="form-group">
			<label for="inputphone" class="col-sm-4 control-label">Phone</label>
			<div class="col-sm-4">
				<input type="tel" class="form-control" id="inputphone" placeholder="Phone" name="phone">
			</div>
		</div>
        <div class="form-group">
			<label for="inputaddress1" class="col-sm-4 control-label">Address1</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputaddress1" placeholder="Address1" name="address1">
			</div>
		</div>
        <div class="form-group">
			<label for="inputaddress2" class="col-sm-4 control-label">Address2</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputaddress2" placeholder="Address2" name="address2">
			</div>
		</div>
        <div class="form-group">
			<label for="inputcity" class="col-sm-4 control-label">City</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputcity" placeholder="City" name="city">
			</div>
		</div>
        <div class="form-group">
			<label for="inputstate" class="col-sm-4 control-label">State</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputstate" placeholder="State" name="state">
			</div>
		</div>
        <div class="form-group">
			<label for="inputzip" class="col-sm-4 control-label">Zip</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputzip" placeholder="Zip" name="zip">
			</div>
		</div>
        <div class="form-group">
			<label for="inputcountry" class="col-sm-4 control-label">Country</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="inputcountry" placeholder="Country" name="country">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-7 col-sm-2">
				<button type="submit" class="btn btn-default">注册</button>
			</div>
		</div>
	</form>


<!--中间下部-->
     <%@ include file="Footer.jsp"%>   
	
</body>
</html>