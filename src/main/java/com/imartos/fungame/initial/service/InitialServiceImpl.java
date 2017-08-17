package com.imartos.fungame.initial.service;

import org.springframework.stereotype.Service;

@Service
public class InitialServiceImpl implements InitialService {

	@Override
	public String initiate() {
		return "this is initilized string";
	}
}
