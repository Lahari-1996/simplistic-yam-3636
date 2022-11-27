package com.ayushkaam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor

@ToString
public class CurrentAdminSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int curadminId;
	private int adminId;
	private String curadminName;
	private String adminMobile;
	public CurrentAdminSession(int adminId, String curadminName, String adminMobile) {
		super();
		
		this.adminId = adminId;
		this.curadminName = curadminName;
		this.adminMobile = adminMobile;
	}

	
}
