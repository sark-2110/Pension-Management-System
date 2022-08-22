package com.cognizant.model.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.BankDetail;
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;

@SpringBootTest
public class PensionerDetailTest {

	PensionerDetail pensionerDetails = new PensionerDetail();
	BankDetail bankDetail = new BankDetail() ;

	@Test
	public void PensionerDetailBeanTest() {
		assertNotNull(pensionerDetails);
	}
	@Test
	public void BankDetailBeanTest() {
		assertNotNull(bankDetail);
	}

	@Test
	public void PensionerDetailNoArgConstructorTest() {
		PensionerDetail pensionerDetails1 = new PensionerDetail();
		assertThat(assertThat(pensionerDetails1).isNotNull());

	}

	@Test
	public void PensionerDetailAllArgConstructorTest() {
		PensionerDetail pensionerDetails1 = new PensionerDetail("12904284925403", "Pratyush", "06-11-1999", "PQWER12345", 40000.00,
				12000.00, "family", bankDetail);
		assertNotNull(pensionerDetails1);
	}

	@Test
	public void PensionerDetailSettersTest() {
		PensionerDetail pensionerDetail1 = new PensionerDetail();
		pensionerDetail1.setAadhaarNumber("1211121324343543");
		pensionerDetail1.setName("Pratyush");
		pensionerDetail1.setDateOfBirth("06-11-1999");
		pensionerDetail1.setPanNumber("POQWERT12345");
		pensionerDetail1.setSalary(40000.00);
		pensionerDetail1.setAllowance(12000.00);
		pensionerDetail1.setPensionType("family");
		pensionerDetail1.setBankDetail(bankDetail);
		assertNotNull(pensionerDetail1);

	}

}
