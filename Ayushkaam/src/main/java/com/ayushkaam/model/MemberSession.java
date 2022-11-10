package com.ayushkaam.model;

import javax.persistence.Entity;

import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MemberSession {

	
	@Id
	private Long memberID;
	
	private String token;
	
	private String timestamp;
	
	private String role;

	public MemberSession(String token, String timestamp, String role) {
		super();
		this.token = token;
		this.timestamp = timestamp;
		this.role = role;
	}
	
	
	
	
}
