package com.ayushkaam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.exception.VaccineException;
import com.ayushkaam.model.Vaccine;


public interface VaccineService {
	
	public List<Vaccine> allVaccines() throws VaccineException;

	public List<Vaccine> getVaccineByName(String vaccineName, String key) throws VaccineException, LoginException;

	public Vaccine getVaccineById(Integer vaccineId, String key) throws VaccineException, LoginException;

	public Vaccine addVaccine(Vaccine vaccine, String key) throws VaccineException, LoginException;

	public Vaccine updateVaccine(Vaccine vaccine, String key) throws VaccineException, LoginException;

	public Boolean deleteVaccine(Integer vaccineId, String key) throws VaccineException, LoginException;

}
