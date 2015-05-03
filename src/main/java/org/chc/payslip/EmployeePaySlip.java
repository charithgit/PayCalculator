package org.chc.payslip;


/**
 * Employee payslip is represented in this class.
 * @author Charith
 *
 */
public class EmployeePaySlip {

	Employee employee;	
	
	private String payPeriod;
	private double grossIncome;
	private double incomeTax;
	private double netIncome;
	private double superContribution;
	


	
	private static final float taxBracketRatioOne 	=0.19f;
	private static final float taxBracketRatioTwo 	=0.325f;
	private static final float taxBracketRatioThree	=0.37f;
	private static final float taxBracketRatioFour 	=0.45f;
	
	//TODO introduce static methods to calculate payslips.
	
	public EmployeePaySlip(Employee emp){
		this.employee = emp;
		
	}
	
	public String getPayPeriod() {
		return payPeriod;
	}
	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}
	public double getGrossIncome() {
		return grossIncome;
	}
	public void setGrossIncome(double grossIncome) {
		this.grossIncome = grossIncome;
	}
	public double getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(double incomeTax) {
		this.incomeTax = incomeTax;
	}
	public double getNetIncome() {
		return netIncome;
	}
	public void setNetIncome(double netIncome) {
		this.netIncome = netIncome;
	}
	public double getSuperContribution() {
		return superContribution;
	}
	public void setSuperContribution(double superContribution) {
		this.superContribution = superContribution;
	}
	
	public Employee getEmployee(){
		return this.employee;
	}
	
	public void calculatePaySlip(){
		
		this.payPeriod = employee.getPayStartDate();
		this.grossIncome = calculateGrossIncome(employee.getAnnualSalary());
		this.incomeTax = calculateIncomeTax(employee.getAnnualSalary());
		this.netIncome = grossIncome - incomeTax;
		this.superContribution = calculateSuperContriution(grossIncome,employee.getSuperRate());		
		
	}


	private double calculateSuperContriution(double grossIncome,double superRate) {
		return Math.round(grossIncome * (superRate/100));
	}
	
	
	/*
	 * Calculate Income Tax based on the following table.
	 * 
	 * Taxable income   Tax on this income
			  	  0 - $18,200       Nil
			$18,201 - $37,000       19c for each $1 over $18,200
			$37,001 - $80,000       $3,572 plus 32.5c for each $1 over $37,000
			$80,001 - $180,000      $17,547 plus 37c for each $1 over $80,000
			$180,001 and over       $54,547 plus 45c for each $1 over $180,000

	 */
	private double calculateIncomeTax(double annualSalary) {
		double incomTax ;
		
		if(annualSalary<=18200){
			incomTax = 0;
		}else
			if(annualSalary<=37000){
				incomTax = ((annualSalary-18201)* taxBracketRatioOne)/12; 	
			}else
				if(annualSalary<=80000){
					incomTax = (((annualSalary-37000)* taxBracketRatioTwo)+3572)/12;
				}else
					if(annualSalary<=180000){
						incomTax = (((annualSalary-80000)* taxBracketRatioThree)+17547)/12;
					}else{
						incomTax = (((annualSalary-180000)* taxBracketRatioFour)+54547)/12;
					}
						
	
		
		System.out.println("income tax befor rounding" +incomTax);
		return Math.round(incomTax);
	}

	private double calculateGrossIncome(double annualSalary) {
		
		return Math.round(annualSalary/12);
	}	
	
}
