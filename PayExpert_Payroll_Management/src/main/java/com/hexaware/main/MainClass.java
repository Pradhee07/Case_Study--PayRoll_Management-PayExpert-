package com.hexaware.main;
import com.hexaware.controller.*;
import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.FinancialRecordException;
import com.hexaware.exception.InvalidInputException;
import com.hexaware.exception.PayrollGenerationException;
import com.hexaware.exception.TaxCalculationException;
import  com.hexaware.model.*;

import java.sql.SQLException;
import java.util.*;

/**
 * Main class for the Payroll Management System.
 * 
 * @version 1.0
 * @author Pradheesha
 */

public class MainClass {
	
	/**
     * Main method to run the Payroll Management System.
     */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpController ec = new EmpController();
		SampleController cc = new SampleController();
		PayController pc = new PayController();
		TaxController tc = new TaxController();
		FinanceController fc = new FinanceController();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("******THE PAYROLL MANAGEMENT******");
			System.out.println("1. Get Employee By Id");
			System.out.println("2. Get All Employees");
			System.out.println("3. Add Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Remove Employee");
			System.out.println("6. Generate Payroll");
			System.out.println("7. Get Payroll By Id");
			System.out.println("8. Get Payroll By Employee_Id");
			System.out.println("9. Get Payroll For Specified Periods");
			System.out.println("10.Calculate Tax");
			System.out.println("11.Get Tax By Id");
			System.out.println("12.Get Tax By Employee Id");
			System.out.println("13.Get Taxes for Year");
			System.out.println("14.Add Financial Record");
			System.out.println("15.Get Record by Id");
			System.out.println("16.Get Record by Employee Id");
			System.out.println("17.Get Record By year");
			System.out.println("0. Exit");
			
			
			System.out.println("**************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...Thank you");
				break;
			}
			switch(input) {
			
			// case 1 to 5 ---->  Performs operations on Employee
			
			case 1:
				try {
					List<Employee> list = ec.getAllEmployee();
					
					System.out.println("Enter Employee Id");
					int eid = sc.nextInt();
					
					boolean validation = cc.EmployeeValidation(list,eid);
					
					if(validation==true) {
						ec.getEmployeeById(list,eid);
				
					}
					
					
				} catch (SQLException | EmployeeNotFoundException | DatabaseConnectionException e) {
					
				}
				break;
				
			case 2:
				try {
					List<Employee> list = ec.getAllEmployee();
					System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s","Employee Id","First Name","Last Name","Date Of Birth","Gender","Phone No","Address","position","Join Date","Termination Date" ));
					for(Employee e:list) {
					
			    	System.out.println(String.format("%-20d%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s",e.getEmployeeId(),e.getFirstName(),e.getLastName(),e.getDateofbirth(),e.getGender(),e.getPhoneNumber(),e.getAddress(),e.getPosition(),e.getJoinDate(),e.getTermDate()));
			    
					}
					System.out.println();

				} catch (SQLException | DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					
				}
				break;
			
			case 3:
				try {
					List<Employee> list = ec.getAllEmployee();
					
					System.out.println("Enter Employee Id:");
					int id = sc.nextInt();
					
					boolean validation = cc.EmployeeValidation1(list, id);
					
					if(validation==false) {
						System.out.println("Employee not exist...");
						System.out.println("Do you want to add your details?[y/n]");
						String ch = sc.next();
						switch(ch.toLowerCase()) {
						case "y":
							System.out.println("Enter First Name:");
							String fname = sc.next();
							sc.nextLine();
							System.out.println("Enter Last Name:");
							String lname = sc.next();
							sc.nextLine();
							System.out.println("Enter Date of Birth:");
							String dob = sc.next();
							sc.nextLine();
							System.out.println("Enter your gender:");
							String gender = sc.next();
							sc.nextLine();
							System.out.println("Enter Phone Number:");
							String no = sc.next();
							sc.nextLine();
							System.out.println("Enter your address:");
							String address = sc.nextLine();
							System.out.println("Enter your position:");
							String pos = sc.next();
							sc.nextLine();
							System.out.println("Enter your joining date:");
							String jdate = sc.next();
							
							System.out.println("Enter your Termination date:");
							String tdate = sc.next();
							
							
							ec.addEmployee(id,fname,lname,dob,gender,no,address,pos,jdate,tdate);
							System.out.println("Employee addedd successfully!!!!");
							break;
							
						case "n":
							System.out.println("Exiting....");
							break;
						default:
							throw new InvalidInputException();
						}
						
					}
					else {
						System.out.println("Employee already exists....");
					}
					
					
				} catch (SQLException | InvalidInputException | DatabaseConnectionException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					
					System.out.println("Enter your Employee ID :");
					int eid = sc.nextInt();
					List<Employee> list = ec.getAllEmployee();
					boolean validation = cc.EmployeeValidation1(list, eid);
					if(validation==true) {
					System.out.println("Enter the attribute u want to update:[address/position/phone_no]");
					String str = sc.next();
					sc.nextLine();
					String newValue = " ";
					if(str.equals("address")) {
						System.out.println("Enter ur new address:");
						newValue=sc.nextLine();
						ec.updateEmployee(eid,str,newValue);
					}
					else if(str.equals("position")) {
						System.out.println("Enter your new position:");
						newValue =sc.next();
						ec.updateEmployee(eid,str,newValue);
					}
					else {
						System.out.println("Enter ur new Phone no:");
						newValue = sc.next();
						ec.updateEmployee(eid,str,newValue);
					}
					
					System.out.println("Updated Successfully :)");
					
					}
					else {
						throw new EmployeeNotFoundException();
					}
				} catch (SQLException | DatabaseConnectionException | EmployeeNotFoundException e) {
					
				}
				break;
				
			case 5:
				try {
					List<Employee> list2 = ec.getAllEmployee();
					System.out.println("Enter Employee Id:");
					int n = sc.nextInt();
					boolean validation = cc.EmployeeValidation(list2, n);
					if(validation==true) {
						ec.deleteEmployeeById(n);
					}
					System.out.println("Deleted Successfully :)");
					
				} catch (SQLException | EmployeeNotFoundException | DatabaseConnectionException e) {
					
				}
				break;
				
			// case 6 to 9 --> performs operation on PayRoll
				
			case 6:
				try {
				System.out.println("Enter employee id:");
				int eid = sc.nextInt();
				
				List<Employee> list = ec.getAllEmployee();
				boolean validation = cc.EmployeeValidation1(list, eid);
				if(validation==true) {
				System.out.println("Enter period_start_date :");
				String start = sc.next();
				
				System.out.println("Enter period_end_date :");
				String end = sc.next();
				
				System.out.println("Enter your extra working hrs:");
				int hrs = sc.nextInt();
				
				System.out.println("enter hrs you skipped work :");
				int hrs1 = sc.nextInt();
				
				
				pc.generatePayroll(eid,start,end,hrs,hrs1);
				System.out.println("PayRoll generated :) ");
				}
				else {
					throw new PayrollGenerationException();
				}
				
				}
				catch(SQLException | PayrollGenerationException | DatabaseConnectionException e){
					
				}
				
				break;
			
			case 7:
				
				try {
					List<PayRoll> paylist = pc.getAllPayroll();
					
					System.out.println("Enter your payroll Id:");
					int pid = sc.nextInt();
					PayRoll pr = pc.getPayRollById(paylist,pid);
					
					System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s","PayRoll Id","Employee Id","Period_Start_Date","Period_End_Date","Basic Salary","OverTime Pay","Deductions","Net Salary"));
					System.out.println(String.format("%-20d%-20d%-20s%-20s%-20f%-20f%-20f%f",pr.getPayrollId(),pr.getEmployeeId(),pr.getStartDate(),pr.getEndDate(),pr.getBasicSalary(),pr.getOverTimePay(),pr.getDeductions(),pr.getNetSalary() ));
					System.out.println();
					
				} catch (SQLException | EmployeeNotFoundException | DatabaseConnectionException e) {
					
				}
				break;
			case 8:
				try {
					List<PayRoll> plist = pc.getAllPayroll();
					
					System.out.println("Enter your employee Id:");
					int eid1 = sc.nextInt();
					PayRoll pr = pc.getPayRollByEmployeeId(plist,eid1);
					
					System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s","PayRoll Id","Employee Id","Period_Start_Date","Period_End_Date","Basic Salary","OverTime Pay","Deductions","Net Salary"));
					System.out.println(String.format("%-20d%-20d%-20s%-20s%-20f%-20f%-20f%f",pr.getPayrollId(),pr.getEmployeeId(),pr.getStartDate(),pr.getEndDate(),pr.getBasicSalary(),pr.getOverTimePay(),pr.getDeductions(),pr.getNetSalary() ));
					System.out.println();
					
				} catch (SQLException | EmployeeNotFoundException | DatabaseConnectionException e) {
					
				}
				break;
			case 9:
				
				try {
					System.out.println("Enter the period start date:");
					String start1 = sc.next();
					System.out.println("Enter the period end date:");
					String end1 = sc.next();
					List<PayRoll> list2;
					list2 = pc.getPayRollByPeriod(start1,end1);
					System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%s","PayRoll Id","Employee Id","Period_Start_Date","Period_End_Date","Basic Salary","OverTime Pay","Deductions","Net Salary"));
					for(PayRoll pr:list2)
						System.out.println(String.format("%-20d%-20d%-20s%-20s%-20f%-20f%-20f%f",pr.getPayrollId(),pr.getEmployeeId(),pr.getStartDate(),pr.getEndDate(),pr.getBasicSalary(),pr.getOverTimePay(),pr.getDeductions(),pr.getNetSalary() ));
					    System.out.println();
				} catch (SQLException | DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
				// case 10 to 13 --> Performs operation on tax
				
			case 10:
				
				try {
					
					System.out.println("Enter Employee Id :");
					int eid = sc.nextInt();
					
                    List<Employee> list = ec.getAllEmployee();
					
					
					boolean validation = cc.EmployeeValidation1(list, eid);
					
					if(validation==true) {
					System.out.println("Enter the tax year :");
					String yr = sc.next();
					tc.calcualteTax(eid,yr);
					}
					else {
						throw new EmployeeNotFoundException();
					}
					
				} catch (SQLException | TaxCalculationException | DatabaseConnectionException | EmployeeNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			
			case 11:
				try {
					List<Tax> tax = tc.getAllTax();
					
					System.out.println("Enter the tax Id:");
					int tid = sc.nextInt();
					
					Tax tx = tc.getTaxById(tax,tid);
					
					System.out.println(String.format("%-20s%-20s%-20s%-20s%s","Tax Id","Employee Id","Tax Year","Tax Income","Tax Amount"));
					System.out.println(String.format("%-20d%-20d%-20d%-20.1f%.1f",tx.getTaxId(),tx.getEmployeeId(),tx.getTaxYear(),tx.getIncome(),tx.getTaxAmount() ));
					System.out.println();
					
				} catch (SQLException | EmployeeNotFoundException | DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 12:
				try {
					
					List<Tax> taxlist = tc.getAllTax();
					
					System.out.println("Enter Employee Id:");
					int eid1 = sc.nextInt();
					
					Tax t = tc.getTaxByEmployeeId(taxlist,eid1);
					
					System.out.println(String.format("%-20s%-20s%-20s%-20s%s","Tax Id","Employee Id","Tax Year","Tax Income","Tax Amount"));
					System.out.println(String.format("%-20d%-20d%-20d%-20.1f%.1f",t.getTaxId(),t.getEmployeeId(),t.getTaxYear(),t.getIncome(),t.getTaxAmount() ));
					System.out.println();
					
				} catch (SQLException | EmployeeNotFoundException | DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 13:
				
				try {
					List<Tax> taxlist = tc.getAllTax();
					
					System.out.println("Enter the year to get the tax:");
				    int year = sc.nextInt();
				    
				    tc.getTaxByYear(taxlist,year);
				   
				    System.out.println(String.format("%-20s%-20s%-20s%-20s%s","Tax Id","Employee Id","Tax Year","Tax Income","Tax Amount"));
				    for(Tax t :taxlist) {
				    	
					System.out.println(String.format("%-20d%-20d%-20d%-20.1f%.1f",t.getTaxId(),t.getEmployeeId(),t.getTaxYear(),t.getIncome(),t.getTaxAmount() ));
				    }
					System.out.println();
				    
				    
				} catch (SQLException | InvalidInputException | DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
				// case 14 to 17 --> performs operations on finance
				
			case 14:
				
				
				try {
					

					System.out.println("Enter Employee Id:");
					int id = sc.nextInt();
					
							System.out.println("Enter the date :");
							String date = sc.next();
							sc.nextLine();
							System.out.println("Enter description :");
							String descrip = sc.next();
							sc.nextLine();
							System.out.println("Enter the amount :");
							double amt = sc.nextDouble();
							
							System.out.println("Enter record type :");
							String recType = sc.next();
							sc.nextLine();
							
							
							fc.addRecord(id,date,descrip,amt,recType);
							System.out.println("Record addedd successfully!!!!");
							
						
					}
				
				catch (SQLException | DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				break;
				
			case 15:
				
				try {
					List<FinancialRecord> frList = fc.getAllRecords();
					
					System.out.println("Enter the record Id:");
					int rid = sc.nextInt();
					
			        FinancialRecord fr = fc.getRecordbyId(frList,rid);
			        
			        System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%s","Record Id","Employee Id","Record Date","Description","Amount","Record Type"));
					System.out.println(String.format("%-20d%-20d%-20s%-20s%-20.1f%s",fr.getRecordId(),fr.getEmployeeId(),fr.getRecordDate(),fr.getDescription(),fr.getAmount(),fr.getRecordType()));
					System.out.println();
					
				} catch (SQLException | FinancialRecordException | DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 16:
				
				try {
					List<FinancialRecord> frList = fc.getAllRecords();
					System.out.println("Enter the Employee Id:");
					int eid1 = sc.nextInt();
					
					FinancialRecord fr = fc.getRecordbyEmployeeId(frList,eid1);
					
					System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%s","Record Id","Employee Id","Record Date","Description","Amount","Record Type"));
					System.out.println(String.format("%-20d%-20d%-20s%-20s%-20.1f%s",fr.getRecordId(),fr.getEmployeeId(),fr.getRecordDate(),fr.getDescription(),fr.getAmount(),fr.getRecordType()));
					System.out.println();
					
					
				} catch (SQLException | FinancialRecordException | DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 17:
				
				try {
					List<FinancialRecord> frList = fc.getAllRecords();
					
					System.out.println("Enter a record date :");
					String date = sc.next();
					
					List<FinancialRecord> fr = fc.getRecordByDate(frList,date);
					
					System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%s","Record Id","Employee Id","Record Date","Description","Amount","Record Type"));
					for(FinancialRecord f : fr) {
						System.out.println(String.format("%-20d%-20d%-20s%-20s%-20.1f%s",f.getRecordId(),f.getEmployeeId(),f.getRecordDate(),f.getDescription(),f.getAmount(),f.getRecordType()));
					}
					System.out.println();
					
				} catch (SQLException | DatabaseConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			default :
				System.out.println("Invalid input !!!!");
				break;
				
			}
		}

	}

}
