package com.wzx.dao;

import java.util.ArrayList;

import com.wzx.entity.ProItInven;

public interface ProItInvenDao {
	public ArrayList<ProItInven> selectCart(String itemid);
}
