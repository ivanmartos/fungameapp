package com.imartos.fungame.user.controller.dto;

import com.imartos.fungame.utils.TimeZone;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserDto {
	private Long id;
	private String name;
	private String registeredDate;

	public void setRegisteredDate(LocalDateTime registeredDate) {
		this.registeredDate = TimeZone.DATETIME_FORMAT.format(registeredDate.toDate());
	}
}
