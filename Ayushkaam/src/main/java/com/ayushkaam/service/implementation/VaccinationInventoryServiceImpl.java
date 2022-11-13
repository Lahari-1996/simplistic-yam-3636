package com.ayushkaam.service.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ayushkaam.model.VaccineInventory;
import com.ayushkaam.service.VaccinationInventoryService;

@Service
public class VaccinationInventoryServiceImpl implements VaccinationInventoryService{


	
	
	@Override
	public VaccineInventory saveVaccineInventory(VaccineInventory vaccineInv, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VaccineInventory> allVaccineInventory(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaccineInventory getVaccineInventoryByCenter(Integer centerid, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaccineInventory addVaccineCount(VaccineInventory inv, Integer vaccineId, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory inv, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteVaccineInventory(VaccineInventory inv, String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByVaccine(String vaccineName, String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
