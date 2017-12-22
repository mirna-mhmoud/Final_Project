/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import ApplicationEntity.Student;
import java.util.Observable;

/**
 *
 * @author hp
 */
public class StudentModel extends Observable{
    
    private Student aStd;
    
    public Student getStudent()
    {
        return aStd;
    }
    public void setStudent(Student aStd)
    {
        this.aStd = aStd;
        setChanged();
        notifyObservers();
    }
    
}
