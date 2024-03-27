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
import com.hexaware.model.PayRoll;
import com.hexaware.util.DBUtil;

/**
 * Service class for  payroll-related operations.
 */

public class PayrollService implements IPayrollService{
	
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;


	/**
     * Retrieves all payroll records from the database.
     * 
     * @return List of PayRoll objects representing all payroll records in the database.
     * @throws SQLException              If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */
	
	@Override
	public List<PayRoll> getAllPayroll() throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		List<PayRoll> list = new ArrayList<>();
		con = DBUtil.getDBConn();
		ps = con.prepareStatement("select * from payroll");
		rs=ps.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("payroll_id");
			int eid = rs.getInt("employee_id");
			String start = String.valueOf(rs.getDate("payperiod_start_date"));
			String end = String.valueOf(rs.getDate("payperiod_end_date"));
			double sal = rs.getDouble("basic_salary");
			double overpay = rs.getDouble("overtime_pay");
			double deduce = rs.getDouble("deductions");
			double netsal = rs.getDouble("net_salary");
			
			PayRoll pay = new PayRoll(id,eid,LocalDate.parse(start),LocalDate.parse(end),sal,overpay,deduce,netsal);
			list.add(pay);
		}
		
		return list;
	}

	
	/**
     * Retrieves payroll records for a specific period from the database.
     * 
     * @param start The start date of the pay period.
     * @param end   The end date of the pay period.
     * @return List of PayRoll objects representing payroll records for the specified period.
     * @throws SQLException              If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */

	@Override
	public List<PayRoll> getPayRollBYPeriod(String start, String end) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		List<PayRoll> roll = new ArrayList<>();
		con = DBUtil.getDBConn();
		ps = con.prepareStatement("select * from payroll where payperiod_start_date>=? and payperiod_end_date<=?") ;
		ps.setDate(1,java.sql.Date.valueOf(start));
		ps.setDate(2, java.sql.Date.valueOf(end));
		
		rs = ps.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("payroll_id");
			int eid = rs.getInt("employee_id");
			String start1 = String.valueOf(rs.getDate("payperiod_start_date"));
			String end1 = String.valueOf(rs.getDate("payperiod_end_date"));
			double sal = rs.getDouble("basic_salary");
			double overpay = rs.getDouble("overtime_pay");
			double deduce = rs.getDouble("deductions");
			double netsal = rs.getDouble("net_salary");
			
			PayRoll pay = new PayRoll(id,eid,LocalDate.parse(start1),LocalDate.parse(end1),sal,overpay,deduce,netsal);
			roll.add(pay);
			
		}
		return roll;
	}
	
	/**
     * Generates payroll for an employee for the specified period and hours worked.
     * 
     * @param eid   The ID of the employee.
     * @param start The start date of the pay period.
     * @param end   The end date of the pay period.
     * @param hrs   The regular hours worked.
     * @param hrs1  The overtime hours worked.
     * @throws SQLException              If a database access error occurs.
     * @throws DatabaseConnectionException If there is an issue with the database connection.
     */


	@Override
	public void generatePayroll(int eid, String start, String end, int hrs,int hrs1) throws SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
	
		
		con = DBUtil.getDBConn();
		ps = con.prepareStatement("insert into payroll (employee_id, payperiod_start_date,payperiod_end_date,basic_salary,overtime_pay,deductions,net_salary) values (?,?,?,?,?,?,?)") ;
		
	    ps.setInt(1, eid);
		ps.setDate(2,java.sql.Date.valueOf(start));
		ps.setDate(3, java.sql.Date.valueOf(end));
		ps.setDouble(4,5000);
		ps.setDouble(5, hrs*100);
		ps.setDouble(6, hrs1*100);
		ps.setDouble(7, 5000 + (hrs*100) - (hrs1 *100));
		
		ps.executeUpdate();
		
	}


	
}
