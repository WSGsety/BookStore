package com.wzx.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.wzx.dao.InventoryDao;
import com.wzx.entity.Inventory;
import com.wzx.util.DataBase;

public class InventoryDaoImpl extends DataBase implements InventoryDao {

	@Override
	public ArrayList<Inventory> findQty(String itemid) {
		String sql = "create or replace view i_i_view as select item.itemid,qty,listprice,attr5 from item join inventory on item.itemid=inventory.itemid";
		this.getResult2(sql);
		String sql2 = "select itemid,qty from i_i_view where itemid='"+itemid+"'";
		ResultSet rs = this.getResult(sql2);
		ArrayList<Inventory> ilist2 = new ArrayList<>();
		try {
			while (rs.next()) {
				Inventory in = new Inventory();
				in.setItemid(rs.getString("itemid"));
				in.setQty(rs.getInt("qty"));
				ilist2.add(in);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// closeDd();
		return ilist2;
	}

	@Override
	public int findQty2(String itemid) {
		String sql = "select qty from inventory where itemid="+itemid;
		ResultSet rs = this.getResult(sql);
		int qty=0;
		try {
			while (rs.next()) {
				qty=rs.getInt("qty");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qty;
	}

}
