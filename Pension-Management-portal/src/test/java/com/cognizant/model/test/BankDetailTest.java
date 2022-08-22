package com.cognizant.model.test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.BankDetail;

@SpringBootTest
class BankDetailTest {
	
	@Test
	void NoArgsBankTest()
	{
		assertThat(new BankDetail()).isNotNull();
	}
	
	@Test
	void AllArgsBankTest()
	{
		BankDetail bankDetail = new BankDetail("SBI", "11223344", "public");
		assertThat(assertThat(bankDetail).isNotNull());
	}
	
	@Test
	void SetterBankTest()
	{
		BankDetail bankDetail = new BankDetail();
		bankDetail.setAccountNumber("12345666655433");
		bankDetail.setBankName("SBI");
		bankDetail.setBankType("public");
		assertThat(assertThat(bankDetail).isNotNull());
	}
	
	@Test
	void getBankDetailTest()
	{
		BankDetail bankDetail = new BankDetail("SBI", "11223344", "public");
		String bankAccountNumber = bankDetail.getAccountNumber() ;
		String bankName = bankDetail.getBankName() ;
		String bankType = bankDetail.getBankType() ;
		assertEquals("11223344", bankAccountNumber) ;
		assertEquals("SBI", bankName) ;
		assertEquals("public", bankType) ;
	}
	

}
