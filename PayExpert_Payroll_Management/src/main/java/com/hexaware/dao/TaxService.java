package com.hexaware.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.controller.*;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.TaxCalculationException;
import com.hexaware.model.Employee;
import com.hexaware.model.PayRoll;
import com.hexaware.model.Tax;
import com.hexaware.util.DBUtil;

/**
 * Service class for tax-related operations.
 */

public class TaxService implements ITaxService{
	
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	
	 /**
     * Retrieves all tax records from the database.
     * 
     * @return List of Tax objects representing all tax records in the database.
     * @throws SQLException              If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */

	@Override
	public List<Tax> getAllTax() throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		List<Tax> list = new ArrayList<>();
		con = DBUtil.getDBConn();
		
		ps = con.prepareStatement("select * from tax");
		rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("tax_id");
			int eid=rs.getInt("employee_id");
			int year=rs.getInt("tax_year");
			double tax_income = rs.getDouble("tax_income");
			double tax_amount = rs.getDouble("tax_amount");
			
			Tax tax = new Tax(id,eid,year,tax_income,tax_amount);
			list.add(tax);
		}
		
		return list;
		
	}
	
	 /**
     * Retrieves the net salary of an employee from the database.
     * 
     * @param eid The ID of the employee.
     * @return The net salary of the employee.
     * @throws SQLException              If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */
	
	@Override
	public double getIncome(int eid) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
        con = DBUtil.getDBConn();
		
		ps = con.prepareStatement("select net_salary from payroll where employee_id = ?");
		ps.setInt(1, eid);
		rs = ps.executeQuery();
		
		 if (rs.next()) {
		        return rs.getDouble("net_salary");
		    } else {
		        
		        throw new SQLException();
		    }		
	}

	/**
     * Calculates and stores tax information for an employee.
     * 
     * @param eid The ID of the employee.
     * @param yr  The tax year.
     * @param d   The tax income of the employee.
     * @throws SQLException              If a database access error occurs.
     * @throws TaxCalculationException    If there is an issue with tax calculation.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */
	
	@Override
	public void calculateTaxIncome(int eid, String yr, double d) throws SQLException,TaxCalculationException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		con = DBUtil.getDBConn();
		ps = con.prepareStatement("insert into tax (employee_id, tax_year, tax_income, tax_amount) values (?,?,?,?)") ;
		ps.setInt(1, eid);
		ps.setString(2, yr);
		ps.setDouble(3, d);
		if(d>15000) {
			ps.setDouble(4, d*0.03);
		}
		else {
			ps.setDouble(4, d*0.01);
		}
		ps.executeUpdate();
	}

	@Override
	public Tax getTaxById(List<Tax> taxlist, int eid) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		Tax tax = null;
		con = DBUtil.getDBConn();
		ps = con.prepareStatement("select * from tax join employee on tax.employee_id = employee.employee_id where tax.employee_id = ?") ;
		ps.setInt(1,eid);
		rs = ps.executeQuery();
		if(rs.next()) {
			tax = new Tax(rs);
		}
		return tax;
	}

	@Override
	public Tax getTaxByYear(List<Tax> taxlist, int year) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		Tax tax = null;
		con = DBUtil.getDBConn();
		ps = con.prepareStatement("select * from tax join employee on tax.employee_id = employee.employee_id where tax.tax_year = ?") ;
		ps.setInt(1,year);
		rs = ps.executeQuery();
		if(rs.next()) {
			tax = new Tax(rs);
		}
		return tax;
	}

	
	
	
    
	
	



}
