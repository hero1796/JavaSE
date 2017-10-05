package ptit.hungvu.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConn {
	public static Connection getSqlServerConn() {
		String hostName = "localhost";
		String dbName = "hoteldb";
		String sqlInstanceName = "SQLEXPRESS";
		String username = "hero1796";
		String password = "hungga123";
		String connectionUrl = "jdbc:jtds:sqlserver://" + hostName + ":1433/" 
				+ dbName + ";instance=" + sqlInstanceName;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionUrl, username, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
}
