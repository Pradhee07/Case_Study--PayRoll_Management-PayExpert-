package com.hexaware.controller;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.model.Employee;
import com.hexaware.dao.*;
import com.hexaware.exception.DatabaseConnectionException;

/**
 * Controller class for employee-related operations.
 */

public class EmpController {
	IEmployeeService eservice = new EmployeeService();
	
	 /**
     * Retrieves all employees from the database.
     * 
     * @return A list of all employees.
     * @throws SQLException               If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */

	public List<Employee> getAllEmployee() throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		return eservice.getAllEmployee();
		
	}
	
	 /**
     * Retrieves an employee by their ID from the given list.
     * 
     * @param list The list of employees to search in.
     * @param eid  The ID of the employee to retrieve.
     */

	public void getEmployeeById(List<Employee> list, int eid) {
		// TODO Auto-generated method stub
	    for(Employee e:list) {
	    	if(e.getEmployeeId()==eid) {
	    	   System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s","Employee Id","First Name","Last Name","Date Of Birth","Gender","Phone No","Address","position","Join Date","Termination Date" ));
		       System.out.println(String.format("%-20d%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s",e.getEmployeeId(),e.getFirstName(),e.getLastName(),e.getDateofbirth(),e.getGender(),e.getPhoneNumber(),e.getAddress(),e.getPosition(),e.getJoinDate(),e.getTermDate()));

	    	   System.out.println();
	    	   break;
	    	}
	    }
	}
	
	 /**
     * Adds a new employee to the database.
     * 
     * @param id      The ID of the new employee.
     * @param fname   The first name of the new employee.
     * @param lname   The last name of the new employee.
     * @param dob     The date of birth of the new employee.
     * @param gender  The gender of the new employee.
     * @param no      The phone number of the new employee.
     * @param address The address of the new employee.
     * @param pos     The position of the new employee.
     * @param jdate   The join date of the new employee.
     * @param tdate   The termination date of the new employee.
     * @throws SQLException               If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */

	public void addEmployee(int id, String fname, String lname, String dob, String gender, String no, String address,
			String pos, String jdate, String tdate) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		eservice.addEmployee(id,fname,lname,dob,gender,no,address,pos,jdate,tdate);
		
	}

	  /**
     * Updates an employee's information in the database.
     * 
     * @param eid      The ID of the employee to update.
     * @param str      The attribute to update.
     * @param newValue The new value for the attribute.
     * @throws SQLException               If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */
	
	public void updateEmployee(int eid, String str, String newValue) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		eservice.updateEmployee(eid,str,newValue);
	}

	/**
     * Deletes an employee from the database by their ID.
     * 
     * @param n The ID of the employee to delete.
     * @throws SQLException               If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */
	
	public void deleteEmployeeById(int n) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		eservice.deleteEmployeeById(n);
	}

	// test case - method 
	
	/**
     * Retrieves an employee by their ID from the given list.
     * 
     * @param list The list of employees to search in.
     * @param eid  The ID of the employee to retrieve.
     * @return The employee object if found, null otherwise.
     */
	
	public Employee getEmployee(List<Employee> list, int eid) {
		// TODO Auto-generated method stub
	    for(Employee e:list) {
	    	if(e.getEmployeeId()==eid) {
	    	   return e;
	    	}
	    }
		return null;
	}

	
}
