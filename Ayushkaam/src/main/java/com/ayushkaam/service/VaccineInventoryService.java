
package com.ayushkaam.service;

import java.time.LocalDate;
import java.util.List;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.exception.VaccineException;
import com.ayushkaam.model.Vaccine;
import com.ayushkaam.model.VaccineInventory;

public interface VaccineInventoryService {

	
	public VaccineInventory addVaccineInventory(VaccineInventory vaccineInventory, String key)
			throws VaccineException, LoginException;
	
	public VaccineInventory addVaccineCount(VaccineInventory vinv, Integer count, String key)
			throws VaccineException, LoginException;
	
	
	public VaccineInventory getVaccineInventoryByCenter(Integer Centerid, String key)
			throws VaccineException, LoginException;
	
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate ld, String key)
			throws VaccineException, LoginException;

	public VaccineInventory getVaccineInventoryByVaccine(Vaccine vc, String key)
			throws VaccineException, LoginException;

	
	public VaccineInventory updateVaccineInventory(VaccineInventory vinv, String key)
			throws VaccineException, LoginException;

	public boolean deleteVaccineInventory(VaccineInventory vinv, String key) throws VaccineException, LoginException;

	

	
	
}


