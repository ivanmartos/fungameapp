package com.imartos.fungame.initial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {

	@RequestMapping("/")
	public String home() {
		return "Hello world";
	}

}
