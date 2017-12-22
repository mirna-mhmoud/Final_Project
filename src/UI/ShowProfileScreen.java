/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ApplicationEntity.Student;
import ApplicationTasks.DBUsers;
import ApplicationTasks.Profile;
import ApplicationTasks.ProfileFactory;
import ApplicationTasks.TasksFacade;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class ShowProfileScreen extends JFrame {

    private JLabel id;
    private JTextField id1;
    private JLabel name;
    private JTextField name1;
    private JLabel major;
    private JTextField major1;
    private JLabel age;
    private JTextField age1;
    private JButton exit;
    private ShowProfileScreen screen;
    private JButton toOptions;
    private TasksFacade tasks;

    public ShowProfileScreen() {
        this.setTitle("Show Profile");
        this.setSize(300, 250);
        this.setLayout(new GridLayout(5, 2, 1, 1));
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        tasks = TasksFacade.getTasksFacade();
        id = new JLabel("ID");
        this.add(id);

        id1 = new JTextField();
        id1.setEditable(false);
        this.add(id1);

        name = new JLabel("Name");
        this.add(name);
        name1 = new JTextField();
        name1.setEditable(false);
        this.add(name1);

        major = new JLabel("Major");
        this.add(major);
        major1 = new JTextField();
        major1.setEditable(false);
        this.add(major1);

        age = new JLabel("Age");
        this.add(age);
        age1 = new JTextField();
        age1.setEditable(false);
        this.add(age1);

        Profile p = tasks.getProfile(DBUsers.getStdId());
        Student std = null;
        if(!tasks.isNull())
            std = tasks.getStd();
        id1.setText("" + std.getId());
        name1.setText(std.getFirst_name() + " " + std.getLast_name());
        major1.setText(std.getMajor());
        age1.setText("" + std.getAge());
        screen = this;
        toOptions = new JButton(" Options Screen ");
        this.add(toOptions);
        toOptions.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                screen.setVisible(false);
                new OptionScreen();
            }
        });

        exit = new JButton("Exit");
        this.add(exit);
        
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

    }
public static void main(String[] args) {
        new ShowProfileScreen();
    }
}
