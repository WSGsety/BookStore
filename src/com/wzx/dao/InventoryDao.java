package com.wzx.dao;

import java.util.ArrayList;

import com.wzx.entity.Inventory;

public interface InventoryDao {
	public ArrayList<Inventory> findQty(String itemid);

	int findQty2(String itemid);
}
