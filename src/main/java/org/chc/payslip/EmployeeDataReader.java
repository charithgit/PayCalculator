package org.chc.payslip;

import java.util.List;

import org.chc.payslip.io.ExcelDataInput;
/**
 * Controller for data reading.
 * @author Charith
 *
 */
public class EmployeeDataReader {
	
	/**
	 * Method to read employee details from a given input 
	 * @param location - Locaton the input is from 
	 * @param fileName - File name to read 
	 * @return - List<Employees> 
	 */
	public static List<Employee> readEmployeeData(String location, String fileName){
		String empDetailsInput = location+fileName;
		return ExcelDataInput.getInstance().read(empDetailsInput);
	}
}
