package com.ayushkaam.service;

import java.time.LocalDate;
import java.util.List;

import com.ayushkaam.exception.VaccineInventoryNotFoundException;
import com.ayushkaam.model.VaccineInventory;

public interface VaccinationInventoryService {
	
	public VaccineInventory saveVaccineInventory(VaccineInventory vaccineInv, String key) throws VaccineInventoryNotFoundException;

	public List<VaccineInventory> allVaccineInventory(String key) throws VaccineInventoryNotFoundException;
	
	public VaccineInventory getVaccineInventoryByCenter(Integer centerid,String key) throws VaccineInventoryNotFoundException;
	
	public  VaccineInventory addVaccineCount(VaccineInventory inv,Integer vaccineId,String key) throws VaccineInventoryNotFoundException;
	
	public VaccineInventory updateVaccineInventory(VaccineInventory inv,String key) throws VaccineInventoryNotFoundException;

	public boolean deleteVaccineInventory(VaccineInventory inv,String key) throws VaccineInventoryNotFoundException;
	
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date,String key) throws VaccineInventoryNotFoundException;
	
	public List<VaccineInventory> getVaccineInventoryByVaccine(String vaccineName,String key) throws VaccineInventoryNotFoundException;

}
