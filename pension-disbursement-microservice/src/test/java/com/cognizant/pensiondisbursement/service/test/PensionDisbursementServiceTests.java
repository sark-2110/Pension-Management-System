package com.cognizant.pensiondisbursement.service.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.model.ProcessPensionInput;
import com.cognizant.service.PensionDisbrusmentService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PensionDisbursementServiceTests {
	ProcessPensionInput processPensionInput = new ProcessPensionInput("1234567891011120", 6069.98, 550);
	ProcessPensionInput processPensionInput1 = new ProcessPensionInput("1234567891011121", 6069.98, 550);
	ProcessPensionInput processPensionInput2 = new ProcessPensionInput("12345678910120", 60, 550);
	ProcessPensionInput processPensionInput3 = new ProcessPensionInput("12345678910120", 6000, 550);
	ProcessPensionInput processPensionInput4 = new ProcessPensionInput("1234567891011120", 6069.98, 500);
	ProcessPensionInput processPensionInput5 = new ProcessPensionInput("123456789101112000", 6069.98, 550);
	ProcessPensionInput processPensionInput6 = new ProcessPensionInput("12345678910111", 6069.98, 550);

	@Autowired
	private PensionDisbrusmentService pensionDisbursementService;

	@Test
	public void contextLoads() {
		assertNotNull(pensionDisbursementService);
	}

	@Test
	public void checkPrivateBankTestSuccess() throws Exception {
		assertEquals(true, pensionDisbursementService.inputBankCharge("private", 550.0));

	}
	@Test
	public void checkPublicBankTestSuccess() throws Exception {
		assertEquals(true, pensionDisbursementService.inputBankCharge("public", 500.0));

	}
	
	@Test
	public void checkPrivateBankTestFailure() throws Exception {
		assertNotEquals("false", pensionDisbursementService.inputBankCharge("private", 500));

	}
	@Test
	public void checkPublicBankTestFailure() throws Exception {
		assertNotEquals("false", pensionDisbursementService.inputBankCharge("public", 550));

	}


}
