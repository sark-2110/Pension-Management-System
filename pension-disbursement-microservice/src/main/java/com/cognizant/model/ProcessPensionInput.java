package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessPensionInput {
	
	private String aadhaarNumber;
	private double pensionAmount;
	private double bankServiceCharge;

}
