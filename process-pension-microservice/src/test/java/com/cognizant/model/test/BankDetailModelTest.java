package com.cognizant.model.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.BankDetail;

@SpringBootTest
public class BankDetailModelTest {
	
	BankDetail bankDetail = new BankDetail() ;
	
	@Test
	public void BankDetailBeanTest() {
		assertNotNull(bankDetail) ;
	}
	
	
	@Test
	public void BankDetailNoArgConstructorTest() {
		BankDetail bankDetail1 = new BankDetail() ;
		assertThat(assertThat(bankDetail1).isNotNull());		
		
	}
	
	@Test 
	public void BankDetailAllArgConstructorTest() {
		BankDetail bankDetail1 = new BankDetail("SBI", "123456789009", "private") ;
		assertNotNull(bankDetail1) ;
	}
	
	@Test
	public void BankDetailSettersTest()
	{
		BankDetail bankDetail1 = new BankDetail() ;
		bankDetail.setAccountNumber("1111111111");
		bankDetail.setBankName("SBI");
		bankDetail.setBankType("public");
		assertNotNull(bankDetail) ;
	}
	

}
