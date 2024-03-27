package com.hexaware.model;

import java.time.LocalDate;


/**
 * Represents an employee in the company.
 * 
 * @version 1.0
 * @author Pradheesha
 */

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private LocalDate dateofbirth;
	private String gender;
	private String phoneNumber;
	private String address;
	private String position;
	private LocalDate joinDate;
	private LocalDate termDate;
	
	/**
	 * composition Relation  Employee has a financial record
	 * Financial record of the employee
	 */
	
	private FinancialRecord record;  
	
	/**
	 * Composition Relation  Employee has a payroll generated for them
	 * Payroll information of the employee
	 */
	
	private PayRoll payroll;   
	
	/**
	 * Composition Relation Employee has a Tax Amount
	 * Tax information of the employee
	 */
	
	private Tax tax;   
	
	/**
     * Default constructor.
     */
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	 /**
     * Parameterized constructor to create an Employee object with specified attributes.
     *
     * @param employeeId Unique identifier for the employee
     * @param firstName  First name of the employee
     * @param lastName   Last name of the employee
     * @param dateOfBirth Date of birth of the employee
     * @param gender     Gender of the employee
     * @param phoneNumber Phone number of the employee
     * @param address    Address of the employee
     * @param position   Position/title of the employee
     * @param joinDate   Date when the employee joined the company
     * @param termDate   Date when the employee's term ends (if applicable)
     */
	
	public Employee(int id, String firstName, String lastName, LocalDate dateofbirth, String gender, String phoneNumber,
			String address, String position, LocalDate joinDate, LocalDate termDate) {
		super();
		this.employeeId=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.position = position;
		this.joinDate = joinDate;
		this.termDate = termDate;
	}

	// Getters and setters for the class attributes

	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public LocalDate getTermDate() {
		return termDate;
	}

	public void setTermDate(LocalDate termDate) {
		this.termDate = termDate;
	}

	
	public PayRoll getPayroll() {
		return payroll;
	}

	public void setPayroll(PayRoll payroll) {
		this.payroll = payroll;
	}

	public FinancialRecord getRecord() {
		return record;
	}

	public void setRecord(FinancialRecord record) {
		this.record = record;
	}

	public Tax getTax() {
		return tax;
	}

	public void setTax(Tax tax) {
		this.tax = tax;
	}

	// Repeat similar documentation for other getters and setters

    // Override toString() method to provide a string representation of the object

    /**
     * Returns a string representation of the Employee object.
     *
     * @return A string containing the employee's details.
     */
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateofbirth=" + dateofbirth + ", gender=" + gender + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", position=" + position + ", joinDate=" + joinDate + ", termDate=" + termDate + ", record="
				+ record + ", payroll=" + payroll + ", tax=" + tax + "]";
	}

	

	
	
	
	
	
	
}
