package com.hexaware.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.hexaware.controller.PayController;

import com.hexaware.exception.TaxCalculationException;
import com.hexaware.model.PayRoll;

/**
 * Test class to process payroll.
 */

public class ProcessPayRoll {
	
	/**
	 * Test method to process payroll.
	 */
	
	@Test
	public void testProcessPayRoll() {
		
		//creating a list and add the values in it
		
		List<PayRoll> list = new ArrayList<>();
		list.add(new PayRoll(1,1,LocalDate.parse("2024-03-01"),LocalDate.parse("2024-03-15"),4000,200,500,3700));
		
		PayController p = new PayController();
		
		try {
			
			//add values returned from processpayroll() into the list2
			
			List<PayRoll> list2 = p.processPayroll(list, 1);
			
			for (int i = 0; i < list.size(); i++) {
                PayRoll expected = list.get(i);
                PayRoll actual = list2.get(i);

               
                assertEquals("Employee ID should match", expected.getEmployeeId(), actual.getEmployeeId());
                assertEquals("Basic salary should match", expected.getBasicSalary(), actual.getBasicSalary(),0.01);
                assertEquals("Overtime pay should match", expected.getOverTimePay(), actual.getOverTimePay(),0.01);
                
            }
		}catch (TaxCalculationException e) {
                
                System.out.println("Error occurred !!");
            }
			
		
	}

}
