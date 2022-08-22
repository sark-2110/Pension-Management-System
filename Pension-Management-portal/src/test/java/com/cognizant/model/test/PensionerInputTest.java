package com.cognizant.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.PensionerInput;

@SpringBootTest
public class PensionerInputTest {
	
	PensionerInput pensionerInput = new PensionerInput() ;
	
	@Test
	void checkBeanCreation() {
		assertNotNull(pensionerInput) ;
	}
	
	@Test
	void noArgsConstructorTest() {
		PensionerInput pensionerInput1 = new PensionerInput() ;
		assertNotNull(pensionerInput1) ;
	}
	
	@Test
	void allArgsConstructorTest() {
		PensionerInput pensionerInput1 = new PensionerInput("Pratyush", "06-11-1999", "ILPWW1234X", "12423543625625", "family") ;
		assertNotNull(pensionerInput1) ;
	}	
	
	@Test
	void getterTest() {
		PensionerInput pensionerInput1 = new PensionerInput() ;
		pensionerInput1.setName("Pratyush");
		pensionerInput1.setDateOfBirth("11-12-2000");
		pensionerInput1.setPanNumber("INFEOG2124");
		pensionerInput1.setAadhaarNumber("1342353463565");
		pensionerInput1.setPensionType("family");
		
		assertNotNull(pensionerInput1) ;
	}
	
	@Test
	void allGettersTest() {
		PensionerInput pensionerInput1 = new PensionerInput("Pratyush", "06-11-1999", "ILPWW1234X", "12423543625625", "family") ;
		assertEquals("Pratyush", pensionerInput1.getName()) ; 
		assertEquals("06-11-1999", pensionerInput1.getDateOfBirth()) ; 
		assertEquals("ILPWW1234X", pensionerInput1.getPanNumber()) ; 
		assertEquals("12423543625625", pensionerInput1.getAadhaarNumber()) ; 
		assertEquals("family", pensionerInput1.getPensionType()) ; 
	}	

}








