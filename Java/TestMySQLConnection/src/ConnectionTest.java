import java.sql.*;
public class ConnectionTest {

	public static void main(String[] args) {
		Connection conn;
		Statement stmt;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?user=root&password=root");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from dept");
			while(rs.next()) {
				System.out.println(rs.getString("loc"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
