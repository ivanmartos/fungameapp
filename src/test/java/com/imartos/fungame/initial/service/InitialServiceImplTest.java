package com.imartos.fungame.initial.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class InitialServiceImplTest {

	@InjectMocks
	private InitialServiceImpl initialService;

	@Test
	public void shouldReturnString() {
		String result = initialService.initiate();

		assertNotNull(result);
		assertNotEquals(result, "");
	}

}