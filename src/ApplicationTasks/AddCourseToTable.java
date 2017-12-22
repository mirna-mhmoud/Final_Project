/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import ApplicationEntity.Course;
import Database.Connection;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class AddCourseToTable {

    private Connection connect;
    private Statement aStatement;
    private ResultSet set;

    public void addCourse(int id, Course c) throws SQLException {

        connect = Connection.getConnection();
        connect.connect();
        aStatement = connect.getStatement();

        String sql1 = "select startAt,endAt from lecture_data where c_id='" + c.getC_id() + "'";
        set = aStatement.executeQuery(sql1);

        if (set.next()) {
           if(!isConfilcet(id,c.getC_id())){
            
            String sql = "insert into std_table(std_id,c_id,c_name,lecturer,startAt,endAt,class,courseType) values('"
                    + id + "','" + c.getC_id() + "','" + c.getC_name() + "','" + c.getLecturer()
                    + "','" + set.getTime("startAt") + "','" + set.getTime("endAt")
                    + "','" + c.getRoom() + "','" + c.getType() + "')";
            try {
                aStatement.execute(sql);
                JOptionPane.showMessageDialog(null, c.getC_name() + " is added ! ");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Choose course to add ! ");

            }
            String sql2 = "update course set state=1 where c_id='" + c.getC_id() + "'";
            aStatement.executeUpdate(sql2);
        }
        }
        
    }

    public boolean isConfilcet(int id , String cid) throws SQLException {
        connect = Connection.getConnection();
        connect.connect();
        aStatement = connect.getStatement();
        ResultSet set = aStatement.executeQuery("select c_id,startAt,endAt from std_table where std_id='" + id + "'");
        if(set.next())
        {
            int x = JOptionPane.showConfirmDialog(null, "The course with id : "+cid+
                    " is confilted with course:"+set.getString("c_id")+" Are you want to register it ? ");
            if(x == JOptionPane.OK_OPTION)
                return false;
            return true;
        }
        return false;

    }

}
