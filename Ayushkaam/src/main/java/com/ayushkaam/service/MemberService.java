package com.ayushkaam.service;

import java.util.List;

import com.ayushkaam.exception.MemberException;
import com.ayushkaam.model.Member;


public interface MemberService {
	
	
	public Member registerAsMember(Member member) throws MemberException;

	public Member updateMemberDetails(Member member , String key) throws MemberException;
	
	public List<Member> getAllMembers(String key) throws MemberException;
	
	public Member getMemberById(Integer memberId , String Key) throws MemberException;
	
	public Member getMemberByAadharNumber(Long aadharNumber , String key)throws MemberException;
	
	public Member deleteMemberById(Integer memberId , String key) throws MemberException;
	
}
