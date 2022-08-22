package com.cognizant.model.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.BankDetail;
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;

@SpringBootTest
public class PensionerDetailTest {

	@Test
	void NoArgsPensionDetailTest()
	{
		assertThat(new PensionerDetail()).isNotNull();
	}
	
	@Test
	void AllArgsPensionDetailTest()
	{
		PensionerDetail pensionDetail=new PensionerDetail("19183857573", "Professor","06-11-1999" , "PIYTH7890L",40000,12000, "family", new BankDetail("SBI", "1930232384", "public"));
		assertThat(assertThat(pensionDetail).isNotNull());
	}

	@Test
	void AllsetterPensionDetailTest()
	{
		PensionerDetail pensionerDetail=new PensionerDetail() ;
		pensionerDetail.setAadhaarNumber("32535245425452");
		pensionerDetail.setName("Nairobi");
		pensionerDetail.setDateOfBirth("11-5-1990");
		pensionerDetail.setPanNumber("ILUPWS2341C");
		pensionerDetail.setPensionType("family");
		pensionerDetail.setSalary(500000);
		pensionerDetail.setAllowance(12000);
		pensionerDetail.setBankDetail(new BankDetail("HDFC","35346356456457", "private" ));
		assertThat(assertThat(pensionerDetail).isNotNull());
	}
	
	@Test
	void getterPensionDetailTest()
	{
		PensionerDetail pensionDetail=new PensionerDetail("19183857573", "Professor","06-11-1999" , "PIYTH7890L",40000,12000, "family", new BankDetail("SBI", "1930232384", "public"));
		String adhaar = pensionDetail.getAadhaarNumber() ;
		assertEquals("19183857573", adhaar) ;
		assertEquals("Professor", pensionDetail.getName() ) ;
		assertEquals("06-11-1999", pensionDetail.getDateOfBirth() ) ;
		assertEquals("PIYTH7890L", pensionDetail.getPanNumber() ) ;
		assertEquals(40000, pensionDetail.getSalary()) ;
		assertEquals(12000, pensionDetail.getAllowance()) ;
		assertEquals("family", pensionDetail.getPensionType()) ;

	}
	 
	
}
