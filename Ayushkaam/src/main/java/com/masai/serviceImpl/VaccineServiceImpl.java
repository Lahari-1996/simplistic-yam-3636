package com.masai.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.exception.VaccineException;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.model.CurrentUserSession;
import com.ayushkaam.model.Vaccine;
import com.ayushkaam.repository.AdminSessionDao;
import com.ayushkaam.repository.UserSessionDao;
import com.ayushkaam.repository.VaccineDao;
import com.ayushkaam.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService{


	@Autowired
	private VaccineDao vaccineDao;

	@Autowired
	private AdminSessionDao adminDao;

	@Autowired
	private UserSessionDao userDao;

	
	
	@Override
	public List<Vaccine> allVaccines() throws VaccineException {
		
		List<Vaccine> vaccines = vaccineDao.findAll();
		if (vaccines.size() != 0) {
			return vaccines;
		} else {
			throw new VaccineException("Vaccine not found");
		}
		
	}

	@Override
	public List<Vaccine> getVaccineByName(String vaccineName, String key) throws VaccineException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			List<Vaccine> vaccines = vaccineDao.findVaccineByName(vaccineName, key);
			if (vaccines.size() != 0) {
				return vaccines;
			} else {
				throw new VaccineException("Vaccine not found with vaccine name - " + vaccineName);
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
		
	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId, String key) throws VaccineException, LoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine, String key) throws VaccineException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Vaccine vacc = vaccineDao.save(vaccine);
			if (vacc != null) {
				return vacc;
			} else {
				throw new VaccineException("Vaccine can not be added");
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
		
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine, String key) throws VaccineException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<Vaccine> opt = vaccineDao.findById(vaccine.getVaccineId());
			if (opt.isPresent()) {
				Vaccine updatedVaccine = vaccineDao.save(vaccine);
				return updatedVaccine;
			} else {
				throw new VaccineException("Vaccine not found ");
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

		
	}

	@Override
	public Boolean deleteVaccine(Integer vaccineId, String key) throws VaccineException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			boolean ans = false;
			Optional<Vaccine> opt = vaccineDao.findById(vaccineId);
			if (opt.isPresent()) {
				Vaccine v = opt.get();
				if (v.getVaccineCount().getQuantity() == 0) {
					vaccineDao.delete(v);
					ans = true;

				}

			} else {
				throw new VaccineException("Vaccine not found ");
			}
			return ans;
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
		
	}

}
