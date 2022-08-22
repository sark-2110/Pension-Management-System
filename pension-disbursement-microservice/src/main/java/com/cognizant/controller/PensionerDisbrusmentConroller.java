package com.cognizant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.ProcessPensionException;
import com.cognizant.model.PensionerDetail;
import com.cognizant.model.ProcessPensionInput;
import com.cognizant.model.ProcessPensionResponse;
import com.cognizant.restClient.PensionerDetailClient;
import com.cognizant.service.PensionDisbrusmentService;

@RestController
public class PensionerDisbrusmentConroller {

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDisbrusmentConroller.class);

	private PensionerDetailClient pensionerDetailClient;

	private PensionDisbrusmentService pensionDisbrusmentService;

	@Autowired
	public PensionerDisbrusmentConroller(PensionerDetailClient pensionerDetailClient,
			PensionDisbrusmentService pensionDisbrusmentService) {

		this.pensionerDetailClient = pensionerDetailClient;
		this.pensionDisbrusmentService = pensionDisbrusmentService;
	}
	
	//pension amount matched for the provided input will return successcode

	@PostMapping("/disbursePension")
	public ProcessPensionResponse getPensionDisbursement(@RequestHeader(name = "Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput) {
		LOGGER.info("STARTED - getPensionDisbursement");
		ProcessPensionResponse processPensionResponseCode = null;
		try {
			processPensionResponseCode = pensionDisbrusmentService.statusCode(
					pensionerDetailClient.findByAadhaarNumber(token, processPensionInput.getAadhaarNumber()),
					processPensionInput);
		} catch (Exception e) {
			LOGGER.error("EXCEPTION - getPensionDisbursement");
			throw new ProcessPensionException("Pension Amoount is not correct");
		}
		LOGGER.info("END - getPensionDisbursement");
		return processPensionResponseCode;

	}
	
	//getting pensioner details from pensioner details microservice

	@GetMapping("/details")
	public List<PensionerDetail> allDetail() {
		LOGGER.info("STARTED - allDetail");
		List<PensionerDetail> pensionerDetail = pensionerDetailClient.getAllDetail();
		LOGGER.info("END - allDetail");
		return pensionerDetail;
	}

}
