/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help.desk.controls;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Chathuranga
 */
public class Validations 
{
    public static boolean checkUser(String username, String password) 
    {
        boolean student = false;
        try 
        {
            PreparedStatement ps = DBConnector.dbconn().prepareStatement("select * from login where username=? and password=?");

            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            student = rs.next();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        } 
        return student;
    }
    
}
