package com.wzx.serviceImlp;

import java.util.ArrayList;

import com.wzx.dao.CartDao;
import com.wzx.daoImpl.CartDaoImpl;
import com.wzx.entity.Cart;
import com.wzx.service.CartService;

public class CartServiceImpl implements CartService {

	@Override
	public ArrayList<Cart> addCart(String username, String itemid) {
		CartDaoImpl cdi = new CartDaoImpl();
		return cdi.addCart(username, itemid);
	}

	@Override
	public boolean findProduct(String username, String productid) {
		CartDao cdi = new CartDaoImpl();
		return cdi.findProduct(username, productid);
	}

	@Override
	public ArrayList<Cart> addBook(String itemid) {
		CartDao cdi = new CartDaoImpl();
		return cdi.addBook(itemid);
	}

	@Override
	public ArrayList<Cart> checkCart(String username) {
		CartDao cdi = new CartDaoImpl();
		return cdi.checkCart(username);
	}

	@Override
	public boolean removeCart(String username, String itemid) {
		CartDao cdi = new CartDaoImpl();
		return cdi.removeCart(username, itemid);
	}

	@Override
	public boolean updateCart(String username, String itemid, String num) {
		CartDao cdi = new CartDaoImpl();
		return cdi.updateCart(username, itemid, num);
	}

}
