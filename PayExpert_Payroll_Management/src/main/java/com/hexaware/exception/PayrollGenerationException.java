package com.hexaware.exception;

/**
 * Exception class for handling payroll generation errors.
 * thrown when there is an issue during payroll generation.
 */

public class PayrollGenerationException extends Exception{

	private static final long serialVersionUID = 1L;

	public PayrollGenerationException() {
		System.out.println("Issue in PayRoll Generation!!!");
	}
	
	

}
