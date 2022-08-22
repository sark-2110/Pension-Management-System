package com.cognizant.model;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionerDetail {	
	@Id
	private String aadhaarNumber;						// Entering the Aadhaar Number  of Pensioner
	private String name;								// Entering the name of Pensioner
	private String dateOfBirth;							// Entering the DOB of Pensioner
	private String panNumber;							// Entering the pan number of Pensioner
	private double salary;								// Entering the Salary of Pensioner
	private double allowance;							// Entering the Allowance of Pensioner
	private String pensionType;							// Entering the Pension Type of Pensioner
	@Embedded
	private BankDetail bankDetail;
	public PensionerDetail() {
		
	}
	public PensionerDetail(String aadhaarNumber, String name, String dateOfBirth, String panNumber, double salary,
			double allowance, String pensionType, BankDetail bankDetail) {
		super();
		this.aadhaarNumber = aadhaarNumber;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.panNumber = panNumber;
		this.salary = salary;
		this.allowance = allowance;
		this.pensionType = pensionType;
		this.bankDetail = bankDetail;
	}
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getAllowance() {
		return allowance;
	}
	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	public String getPensionType() {
		return pensionType;
	}
	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}
	public BankDetail getBankDetail() {
		return bankDetail;
	}
	public void setBankDetail(BankDetail bankDetail) {
		this.bankDetail = bankDetail;
	}
}
