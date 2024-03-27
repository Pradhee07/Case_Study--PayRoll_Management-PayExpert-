package com.hexaware.dao;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.model.FinancialRecord;

/**
 * Interface for performing CRUD operations on financial records.
 */

public interface IFinancialRecordService {

	List<FinancialRecord> getAllrecords() throws SQLException, DatabaseConnectionException;

	List<FinancialRecord> getRecordByDate(List<FinancialRecord> frList, String date) throws SQLException, DatabaseConnectionException;

	void addRecord(int id, String date, String descrip, double amt, String recType) throws SQLException, DatabaseConnectionException;

}
