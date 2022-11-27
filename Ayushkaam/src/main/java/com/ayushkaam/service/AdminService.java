package com.ayushkaam.service;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.model.Admin;
import com.ayushkaam.model.AdminLogin;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.model.MemberLogInDTO;
import com.ayushkaam.model.MemberSession;

public interface AdminService {
 

	public Admin createAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin);
	
	public String logIntoAccount(AdminLogin adminDTO) throws LoginException;
	
	public String logOutAccount(String mobile) throws LoginException;
}
