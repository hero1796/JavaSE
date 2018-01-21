package main.java.ptit.hungvu.jdbcLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnUtils_JTDS {

	public SQLServerConnUtils_JTDS() {

	}
	
	public static Connection getSQLServerConnection() throws SQLException {
		String hostName = "localhost";
		String dbName = "hoteldb";
		String sqlInstanceName = "SQLEXPRESS";
		String userName = "sa";
		String password = "hungga123";
		return getSQLServerConnection(hostName, sqlInstanceName, dbName, userName, password);
	}
	
	public static Connection getSQLServerConnection (String hostName, String sqlInstanceName
			, String dbName, String userName, String password) throws SQLException {
		String connectionUrl = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + dbName
				+ ";instance=" + sqlInstanceName;
		Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
		return conn;
	}
}
