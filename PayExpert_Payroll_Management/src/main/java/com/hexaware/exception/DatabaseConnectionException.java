package com.hexaware.exception;

/**
 * Exception class for handling database connection errors.
 * thrown when there is a failure in establishing a connection to the database.
 */

public class DatabaseConnectionException extends Exception {

	private static final long serialVersionUID = 1L;

	public DatabaseConnectionException() {
		System.out.println("Database Connectivity failed :(");
	}
	
	

}
