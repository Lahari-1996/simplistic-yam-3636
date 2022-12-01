package com.ayushkaam.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {
     
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@NotNull(message = "Name is mandatory")
	private String name;
	
	@NotNull
	@Pattern(regexp = "[789]{1}[0-9]{9}", message ="Mobile number must be 10 digits")
	private String mobile;
	
	@NotNull(message = "Password is mandatory")
	private String password;
	
	@Email
	private String email;
	
}
