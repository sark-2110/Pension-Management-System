package com.cognizant.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "authorizationService",url = "http://localhost:9090")
public interface AuthorizationClient {
	
	// validation of jwt token with authorization micro-service
	
	@GetMapping("/authorize")
	public Boolean authorization(@RequestHeader("Authorization") String token);

}
