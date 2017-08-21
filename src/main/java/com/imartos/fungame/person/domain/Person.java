package com.imartos.fungame.person.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Person")
@Data
public class Person {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String country;
}
