package org.chc.payslip.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.chc.payslip.Employee;

/**
 * Represent a ExcelData Input.
 * @author Charith
 *
 */
public class ExcelDataInput implements DataInput {

	private static ExcelDataInput obj;
	private static final String[] FILE_HEADER_MAPPING = { "name", "last_name",
			"annual_salary", "super_rate", "payment_start_date" };
	private static final String EMP_NAME = "name";
	private static final String EMP_LNAME = "last_name";
	private static final String ANNUAL_SALARY = "annual_salary";
	private static final String SUPER_RATE = "super_rate";
	private static final String PAYMENT_START_DATE = "payment_start_date";

	// regex to validate the Name
	private static final String NAME_VALIDATE_REGEX = "[A-Z][a-zA-Z]*";
	// regex to validate salary
	private static final String SALARY_VALIDATE_REGEX = "^[1-9][0-9]*(\\.[0-9]+)?|0+\\.[0-9]*[1-9][0-9]*$.";
	// regex to validate number
	private static final String NUMBER_VALIDATE_REGEX = "^\\d+$";

	public static ExcelDataInput getInstance() {
		if (obj == null) {
			obj = new ExcelDataInput();
		}
		return obj;
	}

	public List<Employee> read(String input) {

		FileReader fileReader = null;
		CSVParser csvFileParser = null;
		// Create the CSVFormat object with the header mapping
		CSVFormat csvFileFormat = CSVFormat.DEFAULT
				.withHeader(FILE_HEADER_MAPPING);

		List<Employee> employees = new ArrayList<Employee>();

		try {
			// Create a new list of student to be filled by CSV file data

			// initialize FileReader object
			fileReader = new FileReader(input);
			// initialize CSVParser object
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			Employee aEmloyee;
			List<CSVRecord> csvRecords = csvFileParser.getRecords();

			for (int i = 1; i < csvRecords.size(); i++) {

				CSVRecord record = csvRecords.get(i);
				if (validateRecord(record)) {

					aEmloyee = new Employee();
					aEmloyee.setFirstName(record.get(EMP_NAME));
					aEmloyee.setLastName(record.get(EMP_LNAME));
					aEmloyee.setAnnualSalary(Double.parseDouble(record
							.get(ANNUAL_SALARY)));
					aEmloyee.setSuperRate(Double.parseDouble(record.get(
							SUPER_RATE).replace("%", "")));
					aEmloyee.setPayStartDate(record.get(PAYMENT_START_DATE));
					employees.add(aEmloyee);
				}
			}

		} catch (NumberFormatException nfe) {
			System.out.println("Invalid format found !!!");
			nfe.printStackTrace();
		} catch (Exception e) {

			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();

				csvFileParser.close();

			} catch (IOException e) {
				System.out
						.println("Error while closing fileReader/csvFileParser !!!");

				e.printStackTrace();
			}
		}

		return employees;
	}

	/*
	 * Validate the CSV records and create a valid employee object.
	 * 
	 * @return - Employee object on valid and NULL if not valid.
	 */
	private boolean validateRecord(CSVRecord aRecord) throws Exception {
		// Validate First Name
		if (!(aRecord.get(EMP_NAME).matches(NAME_VALIDATE_REGEX))) {
			throw new Exception("Invalid data :" + EMP_NAME + " input was"
					+ aRecord.get(EMP_NAME));
		}

		if (!(aRecord.get(EMP_LNAME).matches(NAME_VALIDATE_REGEX))) {
			throw new Exception("Invalid data :" + EMP_LNAME + " input was "
					+ aRecord.get(EMP_LNAME));
		}

		if (!(aRecord.get(ANNUAL_SALARY).matches(SALARY_VALIDATE_REGEX))) {
			throw new Exception("Invalid data :" + ANNUAL_SALARY
					+ " input was " + aRecord.get(ANNUAL_SALARY));
		}

		if (!(aRecord.get(SUPER_RATE).replace("%", "")
				.matches(NUMBER_VALIDATE_REGEX))) {

			throw new Exception("Invalid data :" + SUPER_RATE + " input was "
					+ aRecord.get(SUPER_RATE));
		}

		return true;
	}
}