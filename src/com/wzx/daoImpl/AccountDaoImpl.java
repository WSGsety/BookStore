package com.wzx.daoImpl;

import com.wzx.dao.AccountDao;
import com.wzx.util.DataBase;

public class AccountDaoImpl extends DataBase implements AccountDao{

	@Override
	public void insertAccount(String userid, String email, String firstname, String lastname, String status,
			String addr1, String addr2, String city, String state, String zip, String country, String phone) {
		String sql = "insert into Account(userid,email,firstname,lastname,status,addr1,addr2,city,state,zip,country,phone) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] param = {userid,email,firstname,lastname,status,addr1,addr2,city,state,zip,country,phone};
		this.exeuteDml(sql, param);
//		closeDd();
	}

}
