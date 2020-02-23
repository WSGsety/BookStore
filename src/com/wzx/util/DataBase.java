package com.wzx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wzx.daoImpl.AccountDaoImpl;
import com.wzx.daoImpl.SignonDaoImpl;

public class DataBase {
	public static String url="";
	public static String user="";
	public static String password="";
	public static String driver="";
	public static Connection conn=null;
	public static PreparedStatement ps=null;
	public static ResultSet rs=null;
	
	
	public DataBase(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet getResult(String sql){
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public void getResult2(String sql){
		try {
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void executeDML(String sql){
		try {
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getResult(String sql, Object[] param){
		try {
			ps = conn.prepareStatement(sql);
			if(param != null){
				for(int i=0;i<param.length;i++){
					ps.setObject(i+1, param[i]);
				}
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	//ִ��DML���
	public void exeuteDml(String sql,Object[] param){
		try {
			ps = conn.prepareStatement(sql);
			if(param != null){
				for(int i=0;i<param.length;i++){
					ps.setObject(i+1, param[i]);
				}
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ע��ҳ��ع�����
	public boolean exeuteDml2(String userid,String password, String email, String firstname, String lastname, String status,
			String addr1, String addr2, String city, String state, String zip, String country, String phone){
		SignonDaoImpl sdi=new SignonDaoImpl();
		AccountDaoImpl adi=new AccountDaoImpl();
		boolean flag=false;
		try {
			conn.setAutoCommit(false);
			sdi.insertSignon(userid, password);
			adi.insertAccount(userid, email, firstname, lastname, status, addr1, addr2, city, state, zip, country, phone);
			conn.commit();
			flag=true;
			System.out.println("����ɹ�");
		} catch (SQLException e) {
			if(conn!=null)
				try {
					conn.rollback();
					System.out.println("����ʧ��");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public void closeDd(){
		try {
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(conn!=null)
			conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

}
