package com.imartos.fungame.initial.controller;

import com.imartos.fungame.initial.service.InitialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class InitialController {

	private final InitialService initialService;

	@Autowired
	public InitialController(InitialService initialService) {
		this.initialService = initialService;
	}

	@RequestMapping("/")
	public String home() {
		log.info("This is test log");
		return initialService.initiate();
	}

}
