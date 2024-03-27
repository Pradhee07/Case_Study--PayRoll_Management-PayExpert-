package com.hexaware.controller;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.model.Tax;

import com.hexaware.dao.*;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.InvalidInputException;
import com.hexaware.exception.TaxCalculationException;

/**
 * Controller class for handling tax-related operations.
 */

public class TaxController {
	
	
	ITaxService tservice = new TaxService();

	 /**
     * Retrieves all tax records.
     * 
     * @return A list of Tax objects representing all tax records.
     * @throws SQLException               If a SQL exception occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */
	
	public List<Tax> getAllTax() throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		return tservice.getAllTax();
	}

	
	/**
     * Retrieves a tax record by its ID.
     * 
     * @param tax The list of tax records to search in.
     * @param tid The tax record ID to search for.
     * @return The Tax object representing the tax record with the given ID.
     * @throws EmployeeNotFoundException If the tax record with the given ID is not found.
     */
	
	public Tax getTaxById(List<Tax> tax, int tid) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		String s=" ";
		String str =" ";
		for(Tax t: tax) {
			if(t.getTaxId()==tid) {
				return t;
			}
		}
		throw new EmployeeNotFoundException(s,str);
	}

	
	/**
     * Retrieves a tax record by employee ID.
     * 
     * @param taxlist The list of tax records to search in.
     * @param eid     The employee ID to search for.
     * @return The Tax object representing the tax record associated with the given employee ID.
     * @throws EmployeeNotFoundException If the tax record for the employee with the given ID is not found.
	 * @throws DatabaseConnectionException 
	 * @throws SQLException 
     */
	
	public Tax getTaxByEmployeeId(List<Tax> taxlist, int eid) throws EmployeeNotFoundException, SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		 return tservice.getTaxById(taxlist,eid);
	}

	/**
     * Retrieves a tax record by tax year.
     * 
     * @param taxlist The list of tax records to search in.
     * @param year    The tax year to search for.
     * @return The Tax object representing the tax record for the given tax year.
     * @throws InvalidInputException If the input tax year is invalid.
	 * @throws SQLException 
	 * @throws DatabaseConnectionException 
     */
	
	public Tax getTaxByYear(List<Tax> taxlist, int year) throws InvalidInputException, SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		/*for(Tax t:taxlist) {
			if(t.getTaxYear()==year) {
				return t;
			}
		}
		throw new InvalidInputException();*/
		return tservice.getTaxByYear(taxlist,year);
	}

	/**
     * Calculates tax for an employee for the given year and updates the tax records.
     * 
     * @param eid The employee ID for whom tax calculation is to be performed.
     * @param yr  The tax year for which tax is to be calculated.
     * @throws SQLException               If a SQL exception occurs.
     * @throws TaxCalculationException    If there is an error during tax calculation.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */
	
	public void calcualteTax(int eid, String yr) throws SQLException, TaxCalculationException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		
		double net_salary = tservice.getIncome(eid);
		tservice.calculateTaxIncome(eid,yr,(net_salary*12));
		
	}
	
	
	//method for test case
	
	 /**
     * Calculates tax amount for an employee for the given year.
     * 
     * @param eid The employee ID for whom tax amount is to be calculated.
     * @param yr  The tax year for which tax amount is to be calculated.
     * @return The calculated tax amount.
     * @throws SQLException               If a SQL exception occurs.
     * @throws TaxCalculationException    If there is an error during tax calculation.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */

	public double calcualteTax1(int eid, String yr) throws SQLException, TaxCalculationException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		
		double net_salary = tservice.getIncome(eid);
		double amt = net_salary *12 * 0.03;
		return amt;
		
	}

	
}
