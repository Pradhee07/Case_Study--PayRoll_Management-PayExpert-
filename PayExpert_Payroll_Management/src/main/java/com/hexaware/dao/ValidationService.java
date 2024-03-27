package com.hexaware.dao;

import java.util.List;
import com.hexaware.exception.*;

import com.hexaware.model.Employee;
import com.hexaware.model.PayRoll;

/**
 * Service class for validating employee-related operations.
 */

public class ValidationService {

	 /**
     * Validates the existence of an employee in the given list based on the employee ID.
     * 
     * @param list The list of employees to search in.
     * @param eid  The ID of the employee to validate.
     * @return true if the employee exists in the list, false otherwise.
     * @throws EmployeeNotFoundException If the employee with the given ID is not found.
     */
	
	public boolean EmployeeValidation(List<Employee> list, int eid) throws EmployeeNotFoundException  {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(Employee e : list) {
			if(e.getEmployeeId()==eid) {
				flag = true;
			}
		}
		if(flag==true)
			return flag;
		else
			throw new EmployeeNotFoundException();
	}

	 /**
     * Validates the existence of an employee in the given list based on the employee ID.
     * 
     * @param list The list of employees to search in.
     * @param id   The ID of the employee to validate.
     * @return true if the employee exists in the list, false otherwise.
     */
	
	public boolean EmployeeValidation1(List<Employee> list, int id) {
		// TODO Auto-generated method stub
		for(Employee e:list)
			if(e.getEmployeeId()==id)
				return true;
		return false;
	}
	
	

	
}
