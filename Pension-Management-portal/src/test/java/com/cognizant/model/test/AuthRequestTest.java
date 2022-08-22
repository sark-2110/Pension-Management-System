package com.cognizant.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.AuthRequest;

@SpringBootTest
public class AuthRequestTest {

	@Test
	void beanCreationTest() {
		assertNotNull(new AuthRequest());
	}

	@Test
	void noArgsConstructorTest() {
		AuthRequest authRequest = new AuthRequest();
		assertNotNull(authRequest);
	}

	@Test
	void AllArgsConstructorTest() {
		AuthRequest authRequest = new AuthRequest("Iftak", "password1");
		assertNotNull(authRequest);
	}

	@Test
	void settersTest() {
		AuthRequest authRequest = new AuthRequest();
		authRequest.setPassword("fwrgeqhte");
		authRequest.setUserName("Pratyush");
		assertNotNull(authRequest) ;
	}

	@Test
	void gettersTest() {
		AuthRequest authRequest = new AuthRequest("Iftak", "password1");
		assertEquals("Iftak", authRequest.getUserName());
		assertEquals("password1", authRequest.getPassword());
	}

}
