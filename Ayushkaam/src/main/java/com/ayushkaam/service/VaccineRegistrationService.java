package com.ayushkaam.service;


import java.util.List;

import com.ayushkaam.model.Member;
import com.ayushkaam.model.VaccineRegistration;

public interface VaccineRegistrationService {
	
	
	public List<VaccineRegistration> allVaccineRegistration(String key);

	public VaccineRegistration getVaccineRegistration(String mobileNo,String key);

	public Member getRegisteredMemberByMobileNumber(String mobileNo,String key);

	public VaccineRegistration addVaccineRegistration(String mobNo,String key);

	public VaccineRegistration updateVaccineRegistration(String mobNo, String newMobNo,String key);

	public boolean deleteVaccineRegistration(String mobNo,String key);

}
