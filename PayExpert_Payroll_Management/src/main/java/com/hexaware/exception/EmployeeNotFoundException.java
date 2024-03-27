package com.hexaware.exception;

public class EmployeeNotFoundException extends Exception {

	/**
	 * Exception class for handling employee not found errors.
	 * thrown when an employee with a specified identifier is not found.
	 */
	private static final long serialVersionUID = 1L;
	
	String s =" ";
	String str =" ";

	public EmployeeNotFoundException() {
		System.out.println("Emplyee not found!!!");
	}
	
	public EmployeeNotFoundException(String s) {
		System.out.println("Payroll Id not found!!!");
	}
	
	public EmployeeNotFoundException(String s,String str) {
		System.out.println("Tax Id not found!!!");
	}

}
