package com.ayushkaam.service;

import java.util.List;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.exception.VaccineCenterException;
import com.ayushkaam.model.VaccinationCenter;

public interface VaccinationCenterService {
	
	
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center, String key)
			throws VaccineCenterException, LoginException;
	
	
	public List<VaccinationCenter> getAllVaccineCenters() throws VaccineCenterException;

	public VaccinationCenter getVaccineCenter(Integer centerId, String key)
			throws VaccineCenterException, LoginException;


	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center, String key)
			throws VaccineCenterException, LoginException;

	public boolean deleteVaccinationCenter(VaccinationCenter center, String key)
			throws VaccineCenterException, LoginException;
		
	

	
}
