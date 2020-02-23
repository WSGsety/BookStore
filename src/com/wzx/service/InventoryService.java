package com.wzx.service;

import java.util.ArrayList;

import com.wzx.entity.Inventory;

public interface InventoryService {
	public ArrayList<Inventory> findQty(String itemid);

	int findQty2(String itemid);
}
