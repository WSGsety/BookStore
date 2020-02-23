package com.wzx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wzx.service.SignonService;
import com.wzx.serviceImlp.SignonServiceImpl;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String username=request.getParameter("Username");
		String password=request.getParameter("Password");
		SignonService ssi=new SignonServiceImpl();
		boolean flag=ssi.judgeSignon(username, password);
		if(flag){
			HttpSession session=request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("Index.jsp");	
		}else{
			response.sendRedirect("Error.jsp");
		}
	}

}
