/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author HungVu
 */
public class SQLServerConnUtils_JTDS {

    public SQLServerConnUtils_JTDS() {

    }

    public static Connection getSQLServerConnection(){
        String hostName = "localhost";
        String dbName = "KaraokeManage";
        String sqlInstanceName = "SQLEXPRESS";
        String userName = "sa";
        String password = "hungga123";
        return getSQLServerConnection(hostName, sqlInstanceName, dbName, userName, password);
    }

    public static Connection getSQLServerConnection(String hostName, String sqlInstanceName, String dbName, String userName, String password) {
        Connection conn = null;
        try {
            String connectionUrl = "jdbc:jtds:sqlserver://" + hostName + ":1433/" + dbName;
            conn = DriverManager.getConnection(connectionUrl, userName, password);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
