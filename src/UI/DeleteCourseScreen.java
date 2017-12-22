/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ApplicationEntity.Course;
import ApplicationTasks.DBUsers;
import ApplicationTasks.DeleteCourse;
import ApplicationTasks.ShowTable;
import ApplicationTasks.Showable;
import ApplicationTasks.TasksFacade;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class DeleteCourseScreen extends JFrame {

    private JLabel delete;
    private List<JCheckBox> courses;
    private JCheckBox course;
    private JButton delBtn;
    private JButton cancel;
    private JPanel panel;
    private JPanel pan;
    private DeleteCourseScreen screen;
    private Course toDel;
    private JButton toOptions;
    private TasksFacade tasks;

    public DeleteCourseScreen() throws SQLException {
        this.setTitle("Delete Course");
        this.setSize(600, 550);
        this.setLayout(new GridLayout(0, 1, 1, 1));
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        tasks = TasksFacade.getTasksFacade();
        delete = new JLabel("Choose course to delete : ");
        this.add(delete);

        
        final int sid = tasks.getStdId();

        panel = new JPanel();
      
        ResultSet set = tasks.getRegCourses(sid);
        courses = new ArrayList<JCheckBox>();

        while (set.next()) {

            course = new JCheckBox(set.getString("c_id") + " : " + set.getString("c_name") + " : " + set.getString("lecturer")
                    + " : " + set.getString("class") + " : " + set.getString("startAt") + " : " + set.getString("endAt"));
            courses.add(course);
            panel.add(course);

        }
        panel.setBorder(BorderFactory.createTitledBorder("Registered Courses"));
        this.add(panel);

        pan = new JPanel(new FlowLayout());
        delBtn = new JButton("Delete");
        pan.add(delBtn);

        delBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                String[] courseId = null;
                for (JCheckBox box : courses) {
                    if (box.isSelected()) {
                        courseId = box.getText().split(" : ");
                        toDel = new Course(courseId[0]);
                        tasks.delete(toDel, sid);
                        box.setVisible(false);
                    }
                }

            }
        });

        toOptions = new JButton(" Options Screen ");
        pan.add(toOptions);
        toOptions.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                screen.setVisible(false);
                new OptionScreen();
            }
        });
        cancel = new JButton("Exit");
        pan.add(cancel);
        screen = this;
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        this.add(pan);

    }

   public static void main(String[] args) throws SQLException {
        new DeleteCourseScreen();
    }

}
