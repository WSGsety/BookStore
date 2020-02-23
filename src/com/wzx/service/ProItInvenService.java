package com.wzx.service;

import java.util.ArrayList;

import com.wzx.entity.ProItInven;

public interface ProItInvenService {
	public ArrayList<ProItInven> selectCart(String itemid);
}
