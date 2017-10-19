/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcConnection;

/**
 *
 * @author HungVu
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnUtils_JTDS {
	public static Connection getSQLServerConnection() throws SQLException {
		String hostName = "localhost";
		String dbName = "StudentDB";
		String sqlInstanceName = "SQLEXPRESS";
		String userName = "hero1796";
		String password = "hungga123";
		return getSQLServerConnection(hostName, sqlInstanceName, dbName, userName, password);
	}
	
	public static Connection getSQLServerConnection (String hostName, String sqlInstanceName
			, String dbName, String userName, String password) throws SQLException {
		String connectionUrl = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + dbName;
		Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
		return conn;
	}
}
