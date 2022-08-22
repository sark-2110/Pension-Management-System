package com.cognizant.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.ResourceNotFoundException;
import com.cognizant.model.AuthRequest;
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;
import com.cognizant.model.PensionerInput;
import com.cognizant.model.ProcessPensionInput;
import com.cognizant.model.ProcessPensionResponse;
import com.cognizant.model.Token;
import com.cognizant.restClient.AuthorizationClient;
import com.cognizant.restClient.ProcessPensionClient;

@RestController
@CrossOrigin(origins = "*")
public class PensionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionController.class);
	private AuthorizationClient authorizationClient;
	private ProcessPensionClient processPensionClient;

	@Autowired
	public PensionController(AuthorizationClient authorizationClient, ProcessPensionClient processPensionClient) {
		this.authorizationClient = authorizationClient;
		this.processPensionClient = processPensionClient;
	}

	// starting message
	@GetMapping("/")
	public String display() {
		return "Pension management working";
	}

	// validating token with authorization microservice

	@PostMapping("/token")
	public ResponseEntity<?> doLogin(@RequestBody AuthRequest authRequest) {
		LOGGER.info("STARTED - doLogin");
		String token = null;
		try {
			token = authorizationClient.generateToken(authRequest);

		} catch (Exception e) {
			LOGGER.error("EXCEPTION - doLogin");
			throw new ResourceNotFoundException("token can't be generated");
		}

		System.out.println("Token is : "+token);
		LOGGER.debug(token);

		LOGGER.info("END - doLogin");
		return ResponseEntity.ok(new Token(token));
	}

	// getting pensioner details from pensioner details micro service

	@GetMapping("/details")
	public List<PensionerDetail> allDetail() {
		LOGGER.info("STARTED - allDetail");
		List<PensionerDetail> pensionerDetail = null;
		try {
			pensionerDetail = processPensionClient.allDetail();
		} catch (Exception e) {
			throw new ResourceNotFoundException("pensioner detail list not found");
		}
		LOGGER.info("END - allDetail");
		return pensionerDetail;

	}

	// calculating pension details for input pensioner details with pensioner micro
	// service
	@PostMapping("/pensionDetail")
	public ResponseEntity<PensionDetail> getPensionDetail(@RequestHeader(name = "Authorization") String token,
			@RequestBody PensionerInput pensionerInput) {
		LOGGER.info("STARTED - getPensionDetail");
		try {
			authorizationClient.authorization(token);
		} catch (Exception e) {
			LOGGER.error("EXCEPTION - getPensionDetail");
			throw new ResourceNotFoundException("enter a valid token");
		}
		PensionDetail pensionDetail = processPensionClient.getPensionDetail(token, pensionerInput);
		LOGGER.info("END - getPensionDetail");
		return ResponseEntity.ok(pensionDetail);

	}

	// return Success or failure code based on given pension disburse input
	// providing with pension disbursement micro service
	@PostMapping("/processPension")
	public ResponseEntity<ProcessPensionResponse> getStatusCode(@RequestHeader(name = "Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput) {
		LOGGER.info("STARTED - getStatusCode");
		try {
			authorizationClient.authorization(token);
		} catch (Exception e) {
			LOGGER.error("EXCEPTION - getStatusCode");
			throw new ResourceNotFoundException("enter a valid token");
		}
		LOGGER.info("END - getStatusCode");
		ProcessPensionResponse processPensionResponse = processPensionClient.getPensionDisbursement(token, processPensionInput);
		return ResponseEntity.ok(processPensionResponse);
	}

}
