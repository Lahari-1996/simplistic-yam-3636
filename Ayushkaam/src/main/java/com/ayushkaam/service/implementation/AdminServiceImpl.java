package com.ayushkaam.service.implementation;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.model.Admin;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.repository.AdminRepository;
import com.ayushkaam.repository.CurrentAdminSessionRepository;
import com.ayushkaam.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
 
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private CurrentAdminSessionRepository currentAdminRepo;
	
	@Override
	public String logIntoAccount(Admin admin) {
		Optional<Admin> adminObj =adminRepo.findByAdminId(admin.getAdminId());
		if(!adminObj.isPresent()) {
			return "Please Enter Valid ID";
		}
		else {
			Admin admin1=adminObj.get();
			String adminName=admin1.getAdminName();
			
			Optional<CurrentAdminSession> currentAdmin1=currentAdminRepo.findByAdminName(adminName);
			if(currentAdmin1.isPresent()) {
				return "Admin already logged in with this Name";
			}
			if(admin1.getAdminPassword().equals(admin.getAdminPassword())) {
				CurrentAdminSession currentAdminSession=new CurrentAdminSession(admin.getAdminId(), admin.getAdminPassword());
				currentAdminRepo.save(currentAdminSession);
				return currentAdminSession.toString();
			}
			else {
				return "Invalid Password";
			}
		}
	}

	
	
	


	@Override
	public String logOutAccount(String adminName, String password) {
		Optional<CurrentAdminSession> currentAdminObj=currentAdminRepo.findByAdminName(adminName);
		if(!currentAdminObj.isPresent()) {
			return "No Admin Logged In With this Name";
		}
		else {
			CurrentAdminSession currentAdmin1=currentAdminObj.get();
			currentAdminRepo.delete(currentAdmin1);
			return "Admin logged out successfully...";
		}
	}

}
