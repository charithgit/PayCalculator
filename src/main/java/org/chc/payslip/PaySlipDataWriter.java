package org.chc.payslip;

import java.util.ArrayList;

import org.chc.payslip.io.ExcelDataOutput;
/**
 * Controls the data writin of the program.
 * @author Charith
 *
 */
public class PaySlipDataWriter {
	
	/**
	 * Method to write payslip details from a given input 
	 * @param location - Location the file need to write to  
	 * @param fileName - File name to read 
	 * @return - List<Employees> 
	 */
	public static void writePayslipData(String location, String fileName,ArrayList<EmployeePaySlip> data){
		String empDetailsOutput = location+fileName;
		ExcelDataOutput.getInstance().write(empDetailsOutput,data);
	}
}
