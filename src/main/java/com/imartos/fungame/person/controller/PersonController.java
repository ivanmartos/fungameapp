package com.imartos.fungame.person.controller;

import com.imartos.fungame.person.domain.Person;
import com.imartos.fungame.person.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PersonController {

	private final PersonRepository personRepository;

	@Autowired
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@RequestMapping("/persons")
	public Iterable<Person> listPerson() {
		log.info("starting to query");

		Iterable<Person> list = personRepository.findAll();

		log.info("retrieved {}", list);

		return list;
	}
}
