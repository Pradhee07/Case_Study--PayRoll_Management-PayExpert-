package com.hexaware.model;

import java.sql.ResultSet;

/**
 * Represents tax information associated with an employee for a specific tax year.
 */

public class Tax {
	
	private int taxId;
	private int employeeId;
	private int taxYear;
	private double income;
	private double taxAmount;
	
	 /**
     * Default constructor.
	 * @param rs 
     */
	
	public Tax() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tax(ResultSet rs) {
		super();
		// TODO Auto-generated constructor stub
	}
	 /**
     * Constructs a Tax object with the specified attributes.
     *
     * @param taxId     Unique identifier for the tax record
     * @param employeeId Identifier of the associated employee
     * @param taxYear   Tax year for which the tax information is recorded
     * @param income    Income of the employee for the tax year
     * @param taxAmount Tax amount calculated for the employee for the tax year
     */

	public Tax(int taxId, int employeeId, int taxYear, double income, double taxAmount) {
		super();
		this.taxId = taxId;
		this.employeeId = employeeId;
		this.taxYear = taxYear;
		this.income = income;
		this.taxAmount = taxAmount;
	}

	// Getters and setters for the class attributes...
	
	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	 /**
     * Returns a string representation of the Tax object.
     *
     * @return A string containing the details of the tax record.
     */

	@Override
	public String toString() {
		return "Tax [taxId=" + taxId + ", employeeId=" + employeeId + ", taxYear=" + taxYear + ", income=" + income
				+ ", taxAmount=" + taxAmount + "]";
	}
	
	

}
