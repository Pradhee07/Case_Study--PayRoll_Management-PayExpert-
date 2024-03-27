package com.hexaware.exception;

/**
 * Exception class for handling financial record-related errors.
 * thrown when a financial record with a specified identifier is not found.
 */


public class FinancialRecordException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	String s=" ";

	public FinancialRecordException() {
		System.out.println("Record Id not found :(");
	}
	
	public FinancialRecordException(String s) {
		System.out.println("Record not found for this Employee Id :(");
	}

}
