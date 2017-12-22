/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ApplicationTasks.DBUsers;
import ApplicationTasks.SearchMark;
import ApplicationTasks.SearchMarkByID;
import ApplicationTasks.SearchMarkByName;
import ApplicationTasks.TasksFacade;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class MarkSearchScreen extends JFrame {

    private JLabel name;
    private JTextField value;
    private JLabel choose;
    private JComboBox cri;
    private JLabel mark;
    private JTextField markText;
    private JButton showMark;
    private JButton cancel;
    private JPanel pan;
    private MarkSearchScreen screen;
    private JButton toOptions;
    private TasksFacade tasks;

    public MarkSearchScreen() {
        this.setTitle("Show Mark");
        this.setSize(650, 250);
        this.setLayout(new GridLayout(4, 4));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        tasks = TasksFacade.getTasksFacade();
        
        name = new JLabel("Please enter the id or the name of course:");
        this.add(name);
        value = new JTextField(20);
        this.add(value);
        choose = new JLabel("Choose the critiria : ");
        this.add(choose);
        cri = new JComboBox();
        cri.addItem("Search Criteria");
        this.add(cri);
        mark = new JLabel("Mark is:");
        this.add(mark);
        markText = new JTextField(10);
        markText.setEditable(false);
        this.add(markText);

      
        final int sid = tasks.getStdId();

        tasks.addMarkType(SearchMarkByID.class);
        tasks.addMarkType(SearchMarkByName.class);

        for (Class c : tasks.getMarkTypes()) {
            cri.addItem(c.getName());

        }

        pan = new JPanel();
        showMark = new JButton("Show Mark");
        pan.add(showMark);

        showMark.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    SearchMark ms = tasks.createMarkType((String) cri.getSelectedItem());
                    ResultSet set = tasks.searchMark(value.getText(), sid);
                    if (set.next()) {
                        markText.setText("" + set.getInt("mark"));
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(MarkSearchScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch(NullPointerException ex)
                {
                    JOptionPane.showMessageDialog(null,"Enter id or name !");
                }

            }
        });
        screen = this;
        toOptions = new JButton("Options Screen");
        pan.add(toOptions);
        toOptions.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                screen.setVisible(false);
                new OptionScreen();
            }
        });

        cancel = new JButton("Cancel");
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
        new MarkSearchScreen();
    }
}
