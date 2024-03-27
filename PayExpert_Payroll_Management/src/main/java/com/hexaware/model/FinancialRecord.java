package com.hexaware.model;

import java.time.LocalDate;

/**
 * Represents a financial record associated with an employee.
 * 
 * @version 1.0
 * @author Pradheesha
 */

public class FinancialRecord {
	
	private int recordId;
	private int employeeId;
	private LocalDate recordDate;
	private String description;
	private double amount;
	private String recordType;
	
	/**
     * Constructs a FinancialRecord object with the specified attributes.
     *
     * @param recordId    Unique identifier for the financial record
     * @param employeeId  Identifier of the associated employee
     * @param recordDate  Date of the financial record
     * @param description Description of the financial transaction
     * @param amount      Amount involved in the financial transaction
     * @param recordType  Type of the financial record (e.g., income, expense)
     */
	
	public FinancialRecord(int recordId, int employeeId, LocalDate recordDate, String description, double amount,
			String recordType) {
		super();
		this.recordId = recordId;
		this.employeeId = employeeId;
		this.recordDate = recordDate;
		this.description = description;
		this.amount = amount;
		this.recordType = recordType;
	}

	// Getters and setters for the class attributes...
	
	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(LocalDate recordDate) {
		this.recordDate = recordDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}


    /**
     * Returns a string representation of the FinancialRecord object.
     *
     * @return A string containing the details of the financial record.
     */
	
	@Override
	public String toString() {
		return "FinancialRecord [recordId=" + recordId + ", employeeId=" + employeeId + ", recordDate=" + recordDate
				+ ", description=" + description + ", amount=" + amount + ", recordType=" + recordType + "]";
	}
	

}
