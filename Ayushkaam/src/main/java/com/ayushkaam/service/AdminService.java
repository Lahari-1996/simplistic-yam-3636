package com.ayushkaam.service;

import com.ayushkaam.exception.LogInException;
import com.ayushkaam.model.Admin;
import com.ayushkaam.model.AdminDTO;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.model.MemberLogInDTO;
import com.ayushkaam.model.MemberSession;

public interface AdminService {
 

	public Admin createAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin);
	
	public String logIntoAccount(AdminDTO adminDTO) throws LogInException;
	
	public String logOutAccount(String mobile) throws LogInException;
}
