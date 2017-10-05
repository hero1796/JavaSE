package ptit.hungvu.jdbcConnection;

import java.sql.Connection;

public class ConnectionUtil {
	
	public static Connection getMyConnection() {
		Connection conn = SQLServerConn.getSqlServerConn();
		return conn;
	}
}
