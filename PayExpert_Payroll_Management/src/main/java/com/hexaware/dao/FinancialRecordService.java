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
import com.hexaware.model.Employee;
import com.hexaware.model.FinancialRecord;
import com.hexaware.model.PayRoll;
import com.hexaware.util.DBUtil;

/**
 * Service class to perform CRUD operations on financial records.
 */

public class FinancialRecordService implements IFinancialRecordService{
	
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	/**
	 * Retrieves all financial records from the database.
	 * 
	 * @return list of FinancialRecord objects representing all financial records in the database.
	 * @throws SQLException              If a database access error occurs.
	 * @throws DatabaseConnectionException If there is an issue with the database connection.
	 */
	
	@Override
	public List<FinancialRecord> getAllrecords() throws SQLException, DatabaseConnectionException {
		
		// TODO Auto-generated method stub
		List<FinancialRecord> list = new ArrayList<>();
		con = DBUtil.getDBConn();
		
		ps = con.prepareStatement("select * from financial_record");
		rs = ps.executeQuery();
		while(rs.next()) {
			int rid = rs.getInt("record_id");
			int eid=rs.getInt("employee_id");
			String date = String.valueOf(rs.getDate("record_date"));
			String description = rs.getString("descrip");
			double amount = rs.getDouble("amount");
			String type = rs.getString("record_type");
			
			
			FinancialRecord fr= new FinancialRecord(rid,eid,LocalDate.parse(date),description,amount,type);
			list.add(fr);
		}
		
		return list;
	}

	/**
	 * Retrieves financial records from the database for a specific date.
	 * 
	 * @param frList the list of FinancialRecord objects.
	 * @param date   the date for which records need to be retrieved.
	 * @return list of FinancialRecord objects representing records for the specified date.
	 * @throws SQLException              If a database access error occurs.
	 * @throws DatabaseConnectionException If there is an issue with the database connection.
	 */
	
	@Override
	public List<FinancialRecord> getRecordByDate(List<FinancialRecord> frList, String date) throws SQLException, DatabaseConnectionException {
		
		List<FinancialRecord> frlist = new ArrayList<>();
		con = DBUtil.getDBConn();
		ps = con.prepareStatement("select * from financial_record where record_date=?") ;
		ps.setDate(1,java.sql.Date.valueOf(date));
		rs = ps.executeQuery();
		
		while(rs.next()) {
			int id=rs.getInt("record_id");
			int eid = rs.getInt("employee_id");
			String date1 = String.valueOf(rs.getDate("record_date"));
			String  des = rs.getString("descrip");
			double amount = rs.getDouble("amount");
			String rec_type = rs.getString("record_type");
			
			FinancialRecord record = new FinancialRecord(id,eid,LocalDate.parse(date1),des,amount,rec_type);
			frlist.add(record);
			
		}
		return frlist;
		
	}
	
	/**
	 * Adds a new financial record to the database.
	 * 
	 * @param id       the ID of the employee associated with the record.
	 * @param date     the date of the record.
	 * @param descrip  the description of the record.
	 * @param amt      the amount associated with the record.
	 * @param recType  the type of the record.
	 * @throws SQLException              If a database access error occurs.
	 * @throws DatabaseConnectionException If there is an issue with the database connection.
	 */

	@Override
	public void addRecord(int id, String date, String descrip, double amt, String recType) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		con=DBUtil.getDBConn();
		ps = con.prepareStatement("insert into financial_record (employee_id, record_date, descrip, amount, record_type) values(?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, date);
		ps.setString(3, descrip);
		ps.setDouble(4, amt);
		ps.setString(5, recType);
		
		ps.executeUpdate();
	}


	
	
	
}
