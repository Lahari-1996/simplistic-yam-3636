package com.ayushkaam.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.AdminException;
import com.ayushkaam.model.Admin;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.repository.AdminDao;
import com.ayushkaam.repository.AdminSessionDao;
import com.ayushkaam.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminSessionDao adminSDao;
	
	@Override
	public Admin createAdmin(Admin admin) throws AdminException {


		Admin existingUser=adminDao.findByMobile(admin.getMobile());
		if(existingUser==null) {
			return adminDao.save(admin);
		}else {
			throw new AdminException("User already registered with mobile number");
		}
		
		
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws AdminException {
		
		CurrentAdminSession loggedInUser=adminSDao.findByuuid(key);
		if(loggedInUser==null) {
			throw new AdminException("Please provide a valid key to update a user");
		}
		
		if(admin.getAdminId()==loggedInUser.getUserId()) {
			return adminDao.save(admin);
		}else {
			throw new AdminException("Invalid user details , please login first");
		}
		
	}

}
