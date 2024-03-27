package com.hexaware.test;
import com.hexaware.model.PayRoll;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.hexaware.controller.PayController;

/**
 *test class for the CalculateGrossSalary method
 *
 */

public class CalculateGrossSalaryTest {
	PayController pc = new PayController();

	/**
     * Test method to verify the calculation of gross salary.
     */

	@Test
	public void testCalculateSalary() {
		
		List<PayRoll> list = new ArrayList<>();
		list.add(new PayRoll(1,50000,2000));
		list.add(new PayRoll(2,60000,3000));
		int id = 1;
		
		List<PayRoll> list2 = pc.calculateGrossSalary(list,id);
		
		PayRoll payroll = null;
        for (PayRoll p : list2) {
            if (p.getEmployeeId() == id) {
                payroll = p;
                break;
            }
        }
		
       
       // Asserting the results
        assertNotNull("PayRoll object should not be null", payroll);
        assertEquals("Employee ID should match", 1, payroll.getEmployeeId());
        assertEquals("Basic Salary should match", 50000, payroll.getBasicSalary(),0.01);
        assertEquals("Overtime Pay should match", 2000, payroll.getOverTimePay(), 0.01);
        assertEquals("Gross Salary should match", 52000, payroll.getGrossSalary(), 0.01);
	}
}


