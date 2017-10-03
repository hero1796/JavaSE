package ptit.hungvu.jdbcLearning;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDataExample {

	public QueryDataExample() {
	
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionUtils.getMyConnection();
		Statement statement = conn.createStatement();
		String sql = "SELECT Emp_Id, FIRST_NAME, TITLE FROM Employee emp";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			int empId = rs.getInt(1);
			String firstName = rs.getString(2);
			String title = rs.getString(3);
			System.out.println(empId + "\t" + firstName + "\t" + title + "\n");
		}
		statement.close();
		String sqlSelect = "SELECT Emp_Id, FIRST_NAME, TITLE, DEPT_ID FROM Employee emp "
				+ "WHERE emp.TITLE LIKE ? AND emp.DEPT_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sqlSelect);
		ps.setString(1, "%");
		ps.setInt(2, 1);
		ResultSet rs2 = ps.executeQuery();
		while(rs2.next()) {
			int empId = rs2.getInt(1);
			String firstName = rs2.getString(2);
			String title = rs2.getString(3);
			int dept_id = rs2.getInt(4);
			System.out.println(empId + "---" + firstName + "---" + title + "---" + dept_id + "\n");
		}
	}
}
