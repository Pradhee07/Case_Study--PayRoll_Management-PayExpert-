package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hexaware.exception.DatabaseConnectionException;

/**
 * class for managing database connections.
 */

public class DBUtil {
	
	static Connection con;
	
	/**
     * Retrieves a database connection.
     *
     * @return The database connection.
     * @throws DatabaseConnectionException If a database connection cannot be established.
     */
	
	   public static Connection getDBConn() throws DatabaseConnectionException  {
		   try {
		   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proj", "root", "Pradheesha@12");
		   }catch(SQLException e) {
			   e.printStackTrace();
		   }
		return con;
	   }
	   
	   /**
	     * Main method for testing the database connection.
	     *
	     * @param args Command-line arguments (not used).
	     */
	   
	   public static void main(String[] args) {
		   try {
			System.out.println(getDBConn());
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }

}
