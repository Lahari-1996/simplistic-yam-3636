package com.ayushkaam.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.exception.VaccineCenterException;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.model.CurrentUserSession;
import com.ayushkaam.model.VaccinationCenter;
import com.ayushkaam.repository.AdminSessionDao;
import com.ayushkaam.repository.UserSessionDao;
import com.ayushkaam.repository.VaccinationCenterDao;
import com.ayushkaam.service.VaccinationCenterService;

@Service
public class VaccineCenterServiceImpl implements VaccinationCenterService{

	@Autowired
	private VaccinationCenterDao vaccineDao;

	@Autowired
	private AdminSessionDao adminDao;

	@Autowired
	private UserSessionDao userDao;
	
	
	
	@Override
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center, String key)
			throws VaccineCenterException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccinationCenter> opt = vaccineDao.findById(center.getCode());

			if (opt.isPresent()) {

				throw new VaccineCenterException("sorry this Vaccination center already exist");
			} else
				return vaccineDao.save(center);
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");
		
	}

	@Override
	public List<VaccinationCenter> getAllVaccineCenters() throws VaccineCenterException {
		
		List<VaccinationCenter> allvaccenters = vaccineDao.findAll();

		if (allvaccenters.size() == 0) {

			throw new VaccineCenterException("No Vaccinaton Center found");
		}

		return allvaccenters;
		
	}

	@Override
	public VaccinationCenter getVaccineCenter(Integer centerId, String key)
			throws VaccineCenterException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccinationCenter> opt = vaccineDao.findById(centerId);

			if (opt.isPresent()) {

				VaccinationCenter vc = opt.get();

				return vc;

			} else
				throw new VaccineCenterException("Vaccination Center does not found with center id :" + centerId);
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

		
	}

	@Override
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center, String key)
			throws VaccineCenterException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccinationCenter> opt = vaccineDao.findById(center.getCode());

			if (opt.isPresent()) {

				VaccinationCenter vc = opt.get();

				return vaccineDao.save(vc);
			} else
				throw new VaccineCenterException("Vaccination Center does not exist to update");
		} else {
			throw new LoginException("Oops...! Login as a user/Admin first.");
		}
		
	}

	@Override
	public boolean deleteVaccinationCenter(VaccinationCenter center, String key)
			throws VaccineCenterException, LoginException {
		

		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		CurrentUserSession currentSessionUser = userDao.findByuuid(key);

		if (currentSessionAdmin != null || currentSessionUser != null) {

			Optional<VaccinationCenter> opt = vaccineDao.findById(center.getCode());

			if (opt.isPresent()) {

				VaccinationCenter vc = opt.get();

				vaccineDao.delete(vc);

				return true;

			} else {
				throw new VaccineCenterException("Vaccination Center cannot be deleted ");
			}
		} else
			throw new LoginException("Oops...! Login as a user/Admin first.");

		
		
	}

}
