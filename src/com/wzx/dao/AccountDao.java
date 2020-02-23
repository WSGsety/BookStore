package com.wzx.dao;

public interface AccountDao {
	public void insertAccount(String userid, String email, String firstname, String lastname, String status,
			String addr1, String addr2, String city, String state, String zip, String country,
			String phone);
}
