package com.wzx.service;

import java.util.ArrayList;
import com.wzx.entity.Product;

public interface ProductService {
	public ArrayList<Product> checkProduct(String catid,int pageNo,int pageSize);
	
	public int getCount(String catid);
	
	public ArrayList<Product> findProduct(String productid);
}
