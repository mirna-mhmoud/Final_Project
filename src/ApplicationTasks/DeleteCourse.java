/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import ApplicationEntity.Course;
import Database.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class DeleteCourse{

    private Connection connect;
    private Statement aStatement;

    public void delete(Course c, int sid) {

        try {
            connect = Connection.getConnection();
            connect.connect();
            aStatement = connect.getStatement();

            String query = "delete from std_table where c_id='" + c.getC_id() + "' and std_id='" + sid + "'";
            aStatement.execute(query);
            JOptionPane.showMessageDialog(null,"Course with id = "+c.getC_id()+" is deleted !");
        } catch (SQLException ex) {
            Logger.getLogger(DeleteCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
