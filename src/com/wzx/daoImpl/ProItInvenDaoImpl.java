package com.wzx.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.wzx.dao.ProItInvenDao;
import com.wzx.entity.ProItInven;
import com.wzx.util.DataBase;

public class ProItInvenDaoImpl extends DataBase implements ProItInvenDao {

	@Override
	public ArrayList<ProItInven> selectCart(String itemid) {
		String sql = "select item.itemid,product.productid,name,qty,listprice,attr1 from product join item on product.productid=item.productid join inventory on item.itemid=inventory.itemid where item.itemid="
				+ itemid;
		ResultSet rs = this.getResult(sql);
		ArrayList<ProItInven> piiList = new ArrayList<ProItInven>();
		try {
			while (rs.next()) {
				ProItInven pii = new ProItInven();
				pii.setItemid(rs.getString("itemid"));
				pii.setProductid(rs.getString("productid"));
				pii.setAttr1(rs.getString("attr1"));
				pii.setName(rs.getString("name"));
				pii.setQty(rs.getInt("qty"));
				pii.setListprice(rs.getDouble("listprice"));
				pii.setBuyqty(0);
				piiList.add(pii);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return piiList;
	}

}
