package com.cognizant.restClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.AuthRequest;

@FeignClient(name = "authorizationService",url = "http://localhost:9090")
public interface AuthorizationClient {
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception; 

	@GetMapping("/authorize")
	public Boolean authorization(@RequestHeader("Authorization") String token);

}
