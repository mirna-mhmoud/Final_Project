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
public class ProfileFactory {

    private static Connection connect;
    private static Statement aStatement;

    public static Profile getProfile(int sid) {
        Student st = null;
        try {
            connect = Connection.getConnection();
            connect.connect();

            aStatement = connect.getStatement();

            String sql = "select * from student where std_id=" + sid + "";
            ResultSet rs = aStatement.executeQuery(sql);
            if (rs.next()) {
                st = new Student(Integer.parseInt(rs.getString("std_id")), rs.getString("std_fn"),
                        rs.getString("std_ln"), rs.getString("major"), Integer.parseInt(rs.getString("age")));
            }

            if (st == null) {
                return new NullStd();
            } else {
                return new ShowProfile(st);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfileFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
