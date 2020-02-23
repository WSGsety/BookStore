package com.wzx.serviceImlp;

import java.util.ArrayList;

import com.wzx.dao.SignonDao;
import com.wzx.daoImpl.SignonDaoImpl;
import com.wzx.entity.Signon;
import com.wzx.service.SignonService;

public class SignonServiceImpl implements SignonService {

	@Override
	public ArrayList<Signon> getSignon(String username, String password) {
		SignonDao sdi=new SignonDaoImpl();
		return sdi.getSignon(username, password);
	}

	@Override
	public boolean judgeSignon(String username, String password) {
		SignonDao sdi=new SignonDaoImpl();
		return sdi.judgeSignon(username, password);
	}

	@Override
	public void insertSignon(String username, String password) {
		SignonDao sdi=new SignonDaoImpl();
	}

}
