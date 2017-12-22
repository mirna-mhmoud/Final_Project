/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import ApplicationTasks.DBUsers;
import ApplicationTasks.TasksFacade;
import UI.OptionScreen;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class Login extends JFrame {

    private JLabel ID;
    private JTextField IDText;
    private JLabel password;
    private JPasswordField passText;
    private JButton submit;
    private JButton cancel;
    private Login login;
    private TasksFacade tasks;

    public Login() {
        this.setTitle("Login");
        this.setSize(440, 240);
        this.setLayout(new GridLayout(3, 2, 2, 2));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        tasks = TasksFacade.getTasksFacade();
        ID = new JLabel("ID : ");
        this.add(ID);
        IDText = new JTextField(15);
        this.add(IDText);

        password = new JLabel("Password : ");
        this.add(password);
        passText = new JPasswordField(15);
        this.add(passText);

        submit = new JButton("Submit");
        this.add(submit);
        cancel = new JButton("Cancel");
        this.add(cancel);
        login = this;
        

        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                tasks.setUser(Integer.parseInt(IDText.getText()), Integer.parseInt(passText.getText()));
                if (tasks.getStdId() == -1) {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password !");

                } else {
                    new OptionScreen();
                    login.setVisible(false);
                }
                }catch(NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Enter your id and password as a number ! ");
                }

            }
        });

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                login.setVisible(false);
            }
        });

    }
    public static void main(String[] args) {
        new Login();
    }



}
