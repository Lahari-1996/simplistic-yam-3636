package com.ayushkaam.service.implementation;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.model.Admin;
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
	public String logIntoAccount(Admin admin) {
		Optional<Admin> adminObj =adminRepo.findByAdminId(admin.getAdminId());
		if(!adminObj.isPresent()) {
			return "Please Enter Valid ID";
		}
		else {
			Admin admin1=adminObj.get();
		
			
			Optional<CurrentAdminSession> currentAdmin1=currentAdminRepo.findById(admin1.getAdminId());
			if(currentAdmin1.isPresent()) {
				return "Admin already logged in with this Name";
			}
			else if(admin1.getAdminPassword().equals(admin.getAdminPassword())) {
				CurrentAdminSession currentAdminSession=new CurrentAdminSession(admin.getAdminId(), admin.getAdminName());
				currentAdminRepo.save(currentAdminSession);
				return currentAdminSession.toString();
			}
			else {
				return "Invalid Password";
			}
		}
	}

	
	
	


	@Override
	public String logOutAccount(CurrentAdminSession currentAdminSession) {
		Optional<CurrentAdminSession> currentAdminObj=currentAdminRepo.findById(currentAdminSession.getAdminId());
		if(!currentAdminObj.isPresent()) {
			return "No Admin Logged In With this Name";
		}
		else {
			CurrentAdminSession currentAdmin1=currentAdminObj.get();
			if(adminRepo.findById(currentAdminSession.getAdminId()).get().getAdminPassword()==password) {
				currentAdminRepo.delete(currentAdmin1);
				return "Admin logged out";
			}
			else return "Invalid Password";
		}
	}






	@Override
	public Admin createAdmin(Admin admin) {
	Optional<Admin> opt= adminRepo.findByAdminId(admin.getAdminId());
		
		if(opt.isPresent()) {
			System.out.println("User already exist");
		}
		return adminRepo.save(admin);
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
