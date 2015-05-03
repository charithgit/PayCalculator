package org.chc.payslip;

import java.util.ArrayList;
import java.util.List;
/**
 * Control the flow of the program by reading the input and writing the output.
 * @author Charith
 *
 */
public class EmployeePaySlipGenerator {

	static final String DEFAULT_INPUT_LOCATION="C:\\DELME\\";
	static final String DEFAULT_OUTPUT_LOCATION="C:\\DELME\\";
	static final String DEFAULT_INPUT_FILE="employee.csv";
	static final String DEFAULT_OUTPUT_FILE="payslips.csv";
	
	private static String inputDataLocation;
	private static String outputDataLocation;
	
	/*
	 * Method to generate the pay slips  from the given inputs.
	 */
	public static void generatePaySlips(String inputLocation, String outputLocation){
		if(inputLocation==null||inputLocation.isEmpty()){
			inputDataLocation = DEFAULT_INPUT_LOCATION;
		}
		else{
			inputDataLocation = inputLocation;
		}
		
		if(outputLocation==null||outputLocation.isEmpty()){
			outputDataLocation = DEFAULT_OUTPUT_LOCATION;
		}else
		{
			outputDataLocation = outputLocation;
		}
		
		List<Employee> employees = EmployeeDataReader.readEmployeeData(inputDataLocation ,DEFAULT_INPUT_FILE);
		
		generate(employees);		
		
	}
	
	private static void generate(List<Employee> employees){
		ArrayList<EmployeePaySlip> paySlips = new ArrayList<EmployeePaySlip>();
		for(Employee emp : employees){
			EmployeePaySlip aPaySlip = new EmployeePaySlip(emp);
			aPaySlip.calculatePaySlip();
			paySlips.add(aPaySlip);
			
		}
		PaySlipDataWriter.writePayslipData(outputDataLocation, DEFAULT_OUTPUT_FILE, paySlips);
		
	}
}

