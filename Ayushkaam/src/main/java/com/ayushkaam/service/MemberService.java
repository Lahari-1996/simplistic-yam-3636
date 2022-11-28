package com.ayushkaam.service;

import java.util.List;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.exception.MemberException;
import com.ayushkaam.model.Member;


public interface MemberService {
	
	
	//public Member registerAsMember(Member member) throws MemberException;
     public Member addMember(Member member, String key) throws MemberException, LoginException;
     
     public Member updateMember(Member member, String key) throws MemberException, LoginException;

     public List<Member> getAllMembers() throws MemberException;
	
     public Member getMemberById(Integer memberId, String key) throws MemberException, LoginException;
     
 	public Member getMemberByAadharNo(Long aadharNo, String key) throws MemberException, LoginException;
 	
	public Member getMemberByPanNo(String panNo, String key) throws MemberException, LoginException;

	public Boolean deleteMember(Member member, String key) throws MemberException, LoginException;
	
	
	
	

	




	
}
