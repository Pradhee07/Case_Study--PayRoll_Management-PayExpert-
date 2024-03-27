package com.hexaware.dao;

import java.sql.SQLException;
import java.util.List;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.model.PayRoll;

/**
 * Interface for performing operations related to payroll management.
 */

public interface IPayrollService {

	List<PayRoll> getAllPayroll() throws SQLException, DatabaseConnectionException;

	List<PayRoll> getPayRollBYPeriod(String start, String end) throws SQLException, DatabaseConnectionException;

	void generatePayroll(int eid, String start, String end, int hrs,int hrs1) throws SQLException, DatabaseConnectionException;

    

}
