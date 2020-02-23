package com.wzx.dao;

import java.util.ArrayList;

import com.wzx.entity.Cart;

public interface CartDao {

	public ArrayList<Cart> addCart(String username, String itemid);

	boolean findProduct(String username, String productid);

	public ArrayList<Cart> addBook(String itemid);

	public ArrayList<Cart> checkCart(String username);

	public boolean removeCart(String username, String itemid);

	public boolean updateCart(String username, String itemid, String num);
}
