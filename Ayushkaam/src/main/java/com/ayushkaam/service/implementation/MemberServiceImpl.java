//package com.ayushkaam.service.implementation;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ayushkaam.exception.MemberException;
//import com.ayushkaam.model.Member;
//import com.ayushkaam.model.MemberSession;
//import com.ayushkaam.repository.MemberDao;
//import com.ayushkaam.repository.MemberSessionDao;
//import com.ayushkaam.service.MemberService;
//
//import net.bytebuddy.utility.RandomString;
//
//
//@Service
//public class MemberServiceImpl implements MemberService{
//	
//	@Autowired
//	private MemberDao memberDao;
//
//	
//	@Autowired
//	private MemberSessionDao memberSessionRepo;
//	
//	@Override
//	public Member registerAsMember(Member member) throws MemberException {
//		
//		
//		member.getAadharCard().setFingerPrints(RandomString.make(6));
//		member.getAadharCard().setIrisscan(RandomString.make(6));
//		
//		Member member2 = memberDao.save(member);
//		
//		if(member2 == null) throw new MemberException("Please Enter proper member details");
//		
//		return member2;
//	}
//
//	@Override
//	public Member updateMemberDetails(Member member, String key) throws MemberException {
//		
//		 memberSessionRepo.findByToken(key).orElseThrow(() -> new MemberException("Invalid Key or User Not Logged In."));
//		
//		 memberDao.findById(member.getMemberId()).orElseThrow(() -> new MemberException("User Not Found"));
//
//		 return memberDao.save(member);
//		 
//	}
//
//	@Override
//	public List<Member> getAllMembers(String key) throws MemberException {
//		
//		
//		memberSessionRepo.findByToken(key).orElseThrow(() -> new MemberException("User Not Logged In, Please Log In First"));
//		
//		List<Member> members = new ArrayList<>();
//		
//		members = memberDao.findAll();
//		
//		if(members.size() == 0) throw new MemberException("Member Not Found");
//		
//		return members;
//	}
//
//	@Override
//	public Member getMemberById(Integer memberId, String key) throws MemberException {
//		
//		memberSessionRepo.findByToken(key).orElseThrow(() -> new MemberException("User Not Logged In, Please Log In First"));		
//		
//		Member member = null;
//		
//		member = memberDao.findById(memberId).orElseThrow(() -> new MemberException("Invalid Member ID, Please Enter Valid Member ID"));
//		
//		return member;
//	}
//
//	@Override
//	public Member getMemberByAadharNumber(Long aadharNumber , String key) throws MemberException {
//		
//		memberSessionRepo.findByToken(key).orElseThrow(() -> new MemberException("User Not Logged In, Please Log In First"));
//		
//		Member member = null;
//		
//		member = memberDao.findByAadharNumber(aadharNumber).orElseThrow(() -> new MemberException("Invalid Aadhar Number, Please Enter Valid Aadhar Number"));
//		
//		return member;
//	}
//
//	@Override
//	public Member deleteMemberById(Integer memberId , String key) throws MemberException {
//	
//		
//		MemberSession memberSession = memberSessionRepo.findByToken(key).orElseThrow(() -> new MemberException("User Not Logged In, Please Log In First"));
//		
//		memberSessionRepo.delete(memberSession);
//		
//		Member member = memberDao.findById(memberId).orElseThrow(() -> new MemberException("Invalid Member ID, Please Enter Valid Member ID"));
//		
//		memberDao.delete(member);
//		
//		return member;
//	}
//
//}
