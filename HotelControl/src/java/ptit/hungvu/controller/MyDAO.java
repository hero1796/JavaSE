package java.ptit.hungvu.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ptit.hungvu.jdbcConnection.ConnectionUtil;

public class MyDAO {
	public static void main(String[] args) throws SQLException {
		Connection conn = ConnectionUtil.getMyConnection();
		String sql1 = "SELECT * FROM tblHotel";
		PreparedStatement ps = conn.prepareStatement(sql1);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2).trim();
			int star = rs.getInt(3);
			String address = rs.getString(4).trim();
			String description = rs.getString(5);
			System.out.println(id + " -- " + name + " -- " + star + " -- " + address + " -- " + description);
		}
	}
}
