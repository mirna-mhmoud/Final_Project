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
public class NullStd extends Profile{

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public Student getStd() {
        return null;
    }
    
}
