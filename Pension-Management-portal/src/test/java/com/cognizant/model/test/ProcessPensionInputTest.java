package com.cognizant.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.ProcessPensionInput;

@SpringBootTest
public class ProcessPensionInputTest {

	@Test
	void beanCreationTest() {
		assertNotNull(new ProcessPensionInput()) ;
	}
	
	@Test
	void noArgsConstructorTest() {
		ProcessPensionInput ppi = new ProcessPensionInput() ;
		assertNotNull(ppi) ;
	}
	
	@Test 
	void allArgsConstructorTest() {
		ProcessPensionInput ppi = new ProcessPensionInput("4254362356623", 40000.00, 550.00) ;

	}
	
	@Test
	void settersTest() {
		ProcessPensionInput ppi = new ProcessPensionInput() ;
		ppi.setAadhaarNumber("2432545236576245");
		ppi.setBankServiceCharge(550);
		ppi.setPensionAmount(40000);
		assertNotNull(ppi) ;

	}
	
	@Test
	void gettersTest() {
		ProcessPensionInput ppi = new ProcessPensionInput("4254362356623", 40000.00, 550.00) ;
		String aadhaar = ppi.getAadhaarNumber() ;
		Double pensionAmount = ppi.getPensionAmount() ;
		Double bankCharge = ppi.getBankServiceCharge() ;
		assertEquals("4254362356623", aadhaar) ;
		assertEquals(40000.00, pensionAmount) ;
		assertEquals(550.00, bankCharge) ;

	}
	
	
	
}
