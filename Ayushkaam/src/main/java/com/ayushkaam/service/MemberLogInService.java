package com.ayushkaam.service;

import com.ayushkaam.exception.LogInException;

import com.ayushkaam.model.MemberSession;

public interface MemberLogInService {

	
	public MemberSession loginAsMember(String mobileNumber , String password) throws LogInException;
	
	public String logOutMember(String key) throws LogInException;
	
	
}
