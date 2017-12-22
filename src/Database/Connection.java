/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */

// Singleton ?!
public class Connection {

   java.sql.Connection conn;
    Statement st;
    ResultSet rs;

    private Connection() {
    }
    private static Connection con = null;//Private static obj of the same class that is the only instance of the class

    public void connect() {
    }

         public boolean verifyUser(String loginName, String Password){
        boolean isFound = false;
        try {
            
            Connection aDbConnection =
                    Connection.getConnection();
            st= aDbConnection.getStatement();
             rs = st.
             executeQuery("Select * from users where userName='"
                     + loginName + "' and password='"
             + Password + "'");
            if(rs.next())
                isFound = true;           

        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }return false;
}

    public void disconnect() {
        try {
            conn.close();
            st.close();
            rs.close();
        } catch (Exception ex) {
        }
    }

    public static Connection getConnection() { //Public static method that returns the instance of the class
        if (con == null) {
            return con = new Connection();
        }
        return con;
    }
    public  Statement getStatement() throws SQLException
    {
        if(st == null)
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        return st;
    }

}
