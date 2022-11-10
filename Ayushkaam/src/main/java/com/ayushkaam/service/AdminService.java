package com.ayushkaam.service;

import com.ayushkaam.model.Admin;

public interface AdminService {
 

	public String logIntoAccount(Admin admin);
	
	public String logOutAccount(String adminName,String password);
}
