/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import ApplicationEntity.Student;
import Database.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class AddStudent extends StdMethodsTemplate {

    private Connection connect;
    private Statement aStatement;



    @Override
    public void addStd(Student std) {
        
            try {
                connect = Connection.getConnection();
                connect.connect();

                aStatement = connect.getStatement();
                String query = "insert into Student (std_id,std_fn,std_ln,major,age,gpa) values('" + std.getId()
                        + "','" + std.getFirst_name() + "','" + std.getLast_name() + "','" + std.getMajor() + "','"
                        + std.getAge() + "','" + std.getGpa() + "')";
                aStatement.execute(query);
            } catch (SQLException ex) {
                Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        
    }

    @Override
    public boolean canAdded(Student s) {
        try {
            connect =  Connection.getConnection();
            connect.connect();
            aStatement = connect.getStatement();
            String qu = "select * from student where std_fn='"+s.getFirst_name()+"' and std_ln='"
                    +s.getLast_name()+"' and gpa='"+s.getGpa()+"' and major='"+s.getMajor()+
                    "' and age='"+s.getAge()+"'";
            ResultSet rs = aStatement.executeQuery(qu);
            if(s.getGpa() > 60 && s.getAge()>17 && !s.getFirst_name().equals("") && !s.getLast_name().equals("") && !rs.next())
                return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void showConfirmMessage(Student s) {
        JOptionPane.showMessageDialog(null, "Welcome  "+s.getFirst_name()+" "+s.getLast_name()+"  !");

    }

}
