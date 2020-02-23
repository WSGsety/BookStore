package com.wzx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzx.util.DataBase;

/**
 * Servlet implementation class DoRegist
 */
@WebServlet("/DoRegist")
public class DoRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String userid=request.getParameter("userid");
		String nowpassword=request.getParameter("nowpassword");
		String repeatpassword=request.getParameter("repeatpassword");

		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String status=request.getParameter("status");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String addr1=request.getParameter("address1");
		String addr2=request.getParameter("address2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zip=request.getParameter("zip");
		String country=request.getParameter("country");


		DataBase db=new DataBase();
		boolean flag=db.exeuteDml2(userid,nowpassword,email,firstname,lastname,status,addr1,addr2,city,state,zip,country,phone);
		if(flag){
			response.sendRedirect("Index.jsp");	
		}else{
			response.sendRedirect("Regist.jsp");
		}
	}

}
