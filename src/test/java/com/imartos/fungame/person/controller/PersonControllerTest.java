package com.imartos.fungame.person.controller;

import com.imartos.fungame.person.repository.PersonRepository;
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

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

	private MockMvc mockMvc;

	@Mock
	private PersonRepository anyPersonRepository;

	@InjectMocks
	private PersonController personController;


	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(personController).build();
	}

	@Test
	public void shouldReturnPersonFromRepository() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/persons").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(anyPersonRepository).findAll();
	}

}