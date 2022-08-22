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
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;
import com.cognizant.model.PensionerInput;
import com.cognizant.model.ProcessPensionInput;
import com.cognizant.model.ProcessPensionResponse;
import com.cognizant.restClient.PensionerDetailClient;
import com.cognizant.service.ProcessPensionService;

@RestController
public class ProcessPensionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessPensionController.class);
	private PensionerDetailClient pensionerDetailClient;
	private ProcessPensionService processPensionService;

	@Autowired
	public ProcessPensionController(PensionerDetailClient pensionerDetailClient,ProcessPensionService processPensionService) {
		this.pensionerDetailClient = pensionerDetailClient;
		this.processPensionService = processPensionService;
	}

	//getting all details from pensioner details micro service
	@GetMapping("/details")
	public List<PensionerDetail> allDetail() {
		LOGGER.info("STARTED - allDetail");
		List<PensionerDetail> pensionerDetail = pensionerDetailClient.getAllDetail();
		LOGGER.info("END - allDetail");
		return pensionerDetail;
	}

	//generating pension detail with pension amount for given user input
	@PostMapping("/pensionerInput")
	public PensionDetail getPensionDetail(@RequestHeader(name = "Authorization") String token,
			@RequestBody PensionerInput pensionerInput) {
		LOGGER.info("STARTED - allDetail");
		PensionDetail pensionDetail = null;
		try {
			pensionDetail = processPensionService.getPensionDetail(
					pensionerDetailClient.findByAadhaarNumber(token, pensionerInput.getAadhaarNumber()),
					pensionerInput);

		} catch (Exception e) {
			LOGGER.error("EXCEPTION - allDetail");
			throw new ProcessPensionException("Pensioner Detail not coreect");
		}
		LOGGER.info("END - allDetail");
		return processPensionService.savePensionDetail(pensionDetail);

	}

	
	//success code in case of valid pension amount 
	@PostMapping("/disbursePension")
	public ProcessPensionResponse getStatusCode(@RequestHeader(name = "Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput) {
		LOGGER.info("STARTED - getStatusCode");
		LOGGER.info("END - getStatusCode");
//		PensionDetail pensionDetail = null;
//		PensionerDetail pensionerDetail = null;
//		PensionerInput pensionerInput = null;
		ProcessPensionResponse processResponse = null;
		//try {
			PensionerDetail pensionerDetail = pensionerDetailClient.findByAadhaarNumber(token, processPensionInput.getAadhaarNumber());
			LOGGER.info("PensionerDetail "+pensionerDetail);
			PensionerInput pensionerInput = new PensionerInput(processPensionInput.getAadhaarNumber());
			LOGGER.info("PensionerInput "+pensionerInput);
			PensionDetail pensionDetail = processPensionService.getPensionDetail(pensionerDetail, pensionerInput);
			if(pensionDetail.getPensionAmount()==(processPensionInput.getPensionAmount()-processPensionInput.getBankCharge())) {
				LOGGER.info("True ",pensionDetail.getPensionAmount());
				processResponse = new ProcessPensionResponse(10);
			}
			else {
				processResponse = new ProcessPensionResponse(21);
			}
			
		//}
		//catch(Exception e) {
			
		//}
		return processResponse;
	}

}
