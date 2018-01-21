/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ptit.hungvu.footballleague.Player;

/**
 *
 * @author HungVu
 */
public class DAO {
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public DAO() {
        conn = SQLServerConn.getSqlServerConn();
    }
    
    public void addPlayer(Player player) {
        try {
            String sql1 = "insert into tblPlayer values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setInt(1, player.getId());
            ps.setString(2, player.getName());
            java.sql.Date dob = new java.sql.Date(player.getDob().getTime());
            ps.setDate(3, dob);
            ps.setFloat(4, player.getWeight());
            ps.setFloat(5, player.getHeight());
            ps.setInt(6, player.getTeam().getId());
            ps.executeUpdate();
            System.out.println("insert done!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
