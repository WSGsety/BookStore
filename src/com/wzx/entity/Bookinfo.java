package com.wzx.entity;

public class Bookinfo {
	String bookid;
	String bookname;
	int bookstore;
	String lenddate;
	int count;
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getBookstore() {
		return bookstore;
	}
	public void setBookstore(int bookstore) {
		this.bookstore = bookstore;
	}
	public String getLenddate() {
		return lenddate;
	}
	public void setLenddate(String lenddate) {
		this.lenddate = lenddate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Bookinfo(String bookid, String bookname, int count) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.count = count;
	}
	
}
