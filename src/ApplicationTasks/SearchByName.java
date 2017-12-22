/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

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
public class SearchByName extends CourseSearch {

    private Connection connect;
    private Statement aStatement;
    private ResultSet set;

    @Override
    public ResultSet search(String value) {
        try {
            connect = Connection.getConnection();
            connect.connect();
            aStatement = connect.getStatement();
            String query = "select * from course c ,lecture_data l,lecturer le where c.c_id=l.c_id and l.lecturer_id = le.lect_id and c.c_name='" + value + "'";
            set = aStatement.executeQuery(query);
                return set;

        } catch (SQLException ex) {
            Logger.getLogger(SearchByName.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
