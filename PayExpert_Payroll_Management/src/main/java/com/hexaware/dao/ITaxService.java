package com.hexaware.dao;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.TaxCalculationException;
import com.hexaware.model.Tax;

/**
 * Interface for performing operations related to tax calculation and management.
 */

public interface ITaxService {

	List<Tax> getAllTax() throws SQLException, DatabaseConnectionException;

	double getIncome(int eid) throws SQLException, DatabaseConnectionException;

	void calculateTaxIncome(int eid, String yr, double d) throws SQLException, TaxCalculationException, DatabaseConnectionException;

	Tax getTaxById(List<Tax> taxlist, int eid) throws SQLException, DatabaseConnectionException;

	Tax getTaxByYear(List<Tax> taxlist, int year) throws SQLException, DatabaseConnectionException;

}
