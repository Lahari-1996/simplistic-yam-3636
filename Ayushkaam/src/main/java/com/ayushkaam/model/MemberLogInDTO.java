package com.ayushkaam.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberLogInDTO {

	
	private String mobileNumber;
	
	private String password;

	public MemberLogInDTO(String mobileNumber, String password) {
		super();
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
	
	
	
	
	
	
	
}
