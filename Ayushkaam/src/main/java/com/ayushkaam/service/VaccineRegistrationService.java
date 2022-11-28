package com.ayushkaam.service;

import java.util.List;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.exception.VaccineRegistrationException;
import com.ayushkaam.model.Member;
import com.ayushkaam.model.VaccineRegistration;



public interface VaccineRegistrationService {
	
	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg, String key)
			throws VaccineRegistrationException, LoginException;
	
	public VaccineRegistration getVaccineRegistration(Long moblieno, String key)
			throws VaccineRegistrationException, LoginException;

	public List<Member> getAllMember(Long mobileno, String key)
			throws VaccineRegistrationException, LoginException;


	public VaccineRegistration updateVaccineRegistration(VaccineRegistration reg, String key)
			throws VaccineRegistrationException, LoginException;

	public boolean deleteVaccineRegistration(Integer reg, String key)
			throws VaccineRegistrationException, LoginException;
	
}
