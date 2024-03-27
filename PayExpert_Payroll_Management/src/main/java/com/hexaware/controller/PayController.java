package com.hexaware.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.dao.*;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.TaxCalculationException;
import com.hexaware.model.PayRoll;

/**
 * Controller class for handling payroll-related operations.
 */

public class PayController {
	
	IPayrollService pservice = new PayrollService();
	
	 /**
     * Retrieves all payrolls from the database.
     * 
     * @return A list of all payrolls.
     * @throws SQLException               If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */

	public List<PayRoll> getAllPayroll() throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		return pservice.getAllPayroll();
	}

	/**
     * Retrieves a payroll by its ID from the given list.
     * 
     * @param paylist The list of payrolls to search in.
     * @param pid     The ID of the payroll to retrieve.
     * @return The payroll object if found.
     * @throws EmployeeNotFoundException If the payroll with the given ID is not found.
     */
	
	public PayRoll getPayRollById(List<PayRoll> paylist, int pid) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		String s=" ";
		for(PayRoll p :paylist) {
			if(p.getPayrollId()==pid) {
				return p;
			}
		}
		throw new EmployeeNotFoundException(s);
	}
	
	
	/**
     * Retrieves a payroll by employee ID from the given list.
     * 
     * @param plist The list of payrolls to search in.
     * @param eid   The employee ID to search for.
     * @return The payroll object if found.
     * @throws EmployeeNotFoundException If the payroll for the given employee ID is not found.
     */

	public PayRoll getPayRollByEmployeeId(List<PayRoll> plist, int eid) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
	
		for(PayRoll p :plist) {
			if(p.getEmployeeId()==eid) {
				return p;
			}
		}
		throw new EmployeeNotFoundException();
	}

	/**
     * Retrieves payrolls by period from the database.
     * 
     * @param start The start date of the period.
     * @param end   The end date of the period.
     * @return A list of payrolls within the specified period.
     * @throws SQLException               If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */
	
	public List<PayRoll> getPayRollByPeriod(String start, String end) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		return pservice.getPayRollBYPeriod(start,end);
	}
	
	/**
     * Generates a payroll for the specified employee and period.
     * 
     * @param eid   The ID of the employee.
     * @param start The start date of the payroll period.
     * @param end   The end date of the payroll period.
     * @param hrs   The number of regular hours worked.
     * @param hrs1  The number of overtime hours worked.
     * @throws SQLException               If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */

	public void generatePayroll(int eid, String start, String end, int hrs, int hrs1) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		
		pservice.generatePayroll(eid,start,end,hrs,hrs1);
	}
	
	/* methods for test cases */
	
	/**
     * Calculates the gross salary for an employee in the given list.
     * 
     * @param list The list of payrolls to calculate from.
     * @param eid  The ID of the employee.
     * @return A list of payrolls with updated gross salary.
     */
	
	public List<PayRoll> calculateGrossSalary(List<PayRoll> list, int eid) {
	    List<PayRoll> updatedList = new ArrayList<>();
	    for (PayRoll p : list) {
	        if (p.getEmployeeId() == eid) {
	            double grossSalary = p.getBasicSalary() + p.getOverTimePay();
	            p.setGrossSalary(grossSalary); 
	        }
	        updatedList.add(p);
	    }
	    return updatedList;
	}
	
	/**
     * Calculates the net salary for an employee in the given list.
     * 
     * @param list The list of payrolls to calculate from.
     * @param id   The ID of the employee.
     * @return A list of payrolls with updated net salary.
     */
	
	public List<PayRoll> calculateNetSalary(List<PayRoll> list, int id){
		List<PayRoll> updatedList = new ArrayList<>();
		for (PayRoll p : list) {
	        if (p.getEmployeeId() == id) {
	            double netSalary = p.getBasicSalary() + p.getOverTimePay()-p.getDeductions();
	            p.setNetSalary(netSalary);
	        }
	        updatedList.add(p);
	    }
	    return updatedList;
	}
	
	/**
     * Processes payroll for an employee in the given list.
     * 
     * @param payroll The list of payrolls to process.
     * @param id      The ID of the employee.
     * @return A list of payrolls processed for the specified employee.
     * @throws TaxCalculationException If an error occurs during tax calculation.
     */
	
	public List<PayRoll> processPayroll(List<PayRoll> payroll,int id) throws TaxCalculationException {
	    List<PayRoll> list = new ArrayList<>();

	    for (PayRoll pr : payroll) {
	        if(pr.getEmployeeId()==id) {
	        PayRoll obj = new PayRoll(pr.getPayrollId(),pr.getEmployeeId(),pr.getStartDate(),pr.getEndDate(),pr.getBasicSalary(),pr.getOverTimePay(),pr.getDeductions(),pr.getNetSalary());
	        
	        list.add(obj); 
	        }
	    }

	    return list;
	}
}
