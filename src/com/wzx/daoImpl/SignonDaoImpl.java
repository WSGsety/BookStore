package com.wzx.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.wzx.dao.SignonDao;
import com.wzx.entity.Signon;
import com.wzx.util.DataBase;

public class SignonDaoImpl extends DataBase implements SignonDao {

	@Override
	public void insertSignon(String uname, String password) {
		String sql = "insert into Signon(username,password) values(?,?)";
		Object[] param = {uname,password};
		System.out.println(uname+"--"+password);
		exeuteDml(sql, param);
//		closeDd();
		
	}

	@Override
	public ArrayList<Signon> getSignon(String uname, String password) {
		String sql = "select * from Signon where username=? and password =?";
		Object[] param  = {uname,password};
		ResultSet rs = this.getResult(sql,param);
		ArrayList<Signon> sList = new ArrayList<Signon>();
		try {
			while (rs.next()) {
				Signon signon = new Signon();
				signon.setUsername(rs.getString("username"));
				signon.setPassword(rs.getString("password"));
				sList.add(signon);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		closeDd();
		return sList;
	}
	
	@Override
	public boolean judgeSignon(String uname, String password) {
		String sql = "select * from Signon where username=? and password =?";
		Object[] param  = {uname,password};
		ResultSet rs = this.getResult(sql,param);
		int flag=0;
		try {
			while (rs.next()) {
				flag=1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		closeDd();
		if(flag==1){
			return true;
		}else{
			return false;
		}
		
	}


}
