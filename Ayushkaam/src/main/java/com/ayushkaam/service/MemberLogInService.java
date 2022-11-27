package com.ayushkaam.service;

import com.ayushkaam.exception.LoginException;

import com.ayushkaam.model.MemberSession;

public interface MemberLogInService {

	
	public MemberSession loginAsMember(String mobileNumber , String password) throws LoginException;
	
	public String logOutMember(String key) throws LoginException;
	
	
}
