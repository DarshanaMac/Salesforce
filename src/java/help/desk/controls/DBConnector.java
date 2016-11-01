/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help.desk.controls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Chathuranga
 */
public class DBConnector 
{
    public static Connection  dbconn() throws ClassNotFoundException, SQLException
    {
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");
	//creating connection with the database 
          Connection  con=DriverManager.getConnection
                     ("jdbc:mysql://localhost:3306/helpdesk","root","mastermind");
          return  con;
        }
}
