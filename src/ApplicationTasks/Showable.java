/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import ApplicationEntity.Student;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public interface Showable {

    public Student getStdData(int sid);

    public ResultSet getRegCourses(int sid);
}
