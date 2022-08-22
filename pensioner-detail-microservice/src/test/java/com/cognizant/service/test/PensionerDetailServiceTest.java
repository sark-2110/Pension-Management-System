package com.cognizant.service.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cognizant.model.BankDetail;
import com.cognizant.model.PensionerDetail;
import com.cognizant.service.PensionarDetailServiceImpl;

@SpringBootTest(classes = PensionerDetailServiceTest.class)
@AutoConfigureMockMvc
public class PensionerDetailServiceTest {

	@InjectMocks
	private PensionarDetailServiceImpl pds;

	@Test
	public void testNotNullPensionDetailServiceObject() {
		assertNotNull(pds);
	}

	@Test
	public void testPensionerDetailFunction() {
		BankDetail bankDetail = new BankDetail("SBI", "1234567743", "public");
		PensionerDetail pensionerDetail = new PensionerDetail("1234567890", "Pratyush", "06-11-1999", "PASW33334DW",
				30000.0, 12000.0, "family", bankDetail);
		assertNotNull(bankDetail);
	}



}
