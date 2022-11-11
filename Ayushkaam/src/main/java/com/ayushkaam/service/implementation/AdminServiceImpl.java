package com.ayushkaam.service.implementation;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.LogInException;
import com.ayushkaam.model.Admin;
import com.ayushkaam.model.Member;
import com.ayushkaam.model.MemberLogInDTO;
import com.ayushkaam.model.MemberSession;
import com.ayushkaam.repository.AdminDao;
import com.ayushkaam.repository.MemberSessionDao;
import com.ayushkaam.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
 
	@Autowired
	private AdminDao adminRepo;
	
	@Autowired
	private MemberSessionDao memberSessionRepository;
	
	@Override
	public MemberSession logIntoAccount(MemberLogInDTO memberLogInDTO) throws LogInException{
		
		
		
		Optional<MemberSession> meOptional = memberSessionRepository.findByMobileNumber(memberLogInDTO.getMobileNumber());

		if(meOptional.isPresent()) throw new LogInException("User already logged in.");
		
		Admin admin = adminRepo.findByMobileNumber(memberLogInDTO.getMobileNumber()).orElseThrow(() -> new LogInException("User Not Registered, please register first"));
		
		if(admin.getAdminPassword() != memberLogInDTO.getPassword()) throw new LogInException("Wrong Password Please Enter Correct Password");
		
		
		MemberSession memberSession = new MemberSession();
		
		memberSession.setMobileNumber(admin.getMobileNumber());
		memberSession.setTimestamp(LocalDateTime.now());
		memberSession.setRole("Admin");
		memberSession.setToken(UUID.randomUUID().toString());
		
		return memberSessionRepository.save(memberSession);
	}

	
	
	


	@Override
	public String logOutAccount(String key) throws LogInException {
		
		MemberSession meSession = memberSessionRepository.findByToken(key).orElseThrow(() -> new LogInException("Invalid Token or User not Logged In"));
		
		memberSessionRepository.delete(meSession);
		
		return "Thank You For Using AyushKaam 💉";
		
	}

}
