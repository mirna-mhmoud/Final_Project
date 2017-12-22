/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ApplicationEntity.Student;
import ApplicationTasks.StudentModel;
import UI.OptionScreen;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class StudentView extends JPanel implements Observer {

    private StudentModel studentModel;

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    private JLabel id;
    private JLabel id1;
    private JLabel pass;
    private JLabel pass1;
    private JLabel fname;
    private JLabel fname1;
    private JLabel lname;
    private JLabel lname1;
    private JLabel gpa;
    private JLabel gpa1;
    private JLabel age;
    private JLabel age1;
    private JLabel major;
    private JLabel major1;
    

    public StudentView() {
        setSize(300, 300);
        setVisible(true);
        this.setLayout(new GridLayout(8, 2, 9, 9));

        id = new JLabel("ID:");
        this.add(id);
        id1 = new JLabel();
        this.add(id1);

        pass = new JLabel("Password:");
        this.add(pass);
        pass1 = new JLabel();
        this.add(pass1);

        fname = new JLabel("First Name:");
        this.add(fname);
        fname1 = new JLabel();
        this.add(fname1);

        lname = new JLabel("Last Name");
        this.add(lname);
        lname1 = new JLabel();
        this.add(lname1);

        gpa = new JLabel("GPA");
        this.add(gpa);
        gpa1 = new JLabel();
        this.add(gpa1);

        age = new JLabel("Age:");
        this.add(age);

        age1 = new JLabel();
        this.add(age1);

        major = new JLabel("Major");
        this.add(major);
        major1 = new JLabel();
        this.add(major1);
        

    }

    @Override
    public void update(Observable o, Object o1) {
        Student std = ((StudentModel) o).getStudent();
        id1.setText(""+std.getId());
        pass1.setText(""+std.getPassword());
        fname1.setText(std.getFirst_name());
        lname1.setText(std.getLast_name());
        age1.setText("" + std.getAge());
        gpa1.setText("" + std.getGpa());
        major1.setText(std.getMajor());
    }

}
