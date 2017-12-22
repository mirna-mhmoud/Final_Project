/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationEntity;

/**
 *
 * @author hp
 */
public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private String major;
    private int age;
    private double gpa;
    private int password;

    public Student(int id, String first_name, String last_name, String major, int age, double gpa) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.major = major;
        this.age = age;
        this.gpa =gpa;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Student() {
    }
    

    public double getGpa() {
        return gpa;
    }

    public Student(int id, String first_name, String last_name, String major, int age) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.major = major;
        this.age = age;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student ID =" + id + "  ,  Name :" + first_name + " " + last_name + "  ,  Major=" + major ;
    }
    
    
    
}
