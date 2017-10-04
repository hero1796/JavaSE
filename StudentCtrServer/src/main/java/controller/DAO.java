package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbcConnection.MySQLConnUtils;
import ptit.hungvu.model.Student;

public class DAO {
	private Connection conn;
        private PreparedStatement ps;
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DAO() {
		try {
			conn = MySQLConnUtils.getMySQLConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addStudent(Student st) {
		System.out.println("start addstdent...");
		String sqlInsert = "INSERT INTO studentdb.tblStudent VALUES(?, ?, ?, ?)";
		try {
			ps = conn.prepareStatement(sqlInsert);
			ps.setInt(1, st.getId());
			ps.setString(2, st.getName());
                        java.sql.Date sqlDate = new java.sql.Date(st.getdOb().getTime());
			ps.setDate(3, sqlDate);
			ps.setString(4, st.getAddress());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("add success!");
		return true;
	}
        
        public ArrayList<Student> searchStudent(String key) {
            System.out.println("start search student for key = " + key);
            String query = "select * from studentdb.tblStudent a where a.name like ?";
            ArrayList<Student> listStudent = new ArrayList<Student>();
            try {
                ps = conn.prepareStatement(query);
                ps.setString(1,"%" + key + "%");
                ResultSet rs = ps.executeQuery();   
                while(rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    java.sql.Date dob = rs.getDate(3);
                    String address = rs.getString(4);
                    Student st = new Student(id, name, dob, address);
                    listStudent.add(st);
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
            System.out.println("query success!");
            return listStudent;
        }
}
