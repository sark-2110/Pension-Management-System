package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProcessPensionMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessPensionMicroserviceApplication.class, args);
	}

}
