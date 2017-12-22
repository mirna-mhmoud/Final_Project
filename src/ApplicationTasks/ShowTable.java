/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import ApplicationEntity.Student;
import Database.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class ShowTable implements Showable {

    private Connection connect;
    private Statement aStatement;
    private ResultSet set;

    public Student getStdData(int sid) {
        Student std = null;
        try {
            connect = Connection.getConnection();
            connect.connect();
            aStatement = connect.getStatement();
            String query = "select * from student where std_id=" + sid + "";
            set = aStatement.executeQuery(query);
            if(set.next())
            std = new Student(set.getInt("std_id"), set.getString("std_fn"),
                    set.getString("std_ln"), set.getString("major"), set.getInt("age"), set.getDouble("gpa"));
        } catch (SQLException ex) {
            Logger.getLogger(ShowTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return std;
    }

    public ResultSet getRegCourses(int sid) {
        try {

            connect = Connection.getConnection();
            connect.connect();
            aStatement = connect.getStatement();

            String sql = "select * from std_table where std_id="
                    + sid + "";
            set = aStatement.executeQuery(sql);
            
                return set;
            

        } catch (SQLException ex) {
            Logger.getLogger(DeleteCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
