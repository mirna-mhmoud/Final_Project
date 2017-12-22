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
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class SpecialityReq extends Course implements CourseType {

    private Connection connect;
    private Statement aStatement;
    private ResultSet set;
    private String type;

    public SpecialityReq() {
    }


    public SpecialityReq(String c_id, String c_name, String lecturer, Time start, Time end, String room, String type) {
        super(c_id, c_name, lecturer, start, end, room);

    }

    public List<Course> getCourses() {
        Course course = null;
        List<Course> courses = new ArrayList<Course>();
        DBUsers user = new DBUsers();
        int sid = user.getStdId();
        try {
            connect = Connection.getConnection();
            connect.connect();
            aStatement = connect.getStatement();
            // to show just un-registered courses ..
            String q1 = "update course c set c.state=1 where c.c_id in"
                    + " (select t.c_id from std_table t where t.std_id =" + sid + ")";
            aStatement.executeUpdate(q1);
            String q2 = "update course c set c.state=0 where c.c_id not in"
                    + " (select t.c_id from std_table t where t.std_id =" + sid + ")";
            aStatement.executeUpdate(q2);
           
            String query = "select * from course c,lecture_data d,lecturer l where c.c_id=d.c_id "
                    + "and d.lecturer_id=l.lect_id and c.courseType='sp' and c.sem=20151 and c.state=0";
            set = aStatement.executeQuery(query);
            while (set.next()) {
                course = new Course(set.getString("c_id"), set.getString("c_name"),
                        set.getString("lect_fn") + " " + set.getString("lect_ln"),
                        set.getTime("startAt"), set.getTime("endAt"), set.getString("class"), "SP");
                courses.add(course);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddCourseToTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!courses.isEmpty()) {
            return courses;
        }
        return null;
    }

}
