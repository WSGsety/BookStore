package com.wzx.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wzx.entity.Inventory;
import com.wzx.entity.Item;
import com.wzx.entity.Product;
import com.wzx.service.InventoryService;
import com.wzx.service.ItemService;
import com.wzx.service.ProductService;
import com.wzx.serviceImlp.InventoryServiceImpl;
import com.wzx.serviceImlp.ItemServiceImpl;
import com.wzx.serviceImlp.ProductServiceImpl;


@WebServlet("/DoBook")
public class DoBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if("Book".equals(action)){
			Book(request,response);
		}else if("BookMsg".equals(action)){
			BookMsg(request,response);
		}else if("BookInventory".equals(action)){
			BookInventory(request,response);
		}
		
	}

	public void BookInventory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String itemid=request.getParameter("itemid");
		ItemService isi = new ItemServiceImpl();
		InventoryService isi2=new InventoryServiceImpl();
		ArrayList<Item> ilist = isi.findPrice2(itemid);
		ArrayList<Inventory> ilist2 = isi2.findQty(itemid);
		session.setAttribute("Ilist", ilist);
		session.setAttribute("Ilist2", ilist2);
		response.sendRedirect("BookInventory.jsp");
	}

	public void BookMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String productid=request.getParameter("productid");
		ProductService psi = new ProductServiceImpl();
		ItemService isi = new ItemServiceImpl();
		ArrayList<Product> plist = psi.findProduct(productid);
		ArrayList<Item> ilist = isi.findPrice(productid);
		session.setAttribute("Plist", plist);
		session.setAttribute("Ilist", ilist);
		response.sendRedirect("BookMsg.jsp");
	}

	public void Book(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String catid = null;
		ProductServiceImpl psi = new ProductServiceImpl();
		int pageNo = 1, pageSize = 2;

		if (request.getParameter("catid") != null) {
			catid = request.getParameter("catid");
			session.setAttribute("category", catid);
		} else {
			catid = (String) session.getAttribute("category");
		}
		
		//总页数
		int pageCount = psi.getCount(catid);
		session.setAttribute("pageCount", pageCount);
		
		
		
		int pageno=0;
		if (session.getAttribute("pageNo") == null || request.getParameter("catid") != null) {
			pageNo = 1;
		} else {
			pageNo = (Integer)session.getAttribute("pageNo");
			pageno=pageNo;
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} 
		
		
		if(pageNo>pageCount || pageNo<1){
			pageNo=pageno;
		}
		
		
		
		//上下页
		String flag = request.getParameter("flag");
		
		if ("up".equals(flag)) {
			if (pageNo < pageCount) {
				pageNo++;
			} else {
				pageNo = pageCount;
			}
		} else if ("down".equals(flag)) {
			if (pageNo > 1) {
				pageNo--;
			} else {
				pageNo = 1;
			}
		}
		

		session.setAttribute("pageNo", pageNo);
		
		

		ArrayList<Product> plist = psi.checkProduct(catid, pageNo, pageSize);
		session.setAttribute("plist", plist);
		response.sendRedirect("Book.jsp?pageCount=" + pageCount+"&pageNo="+pageNo);
		
	}
}
