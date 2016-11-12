package com.leons.controls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector 
{
	public static Connection dbconn() throws ClassNotFoundException, SQLException
    {
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");
	//creating connection with the database 
          Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/businessPartner","root","Brighter92");
          return  con;
        }
}
