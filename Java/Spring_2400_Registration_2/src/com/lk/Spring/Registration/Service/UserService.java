package com.lk.Spring.Registration.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.lk.Spring.Registration.model.User;

public class UserService {
	
	public void add(User u) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "root");
			String sql = "insert into user values(null,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean exists(User u) {
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root" ,"root");
			String sql = "select count(*) from user where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(count);
		if(count > 0) {
			return true;
		} else return false;
	}
	
}
