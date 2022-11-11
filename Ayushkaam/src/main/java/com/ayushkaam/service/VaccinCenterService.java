package com.ayushkaam.service;

import java.util.List;

import com.ayushkaam.exception.VaccinationCenterException;
import com.ayushkaam.model.VaccinationCenter;

public interface VaccinCenterService {
	
	
	public List<VaccinationCenter> getAllVaccineCenters(String key) throws VaccinationCenterException;

	public VaccinationCenter getvaccineCenter(Integer centerId, String key) throws VaccinationCenterException;
	
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center, String key) throws VaccinationCenterException;
	
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center, String key) throws VaccinationCenterException;
	
	public boolean deleteVaccineCenter (VaccinationCenter center, String key) throws VaccinationCenterException;
	
	

	
}
