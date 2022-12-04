package com.ayushkaam.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;

@Entity
public class CurrentAdminSession {

	@Id
	@Column(unique = true)
	private Integer userId;
	
	private String name;
	
	private String mobile;
	private String uuid;
	private LocalDateTime localDateTime;
	
	public CurrentAdminSession() {
		// TODO Auto-generated constructor stub
	}
	public CurrentAdminSession(Integer userId, String name, String mobile, String uuid, LocalDateTime localDateTime) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobile = mobile;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	@Override
	public String toString() {
		return "CurrentAdminSession [userId=" + userId + ", name=" + name + ", mobile=" + mobile + ", uuid=" + uuid
				+ ", localDateTime=" + localDateTime + "]";
	}
	
	
	
	

	
}
