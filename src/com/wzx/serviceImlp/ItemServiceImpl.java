package com.wzx.serviceImlp;

import java.util.ArrayList;

import com.wzx.dao.ItemDao;
import com.wzx.daoImpl.ItemDaoImpl;
import com.wzx.entity.Item;
import com.wzx.service.ItemService;

public class ItemServiceImpl implements ItemService{

	@Override
	public ArrayList<Item> findPrice(String catid) {
		ItemDao idi = new ItemDaoImpl();
		return idi.findPrice(catid);
	}

	@Override
	public ArrayList<Item> findPrice2(String catid) {
		ItemDao idi = new ItemDaoImpl();
		return idi.findPrice2(catid);
	}

	@Override
	public double findPrice3(String itemid) {
		ItemDao idi = new ItemDaoImpl();
		return idi.findPrice3(itemid);
	}

	@Override
	public String findBook(String itemid) {
		ItemDao idi = new ItemDaoImpl();
		return idi.findBook(itemid);
	}

}
