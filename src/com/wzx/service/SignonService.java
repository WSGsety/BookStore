package com.wzx.service;

import java.util.ArrayList;

import com.wzx.entity.Signon;

public interface SignonService {
	public ArrayList<Signon> getSignon(String username,String password);
	public boolean judgeSignon(String username,String password);
	public void insertSignon(String username,String password);
	
}
