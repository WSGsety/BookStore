package com.wzx.dao;

import java.util.ArrayList;

import com.wzx.entity.Item;
import com.wzx.entity.Product;

public interface ItemDao {
	public ArrayList<Item> findPrice(String catid);
	public ArrayList<Item> findPrice2(String catid);
	double findPrice3(String itemid);
	String findBook(String itemid);
}
