package com.wzx.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.wzx.dao.ProductDao;
import com.wzx.entity.Product;
import com.wzx.util.DataBase;

public class ProductDaoImpl extends DataBase implements ProductDao {

	@Override
	public ArrayList<Product> checkProduct(String catid, int pageNo, int pageSize) {
		String sql = "select productid,name,descn from Product where category='" + catid + "' limit "
				+ (pageNo - 1) * pageSize + "," + pageSize;
		ResultSet rs = this.getResult(sql);
		ArrayList<Product> plist = new ArrayList<>();
		try {
			while (rs.next()) {
				Product pd = new Product();
				pd.setProductid(rs.getString("productid"));
				pd.setName(rs.getString("name"));
				pd.setDescn(rs.getString("descn"));
				plist.add(pd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// closeDd();
		return plist;
	}

	@Override
	public int getCount(String catid) {
		int count = 0;
		String sql = "select count(*) from Product where category='" + catid + "'";
		ResultSet rs = this.getResult(sql);
		try {
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// closeDd();
		return count;
	}

	@Override
	public ArrayList<Product> findProduct(String productid) {
		String sql = "create or replace view p_i_view as select item.itemid,product.productid,name,descn,listprice from product join item on product.productid=item.productid";
		this.getResult2(sql);
		String sql2 = "select name,descn from p_i_view where productid="+productid;
		ResultSet rs = this.getResult(sql2);
		ArrayList<Product> plist = new ArrayList<>();
		try {
			while (rs.next()) {
				Product pd = new Product();
				pd.setName(rs.getString("name"));
				pd.setDescn(rs.getString("descn"));
				plist.add(pd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// closeDd();
		return plist;
	}

	

}
