//package com.ayushkaam.service.implementation;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ayushkaam.exception.LogInException;
//import com.ayushkaam.exception.MemberException;
//import com.ayushkaam.model.Member;
//import com.ayushkaam.model.MemberSession;
//import com.ayushkaam.repository.MemberDao;
//import com.ayushkaam.repository.MemberSessionDao;
//import com.ayushkaam.service.MemberLogInService;
//
//
//@Service
//public class MemberServiceLogInImpl implements MemberLogInService{
//
//	
//	@Autowired
//	private MemberSessionDao memberSessionRepository;
//	
//	
//	@Autowired
//	private MemberDao memberDao;
//	
//	
//	@Override
//	public MemberSession loginAsMember(String mobileNumber, String password) throws LogInException {
//		
//		
//		Optional<MemberSession> meOptional = memberSessionRepository.findByMobileNumber(mobileNumber);
//
//		if(meOptional.isPresent()) throw new LogInException("User already logged in.");
//		
//		Member member = memberDao.findByMobileNumber(mobileNumber).orElseThrow(() -> new LogInException("User Not Registered, please register first"));
//		
//		
//		System.out.println(password + " "  + member.getPassword());
//		
//		if(!member.getPassword().equals(password)) {
//			
//			throw new LogInException("Wrong Password Please Enter Correct Password");
//		}
//		
//		
//		MemberSession memberSession = new MemberSession();
//		
//		memberSession.setMobileNumber(mobileNumber);
//		memberSession.setTimestamp(LocalDateTime.now());
//		memberSession.setRole("Member");
//		memberSession.setToken(UUID.randomUUID().toString());
//		
//		return memberSessionRepository.save(memberSession);
//		
//	}
//
//	@Override
//	public String logOutMember(String key) throws LogInException {
//		
//		MemberSession meSession = memberSessionRepository.findByToken(key).orElseThrow(() -> new LogInException("Invalid Token or User not Logged In"));
//		
//		memberSessionRepository.delete(meSession);
//		
//		return "Thank You For Using AyushKaam 💉";
//	}
//
//}
