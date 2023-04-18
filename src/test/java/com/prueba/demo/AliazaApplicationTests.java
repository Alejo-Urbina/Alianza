package com.prueba.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class AliazaApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void saveClientSucces() throws Exception {

		MvcResult resultClient = mvc.perform(
				MockMvcRequestBuilders.post("/client")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(new RequestSaveClientTest("aruiz","Ana Ruiz",
						"aruiz@gmail.com","3215648987", new Date(System.currentTimeMillis()),
						new Date(System.currentTimeMillis())))))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.startDate").exists())
				.andReturn();

	}

	@Test
	public void getClients() throws Exception {

		mvc.perform(MockMvcRequestBuilders
				.get("/client/")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void getClientId() throws Exception {

		MvcResult resultClient = mvc.perform(
				MockMvcRequestBuilders.post("/client")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new RequestSaveClientTest("aruiz","Ana Ruiz",
								"aruiz@gmail.com","3215648987", new Date(System.currentTimeMillis()),
								new Date(System.currentTimeMillis())))))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.startDate").exists())
				.andReturn();

		ResponseSaveClientTest resultadoPrestamo = objectMapper.readValue(resultClient.getResponse().getContentAsString(),
				ResponseSaveClientTest.class);

		LocalDate date = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		mvc.perform(MockMvcRequestBuilders
				.get("/client/"+ resultadoPrestamo.getId())
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.sharedKey", is("aruiz")))
				.andExpect(jsonPath("$.businessId", is("Ana Ruiz")))
				.andExpect(jsonPath("$.email", is("aruiz@gmail.com")))
				.andExpect(jsonPath("$.phone", is("3215648987")))
				.andExpect(jsonPath("$.startDate", is(date.format(formato))))
				.andExpect(jsonPath("$.endDate", is(date.format(formato))));
	}



}
