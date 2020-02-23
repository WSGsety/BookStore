package com.wzx.dao;

import java.util.ArrayList;

import com.wzx.entity.Signon;

public interface SignonDao {
	public ArrayList<Signon> getSignon(String username,String password);
	public boolean judgeSignon(String username,String password);
	public void insertSignon(String username,String password);
	
}
