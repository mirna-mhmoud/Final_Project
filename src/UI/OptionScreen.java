/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class OptionScreen extends JFrame {

    private JButton addCourse;
    private JButton deleteCourse;
    private JButton table;
    private JButton courseSearch;
    private JButton markSearch;
    private JButton profile;
    private JButton exit;
    private OptionScreen screen;
    private UIFacade fac;

    public OptionScreen() {
        this.setTitle("Option Screen");
        this.setSize(300, 290);
        this.setLayout(new GridLayout(4,2,2,2));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        addCourse = new JButton("Add Course");
        this.add(addCourse);
        screen = this;
        fac = UIFacade.getUIFacade();
        addCourse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                screen.setVisible(false);
                fac.getAddCourseScreen();
            }
        });

        deleteCourse = new JButton("Delete Course");
        this.add(deleteCourse);

        deleteCourse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    screen.setVisible(false);
                    fac.getDeleteCourseScreen();
                } catch (SQLException ex) {
                    Logger.getLogger(OptionScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        table = new JButton("Student Table");
        this.add(table);
        table.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    screen.setVisible(false);
                    fac.getShowTableScreen();
                } catch (SQLException ex) {
                    Logger.getLogger(OptionScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        courseSearch = new JButton("Search of course");
        this.add(courseSearch);
        courseSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                screen.setVisible(false);
                fac.getCourseSearchScreen();
            }
        });

        markSearch = new JButton("Search of Mark");
        this.add(markSearch);
        markSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                screen.setVisible(false);
                fac.getMarkSearchScreen();
            }
        });
        
        profile = new JButton("Show Profile");
        this.add(profile);
        profile.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                screen.setVisible(false);
                fac.getShowProfileScreen();
            }
        });
        exit = new JButton("Exit");
        this.add(exit);
        exit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

    }
  public static void main(String[] args) {
        new OptionScreen();
    }
}
