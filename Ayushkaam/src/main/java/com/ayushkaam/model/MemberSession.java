package com.ayushkaam.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MemberSession {

	
	@Id
	private String mobileNumber;
	
	private String token;
	
	private LocalDateTime timestamp;
	
	
	@Pattern(regexp = "^(Member|Admin)" , message = "Invalid Role Type")
	private String role;

	public MemberSession(String token, LocalDateTime timestamp, String role) {
		super();
		this.token = token;
		this.timestamp = timestamp;
		this.role = role;
	}
	
	
	
	
}
