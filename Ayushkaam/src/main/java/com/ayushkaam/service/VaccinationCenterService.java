package com.ayushkaam.service;

import java.util.List;

import com.ayushkaam.exception.VaccinationCenterException;
import com.ayushkaam.model.VaccinationCenter;

public interface VaccinationCenterService {
	
	
	public List<VaccinationCenter> getAllVaccineCenters(String mobileNo) throws VaccinationCenterException;

	public VaccinationCenter getvaccineCenter(Integer centerId, String mobileNo) throws VaccinationCenterException;
	
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center, String mobileNo) throws VaccinationCenterException;
	
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center, String mobileNo) throws VaccinationCenterException;
	
	public boolean deleteVaccineCenter (VaccinationCenter center, String mobileNo) throws VaccinationCenterException;
	
	

	
}
