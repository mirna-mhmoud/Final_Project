/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ApplicationEntity.Course;
import ApplicationTasks.CourseSearch;
import ApplicationTasks.SearchByID;
import ApplicationTasks.SearchByName;
import ApplicationTasks.TasksFacade;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class CourseSearchScreen extends JFrame {

    private JLabel value;
    private JTextField valueText;
    private JComboBox box;
    private JButton search;
    private JLabel result;
    private JTextArea area;
    private JButton toOptions;
    private JButton exit;
    private CourseSearchScreen screen;
    private TasksFacade tasks;

    public CourseSearchScreen() {
        this.setSize(new Dimension(700, 300));
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        value = new JLabel("Enter course id or name:");
        this.add(value);
        tasks = TasksFacade.getTasksFacade();
        valueText = new JTextField(20);

        this.getContentPane().add(valueText);

        box = new JComboBox();
        box.setMaximumRowCount(3);
        this.getContentPane().add(box);

        search = new JButton("Sreach");
        this.getContentPane().add(search);

        result = new JLabel("Results");
        this.getContentPane().add(result);
        area = new JTextArea(10, 59);
        area.setEditable(false);
        this.getContentPane().add(new JScrollPane(area), BorderLayout.SOUTH);

        tasks.addCourseSearchType(SearchByID.class);
        tasks.addCourseSearchType(SearchByName.class);

        box.addItem("Search criteria");
        for (Class c : tasks.getCourseSearchTypes()) {
            box.addItem(c.getName());

        }

        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {

                    CourseSearch cat = tasks.createType((String) box.getSelectedItem());
                    ResultSet rs = tasks.search(valueText.getText());
                    Course record = null;
                    try {
                        while (rs.next()) {
                            record = new Course(rs.getString("c_id"), rs.getString("c_name"),
                                    rs.getString("lect_fn") + " " + rs.getString("lect_ln"), rs.getTime("startAt"),
                                    rs.getTime("endAt"), rs.getString("class"), rs.getString("courseType"));
                            System.out.println("here!");
                            area.setText(area.getText() + record.toString());
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(CourseSearchScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (SecurityException ex) {
                    Logger.getLogger(CourseSearchScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(CourseSearchScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Error criteria or value !");
                }

            }
        });

        screen = this;
        toOptions = new JButton(" Options Screen ");
        this.add(toOptions);
        toOptions.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new OptionScreen();
                screen.setVisible(false);
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
        new CourseSearchScreen();
    }
}
