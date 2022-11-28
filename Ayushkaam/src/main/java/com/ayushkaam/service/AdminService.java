package com.ayushkaam.service;

import com.ayushkaam.exception.AdminException;
import com.ayushkaam.exception.LoginException;
import com.ayushkaam.model.Admin;
import com.ayushkaam.model.AdminLogin;
import com.ayushkaam.model.CurrentAdminSession;


public interface AdminService {
 

	public Admin createAdmin(Admin admin) throws AdminException;
	
	public Admin updateAdmin(Admin admin, String key) throws AdminException;
	
	//public String logIntoAccount(AdminLogin adminDTO) throws LoginException;
	
	//public String logOutAccount(String mobile) throws LoginException;
	
	//public Admin createCustomer(Admin admin) throws AdminException;

	//public Admin updateCustomer(Admin admin, String key) throws AdminException;
}
