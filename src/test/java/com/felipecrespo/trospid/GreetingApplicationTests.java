package com.felipecrespo.trospid;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class GreetingApplicationTests {

	public static final String VALID_ENDPOINT = "/greeting";
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void noParamGretingWithOnlyAnEShouldReturnNotFoundError() throws Exception {

		this.mockMvc.perform(get("/greting")).andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		// arrange
		String expectedValue = "Hello, Trospid!";

		// act + assert
		this.mockMvc.perform(get(VALID_ENDPOINT)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value(expectedValue));
	}

	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		// arrange
		String inputParameterValue = "Spring Community";
		String expectedValue = "Hello, " + inputParameterValue + "!";

		// act

		// assert
		getName(VALID_ENDPOINT, inputParameterValue, expectedValue);
	}

	private ResultActions getName(String urlTemplate, String inputParameter, String expectedValue) throws Exception {
		return this.mockMvc.perform(get(urlTemplate).param("name", inputParameter))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").value(expectedValue));
	}

}
