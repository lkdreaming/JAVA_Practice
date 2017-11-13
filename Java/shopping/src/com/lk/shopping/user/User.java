package com.lk.shopping.user;

import java.util.*;
import java.sql.*;
import java.util.Date;
import com.lk.shopping.db.DB;

public class User {
	private String username;
	private String password;
	private String phone;
	private String addr;
	private Date rdate;
	boolean logined = false;
	// List<User> users = new ArrayList<User>();
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public boolean checkUser(String username, String password) {
		String sql = "select * from  user";
		/*
		 * Connection conn = DB.getConn(); Statement stmt = DB.getStmt(conn);
		 */
		ResultSet rs = DB.executeQuery(sql);
		User u = new User(username, password);
		String rsUsrnm = null;
		String rsPw = null;
		try {
			while (rs.next()) {
				rsUsrnm = rs.getString("username");
				rsPw = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rsUsrnm != username) {
			// System.out.print("用户名错误!");
			u.logined = false;
		} else if (rsPw != password) {
			// System.out.print("密码错误!");
			u.logined = false;
		} else if (rsUsrnm == username && rsPw == password) {
			// System.out.print("登录成功!");
			u.logined = true;
			// users.add(u);
		}
		return u.logined;
	}
	
	public void regUser(User user) {
		
	}
}
