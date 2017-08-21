package com.imartos.fungame.user.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	@CreationTimestamp
	private Date registeredDate;

	@Transient
	public LocalDateTime getRegisteredDate() {
		return LocalDateTime.fromDateFields(registeredDate);
	}
}
