/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hungvu.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HungVu
 */
public class SQLServerConn {
    
    public static Connection getSqlServerConn() {
        String hostName = "localhost";
        String dbName = "footballleague";
        String sqlInstanceName = "SQLEXPRESS";
        String username = "hero1796";
        String password = "hungga123";
        String connectionUrl = "jdbc:jtds:sqlserver://" + hostName + ":1433/"
                + dbName + ";instance=" + sqlInstanceName;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionUrl, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
