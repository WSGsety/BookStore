package com.wzx.serviceImlp;

import java.util.ArrayList;

import com.wzx.dao.ProItInvenDao;
import com.wzx.daoImpl.ProItInvenDaoImpl;
import com.wzx.entity.ProItInven;
import com.wzx.service.ProItInvenService;

public class ProItInvenServiceImpl implements ProItInvenService{

	@Override
	public ArrayList<ProItInven> selectCart(String itemid) {
		ProItInvenDao pdi=new ProItInvenDaoImpl();
		return pdi.selectCart(itemid);
	}

}
