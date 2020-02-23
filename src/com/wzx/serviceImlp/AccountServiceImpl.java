package com.wzx.serviceImlp;

import com.wzx.dao.AccountDao;
import com.wzx.daoImpl.AccountDaoImpl;
import com.wzx.service.AccountService;

public class AccountServiceImpl implements AccountService{

	@Override
	public void insertAccount(String userid, String email, String firstname, String lastname, String status,
			String addr1, String addr2, String city, String state, String zip, String country, String phone) {
		AccountDao adi = new AccountDaoImpl();
		adi.insertAccount(userid, email, firstname, lastname, status, addr1, addr2, city, state, zip, country, phone);
	}
	
}
