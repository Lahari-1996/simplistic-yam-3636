package com.ayushkaam.service;


import java.util.List;

import com.ayushkaam.model.Member;
import com.ayushkaam.model.VaccineRegistration;

public interface VaccineRegistrationService {
	
	
	public List<VaccineRegistration> allVaccineRegistration(String mobileNo);

	public VaccineRegistration getVaccineRegistration(String mobileNo);

	public Member getRegisteredMemberByMobileNumber(String mobileNo );

	public VaccineRegistration addVaccineRegistration(String mobNo );

	public VaccineRegistration updateVaccineRegistration(String mobNo, String newMobNo );

	public boolean deleteVaccineRegistration(String mobNo);

}
