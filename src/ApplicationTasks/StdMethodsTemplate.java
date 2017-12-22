/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import ApplicationEntity.Student;

/**
 *
 * @author hp
 */
public abstract class StdMethodsTemplate {

    public abstract void addStd(Student s);

    public abstract boolean canAdded(Student s);

    public abstract void showConfirmMessage(Student s);


    public void addStudent(Student s) {
        if (canAdded(s)) {
            addStd(s);
            showConfirmMessage(s);
        }
    }

}
