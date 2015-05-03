package org.chc.payslip;

import static org.junit.Assert.*;

import java.io.DataOutput;
import java.util.ArrayList;

import org.chc.payslip.io.ExcelDataOutput;
import org.junit.Test;

public class ExcelDataOutputTest {

	@Test
	public void testWriteEmployeeData() {
		
		Employee aEmployee = new Employee("David","Rudd",9,18200,"01 March – 31 March");
		EmployeePaySlip aPaySlip = new EmployeePaySlip(aEmployee);
		aPaySlip.calculatePaySlip();
		ArrayList<EmployeePaySlip> paySlips = new ArrayList<EmployeePaySlip>();
		paySlips.add(aPaySlip);
		ExcelDataOutput.getInstance().write("C:\\DELME\\payslips.csv", paySlips);
			
	}

}
