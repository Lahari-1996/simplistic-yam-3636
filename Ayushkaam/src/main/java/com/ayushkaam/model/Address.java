package com.ayushkaam.model;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {

	@NotNull(message = "Address Filed Can't be empty")
	private String address;
	
	@NotNull(message = "State Filed Can't be empty")
	private String state;
	
	@NotNull(message = "City Filed Can't be empty")
	private String city;
	
	@NotNull(message = "Pincode Filed Can't be empty")
	private String pincode;
	
	
	
	public Address(String address, String state, String city, String pincode) {
		super();
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}
	
	
	
}
