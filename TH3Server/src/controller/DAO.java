package controller;

import connectdb.SQLServerConnUtils_JTDS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ptit.hungvu.karaoke.Phong;

public class DAO {
	private Connection conn = null;
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public DAO() {
		conn = SQLServerConnUtils_JTDS.getSQLServerConnection();
	}

	public boolean checkLogin(Phong user) {
		String sql = "select * from tblPhong where ma = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getMa());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
