package com.wzx.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wzx.dao.CartDao;
import com.wzx.entity.Cart;
import com.wzx.util.DataBase;

public class CartDaoImpl extends DataBase implements CartDao {
	
	
	@Override
	public ArrayList<Cart> addCart(String username, String itemid) {
		boolean flag = findProduct(username, itemid);
		ArrayList<Cart> clist = new ArrayList<>();
		if (flag) {
			String sql = "update cart set num=num+1 where username='" + username + "' and itemid='" + itemid + "'";
			this.executeDML(sql);
		} else {
			InventoryDaoImpl idi = new InventoryDaoImpl();
			int qty = idi.findQty2(itemid);
			ItemDaoImpl idi2 = new ItemDaoImpl();
			double listprice = idi2.findPrice3(itemid);
			clist = addBook(itemid);
			for (Cart c : clist) {
				itemid = c.getItemid();
				String productid = c.getProductid();
				String name = c.getName();
				String sql = "insert into cart(username,itemid,productid,name,qty,listprice,num) values(?,?,?,?,?,?,1)";
				Object[] param = { username, itemid, productid, name, qty, listprice };
				this.exeuteDml(sql, param);
			}
		}
		return clist;
	}
	
	@Override
	public ArrayList<Cart> addBook(String itemid) {
		String sql = "SELECT item.itemid,item.productid,product.name FROM item join product on item.productid=product.productid where item.itemid='"
				+ itemid + "'";
		ResultSet rs = this.getResult(sql);
		ArrayList<Cart> clist = new ArrayList<Cart>();
		try {
			while (rs.next()) {
				Cart c = new Cart();
				c.setItemid(rs.getString("itemid"));
				c.setProductid(rs.getString("productid"));
				c.setName(rs.getString("name"));
				clist.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clist;
	}

	@Override
	public boolean findProduct(String username, String itemid) {
		String sql = "select * from cart where username='" + username + "' and itemid='" + itemid + "'";
		ResultSet rs = this.getResult(sql);
		boolean flag = false;
		try {
			while (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public ArrayList<Cart> checkCart(String username) {
		String sql = "SELECT itemid,productid,name,qty,listprice,num FROM cart where username='" + username + "'";
		ResultSet rs = this.getResult(sql);
		ArrayList<Cart> clist = new ArrayList<Cart>();
		try {
			while (rs.next()) {
				Cart c = new Cart();
				c.setItemid(rs.getString("itemid"));
				c.setProductid(rs.getString("productid"));
				c.setName(rs.getString("name"));
				c.setQty(rs.getInt("qty"));
				c.setListprice(rs.getDouble("listprice"));
				c.setNum(rs.getInt("num"));
				clist.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clist;
	}

	@Override
	public boolean removeCart(String username, String itemid) {
		String sql = "delete from cart where username='" + username + "' and itemid='" + itemid + "'";
		this.executeDML(sql);
		return true;
	}

	@Override
	public boolean updateCart(String username, String itemid, String num) {
		String sql = "update cart set num='" + num + "' where username='" + username + "' and itemid='" + itemid + "'";
		this.executeDML(sql);
		return true;
	}
}
