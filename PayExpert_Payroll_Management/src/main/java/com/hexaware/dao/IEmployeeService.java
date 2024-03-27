package com.hexaware.dao;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.model.Employee;

/**
 * Interface for performing CRUD operations on employee records.
 */

public interface IEmployeeService {

	List<Employee> getAllEmployee() throws SQLException, DatabaseConnectionException;

	void addEmployee(int id, String fname, String lname, String dob, String gender, String no, String address,
			String pos, String jdate, String tdate) throws SQLException, DatabaseConnectionException;

	void updateEmployee(int eid, String str, String newValue) throws SQLException, DatabaseConnectionException;

	void deleteEmployeeById(int n) throws SQLException, DatabaseConnectionException;

	

	

}
