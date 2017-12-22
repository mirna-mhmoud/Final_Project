/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import ApplicationEntity.Course;
import ApplicationEntity.Student;
import ApplicationEntity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class TasksFacade {

    private AddCourseToTable addToTable;
    private AddStudent addStd;
    private CourseFactory courseFactory;
    private CourseSearch courseSearch;
    private DBUsers dbuser;
    private DeleteCourse delete;
    private CourseType courseType;
    private Profile profile;
    private ProfileFactory profileFactory;
    private SearchMark searchMark;
    private Showable showable;
    private StdMethodsTemplate temp;
    private static TasksFacade facade;//instance

    private TasksFacade() {//private constructor
        addToTable = new AddCourseToTable();
        addStd = new AddStudent();
        courseFactory = new CourseFactory();
        showable = new ShowTable();
        dbuser = new DBUsers();
        delete = new DeleteCourse();
        profileFactory = new ProfileFactory();
     
    }

    public static TasksFacade getTasksFacade() { //public static method to return the instance
        if (facade == null) {
            facade = new TasksFacade();
        }
        return facade;
    }

    public void addCourse(int id, Course c) {
        try {
            addToTable.addCourse(id, c);
        } catch (SQLException ex) {
            Logger.getLogger(TasksFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addStd(Student std) {
        addStd.addStd(std);
    }

    public boolean canAdded(Student s) {
        return addStd.canAdded(s);
    }

    public void showConfirmMessage(Student s) {
        addStd.showConfirmMessage(s);
    }

    public CourseType createCourseType(String path) {

        courseType = CourseFactory.createType(path);
        return courseType;
    }

    public void addCourseType(Class c) {
        CourseFactory.addType(c);
    }

    public List<Class> getCourseTypes() {
        return CourseFactory.getTypes();
    }

    public List<Course> getCourses() {
        return courseType.getCourses();
    }

    public boolean isExist(int id, int password) {
        return dbuser.isExist(id, password);
    }

    public void addUser(User user) {
        dbuser.addUser(user);
    }

    public void setStdId(int id) {
        dbuser.setStdId(id);
    }

    public void setUser(int id, int password) {
        dbuser.setUser(id, password);
    }

    public int getStdId() {
        return DBUsers.getStdId();
    }

    public CourseSearch createType(String typePath) {
        courseSearch = CourseSearch.createType(typePath);
        return courseSearch;
    }

    public void addCourseSearchType(Class c) {
        CourseSearch.addType(c);
    }

    public List<Class> getCourseSearchTypes() {
        return CourseSearch.getTypes();
    }

    public ResultSet search(String value) {
        return courseSearch.search(value);
    }

    public void delete(Course c, int sid) {
        delete.delete(c, sid);
    }

    public Profile getProfile(int sid) {
        profile = ProfileFactory.getProfile(sid);
        return profile;
    }

    public boolean isNull() {
        return profile.isNull();
    }

    public Student getStd() {
        return profile.getStd();
    }

    public SearchMark createMarkType(String typePath) {
        searchMark = SearchMark.createType(typePath);
        return searchMark;
    }

    public void addMarkType(Class c) {
        SearchMark.addType(c);
    }

    public List<Class> getMarkTypes() {
        return SearchMark.getTypes();
    }

    public ResultSet searchMark(String value, int sid) {
        return searchMark.search(value, sid);
    }

    public Student getStdData(int sid) {
        return showable.getStdData(sid);
    }

    public ResultSet getRegCourses(int sid) {
        return showable.getRegCourses(sid);
    }

    public void addStudent(Student s) {
        if (canAdded(s)) {
            addStd(s);
            showConfirmMessage(s);
        }
    }
    
}
