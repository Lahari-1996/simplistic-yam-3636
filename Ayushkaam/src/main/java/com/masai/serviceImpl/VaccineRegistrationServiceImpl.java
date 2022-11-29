package com.masai.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.exception.VaccineRegistrationException;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.model.CurrentUserSession;
import com.ayushkaam.model.Member;
import com.ayushkaam.model.VaccineRegistration;
import com.ayushkaam.repository.AdminSessionDao;
import com.ayushkaam.repository.MemberDao;
import com.ayushkaam.repository.UserSessionDao;
import com.ayushkaam.repository.VaccinRegistrationDao;
import com.ayushkaam.service.VaccineRegistrationService;

@Service
public class VaccineRegistrationServiceImpl implements VaccineRegistrationService{

	@Autowired
	private VaccinRegistrationDao vaccineRegistrationDao;

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private AdminSessionDao adminDao;

	@Autowired
	private UserSessionDao userDao;
	
	
	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration reg, String key)
			throws VaccineRegistrationException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			VaccineRegistration addVaccineRegistration = vaccineRegistrationDao.save(reg);

			return addVaccineRegistration;

		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
		
		
	}

	@Override
	public VaccineRegistration getVaccineRegistration(Long moblieno, String key)
			throws VaccineRegistrationException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			VaccineRegistration vaccineRegistration = vaccineRegistrationDao.findByMobileno(moblieno);
			if (vaccineRegistration != null) {
				return vaccineRegistration;
			} else {
				throw new VaccineRegistrationException("No VaccineRegistration found...");
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
		
		
	}

	@Override
	public List<Member> getAllMember(Long mobileno, String key) throws VaccineRegistrationException, LoginException {
		
		List<Member> member = memberDao.findAll();

		if (member.size() == 0) {
			throw new VaccineRegistrationException("No memeber Found");
		} else {
			return member;
		}
		
	}

	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration reg, String key)
			throws VaccineRegistrationException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccineRegistration> opt = vaccineRegistrationDao.findById(reg.getRegistrationNo());
			if (opt.isPresent()) {
				VaccineRegistration updatedVaccineRegs = vaccineRegistrationDao.save(reg);
				return updatedVaccineRegs;
			} else {
				throw new VaccineRegistrationException("Invalid VaccineRegistration");
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
		
	}

	@Override
	public boolean deleteVaccineRegistration(Integer reg, String key)
			throws VaccineRegistrationException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccineRegistration> opt = vaccineRegistrationDao.findById(reg);
			if (!opt.isPresent()) {
				throw new RuntimeException("not able to access");
			} else {
				VaccineRegistration vaccineRegestration = vaccineRegistrationDao.findById(reg)
						.orElseThrow(() -> new VaccineRegistrationException("Vaccine Registration not Found"));
				vaccineRegistrationDao.delete(vaccineRegestration);
				return true;
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
		
	}

}
