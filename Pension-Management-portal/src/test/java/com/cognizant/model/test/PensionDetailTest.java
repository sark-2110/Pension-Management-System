package com.cognizant.model.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.PensionDetail;

@SpringBootTest
public class PensionDetailTest {


	@Test
	void NoArgsPensionDetailTest()
	{
		assertThat(new PensionDetail()).isNotNull();
	}
	
	@Test
	void AllArgsPensionDetailTest()
	{
		PensionDetail pensionDetail=new PensionDetail("Professor","06-11-1999" , "PIYTH7890L", "family", 52131.0);
		assertThat(assertThat(pensionDetail).isNotNull());
	}
	
	@Test
	void AllSetterPensionDetailTest()
	{
		PensionDetail pensionDetail=new PensionDetail() ;
		pensionDetail.setName("Nairobi");
		pensionDetail.setDateOfBirth("11-5-1990");
		pensionDetail.setPanNumber("ILUPWS2341C");
		pensionDetail.setPensiontype("family");
		pensionDetail.setPensionAmount(40000);
		assertThat(assertThat(pensionDetail).isNotNull());
	}
	
	@Test
	void AllGetterPensionDetailTest()
	{
		PensionDetail pensionDetail=new PensionDetail("Professor","06-11-1999" , "PIYTH7890L", "family", 52131.0);
		String name = pensionDetail.getName() ;
		String dob = pensionDetail.getDateOfBirth() ;
		String pn = pensionDetail.getPanNumber() ;
		String pt = pensionDetail.getPensiontype();
		Double pa = pensionDetail.getPensionAmount() ;
		assertEquals("Professor", name) ;
		assertEquals("06-11-1999", dob) ;
		assertEquals("PIYTH7890L", pn) ;
		assertEquals("family", pt) ;
		assertEquals(52131.0, pa) ;
	}
	
	
}
