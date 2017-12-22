/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class UIFacade {

    private AddCourseScreen addCourseScreen;
    private CourseSearchScreen courseSearchScreen;
    private DeleteCourseScreen deleteScreen;
    private Login login;
    private MarkSearchScreen markScreen;
    private OptionScreen optionScreen;
    private RegisterScreen regScreen;
    private ShowProfileScreen profile;
    private ShowTableScreen table;
    private static UIFacade facade;

    public static UIFacade getUIFacade() {
        if (facade == null) {
            facade = new UIFacade();
        }
        return facade;
    }

    public void getAddCourseScreen() {
         new AddCourseScreen();
    }

    public void getCourseSearchScreen() {
         new CourseSearchScreen();
    }

    public void getDeleteCourseScreen() throws SQLException {
         new DeleteCourseScreen();
    }

    public void getLogin() {
         new Login();
    }

    public void getMarkSearchScreen() {
         new MarkSearchScreen();
    }

    public void getOptionScreen() {
         new OptionScreen();
    }
    
       public void getRegisterScreen() {
         new RegisterScreen();
    }

    public void getShowProfileScreen() {
         new ShowProfileScreen();
    }

    public void getShowTableScreen() throws SQLException {
         new ShowTableScreen();
    }
    
    

}
