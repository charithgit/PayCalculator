package org.chc.payslip;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for testing the functionality of payslip calculation
 * @author Charith
 *
 */
public class PaySlipCalculatorTest {
	//Output (name, pay period, gross income, income tax, net income, super):
	//David Rudd,01 March – 31 March,5004,922,4082,450
	
	@Test
	public void testIncomeTaxFirstLevel() {
		
		Employee aEmployee = new Employee("David","Rudd",9,18200,"01 March – 31 March");
		EmployeePaySlip paySlip = new EmployeePaySlip(aEmployee);
		paySlip.calculatePaySlip();
		assertEquals("Income Tax calculation failed",0,paySlip.getIncomeTax(),0);
				
	}	

	
	@Test
	public void testIncomeTaxSecondLevel() {
		
		Employee aEmployee = new Employee("David","Rudd",9,21000,"01 March – 31 March");
		EmployeePaySlip paySlip = new EmployeePaySlip(aEmployee);
		paySlip.calculatePaySlip();
		assertEquals("Income Tax calculation failed",44,paySlip.getIncomeTax(),0);
		
	}
	
	@Test
	public void testIncomeTaxThirdLevel() {
			
		Employee aEmployee = new Employee("David","Rudd",9,60050,"01 March – 31 March");
		EmployeePaySlip paySlip = new EmployeePaySlip(aEmployee);
		paySlip.calculatePaySlip();
		paySlip.calculatePaySlip();
		assertEquals("Income Tax calculation failed",922,paySlip.getIncomeTax(),0);
		
	}
	
	@Test
	public void testIncomeTaxFourthLevel() {
		
		Employee aEmployee = new Employee("David","Rudd",9,99000,"01 March – 31 March");
		EmployeePaySlip paySlip = new EmployeePaySlip(aEmployee);
		paySlip.calculatePaySlip();
		assertEquals("Income Tax calculation failed",2048,paySlip.getIncomeTax(),0);
		
	}
	
	@Test
	public void testIncomeTaxHighestLevel() {
		
		Employee aEmployee = new Employee("David","Rudd",9,230000,"01 March – 31 March");
		EmployeePaySlip paySlip = new EmployeePaySlip(aEmployee);
		paySlip.calculatePaySlip();
		assertEquals("Income Tax calculation failed",6421,paySlip.getIncomeTax(),0);
		
	}
	
}
