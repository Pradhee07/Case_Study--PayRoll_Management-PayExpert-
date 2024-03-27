package com.hexaware.exception;

/**
 * Exception class for handling invalid input errors.
 * thrown when the input provided by the user is not valid.
 */


public class InvalidInputException extends Exception{

	private static final long serialVersionUID = 1L;

	public InvalidInputException() {
		System.out.println("Invalid Input :(");
	}
	
	

}
