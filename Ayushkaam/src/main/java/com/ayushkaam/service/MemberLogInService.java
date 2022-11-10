package com.ayushkaam.service;

import com.ayushkaam.exception.MemberException;
import com.ayushkaam.model.MemberSession;

public interface MemberLogInService {

	
	public MemberSession loginAsMember(String mobileNumber , String password) throws MemberException;
	
	public String logOutMember(String key) throws MemberException;
	
	
}
