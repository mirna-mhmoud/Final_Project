/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ApplicationEntity.Student;
import ApplicationEntity.User;
import ApplicationTasks.AddStudent;
import ApplicationTasks.DBUsers;
import ApplicationTasks.StdMethodsTemplate;
import ApplicationTasks.StudentController;
import ApplicationTasks.StudentModel;
import ApplicationTasks.TasksFacade;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class RegisterScreen extends JPanel implements Observer {

    private JLabel fn;
    private JTextField fnText;
    private JLabel ln;
    private JTextField lnText;
    private JLabel age;
    private JTextField ageText;
    private JLabel major;
    private JComboBox majors;
    private JLabel gpa;
    private JTextField gpaText;
    private JButton addStudent;
    private JButton cancel;
    private JPanel panel1;
    private Random random;
    private double id;
    private double password;
    private RegisterScreen screen;
    private StudentModel model; 
    private TasksFacade tasks;
    

    public StudentModel getModel() {
        return model;
    }

    public void setModel(StudentModel model) {
        this.model = model;
    }

    public RegisterScreen() {
        
        this.setSize(600, 260);
        this.setLayout(new GridLayout(6, 1, 5, 5));
        this.setVisible(true);
        tasks = TasksFacade.getTasksFacade();

        fn = new JLabel("First Name : ");
        this.add(fn);
        fnText = new JTextField(15);
        this.add(fnText);
        ln = new JLabel("Last Name : ");
        this.add(ln);
        lnText = new JTextField(15);
        this.add(lnText);
        age = new JLabel("Age : ");
        this.add(age);
        ageText = new JTextField(15);
        this.add(ageText);
        major = new JLabel("Major");
        this.add(major);
        majors = new JComboBox();
        this.add(majors);
        gpa = new JLabel("GPA");
        this.add(gpa);
        gpaText = new JTextField(13);
        this.add(gpaText);
        majors.addItem("SD");
        majors.addItem("CS");
        addStudent = new JButton("Add New Student");
        this.add(addStudent);
        cancel = new JButton("Cancel");
        this.add(cancel);
        final RegisterScreen reg = this;
        random = new Random();
        id = Math.round(Math.random() * 100000000);
        password = Math.round(Math.random() * 10000);
        screen = this;
        model = new StudentModel();
       
        addStudent.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (fnText.getText().equals("") || lnText.getText().equals("") || age.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Complete All Information ..");
                } else {
                 
                    boolean notExist = false;
                    while (tasks.isExist((int) id, (int) password)) {
                        id = Math.round(Math.random() * 100000000);
                        password = Math.round(Math.random() * 10000);
                        notExist = true;
                    }
                    if (!notExist) {
                        
                        Student std = new Student((int) id, fnText.getText(), lnText.getText(),
                                (String) majors.getSelectedItem(), Integer.parseInt(ageText.getText()),
                                Double.parseDouble(gpaText.getText()));
                        tasks.addStudent(std);
                        User us = new User((int) id, (int) password);
                        tasks.addUser(us);
                        tasks.setStdId(us.getId());
                        
                        
                        std.setId((int) id);
                        std.setPassword((int) password);
                        
                        model.setStudent(std);
                        fnText.setText("");
                        lnText.setText("");
                        ageText.setText("");
                        gpaText.setText("");
                        majors.setSelectedItem("");
                    }
                }

            }
        });

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                reg.setVisible(false);

            }
        });

    }
    @Override
    public void update(Observable o, Object o1) {
        Student std = ((StudentModel) o).getStudent();
        fnText.setText(std.getFirst_name());
        lnText.setText(std.getLast_name());
        ageText.setText("" + std.getAge());
        gpaText.setText("" + std.getGpa());
        majors.setSelectedItem(std.getMajor());
    }
   public static void main(String[] args) {
        new RegisterScreen();
    } 

}
