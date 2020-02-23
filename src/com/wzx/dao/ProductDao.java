package com.wzx.dao;

import java.util.ArrayList;
import com.wzx.entity.Product;

public interface ProductDao {
	public ArrayList<Product> checkProduct(String catid,int pageNo,int pageSize);
	
	public int getCount(String name);
	
	public ArrayList<Product> findProduct(String productid);
}
