package com.hexaware.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.*;

import org.junit.Test;

import com.hexaware.controller.EmpController;
import com.hexaware.model.*;

public class VerifyInvalidEmployeeData {
	
	
	 
	@Test
	
	public void testEmployeeNotFound() {
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee(1, "John", "Doe", LocalDate.parse("1980-01-01"), "Male", "1234567890", "123 Main St", "Manager", LocalDate.parse("2022-01-01"), LocalDate.parse("2026-10-05")));
		
		EmpController ec = new EmpController();
		
		// EmployeeId not available
		int invalidId = 2; 
		
		Employee e = ec.getEmployee(list, invalidId); 
		
		//checks whether the list is null
		//If null, Employee not found
		assertNull(e);
		
	}
	
	@Test
	public void testEmployeeFound() {
		
        List<Employee> list = new ArrayList<>();
		
		list.add(new Employee(101, "John", "Doe", LocalDate.parse("1980-01-01"), "Male", "1234567890", "123 Main St", "Manager", LocalDate.parse("2022-01-01"), LocalDate.parse("2026-10-05")));
		
		EmpController ec = new EmpController();
		
		// EmployeeId available
		int invalidId = 101;
		
		Employee e = ec.getEmployee(list, invalidId);
		
		//checks whether the list is not null
		//If not null, Employee found
		assertNotNull(e);
	}

}
