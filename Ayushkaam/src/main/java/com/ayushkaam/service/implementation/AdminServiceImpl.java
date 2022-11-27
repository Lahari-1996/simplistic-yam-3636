package com.ayushkaam.service.implementation;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.model.Admin;
import com.ayushkaam.model.AdminLogin;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.repository.AdminDao;
import com.ayushkaam.repository.CurrentAdminDao;
import com.ayushkaam.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
 
	@Autowired
	private AdminDao adminRepo;
	
	@Autowired
	private CurrentAdminDao currentAdminRepo;
	
	
	@Override
	public Admin createAdmin(Admin admin) {
	Optional<Admin> opt= adminRepo.findById(admin.getAdminId());
		
		if(opt.isPresent()) {
			System.out.println("User already exist");
		}
		
		Admin adm=adminRepo.save(admin);
		return adm;
	}

	
	
	@Override
	public String logIntoAccount(AdminLogin adminDTO) {
		Optional<Admin> adminObj =adminRepo.findByAdminMobile(adminDTO.getMobile());
		if(!adminObj.isPresent()) {
			return "Please Enter Valid ID";
		}
		else {
			Admin admin1=adminObj.get();
		
			
			Optional<CurrentAdminSession> currentAdmin1=currentAdminRepo.findByAdminMobile(adminDTO.getMobile());
			if(currentAdmin1.isPresent()) {
				return "Admin already logged in with this Name";
			}
			else if(admin1.getAdminPassword().equals(adminDTO.getAdminPassword())) {
				CurrentAdminSession currentAdminSession=new CurrentAdminSession(adminDTO.getAdminId(), adminDTO.getAdminName(),adminDTO.getMobile());
				currentAdminRepo.save(currentAdminSession);
				return currentAdminSession.toString();
			}
			else {
				return "Invalid Password";
			}
		}
	}

	
	
	


	@Override
	public String logOutAccount(String mobile) { 
		Optional<CurrentAdminSession> currentAdminObj=currentAdminRepo.findByAdminMobile(mobile);
		if(!currentAdminObj.isPresent()) {
			return "No Admin Logged In With this Name";
		}
		else {
			CurrentAdminSession currentAdmin1=currentAdminObj.get();
			
				currentAdminRepo.delete(currentAdmin1);
				return "Admin logged out";
			}
		
		}
	






	





	@Override
	public Admin updateAdmin(Admin admin) {
		Optional<Admin> optAdmin= adminRepo.findById(admin.getAdminId());
		
		if(!optAdmin.isPresent()) {
			
			throw new RuntimeException("Unauthorised access");
		}
		
		else return adminRepo.save(admin);
	}






}
