package com.hexaware.controller;

import java.util.List;
import com.hexaware.dao.*;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.model.Employee;
import com.hexaware.model.PayRoll;

/**
 * Controller class for employee validation operations.
 */

public class SampleController {
	ValidationService vs = new ValidationService();

	/**
     * Validates if an employee exists in the given list by employee ID.
     * 
     * @param list The list of employees to search in.
     * @param eid  The employee ID to validate.
     * @return true if the employee exists, false otherwise.
     * @throws EmployeeNotFoundException If the employee with the given ID is not found.
     */
	
	public boolean EmployeeValidation(List<Employee> list, int eid) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return vs.EmployeeValidation(list,eid);
	}

	/**
     * Validates if an employee exists in the given list by ID.
     * 
     * @param list The list of employees to search in.
     * @param id   The ID to validate.
     * @return true if the employee exists, false otherwise.
     */
	
	public boolean EmployeeValidation1(List<Employee> list, int id) {
		// TODO Auto-generated method stub
		return vs.EmployeeValidation1(list, id);
	}

	
	

}
