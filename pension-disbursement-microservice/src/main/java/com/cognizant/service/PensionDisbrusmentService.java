package com.cognizant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cognizant.model.PensionerDetail;
import com.cognizant.model.ProcessPensionInput;
import com.cognizant.model.ProcessPensionResponse;

@Service
public class PensionDisbrusmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionDisbrusmentService.class);

	private int successCode = 10;
	private int failedCode = 21;

	//Returning success response in case of matching pension amount for given user.
	
	public ProcessPensionResponse statusCode(PensionerDetail pensionerDetail, ProcessPensionInput processPensionInput) {

		LOGGER.info("STARTED - statusCode");
		String bankType = pensionerDetail.getBankDetail().getBankType();
		double bankServiceCharge = processPensionInput.getBankServiceCharge();

		if (inputBankCharge(bankType, bankServiceCharge)
				&& calculatePension(pensionerDetail, processPensionInput.getPensionAmount())) {
			LOGGER.info("END - statusCode - sucess");
			return new ProcessPensionResponse(successCode);
		}

		LOGGER.info("END - statusCode - fail");
		return new ProcessPensionResponse(failedCode);
	}

	//calculating pension amount for different types of pension
	
	public boolean calculatePension(PensionerDetail pensionerDetail, double pensionInput) {
		LOGGER.info("STARTED - calculatePension");
		double pensionAmount = 0;
		if (pensionerDetail.getPensionType().equalsIgnoreCase("self")) {
			pensionAmount = 0.8 * pensionerDetail.getSalary() + pensionerDetail.getAllowance();
		} else if (pensionerDetail.getPensionType().equalsIgnoreCase("family")) {
			pensionAmount = 0.5 * pensionerDetail.getSalary() + pensionerDetail.getAllowance();
		}
		LOGGER.info("END - calculatePension");
		return pensionAmount == pensionInput;
	}

	//checking bank charge for private and public banks
	
	public boolean inputBankCharge(String bankType, double bankCharge) {

		LOGGER.info("STARTED - inputBankCharge");
		if (bankType.equalsIgnoreCase("private")) {
			if (bankCharge == 550) {
				LOGGER.info("END - inputBankCharge - private - true");
				return true;
			} else {
				LOGGER.info("END - inputBankCharge - private - false");
				return false;
			}
		}
		if (bankType.equalsIgnoreCase("public")) {
			if (bankCharge == 500) {
				LOGGER.info("END - inputBankCharge - public - true");
				return true;
			} else {
				LOGGER.info("END - inputBankCharge - public - false");
				return false;
			}
		}
		LOGGER.info("END - inputBankCharge - false");
		return false;
	}

}
