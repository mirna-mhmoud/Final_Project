/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import UI.StudentView;
import UI.OptionScreen;
import UI.RegisterScreen;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class StudentController extends JFrame {

   private StudentModel model;
    private StudentView view1;
    private RegisterScreen view2;
    private JButton btn1;
    private StudentController cont;

    public StudentController() {
        this.setTitle("Add Student");
        this.setSize(400,600);
        this.setLayout(new GridLayout(3, 1, 15, 15));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        view1 = new StudentView();
        view2 = new RegisterScreen();
        model = new StudentModel();
        model.addObserver(view1);
        model.addObserver(view2);

        view1.setStudentModel(model);
        view2.setModel(model);
        this.add(view2);
        this.add(view1);
        JPanel pan = new JPanel(new FlowLayout());
        btn1 = new JButton("To Option Screen --->");
        pan.setSize(50,50);
        pan.add(btn1);
        this.add(pan);
        cont =this;
        
        btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (DBUsers.getStdId() > -1) {
                    cont.setVisible(false);
                    new OptionScreen();
                }
            }
        });
    }
    
    public static void main(String[] args) {
        new StudentController();
    }

   

}
