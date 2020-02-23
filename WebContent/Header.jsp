<%@ page import="com.wzx.entity.Category"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.wzx.daoImpl.CategoryDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding = "utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
    	<div class = "row">
       
		<!--header-->
        	<!--商标名称-->
            <div class="col-md-3">
                <h3>在线图书销售平台</h3>
            </div>
            <!--保障图片-->
            <div class="col-md-5">
                <img src="images/header.jpg">
            </div>
            <!--登录入口-->
            <div class="col-md-4" id="func">
                <ul>
                    <li><a href="DoCart?action=Cart" style="font-size: 15px">MyShopping</a></li>
                    <c:if test="${ sessionScope.username!=null}" var="flag">
                    	<li><a href="DoInvalidate" style="font-size: 15px;">注销</a></li>
                    	<li>welcome ${ sessionScope.username}</li>
                    </c:if>

                    <c:if test="${not flag}">
                    	<li><a href="Regist.jsp" style="font-size: 15px;">Register</a></li>
                    	<li><a href="Login.jsp" style="font-size: 15px; margin-right:15px;">Login</a></li>
					</c:if>
                    
                </ul>
            </div>
            
         </div>
		<!--导航栏-->
			<div>
				<nav class="navbar navbar-inverse" role="navigation">
				  <!-- Brand and toggle get grouped for better mobile display -->
                  <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="Index.jsp">首页</a>
                  </div>
				
				  <!-- Collect the nav links, forms, and other content for toggling -->
				  <div class="collapse navbar-collapse navbar-ex1-collapse">
				    <ul class="nav navbar-nav">
                          <li class="active">
                          <%
                          CategoryDaoImpl cdi = new CategoryDaoImpl();
						  ArrayList<Category> clist= cdi.checkCategory();
						  request.setAttribute("clist",clist);
						  %>
							<c:forEach var="c" items="${clist}" begin="0" end="3">
								<li><a href="DoBook?action=Book&catid=${c.catid}">${c.name }</a></li>
							</c:forEach>
							<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">其它 <b class="caret"></b></a>
							<ul class="dropdown-menu">
							<c:forEach var="c" items="${clist}" begin="4" end="6">
								<li><a href="DoBook?action=Book&catid=${c.catid}">${c.name }</a></li>
							</c:forEach>
							<li class="divider"></li>
							<c:forEach var="c" items="${clist}" begin="7" end="9">
								<li><a href="DoBook?action=Book&catid=${c.catid}">${c.name }</a></li>
							</c:forEach>
							<li class="divider"></li>
							<c:forEach var="c" items="${clist}" begin="10">
								<li><a href="DoBook?action=Book&catid=${c.catid}">${c.name }</a></li>
							</c:forEach>
                        		  
							 
                         
                            </ul>
				      </li>
				    </ul>
				    <form class="navbar-form navbar-right" role="search">
                          <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                          </div>
                          <button type="submit" class="btn btn-default">搜索</button>
				    </form>
				
				  </div><!-- /.navbar-collapse -->
				</nav>
			</div>