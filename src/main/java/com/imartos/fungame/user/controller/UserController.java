package com.imartos.fungame.user.controller;

import com.imartos.fungame.user.controller.dto.RegisterUserRequestDto;
import com.imartos.fungame.user.controller.dto.UserDto;
import com.imartos.fungame.user.entity.User;
import com.imartos.fungame.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {

	private final UserService userService;
	private final ModelMapper modelMapper;

	@Autowired
	public UserController(UserService userService, ModelMapper modelMapper) {
		this.userService = userService;
		this.modelMapper = modelMapper;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/user/register")
	public void registerUser(@RequestBody RegisterUserRequestDto registerUserRequestDto) {
		User newUser = new User();
		newUser.setName(registerUserRequestDto.getName());
		userService.registerUser(newUser);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/name/{name}")
	public List<UserDto> findUserByName(@PathVariable("name") String name) {
		return userService.findUser(name).stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Nullable
	@RequestMapping(method = RequestMethod.GET, value = "/user/id/{id}")
	public UserDto findUserById(@PathVariable("id") Long id) {
		Optional<User> user = userService.findUser(id);
		if (user.isPresent()) {
			return convertToDto(user.get());
		} else {
			return null;
		}
	}

	private UserDto convertToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		userDto.setRegisteredDate(user.getRegisteredDate());
		return userDto;
	}
}
