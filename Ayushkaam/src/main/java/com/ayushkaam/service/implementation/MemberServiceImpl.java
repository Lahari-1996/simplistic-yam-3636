package com.ayushkaam.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ayushkaam.exception.MemberException;
import com.ayushkaam.model.Member;
import com.ayushkaam.model.MemberSession;
import com.ayushkaam.repository.MemberDao;
import com.ayushkaam.repository.MemberSessionRepository;
import com.ayushkaam.service.MemberService;

public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;

	
	@Autowired
	private MemberSessionRepository memberSessionRepo;
	
	@Override
	public Member registerAsMember(Member member) throws MemberException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member updateMemberDetails(Member member, String key) throws MemberException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getAllMembers(String key) throws MemberException {
		
		
		MemberSession member = memberSessionRepo.findByToken(key);
		
		
		if(member == null) {
			
			
			throw new MemberException("User Not Logged In, Please Log In First");
		}
		
		
		
		List<Member> members = new ArrayList<>();
		
		members = memberDao.findAll();
		
		if(members.size() == 0) throw new MemberException("Member Not Found");
		
		return members;
	}

	@Override
	public Member getMemberById(Long memberId, String key) throws MemberException {
		
		MemberSession memberSession = memberSessionRepo.findByToken(key);
		
		
		if(memberSession == null) {
			
			
			throw new MemberException("User Not Logged In, Please Log In First");
		}
		
		
		
		Member member = null;
		
		member = memberDao.findById(memberId).orElseThrow(() -> new MemberException("Invalid Member ID, Please Enter Valid Member ID"));
		
		return member;
	}

	@Override
	public Member getMemberByAadharNumber(Long aadharNumber) throws MemberException {
		
		Member member = null;
		
		member = memberDao.findById(aadharNumber).orElseThrow(() -> new MemberException("Invalid Aadhar Number, Please Enter Valid Aadhar Number"));
		
		return member;
	}

	@Override
	public Member deleteMemberById(Long memberId) throws MemberException {
		// TODO Auto-generated method stub
		return null;
	}

}
