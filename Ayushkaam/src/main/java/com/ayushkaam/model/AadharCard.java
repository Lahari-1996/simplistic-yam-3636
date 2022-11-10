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
	
	
	@NotNull
	@Column(unique = true)
	private String fingerPrints;
	
	@NotNull
	@Column(unique = true)
	private String irisscan;

	public AadharCard(@Size(min = 12, max = 12, message = "Invalid Addhar Number") Long aadharNumber,
			String fingerPrints, String irisscan) {
		super();
		this.aadharNumber = aadharNumber;
		this.fingerPrints = fingerPrints;
		this.irisscan = irisscan;
	}
	
	
	
	
}
