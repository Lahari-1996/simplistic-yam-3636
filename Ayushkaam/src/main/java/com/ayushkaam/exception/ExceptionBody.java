package com.ayushkaam.exception;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ExceptionBody {
	
	private LocalDateTime timestamp;
	private String message;
	private String description;
	
	
	public ExceptionBody(LocalDateTime timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}

}
