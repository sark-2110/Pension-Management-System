package com.cognizant.controller.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.controller.ProcessPensionController;
import com.cognizant.model.ProcessPensionInput;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ProcessPensionControllerTest {

	@Autowired
	ProcessPensionController processpensioncontroller;

	@Autowired
	private MockMvc mvc;

	ObjectMapper objectMapper = new ObjectMapper();
	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";

	@Test
	public void contextLoads() {
		assertNotNull(processpensioncontroller);
	}
//	@Test
//	public void getProcessingCodeTestSuccess() throws Exception {
//		ProcessPensionInput processPensionInput = new ProcessPensionInput("1234567891011120", 6069.98, 550);
//		assertNotNull(processPensionInput) ;
//		String jsonReq = objectMapper.writeValueAsString(processPensionInput);
//		ResultActions actions = mvc.perform(post("/processPension").contentType("application/json").content(jsonReq)
//				.header("Authorization", "Bearer " + token));
//		assertNotNull(actions) ;
//		actions.andExpect(content().string("10"));

}
