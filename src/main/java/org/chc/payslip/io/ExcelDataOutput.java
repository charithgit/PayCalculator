package org.chc.payslip.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.chc.payslip.EmployeePaySlip;

/**
 * Represent a Excel Data output.
 * @author Charith
 *
 */
public class ExcelDataOutput implements DataOutput<EmployeePaySlip> {
	private static ExcelDataOutput obj;
	ArrayList<EmployeePaySlip> dataToWrite;

	// Delimiter used in CSV file
	private static final String NEW_LINE_SEPARATOR = "\n";

	// CSV file header
	private static final Object[] FILE_HEADER = { "name", "pay period",
			"gross income", "income tax", "net income", "super" };


	public static ExcelDataOutput getInstance() {
		if (obj == null)
			obj = new ExcelDataOutput();
		return obj;
	}

	public boolean write(String fileName, ArrayList<EmployeePaySlip> data) {

		if (data == null) {
			System.out.println("-- No  Data to write .Exiting ! ");
			return false;
		}

		this.dataToWrite = data;

		FileWriter fileWriter = null;

		CSVPrinter csvFilePrinter = null;

		// Create the CSVFormat object with "\n" as a record delimiter
		CSVFormat csvFileFormat = CSVFormat.DEFAULT
				.withRecordSeparator(NEW_LINE_SEPARATOR);

		try {

			// initialize FileWriter object
			fileWriter = new FileWriter(fileName);

			// initialize CSVPrinter object
			csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

			// Create CSV file header
			csvFilePrinter.printRecord(FILE_HEADER);

			// Write a new student object list to the CSV file
			for (EmployeePaySlip paySlip : dataToWrite) {
				List<String> paySlipDataRecord = new ArrayList<String>();
				paySlipDataRecord.add(paySlip.getEmployee().getFirstName()
						.concat(" ")
						.concat(paySlip.getEmployee().getLastName()));
				paySlipDataRecord.add(paySlip.getPayPeriod());
				paySlipDataRecord.add(String.valueOf(paySlip.getGrossIncome()));
				paySlipDataRecord.add(String.valueOf(paySlip.getIncomeTax()));
				paySlipDataRecord.add(String.valueOf(paySlip.getNetIncome()));
				paySlipDataRecord.add(String.valueOf(paySlip
						.getSuperContribution()));
				csvFilePrinter.printRecord(paySlipDataRecord);
			}

			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
				csvFilePrinter.close();
			} catch (IOException e) {
				System.out
						.println("Error while flushing/closing fileWriter/csvPrinter !!!");
				e.printStackTrace();
			}
		}

		return false;
	}

}
