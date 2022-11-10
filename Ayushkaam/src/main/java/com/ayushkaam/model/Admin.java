package com.ayushkaam.model;



import javax.persistence.Entity;

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
     
	private int adminId;
	private String adminName;
	private String adminPassword;
	
}
