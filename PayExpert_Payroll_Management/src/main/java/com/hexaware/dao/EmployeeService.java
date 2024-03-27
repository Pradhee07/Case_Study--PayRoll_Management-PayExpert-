package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.model.*;
import com.hexaware.util.DBUtil;

/**
 * Service class to perform CRUD operations on employee data.
 */

public class EmployeeService implements IEmployeeService {
	
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	
	/**
	 * Retrieves all employees from the database.
	 * 
	 * @return List of Employee objects representing all employees in the database.
	 * @throws SQLException              If a database access error occurs.
	 * @throws DatabaseConnectionException If there is an issue with the database connection.
	 */

	@Override
	public List<Employee> getAllEmployee() throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		con = DBUtil.getDBConn();
		
		ps = con.prepareStatement("select * from employee");
		rs = ps.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("employee_id");
			String firstName=rs.getString("first_name");
			String lastName=rs.getString("last_name");
			String dob = String.valueOf(rs.getDate("dob"));
			String gender = rs.getString("gender");
			String phone_no = rs.getString("phone_no");
			String address = rs.getString("address");
			String pos = rs.getString("position");
			String joinDate = String.valueOf(rs.getDate("join_date"));
			String termDate = String.valueOf(rs.getDate("terminate_date"));
			
			Employee emp = new Employee(id,firstName,lastName,LocalDate.parse(dob),gender,phone_no,address,pos,LocalDate.parse(joinDate),LocalDate.parse(termDate));
			list.add(emp);
		}
		
		return list;
		
		
	}
	
	/**
	 * Adds a new employee to the database.
	 * 
	 * @param id     the ID of the employee to be added.
	 * @param fname  the first name of the employee.
	 * @param lname  the last name of the employee.
	 * @param dob    the date of birth of the employee.
	 * @param gender the gender of the employee.
	 * @param no     the phone number of the employee.
	 * @param address the address of the employee.
	 * @param pos    the position of the employee.
	 * @param jdate  the join date of the employee.
	 * @param tdate  the termination date of the employee.
	 * @throws SQLException              If a database access error occurs.
	 * @throws DatabaseConnectionException If there is an issue with the database connection.
	 */

	@Override
	public void addEmployee(int id, String fname, String lname, String dob, String gender, String no, String address,
			String pos, String jdate, String tdate) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		con=DBUtil.getDBConn();
		ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setString(4, dob);
		ps.setString(5, gender);
		ps.setString(6, no);
		ps.setString(7, address);
		ps.setString(8, pos);
		ps.setString(9, jdate);
		ps.setString(10, tdate);
		ps.executeUpdate();
		
	}

	/**
	 * Updates an existing employee in the database.
	 * 
	 * @param eid      the ID of the employee to be updated.
	 * @param str      the attribute to be updated (address/position/phone_no).
	 * @param newValue the new value of the attribute.
	 * @throws SQLException              If a database access error occurs.
	 * @throws DatabaseConnectionException If there is an issue with the database connection.
	 */
	
	@Override
	public void updateEmployee(int eid, String str, String newValue) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		con=DBUtil.getDBConn();
		ps = con.prepareStatement("update employee set "+str+"=? where employee_id =?") ;
		ps.setString(1, newValue);
		
		ps.setInt(2, eid);
		
		ps.executeUpdate();
	}
	
	/**
	 * Deletes an employee from the database by ID.
	 * 
	 * @param n the ID of the employee to be deleted.
	 * @throws SQLException              If a database access error occurs.
	 * @throws DatabaseConnectionException If there is an issue with the database connection.
	 */

	@Override
	public void deleteEmployeeById(int n) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		con=DBUtil.getDBConn();
		ps = con.prepareStatement("delete from employee where employee_id =?");
		ps.setInt(1, n);
		ps.executeUpdate();
		
	}

	

	

}
