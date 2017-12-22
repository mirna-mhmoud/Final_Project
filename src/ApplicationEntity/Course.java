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
public class Course {
    private String std_id;
    private String c_id;
    private String c_name;
    private String lecturer;
    private Time start;
    private Time end;
    private String room;

    public Course(String c_id, String c_name, String lecturer, Time start, Time end, String room, String type) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.lecturer = lecturer;
        this.start = start;
        this.end = end;
        this.room = room;
        this.type = type;
    }

    public Course(String c_id, String c_name, String lecturer, String room, String type) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.lecturer = lecturer;
        this.room = room;
        this.type = type;
    }
    private String type;

    public Course(String c_id, String c_name, String lecturer, Time start, Time end, String room) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.lecturer = lecturer;
        this.start = start;
        this.end = end;
        this.room = room;
    }

    public Course(String c_id, String c_name, String lecturer, String room) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.lecturer = lecturer;
        this.room = room;
    }

    public Course() {
    }

    public Course(String std_id, String c_id, String c_name, String lecturer, Time start, Time end, String room) {
        this.std_id = std_id;
        this.c_id = c_id;
        this.c_name = c_name;
        this.lecturer = lecturer;
        this.start = start;
        this.end = end;
        this.room = room;
    }

    public String getStd_id() {
        return std_id;
    }

    public void setStd_id(String std_id) {
        this.std_id = std_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public Course(String c_id) {
        this.c_id = c_id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Course(String c_id, String c_name, String lecturer) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.lecturer = lecturer;
    }

    @Override
    public String toString() {
        return  c_id + " : " + c_name + " : " + lecturer + " : " + start + " : " + end + " : " + room+" : "+type+"\n" ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}

