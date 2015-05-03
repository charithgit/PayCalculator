package org.chc.payslip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Main Class for the Program.
 * @author Charith
 *
 */
public class PaySlipCalculatorMain {

	public static void main(String[] args) {
		
		byte[] dataInput = new byte[2048];
		String inputLocation=null;
		String outputLocation=null;
		
		System.out.print("Please Input the location  of the input file :");
		BufferedReader bri = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			inputLocation = bri.readLine();
	      } catch (IOException ioe) {
	         System.out.println("IO error trying to read input location !");
	         System.exit(1);
	      }
		
		System.out.print("Please enter the location you want to save the output file :");
		BufferedReader bro = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			outputLocation = bro.readLine();
	      } catch (IOException ioe) {
	         System.out.println("IO error trying to read input location !");
	         System.exit(1);
	      }
			
		EmployeePaySlipGenerator.generatePaySlips(inputLocation, outputLocation);
		
		
		
		
	}

}
