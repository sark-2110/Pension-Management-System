package com.cognizant.model.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.ProcessPensionResponse;

@SpringBootTest
public class ProcessPensionResponseTest {

	@Test
	void beanCreationTest() {
		assertNotNull(new ProcessPensionResponse());
	}

	@Test
	void noArgsConstructorTest() {
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		assertThat(assertThat(processPensionResponse).isNotNull());
	}

	@Test
	void allArgsConstructorTest() {
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(21);
		assertThat(assertThat(processPensionResponse).isNotNull());
	}
	
	@Test
	void setterForPensionStatusCodeTest()
	{
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(21); 
		
	}
	
	@Test
	void getterForPensionStatusCodeTest() {
		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(21);
		 int code = processPensionResponse.getProcessPensionStatusCode() ;
		 assertEquals(21, code) ; 
	}

}
