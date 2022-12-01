package com.ayushkaam.service;

import com.ayushkaam.exception.AdminException;
import com.ayushkaam.model.Admin;



public interface AdminService {
 

	public Admin createAdmin(Admin admin) throws AdminException;
	
	public Admin updateAdmin(Admin admin, String key) throws AdminException;
	
	
}
