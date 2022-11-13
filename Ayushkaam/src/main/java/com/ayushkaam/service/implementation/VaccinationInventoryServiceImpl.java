package com.ayushkaam.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.VaccineInventoryNotFoundException;
import com.ayushkaam.model.Appointment;
import com.ayushkaam.model.VaccinationCenter;
import com.ayushkaam.model.VaccineCount;
import com.ayushkaam.model.VaccineInventory;
import com.ayushkaam.repository.AppointmentDao;
import com.ayushkaam.repository.VaccinationCenterDao;
import com.ayushkaam.repository.VaccineCountDao;
import com.ayushkaam.repository.VaccineInventoryDao;
import com.ayushkaam.service.VaccinationCenterService;
import com.ayushkaam.service.VaccinationInventoryService;

@Service
public class VaccinationInventoryServiceImpl implements VaccinationInventoryService{
 
  @Autowired
  private VaccineInventoryDao vaccineInvDao;
  
  @Autowired
  private VaccinationCenterService vaccineCenterService;
  
  @Autowired
  private VaccineCountDao vaccinecountdao;
  
  @Autowired
  private VaccinationCenterDao vctDao;
  
  @Autowired
  private AppointmentDao appointmentDAO;
	
	
	
	@Override
	public VaccineInventory saveVaccineInventory(VaccineInventory vaccineInv, String key) {
		
        Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		if(!optCurrAdmin.isPresent()) {
			throw new RuntimeException("Unauthorised access");
		}
		
		Optional<VaccineInventory> opt = vaccineInvDao.findById(vaccineInvDao.getInventoryId());
		if (opt.isPresent()) {
			throw new VaccineInventoryNotFoundException("VaccineInventory already exists!");
		}


		List<VaccinationCenter> vaccineCenterList = vaccineInv.getVaccinationCenter();
		for (VaccinationCenter vaccinationCenter : vaccineCenterList) {
			vaccinationCenter.setVaccineInventory(vaccineInv);

		}

		List<VaccineCount> vaccinecountList = vaccineInv.getVaccinecount();
		for (VaccineCount vaccineCount : vaccinecountList) {
			vaccineCount.setVaccineInventory(vaccineInv);

		}
		return vaccineInvDao.save(vaccineInv);
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
