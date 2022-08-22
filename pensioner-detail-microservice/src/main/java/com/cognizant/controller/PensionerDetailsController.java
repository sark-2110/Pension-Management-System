package com.cognizant.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.exception.ResourceNotFoundException;
import com.cognizant.model.PensionerDetail;
import com.cognizant.repository.PensionerDetailRepository;
import com.cognizant.restclient.AuthorizationClient;
import com.cognizant.service.PensionarDetailServiceImpl;

@RestController
public class PensionerDetailsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDetailsController.class);
	private AuthorizationClient authorizationClient;
	private PensionerDetailRepository pensionerDetailRepository;

	@Autowired
	public PensionerDetailsController(PensionerDetailRepository pensionerDetailRepository,
			PensionarDetailServiceImpl pensionarDetailServiceImpl, AuthorizationClient authorizationClient) {
		this.pensionerDetailRepository = pensionerDetailRepository;
		this.authorizationClient = authorizationClient;
	}

	//authorizing end point with jwt token 
	
	//Returning pensioner detail for provided aadhaar number 
	
	@GetMapping("/pensionerDetail/{aadhaarNumber}")
	public PensionerDetail findByAadhaarNumber(@RequestHeader("Authorization") String token,
			@PathVariable String aadhaarNumber) throws Exception {
		LOGGER.info("STARTED - findByAadhaarNumber");

		if (authorizationClient.authorization(token)) {
			PensionerDetail pensionerDetail = pensionerDetailRepository.findById(aadhaarNumber)
					.orElseThrow(() -> new ResourceNotFoundException("employee with aadhaar number not found"));
			LOGGER.info("END - findByAadhaarNumber");
			return pensionerDetail;
		} else {
			LOGGER.error("EXCEPTION - findByAadhaarNumber");
			throw new Exception("token is not valid");
		}
	}

	
	// all pensioner details
	
	@GetMapping("/allDetails")
	public List<PensionerDetail> getAllDetail() {
		LOGGER.info("STARTED - getAllDetail");
		LOGGER.info("END - getAllDetail");
		return pensionerDetailRepository.findAll();

	}

}
