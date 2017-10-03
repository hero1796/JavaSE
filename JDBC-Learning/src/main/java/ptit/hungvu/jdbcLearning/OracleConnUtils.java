package ptit.hungvu.jdbcLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnUtils {

	public OracleConnUtils() {
	}
	
	public static Connection getOracleConnection() throws SQLException, ClassNotFoundException {
		String hostName = "192.168.1.104";
		String sid = "db12c";
		String userName = "learnsql";
		String password = "hungga123";
		return getOracleConnection(hostName, sid, userName, password);
		
	}
	
	public static Connection getOracleConnection(String hostName, String sid, String userName
			, String password) throws SQLException, ClassNotFoundException {
		
		String connectionUrl = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;
		Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
		return conn;
	}

}
