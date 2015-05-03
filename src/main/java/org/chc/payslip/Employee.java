package org.chc.payslip;

/**
 * Represents a Employee in the system.
 * 
 * @author Charith
 */

public class Employee {

	private String firstName;
	private String lastName;
	private double superRate;
	private String payStartDate;
	private double annualSalary;
	
	// Constructor 
	public Employee(String fName, String lName, double sRate,double salary, String payDate)
	{
		this.firstName = fName;
		this.lastName = lName;
		this.superRate = sRate;
		this.annualSalary = salary;
		this.payStartDate = payDate;		
	}
	
	// Constructor 
	public Employee(){
		
	}

	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSuperRate() {
		return superRate;
	}

	public void setSuperRate(double superRate) {
		this.superRate = superRate;
	}

	public String getPayStartDate() {
		return payStartDate;
	}

	public void setPayStartDate(String payStartDate) {
		this.payStartDate = payStartDate;
	}

}
