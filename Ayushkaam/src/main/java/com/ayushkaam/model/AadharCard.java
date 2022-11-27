package com.ayushkaam.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AadharCard {

	
	@NotNull
	@Size(min = 12 , max = 12 , message = "Invalid Addhar Number")
	@Column(unique = true)
	private Long aadharNumber;

	public AadharCard(@Size(min = 12, max = 12, message = "Invalid Addhar Number") Long aadharNumber) {
		super();
		this.aadharNumber = aadharNumber;
	}
	
	
	
	
}
