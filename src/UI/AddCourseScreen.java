/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ApplicationEntity.Course;
import ApplicationEntity.Course;
import ApplicationTasks.AddCourseToTable;
import ApplicationTasks.CourseFactory;
import ApplicationTasks.CourseType;
import ApplicationTasks.DBUsers;
import ApplicationTasks.FacultyReq;
import ApplicationTasks.SpecialityReq;
import ApplicationTasks.TasksFacade;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class AddCourseScreen extends JFrame {

    private JLabel addCourse;
    private List<JCheckBox> boxes;
    private JCheckBox course;
    private JButton add;
    private JButton cancel;
    private AddCourseScreen screen;
    private JPanel panelF;
    private JPanel panelS;
    private List<Course> coursesFa;
    private List<Course> courseSp;
    private JPanel pan;
    private JButton toOptions;
    private TasksFacade tasks;

    public AddCourseScreen() {
        this.setTitle("Add Course");
        this.setSize(600, 350);
        this.setLayout(new GridLayout(0, 1, 1, 1));
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        tasks = TasksFacade.getTasksFacade();//siglton with facad
        addCourse = new JLabel("Choose the courses : ");
        this.add(addCourse);

        panelF = new JPanel();
        panelF.setSize(100, 120);
        panelF.setLayout(new GridLayout(0, 1));

        panelS = new JPanel();
        panelS.setSize(100, 120);
        panelS.setLayout(new GridLayout(0, 1));

        tasks.addCourseType(FacultyReq.class);
        tasks.addCourseType(SpecialityReq.class);
        List<CourseType> types = new ArrayList<CourseType>();
        for (Class c : tasks.getCourseTypes()) {
            types.add(tasks.createCourseType(c.getName()));
        }
        coursesFa = new ArrayList<Course>();
        courseSp = new ArrayList<Course>();

        coursesFa = types.get(0).getCourses();

        courseSp = types.get(1).getCourses();

        panelF.setBorder(BorderFactory.createTitledBorder("Faculty Requirements"));
        this.add(panelF);
        boxes = new ArrayList<JCheckBox>();
        if (coursesFa != null) {
            for (Course c : coursesFa) {
                course = new JCheckBox(c.toString());
                boxes.add(course);
                panelF.add(course);
            }
        } else {
            panelF.add(new JLabel("No Faculty Requirements available !"));
        }

        
        panelS.setBorder(BorderFactory.createTitledBorder("Speciality Requirements"));
        this.add(panelS);
        if (courseSp != null) {
            for (Course c : courseSp) {
                course = new JCheckBox(c.toString());
                boxes.add(course);
                panelS.add(course);
            }
        } else {
            panelS.add(new JLabel("No Speciality Requirements available !"));
        }

     
        pan = new JPanel(new FlowLayout());
        add = new JButton("Add");
        pan.add(add);

       
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                int id = tasks.getStdId();
                String[] courseData = null;
                Course co = null;
                try{
                for (JCheckBox box : boxes) {
                    if (box.isSelected()) {
                        courseData = box.getText().split(" : ");
                        co = new Course(courseData[0], courseData[1], courseData[2], courseData[5], courseData[6]);
                        tasks.addCourse(id, co);
                        box.setVisible(false);
                        
                    }
                }
                }catch(Exception  ex)
                {
                    JOptionPane.showMessageDialog(null, "Choose course to add ! ");
                }

            }
        });

         screen = this;
        toOptions = new JButton(" Options Screen ");
        pan.add(toOptions);
        toOptions.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new OptionScreen();
                screen.setVisible(false);
            }
        });

        cancel = new JButton("Exit");
        pan.add(cancel);

       
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        this.add(pan);

    }
 public static void main(String[] args) {
        new AddCourseScreen();
    }
}
