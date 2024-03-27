package com.hexaware.test;
import com.hexaware.main.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import com.hexaware.controller.TaxController;

import com.hexaware.exception.DatabaseConnectionException;
import com.hexaware.exception.TaxCalculationException;

public class VerifyTaxCalculation {
    @Test
	public void testTaxCalculation() throws  TaxCalculationException, DatabaseConnectionException {
		
		int id = 7;
        String year = "2024";
        double netSalary = 7000;
        
		TaxController tc = new TaxController();
		
		
		try {
			
			double taxAmount = tc.calcualteTax1(id, year);
			
			double expectedTaxAmount = netSalary * 12 * 0.03; 
			
			//checking expected tax amount nd actual tax amount are equal
			assertEquals("Tax amount should match", expectedTaxAmount, taxAmount, 0.01);
			
		}catch(TaxCalculationException | DatabaseConnectionException | SQLException e) {
			System.out.println("Error:(");
		}
		
	}
}
