package ptit.hungvu.jdbcLearning;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

	public ConnectionUtils() {

	}
	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
//	 	Connection conn = SQLServerConnUtils_JTDS.getSQLServerConnection();
//		Connection conn = OracleConnUtils.getOracleConnection();
		Connection conn = MySQLConnUtils.getMySQLConnection();
		
	 	return conn;
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("get connection");
		Connection conn = getMyConnection();
		System.out.println("Get connection " + conn + " done!");
	}
}
