package com.imartos.fungame.user.service;

import com.imartos.fungame.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

	void registerUser(User newUser);

	List<User> getUserList();

	List<User> findUser(String userName);

	Optional<User> findUser(Long userId);
}
