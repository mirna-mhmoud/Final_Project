/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public abstract class CourseSearch {
    private static List<Class> types = new ArrayList<Class>();
    
    public static CourseSearch createType(String typePath)
    {
        CourseSearch se = null;
        Class c;
        
        try {
            c = Class.forName(typePath);
            se = (CourseSearch) c.getConstructor().newInstance();
            return se;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Please choose the critria !");
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CourseSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(CourseSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CourseSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourseSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CourseSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CourseSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void addType (Class c)
    {
        types.add(c);
    }
    
    public static List<Class> getTypes()
    {
        return types;
    }
    
    public abstract ResultSet search(String value);
}
