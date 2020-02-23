package com.wzx.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wzx.entity.Cart;
import com.wzx.service.CartService;
import com.wzx.serviceImlp.CartServiceImpl;

@WebServlet("/DoCart")
public class DoCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String action = request.getParameter("action");
			if ("Cart".equals(action)) {
				Cart(request, response);
			} else if ("Remove".equals(action)) {
				Remove(request, response);
			} else if ("Change".equals(action)) {
				Change(request, response);
			} else if ("AddCart".equals(action)) {
				AddCart(request, response);
			}
		}

		public void AddCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username=request.getParameter("username");
			if("".equals(username)){
				response.sendRedirect("Login.jsp");
			}else{
				CartService csi=new CartServiceImpl();
				String itemid = request.getParameter("itemid");
				csi.addCart(username,itemid);
				Cart(request, response);
			}
		}

		public void Cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			double total=0;
			HttpSession session = request.getSession();
			String username=(String)session.getAttribute("username");
			if(username==null){
				response.sendRedirect("Login.jsp");
			}else{
				CartService csi=new CartServiceImpl();
				ArrayList<Cart> cartlist = csi.checkCart(username);
				for (Cart c : cartlist) {
					total+=c.getListprice()*c.getNum();
				}
				session.setAttribute("total", total);
				session.setAttribute("cartlist", cartlist);
				response.sendRedirect("Cart.jsp");
			}
		}

		public void Remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String username=(String)session.getAttribute("username");
//			System.out.println("Add:"+username);
			String itemid = request.getParameter("itemid");
			CartService csi=new CartServiceImpl();
			csi.removeCart(username,itemid);
			Cart(request, response);
		}
		
		public void Change(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			String username=(String)session.getAttribute("username");
			String itemid = request.getParameter("itemid");
			String num = request.getParameter("num");
			CartService csi=new CartServiceImpl();
			csi.updateCart(username,itemid,num);
			Cart(request, response);
		}

}
