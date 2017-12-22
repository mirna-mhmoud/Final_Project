/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import ApplicationEntity.User;
import Database.Connection;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class DBUsers {

    private Connection connect;
    private Statement aStatement;
    private ResultSet set;
    protected static int std_id = -1;

    public boolean isExist(int id, int password) {
        try {
            connect = Connection.getConnection();
            connect.connect();
            aStatement = connect.getStatement();
            String query = "select * from users where std_id='" + id + "' and password='" + password + "'";
            set = aStatement.executeQuery(query);
            if (set.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void addUser(User user) {
        try {
            connect = Connection.getConnection();
            connect.connect();
            aStatement = connect.getStatement();
            String query = "insert into users (std_id,password) values('" + user.getId() + "','" + user.getPassword() + "')";
            aStatement.execute(query);
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "This information is already exist !");
        }

    }

    public void setStdId(int id) {

        this.std_id = id;

    }
    public void setUser(int id , int password)
    {
        if(isExist(id, password))
        this.std_id =id;
    }

    public static int getStdId() {

        return std_id;

    }

}
