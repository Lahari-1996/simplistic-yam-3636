package com.ayushkaam.service;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.model.AdminLogin;
import com.ayushkaam.model.UserLogin;

public interface LoginService {

	public String logIntoAccount(UserLogin login)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
	
	public String logIntoAdmin(AdminLogin adl) throws LoginException;
	
	public String logOutAdmin(String key) throws LoginException;
	
}
