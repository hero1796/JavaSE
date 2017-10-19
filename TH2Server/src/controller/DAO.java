/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author HungVu
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ptit.hungvu.student.Student;
import ptit.hungvu.student.Subject;
import ptit.hungvu.student.SubjectClass;
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
            conn = SQLServerConnUtils_JTDS.getSQLServerConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addStudent(Student st) {
        System.out.println("start addstdent...");
        String sqlInsert = "INSERT INTO tblStudent VALUES(?, ?, ?, ?)";
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
        String query = "select * from tblStudent a where a.name like ?";
        ArrayList<Student> listStudent = new ArrayList<Student>();
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                java.sql.Date dob = rs.getDate(3);
                String address = rs.getString(4);
                Student st = new Student(id, name, dob, address);
                listStudent.add(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("query success!");
        return listStudent;
    }
    
    public ArrayList<Subject> searchSubject(String key) {
        System.out.println("start search Subject for key = " + key);
        String query = "select * from tblSubject a where a.name like ?";
        ArrayList<Subject> listStudent = new ArrayList<Subject>();
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int numTinChi = rs.getInt(3);
                Subject st = new Subject(id, name, numTinChi, null);
                listStudent.add(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("query success!");
        return listStudent;
    }
    
    public ArrayList<SubjectClass> searchSubjectClass(int key) {
        System.out.println("start search SubjectClass for subjectID = " + key);
        String query = "select * from  tblSubjectClass as a where a.subjectID = ?";
        ArrayList<SubjectClass> listStudent = new ArrayList<SubjectClass>();
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String learnTime = rs.getString(3);
                String room = rs.getString(4);
                int maxSlot = rs.getInt(5);
                SubjectClass st = new SubjectClass(id, name, learnTime, room, maxSlot, new Subject(key));
                listStudent.add(st);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("query success!");
        return listStudent;
    }
}
