/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;


import ApplicationEntity.Course;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class CourseFactory {
    private static List<Class> types = new ArrayList<Class>();
    public static CourseType createType(String path)
    {
       
        try {
            CourseType type =null;
            Class c ;
            c = Class.forName(path);
            type = (CourseType)c.getConstructor().newInstance();
   
            return type;
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CourseFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(CourseFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CourseFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourseFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CourseFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CourseFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CourseFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void addType(Class c)
    {
        types.add(c);
    }
    public static List<Class> getTypes()
    {
        return types;
    }
     
}
