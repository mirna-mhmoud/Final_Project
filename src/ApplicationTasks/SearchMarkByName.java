/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationTasks;

import Database.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class SearchMarkByName extends SearchMark {

    private Connection connect;
    private Statement aStatement;
    private ResultSet set;

    @Override
    public ResultSet search(String value, int sid) {
        try {
            connect = Connection.getConnection();
            connect.connect();
            aStatement = connect.getStatement();
            String query = "select mark from marks where c_name ='" + value + "' and std_id=" + sid + "";
            set = aStatement.executeQuery(query);
            return set;
        } catch (SQLException ex) {
            Logger.getLogger(SearchMarkByName.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
