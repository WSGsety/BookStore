package com.wzx.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wzx.dao.CategoryDao;
import com.wzx.entity.Category;
import com.wzx.util.DataBase;

public class CategoryDaoImpl extends DataBase implements CategoryDao{

	@Override
	public ArrayList<Category> checkCategory() {
		String sql = "select catid,name from category";
		ResultSet rs = this.getResult(sql);
		ArrayList<Category> clist = new ArrayList<>();
		try {
			while(rs.next()){
				Category c = new Category();
				c.setCatid(rs.getString("catid"));
				c.setName(rs.getString("name"));
				clist.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		closeDd();
		return clist;
	}
}
