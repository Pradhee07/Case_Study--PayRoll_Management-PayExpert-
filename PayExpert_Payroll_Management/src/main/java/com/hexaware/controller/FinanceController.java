package com.hexaware.controller;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.model.FinancialRecord;

import com.hexaware.dao.*;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.FinancialRecordException;

/**
 * Controller class for financial record-related operations.
 */

public class FinanceController {
	
	IFinancialRecordService fservice = new FinancialRecordService();

	/**
     * Retrieves all financial records from the database.
     * 
     * @return A list of all financial records.
     * @throws SQLException               If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */
	
	public List<FinancialRecord> getAllRecords() throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		return fservice.getAllrecords();
	}

	 /**
     * Retrieves a financial record by its ID from the given list.
     * 
     * @param frList The list of financial records to search in.
     * @param rid    The ID of the financial record to retrieve.
     * @return The financial record object if found.
     * @throws FinancialRecordException If the financial record with the given ID is not found.
     */
	
	public FinancialRecord getRecordbyId(List<FinancialRecord> frList,  int rid) throws FinancialRecordException {
		// TODO Auto-generated method stub
		for(FinancialRecord fr :frList) {
			if(fr.getRecordId()==rid) {
				return fr;
			}
		}
		throw new FinancialRecordException();
	}
	
	 /**
     * Retrieves a financial record by its ID from the given list.
     * 
     * @param frList The list of financial records to search in.
     * @param rid    The ID of the financial record to retrieve.
     * @return The financial record object if found.
     * @throws FinancialRecordException If the financial record with the given ID is not found.
     */

	public FinancialRecord getRecordbyEmployeeId(List<FinancialRecord> frList, int eid) throws FinancialRecordException {
		// TODO Auto-generated method stub
		String s=" ";
		for(FinancialRecord fr :frList) {
			if(fr.getEmployeeId()==eid) {
				return fr;
			}
		}
		throw new FinancialRecordException(s);
	}
	
	 /**
     * Retrieves a financial record by its ID from the given list.
     * 
     * @param frList The list of financial records to search in.
     * @param rid    The ID of the financial record to retrieve.
     * @return The financial record object if found.
     * @throws FinancialRecordException If the financial record with the given ID is not found.
     */

	public List<FinancialRecord> getRecordByDate(List<FinancialRecord> frList, String date) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		return fservice.getRecordByDate(frList, date);
	}
	
	/**
     * Adds a new financial record to the database.
     * 
     * @param id      The ID of the financial record.
     * @param date    The date of the financial record.
     * @param descrip The description of the financial record.
     * @param amt     The amount of the financial record.
     * @param recType The type of the financial record.
     * @throws SQLException               If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */

	public void addRecord(int id, String date, String descrip, double amt, String recType) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		fservice.addRecord(id,date,descrip,amt,recType);
	}

}
