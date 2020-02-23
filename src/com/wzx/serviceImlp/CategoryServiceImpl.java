package com.wzx.serviceImlp;

import java.util.ArrayList;

import com.wzx.dao.CategoryDao;
import com.wzx.daoImpl.CategoryDaoImpl;
import com.wzx.entity.Category;
import com.wzx.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	@Override
	public ArrayList<Category> checkCategory() {
		CategoryDao cdi = new CategoryDaoImpl();
		return cdi.checkCategory();
	}

}
