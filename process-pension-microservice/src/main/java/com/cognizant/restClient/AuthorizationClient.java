package com.cognizant.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authorizationService",url = "http://localhost:8081")
public interface AuthorizationClient {
	
	@GetMapping("/authorize")
	public Boolean authorization(@RequestHeader("Authorization") String token);

}
