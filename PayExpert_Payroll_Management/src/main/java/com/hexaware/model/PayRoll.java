package com.hexaware.model;

import java.time.LocalDate;

/**
 * Represents a payroll associated with an employee.
 * 
 * @version 1.0
 * @author Pradheesha
 */

public class PayRoll {
	
	private int payrollId;
	private int employeeId;
	private LocalDate startDate;
	private LocalDate endDate;
	private double basicSalary;
	private double overTimePay;
	private double deductions;
	private double netSalary;
	private double grossSalary;;
	
	/**
     * Constructs a PayRoll object with the specified attributes.
     *
     * @param employeeId   Identifier of the associated employee
     * @param basicSalary  Basic salary of the employee
     * @param overTimePay  Overtime pay of the employee
     */
	
	public PayRoll(int employeeId, double basicSalary, double overTimePay) {
		super();
		this.employeeId = employeeId;
		this.basicSalary = basicSalary;
		this.overTimePay = overTimePay;
	}
	
	/**
     * Constructs a PayRoll object with the specified attributes.
     *
     * @param employeeId   Identifier of the associated employee
     * @param basicSalary  Basic salary of the employee
     * @param overTimePay  Overtime pay of the employee
     * @param deductions   Deductions from the employee's salary
     */
	

	public PayRoll(int employeeId, double basicSalary, double overTimePay, double deductions) {
		super();
		this.employeeId = employeeId;
		this.basicSalary = basicSalary;
		this.overTimePay = overTimePay;
		this.deductions = deductions;
	}

	/**
     * Default constructor.
     */

	public PayRoll() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
     * Constructs a PayRoll object with the specified attributes.
     *
     * @param payrollId    Unique identifier for the payroll
     * @param employeeId   Identifier of the associated employee
     * @param startDate    Start date of the payroll period
     * @param endDate      End date of the payroll period
     * @param basicSalary  Basic salary of the employee
     * @param overTimePay  Overtime pay of the employee
     * @param deductions   Deductions from the employee's salary
     * @param netSalary    Net salary received by the employee
     */
	
	public PayRoll(int payrollId, int employeeId, LocalDate startDate, LocalDate endDate, double basicSalary,
			double overTimePay, double deductions, double netSalary) {
		super();
		this.payrollId = payrollId;
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.basicSalary = basicSalary;
		this.overTimePay = overTimePay;
		this.deductions = deductions;
		this.netSalary = netSalary;
	}

	// Getters and setters for the class attributes...
	
	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getOverTimePay() {
		return overTimePay;
	}

	public void setOverTimePay(double overTimePay) {
		this.overTimePay = overTimePay;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	
	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	/**
     * Returns a string representation of the PayRoll object.
     *
     * @return A string containing the details of the payroll.
     */

	@Override
	public String toString() {
		return "PayRoll [payrollId=" + payrollId + ", employeeId=" + employeeId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", basicSalary=" + basicSalary + ", overTimePay=" + overTimePay
				+ ", deductions=" + deductions + ", netSalary=" + netSalary + "]";
	}

	
	
	
	

}
