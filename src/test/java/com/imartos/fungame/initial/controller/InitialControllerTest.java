package com.imartos.fungame.initial.controller;

import com.imartos.fungame.initial.service.InitialService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InitialControllerTest {

	private MockMvc mvc;

	@Mock
	private InitialService anyService;

	@InjectMocks
	private InitialController initialController;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(initialController).build();
	}

	//	@Test
	//	public void getHello() throws Exception {
	//		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(
	//				content().string(equalTo("Hello world")));
	//	}

	@Test
	public void getHello() throws Exception {
		String anyResultString = "ANY RESULT STRING";

		when(anyService.initiate()).thenReturn(anyResultString);
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(
				content().string(equalTo(anyResultString)));
		verify(anyService).initiate();
	}

}