<%@page import="java.util.ArrayList"%>
<%@page import="com.wzx.daoImpl.ProductDaoImpl"%>
<%@page import="com.wzx.entity.Product"%>
<%@page import="com.wzx.daoImpl.CategoryDaoImpl"%>
<%@page import="com.wzx.entity.Category"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding = "utf-8"%>
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
<script>
	$(function(){
		$(".aSubmit").click(function(){
			var pageNo=$("#pageNo").val();
			var str=/^\d+$/;
			if((str.test(pageNo))){
				window.location="DoBook?action=Book&pageNo="+pageNo;
			}
		})
		
	})
</script>
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
                	<td> # </td>
                    <td>图书编号</td>
                    <td>图书名称</td>
                    <td>图书描述</td>
             </tr> 
            	<c:forEach var="number" items="${plist}" varStatus="status">
            		<tr>
	            		<td>${status.index+1}</td>
		            	<td><a href="DoBook?action=BookMsg&productid=${number.productid}">${number.productid}</a></td>
		            	<td>${ number.name}</td>
		            	<td>${ number.descn}</td>
            		</tr>
            	</c:forEach>   		
            </table>
            <c:set var="pageNo" scope="request" value="${request.pageNo}"/>
           	<c:set var="pageCount" scope="request" value="${request.pageCount }"/>            
            <ul class="pagination">
				<li><a href="DoBook?action=Book&flag=down&pageNo=${pageNo }">&laquo;</a></li>
				<c:if test="${pageCount <=5}" var="flag">
					<c:forEach var="i" begin="1" end="${pageCount }">
						<li><a href="DoBook?action=Book&pageNo=${i} ">${i} </a></li>
					</c:forEach>
				</c:if>
				<c:if test="${not flag }">
					<c:choose>
						<c:when test="${pageNo<=2 }">
							<c:forEach var="i" begin="1" end="5">
								<li><a href="DoBook?action=Book&pageNo=${i} ">${i} </a></li>
							</c:forEach>
						</c:when>
						<c:when test="${(pageNo+2)<=pageCount }">
							<c:forEach var="i" begin="${pageNo-2}" end="${pageNo+2}">
								<li><a href="DoBook?action=Book&pageNo=${i} ">${i} </a></li>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:forEach var="i" begin="${pageCount-4}" end="${pageCount}">
								<li><a href="DoBook?action=Book&pageNo=${i} ">${i} </a></li>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</c:if>
				<li><a href="DoBook?action=Book&flag=up&pageNo=${pageNo }">&raquo;</a></li>
				</ul>
				
			<div align="center">
    	<input type="text" id="pageNo" name="pageno" />
    	<input type="submit" class="aSubmit" value="跳转" />
    	</div>
        </div>
       
    <!-- footer -->
    
    <%@ include file="Footer.jsp"%>
</body>
</html>