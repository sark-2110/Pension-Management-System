package com.cognizant.model.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.PensionDetail;

@SpringBootTest
public class PensionDetailTest {

	PensionDetail pensionDetails = new PensionDetail();

	@Test
	public void BankDetailBeanTest() {
		assertNotNull(pensionDetails);
	}

	@Test
	public void PensionerDetailNoArgConstructorTest() {
		PensionDetail pensionDetails1 = new PensionDetail();
		assertThat(assertThat(pensionDetails1).isNotNull());

	}

	@Test
	public void BankDetailAllArgConstructorTest() {
		PensionDetail pensionDetails1 = new PensionDetail(1, "Pratyush", "06-11-1999", "PQWER12345", "family",
				40000.00);
		assertNotNull(pensionDetails1);
	}

	@Test
	public void BankDetailSettersTest() {
		PensionDetail pensionDetail1 = new PensionDetail();
		pensionDetail1.setId(1);
		pensionDetail1.setName("Pratyush");
		pensionDetail1.setDateOfBirth("06-11-1999");
		pensionDetail1.setPanNumber("POQWERT12345");
		pensionDetail1.setPensiontype("family");
		pensionDetail1.setPensionAmount(40000.00);

		assertNotNull(pensionDetail1);

	}

}