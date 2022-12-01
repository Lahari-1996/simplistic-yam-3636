package com.ayushkaam.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.exception.MemberException;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.model.CurrentUserSession;
import com.ayushkaam.model.Member;
import com.ayushkaam.repository.AdminSessionDao;
import com.ayushkaam.repository.MemberDao;
import com.ayushkaam.repository.UserSessionDao;
import com.ayushkaam.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private AdminSessionDao adminDao;

	@Autowired
	private UserSessionDao userDao;
	
	@Override
	public Member addMember(Member member, String key) throws MemberException, LoginException {


		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Member registeredMember = memberDao.save(member);

			if (registeredMember != null) {

				return member;

			} else {

				throw new MemberException("Something went wrong.");

			}
		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");
		
	}

	@Override
	public Member updateMember(Member member, String key) throws MemberException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<Member> optional = memberDao.findById(member.getMemberId());

			if (optional.isPresent()) {

				Member oldMember = optional.get();

				oldMember.setDose1date(member.getDose1date());
				oldMember.setDose1status(member.getDose1status());
				oldMember.setDose2date(member.getDose2date());
				oldMember.setDose2status(member.getDose2status());

				return memberDao.save(oldMember);

			} else {

				throw new MemberException("No any member found with memberId : " + member.getMemberId());

			}
		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");
		
	}

	@Override
	public List<Member> getAllMembers() throws MemberException {
		
		List<Member> memberList = memberDao.findAll();

		if (memberList.isEmpty()) {

			throw new MemberException("No any member found in data!!!");

		} else {

			return memberList;

		}
		
	}

	@Override
	public Member getMemberById(Integer memberId, String key) throws MemberException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<Member> optional = memberDao.findById(memberId);

			if (optional.isPresent()) {

				Member member = optional.get();

				return member;

			} else {

				throw new MemberException("No any member found with Id : " + memberId);

			}
		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");

		
	}

	@Override
	public Member getMemberByAadharNo(Long aadharNo, String key) throws MemberException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Member member = memberDao.getByAdharNo(aadharNo);

			if (member != null) {

				return member;

			} else {

				throw new MemberException("Member not found with Aadhar No : " + aadharNo);

			}
		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");
		
	}

	@Override
	public Member getMemberByPanNo(String panNo, String key) throws MemberException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Member member = memberDao.getByPanNo(panNo);

			if (member != null) {

				return member;

			} else {

				throw new MemberException("Member not found with Aadhar No : " + panNo);

			}

		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");
		
	}

	@Override
	public Boolean deleteMember(Member member, String key) throws MemberException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<Member> optional = memberDao.findById(member.getMemberId());

			if (optional.isPresent()) {

				Member currentMember = optional.get();

				if (currentMember.getDose1status() == true) {

					if (currentMember.getDose2status() == true) {

						memberDao.delete(currentMember);

						return true;

					} else {
						throw new MemberException("Member must have to complete dose 2.");
					}

				} else {
					throw new MemberException("Member must have to complete dose 1 & dose 2.");
				}

			} else {
				throw new MemberException("No any member found with memberId : " + member.getMemberId());
			}
		} else
			throw new LoginException("Oops...! Log in as an admin/user first.");
		
	}

}
