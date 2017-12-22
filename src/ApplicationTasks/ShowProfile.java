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
public class ShowProfile extends Profile {


    public ShowProfile(Student std)
    {
        this.std = std;
    }

    @Override
    public boolean isNull() {

        return false;
    }

    @Override
    public Student getStd() {
        return std;
        
       
    }

}
