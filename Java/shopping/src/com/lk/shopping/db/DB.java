package com.lk.shopping.db;
import java.sql.*;

public class DB {
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3336/shopping", "root", "root");
		} catch (ClassNotFoundException e) {
			return null;
		} catch (SQLException e) {
			return null;
		}
		return conn;
	}

	public static Statement getStmt(Connection conn) {
		Statement stmt = null;
		try {
			stmt = DB.getConn().createStatement();
		} catch (SQLException e) {
			return null;
		}
		return stmt;
	}

	public static ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			rs = DB.getStmt(DB.getConn()).executeQuery(sql);
		} catch (SQLException e) {
			return null;
		}
		return rs;
	}

	public static PreparedStatement prepare(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		if(conn != null) {
			try {
				pstmt = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pstmt;
	}
	
}
