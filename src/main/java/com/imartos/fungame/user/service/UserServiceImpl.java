package com.imartos.fungame.user.service;

import com.google.common.collect.ImmutableList;
import com.imartos.fungame.user.entity.User;
import com.imartos.fungame.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void registerUser(User newUser) {
		log.info("Storing new user - {}", newUser.getName());
		userRepository.save(newUser);
	}

	@Override
	public List<User> getUserList() {
		log.info("Retrieving all users");
		return ImmutableList.copyOf(userRepository.findAll());
	}

	@Override
	public List<User> findUser(String userName) {
		ImmutableList<User> userList = ImmutableList.copyOf(userRepository.findUserByName(userName));
		log.info("Found {} users with name {}", userList.size(), userName);
		return userList;
	}

	@Override
	public Optional<User> findUser(Long userId) {
		User user = userRepository.findOne(userId);
		return Optional.ofNullable(user);
	}
}
