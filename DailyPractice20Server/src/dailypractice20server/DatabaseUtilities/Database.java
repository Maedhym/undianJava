/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailypractice20server.DatabaseUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Richard Shiawase
 */
public class Database {

    private static Connection conn = null;
    private static String url = "jdbc:mysql://localhost/donasi";
    private static String user = "root";
    private static String pass = "";

    public static Connection getConnection() {
        if (conn == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn =  DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return conn;

    }
}
