package com.leons.checks;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.leons.controls.DBConnector;

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
            System.out.println(student);
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            System.out.println("came here sql query failed");
        } 
        return student;
        
    }
    

}
