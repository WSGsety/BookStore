package com.wzx.serviceImlp;

import java.util.ArrayList;

import com.wzx.dao.InventoryDao;
import com.wzx.daoImpl.InventoryDaoImpl;
import com.wzx.entity.Inventory;
import com.wzx.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {

	@Override
	public ArrayList<Inventory> findQty(String itemid) {
		InventoryDao idi = new InventoryDaoImpl();
		return idi.findQty(itemid);
	}

	@Override
	public int findQty2(String itemid) {
		InventoryDao idi = new InventoryDaoImpl();
		return idi.findQty2(itemid);
	}

}
