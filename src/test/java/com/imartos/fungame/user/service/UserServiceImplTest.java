package com.imartos.fungame.user.service;

import com.google.common.collect.ImmutableList;
import com.imartos.fungame.user.entity.User;
import com.imartos.fungame.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	@Mock
	private UserRepository anyUserRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Test
	public void shouldFetchUsersFromRepo() {
		User anyUser = mock(User.class);

		when(anyUserRepository.findAll()).thenReturn(ImmutableList.of(anyUser));
		List<User> userList = userService.getUserList();
		verify(anyUserRepository).findAll();
		assertEquals(userList.size(), 1);
		assertEquals(userList.get(0), anyUser);
	}


	@Test
	public void shouldFetchUserFromRepoByName() throws Exception {
		User anyUser = mock(User.class);
		String anyName = "ANY";
		when(anyUserRepository.findUserByName(anyName)).thenReturn(ImmutableList.of(anyUser));
		List<User> userList = userService.findUser(anyName);
		verify(anyUserRepository).findUserByName(anyName);
		assertEquals(userList.size(), 1);
		assertEquals(userList.get(0), anyUser);
	}

	@Test
	public void shouldFetchUserFromRepoById() throws Exception {
		User anyUser = mock(User.class);
		Long anyId = 1L;
		when(anyUserRepository.findOne(anyId)).thenReturn(anyUser);
		Optional<User> user = userService.findUser(anyId);
		verify(anyUserRepository).findOne(anyId);
		assertTrue(user.isPresent());
		assertEquals(user.get(), anyUser);
	}

	@Test
	public void shouldStoreUser() {
		User anyUser = mock(User.class);
		userService.registerUser(anyUser);
		verify(anyUserRepository).save(anyUser);

	}
}