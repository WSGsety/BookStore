package com.wzx.serviceImlp;

import java.util.ArrayList;

import com.wzx.dao.ProductDao;
import com.wzx.daoImpl.ProductDaoImpl;
import com.wzx.entity.Product;
import com.wzx.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	public ArrayList<Product> checkProduct(String catid, int pageNo, int pageSize) {
		ProductDao pdi = new ProductDaoImpl();
		return pdi.checkProduct(catid, pageNo, pageSize);
	}

	@Override
	public int getCount(String catid) {
		ProductDao pdi = new ProductDaoImpl();
		int pageCount = 0,pageSize=2;
		int count = pdi.getCount(catid);
		if (count % pageSize == 0) {
			pageCount = count / pageSize;
		} else {
			pageCount = count / pageSize + 1;
		}
		return pdi.getCount(catid);
	}

	@Override
	public ArrayList<Product> findProduct(String productid) {
		ProductDao pdi = new ProductDaoImpl();
		return pdi.findProduct(productid);
	}

}
