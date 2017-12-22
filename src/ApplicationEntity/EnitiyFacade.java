/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationEntity;

import java.sql.Time;

/**
 *
 * @author hp
 */
public class EnitiyFacade {

    private Course course;
    private Student student;
    private Lecturer lecturer;
    private User user;
    private static EnitiyFacade facade;

    private EnitiyFacade() {
        facade = new EnitiyFacade();
        
        student = new Student();
        course  = new Course();
        lecturer = new Lecturer();
        user = new User();
        
    }

    public EnitiyFacade getEnitiyFacade() {
        if (facade == null) {
            facade = new EnitiyFacade();
        }
        return facade;
    }

    public double getGpa() {
        return student.getGpa();
    }

    public void setGpa(double gpa) {
        this.student.setGpa(gpa);
    }

    public int getId() {
        return student.getId();
    }

    public void setId(int id) {
        this.student.setId(id);
    }

    public String getFirst_name() {
        return this.student.getFirst_name();
    }

    public void setFirst_name(String first_name) {
        this.student.setFirst_name(first_name);
    }

    public String getLast_name() {
        return this.student.getLast_name();
    }

    public void setLast_name(String last_name) {
        this.student.setLast_name(last_name);
    }

    public String getMajor() {
        return this.student.getMajor();
    }

    public void setMajor(String major) {
        this.student.setMajor(major);
    }

    public int getAge() {
        return this.student.getAge();
    }

    public void setAge(int age) {
        this.student.setAge(age);
    }

    /////////////////
    public void setStd_id(String std_id) {
        this.course.setStd_id(std_id);
    }

    public String getC_id() {
        return this.course.getC_id();
    }

    public void setC_id(String c_id) {
        this.course.setC_id(c_id);
    }

    public String getC_name() {
        return this.course.getC_name();
    }

    public void setC_name(String c_name) {
        this.course.setC_name(c_name);
    }

    public String getLecturer() {
        return this.course.getLecturer();
    }

    public void setLecturer(String lecturer) {
        this.course.setLecturer(lecturer);
    }

    public Time getStart() {
        return this.course.getStart();
    }

    public void setStart(Time start) {
        this.setStart(start);
    }

    public Time getEnd() {
        return this.course.getEnd();
    }

    public void setEnd(Time end) {
        this.course.setEnd(end);
    }

    public String getRoom() {
        return this.course.getRoom();
    }

    public void setRoom(String room) {
        this.course.setRoom(room);
    }

    public String getType() {
        return this.course.getType();
    }

    public void setType(String type) {
        this.course.setType(type);
    }

    ////////////////////
    public int getUserId() {
        return user.getId();
    }

    public void setUserId(int id) {
        this.user.setId(id);
    }

    public int getPassword() {
        return this.user.getPassword();
    }

    public void setPassword(int password) {
        this.user.setPassword(password);
    }

    //////////////////////
    public String getLecture_id() {
        return lecturer.getLecture_id();
    }

    public void setLecture_id(String lecture_id) {
        this.lecturer.setLecture_id(lecture_id);
    }

    public String getFn() {
        return lecturer.getFn();
    }

    public void setFn(String fn) {
        this.lecturer.setFn(fn);
    }

    public String getLn() {
        return lecturer.getLn();
    }

    public void setLn(String ln) {
        this.lecturer.setLn(ln);
    }

}

