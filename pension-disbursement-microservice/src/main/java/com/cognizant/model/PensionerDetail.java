package com.cognizant.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PensionerDetail {
	
	private String aadhaarNumber;
	private String name;
	private String dateOfBirth;
	private String panNumber;
	private double salary;
	private double allowance;
	private String pensionType;
	private BankDetail bankDetail;

}
