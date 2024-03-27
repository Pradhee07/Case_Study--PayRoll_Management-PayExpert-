package com.hexaware.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.hexaware.controller.PayController;
import com.hexaware.model.PayRoll;


/**
 * Test class to calculate net salary.
 */

public class CalculateNetSalary {
	
	PayController pc = new PayController();


	/**
	 * Test method to calculate net salary.
	 */
	
	@Test
	public void testCalculateNetSalary() {
		
		List<PayRoll> list = new ArrayList<>();
		list.add(new PayRoll(1,50000,2000,200));
		list.add(new PayRoll(2,60000,3000,100));
		int id = 2; 
		
		List<PayRoll> list2 = pc.calculateNetSalary(list,id);
		
		// Asserting the results
		PayRoll payroll = null;
        for (PayRoll p : list2) {
            if (p.getEmployeeId() == id) {
                payroll = p;
                break;
            }
        }
		
       
        
        assertNotNull("PayRoll object should not be null", payroll);
        assertEquals("Employee ID should match", 2, payroll.getEmployeeId());
        assertEquals("Basic Salary should match", 60000, payroll.getBasicSalary(),0.01);
        assertEquals("Overtime Pay should match", 3000, payroll.getOverTimePay(), 0.01);
        assertEquals("Overtime Pay should match", 100, payroll.getDeductions(), 0.01);
        assertEquals("Gross Salary should match", 62900, payroll.getNetSalary(), 0.01);
	}

}
