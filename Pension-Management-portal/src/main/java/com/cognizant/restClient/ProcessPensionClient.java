package com.cognizant.restClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;
import com.cognizant.model.PensionerInput;
import com.cognizant.model.ProcessPensionInput;
import com.cognizant.model.ProcessPensionResponse;

@FeignClient(name = "ProcessPensionService", url="http://localhost:9084")
public interface ProcessPensionClient {
	
	ProcessPensionResponse ProcessPensionResponse = null;

	@PostMapping("/pensionerInput")
	public PensionDetail getPensionDetail(@RequestHeader(name = "Authorization") String token, @RequestBody PensionerInput pensionerInput);

	@GetMapping("/details")
	public List<PensionerDetail> allDetail();
	
	@PostMapping("/disbursePension")
	public ProcessPensionResponse getPensionDisbursement(@RequestHeader(name = "Authorization") String token,
			@RequestBody ProcessPensionInput processPensionInput);	
}
