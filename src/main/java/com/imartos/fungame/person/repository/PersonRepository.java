package com.imartos.fungame.person.repository;

import com.imartos.fungame.person.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

// CrudRepository tutorial
// https://stackoverflow.com/questions/30880927/spring-boot-extending-crudrepository

@Transactional
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {}
