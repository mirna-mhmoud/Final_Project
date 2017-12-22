/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ApplicationEntity.Student;
import ApplicationTasks.DBUsers;
import ApplicationTasks.DeleteCourse;
import ApplicationTasks.ShowTable;
import ApplicationTasks.Showable;
import ApplicationTasks.TasksFacade;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class ShowTableScreen extends JFrame {

    private JTable table;
    private JScrollPane scroll;
    private JPanel panel;
    private JButton toOptions;
    private JButton exit;
    private ShowTableScreen screen;
    private TasksFacade tasks;

    public ShowTableScreen() throws SQLException {
        this.setTitle("Student Table");
        this.setSize(670, 500);
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        tasks = TasksFacade.getTasksFacade();

        final int sid = tasks.getStdId();

        panel = new JPanel();
        Student std = tasks.getStdData(sid);
        panel.add(new JLabel(std.toString()));
        this.add(panel, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Course ID");
        model.addColumn("Course Name");
        model.addColumn("Lecturer");
        model.addColumn("From");
        model.addColumn("To");
        model.addColumn("Class");

        ResultSet set = tasks.getRegCourses(sid);
        while (set.next()) {
            model.addRow(new Object[]{set.getString("c_id"),
                set.getString("c_name"),
                set.getString("lecturer"),
                set.getString("startAt"),
                set.getString("endAt"),
                set.getString("class")
            });
        }

        table = new JTable(model);
        table.setPreferredSize(new Dimension(730, 650));
        table.setPreferredScrollableViewportSize(new Dimension(620, 120));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        table.setRowSelectionAllowed(true);
        scroll = new JScrollPane(table);
        this.getContentPane().add(scroll);

        toOptions = new JButton(" Options Screen ");
        this.add(toOptions);
        screen =this;
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
public static void main(String[] args) throws SQLException {
        new ShowTableScreen();
    }
}
