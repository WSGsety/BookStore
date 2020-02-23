package com.wzx.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.wzx.dao.ItemDao;
import com.wzx.entity.Item;
import com.wzx.util.DataBase;

public class ItemDaoImpl extends DataBase implements ItemDao {

	@Override
	public ArrayList<Item> findPrice(String productid) {
		String sql = "create or replace view p_i_view as select itemid,product.productid,name,descn, listprice from product join item on product.productid=item.productid";
		this.getResult2(sql);
		String sql2 = "select itemid,listprice from p_i_view where productid="+productid;
		ResultSet rs = this.getResult(sql2);
		ArrayList<Item> ilist = new ArrayList<>();
		try {
			while (rs.next()) {
				Item it = new Item();
				it.setItemid(rs.getString("itemid"));
				it.setListprice(rs.getDouble("listprice"));
				ilist.add(it);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// closeDd();
		return ilist;
	}
	
	@Override
	public ArrayList<Item> findPrice2(String itemid) {
		String sql = "create or replace view i_i_view as select item.itemid,qty,listprice,attr5 from item join inventory on item.itemid=inventory.itemid";
		this.getResult2(sql);
		String sql2 = "select listprice,attr5 from i_i_view where itemid="+itemid;
		ResultSet rs = this.getResult(sql2);
		ArrayList<Item> ilist = new ArrayList<>();
		try {
			while (rs.next()) {
				Item it = new Item();
				it.setListprice(rs.getDouble("listprice"));
				it.setAttr5(rs.getString("attr5"));
				ilist.add(it);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// closeDd();
		return ilist;
	}
	
	@Override
	public String findBook(String itemid) {
		String sql = "select productid from item where itemid='"+itemid+"'";
		ResultSet rs = this.getResult(sql);
		String productid="";
		try {
			while (rs.next()) {
				productid=rs.getString("productid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productid;
	}
	
	@Override
	public double findPrice3(String itemid) {
		String sql = "select listprice from item where itemid="+itemid;
		ResultSet rs=this.getResult(sql);
		double listprice=0;
		try {
			while (rs.next()) {
				listprice=rs.getDouble("listprice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// closeDd();
		return listprice;
	}

}
