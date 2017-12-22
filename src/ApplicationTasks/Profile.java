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
public abstract class Profile {
    protected Student std ;

    public abstract boolean isNull();
    public abstract Student getStd();
}
