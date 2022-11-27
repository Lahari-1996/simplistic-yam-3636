package com.ayushkaam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminDTO {
  
	private Integer adminId;
	private String mobile;
	private String adminName;
	private String adminPassword;
}
