<<<<<<< HEAD
//package com.ayushkaam.service.implementation;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ayushkaam.exception.VaccineInventoryNotFoundException;
//import com.ayushkaam.model.Appointment;
//import com.ayushkaam.model.VaccinationCenter;
//import com.ayushkaam.model.VaccineCount;
//import com.ayushkaam.model.VaccineInventory;
//import com.ayushkaam.repository.AppointmentDao;
//import com.ayushkaam.repository.VaccinationCenterDao;
//import com.ayushkaam.repository.VaccineCountDao;
//import com.ayushkaam.repository.VaccineInventoryDao;
//import com.ayushkaam.service.VaccinationCenterService;
//import com.ayushkaam.service.VaccinationInventoryService;
//
//@Service
//public class VaccinationInventoryServiceImpl implements VaccinationInventoryService{
// 
//  @Autowired
//  private VaccineInventoryDao vaccineInvDao;
//  
//  @Autowired
//  private VaccinationCenterService vaccineCenterService;
//  
//  @Autowired
//  private VaccineCountDao vaccinecountdao;
//  
//  @Autowired
//  private VaccinationCenterDao vctDao;
//  
//  @Autowired
//  private AppointmentDao appointmentDAO;
//	
//	
//	
//	@Override
//	public VaccineInventory saveVaccineInventory(VaccineInventory vaccineInv, String key) throws VaccineInventoryNotFoundException {
//		
//        Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
//		
//		if(!optCurrAdmin.isPresent()) {
//			throw new RuntimeException("Unauthorised access");
//		}
//		
//		Optional<VaccineInventory> opt = vaccineInvDao.findById(vaccineInv.getInventoryId());
//		if (opt.isPresent()) {
//			throw new VaccineInventoryNotFoundException("VaccineInventory already exists!");
//		}
//
//
//		List<VaccinationCenter> vaccineCenterList = vaccineInv.getVaccinationCenter();
//		for (VaccinationCenter vaccinationCenter : vaccineCenterList) {
//			vaccinationCenter.setVaccineInventory(vaccineInv);
//
//		}
//
//		List<VaccineCount> vaccinecountList = vaccineInv.getVaccinecount();
//		for (VaccineCount vaccineCount : vaccinecountList) {
//			vaccineCount.setVaccineInventory(vaccineInv);
//
//		}
//		return vaccineInvDao.save(vaccineInv);
//	}
//
//	@Override
//	public List<VaccineInventory> allVaccineInventory(String key) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public VaccineInventory getVaccineInventoryByCenter(Integer centerid, String key) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public VaccineInventory addVaccineCount(VaccineInventory inv, Integer vaccineId, String key) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public VaccineInventory updateVaccineInventory(VaccineInventory inv, String key) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean deleteVaccineInventory(VaccineInventory inv, String key) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date, String key) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<VaccineInventory> getVaccineInventoryByVaccine(String vaccineName, String key) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
=======
package com.ayushkaam.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.VaccineInventoryNotFoundException;
import com.ayushkaam.exception.VaccineNotFoundException;
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
	public VaccineInventory saveVaccineInventory(VaccineInventory vaccineInv, String key) throws VaccineInventoryNotFoundException {
		
        Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		if(!optCurrAdmin.isPresent()) {
			throw new RuntimeException("Unauthorised access");
		}
		
		Optional<VaccineInventory> opt = vaccineInvDao.findById(vaccineInv.getInventoryId());
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
	public List<VaccineInventory> allVaccineInventory(String key) throws VaccineInventoryNotFoundException {
		
		 Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
			
			if(!optCurrAdmin.isPresent()) {
				throw new RuntimeException("Unauthorised access");
			}
			
			List<VaccineInventory> vaccineInventoryList = vaccineInvDao.findAll();
			if (vaccineInventoryList.size() > 0) {
				return vaccineInventoryList;
			}
			throw new VaccineInventoryNotFoundException("Vaccine Inventory is not found ");
	}


	@Override
	public VaccineInventory getVaccineInventoryByCenter(Integer centerid, String key) throws VaccineInventoryNotFoundException {
	
		 Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
			
			if(!optCurrAdmin.isPresent()) {
				throw new RuntimeException("Unauthorised access");
			}
			
			VaccinationCenter vc = vaccineCenterService.getvaccineCenter(centerid, key);
			if (vc == null) {
				throw new VaccineInventoryNotFoundException("Vaccine Inventory not found!");
			}
			return vc.getVaccineInventory();
	
	}

	@Override
	public VaccineInventory addVaccineCount(VaccineInventory inv, Integer vaccineId, String key) throws VaccineInventoryNotFoundException {
	
		Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		if(!optCurrAdmin.isPresent()) {
			throw new RuntimeException("Unauthorised access");
		}
		
		Optional<VaccineInventory> opt = vaccineInvDao.findById(inv.getInventoryId());

		if (opt.isPresent()) {
			VaccineInventory vacInv = opt.get();

			List<VaccineCount> vcList = vacInv.getVaccinecount();
			int count = 0;
			for (VaccineCount vaccineCount : vcList) {
				if (vaccineCount.getVaccine() != null) {
					if (vaccineCount.getVaccine().getVaccineId() == vaccineId) {
						count++;
						vaccineCount.setQuantity(vaccineCount.getQuantity() + 1);
					}
				}
			}
			if (count == 0) {
				throw new VaccineNotFoundException("Vaccine not found by id: " + vaccineId);
			}
			return vaccineInvDao.save(vacInv);
		}
		throw new VaccineInventoryNotFoundException("Vaccine Inventory not found!");

	}
	

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory inv, String key) throws VaccineInventoryNotFoundException {
		
		Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		if(!optCurrAdmin.isPresent()) {
			throw new RuntimeException("Unauthorised access");
		}
		
		Optional<VaccineInventory> vacInvOpt = vaccineInvDao.findById(inv.getInventoryId());
		if (vacInvOpt.isPresent()) {

			// saving vaccine count and centers
			List<VaccinationCenter> vaccineCenterList = inv.getVaccinationCenter();
			for (VaccinationCenter vaccinationCenter : vaccineCenterList) {
				vctDao.save(vaccinationCenter);
				vaccinationCenter.setVaccineInventory(inv);
			}

			List<VaccineCount> vaccinecountList = inv.getVaccinecount();
			for (VaccineCount vaccineCount : vaccinecountList) {
				vaccinecountdao.save(vaccineCount);
				vaccineCount.setVaccineInventory(inv);
			}
			// till here
			return vaccineInvDao.save(inv);
		}
		throw new VaccineInventoryNotFoundException("Vaccine Inventory not found!");
		
	}

	@Override
	public boolean deleteVaccineInventory(VaccineInventory inv, String key) throws VaccineInventoryNotFoundException {
		
		Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		if(!optCurrAdmin.isPresent()) {
			throw new RuntimeException("Unauthorised access");
		}
		
		boolean flag = false;

		Optional<VaccineInventory> vacInvOpt = vaccineInvDao.findById(inv.getInventoryId());
		if (vacInvOpt.isPresent()) {
			flag = true;
			VaccineInventory vacInv = vacInvOpt.get();
			vaccineInvDao.delete(vacInv);
			return flag;
		}
		throw new VaccineInventoryNotFoundException("Vaccine Inventory not found!");
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate date, String key) throws VaccineInventoryNotFoundException {
		
		Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		if(!optCurrAdmin.isPresent()) {
			throw new RuntimeException("Unauthorised access");
		}
		
		List<VaccineInventory> vacInvList = vaccineInvDao.findByDate(date);
		if (vacInvList.size() > 0) {
			return vacInvList;
		}
		throw new VaccineInventoryNotFoundException("No Vaccine Inventory found!");
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByVaccine(String vaccineName, String key) throws VaccineInventoryNotFoundException {
		
		Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		if(!optCurrAdmin.isPresent()) {
			throw new RuntimeException("Unauthorised access");
		}
		List<VaccineInventory> vaccineInventoryList = vaccineInvDao.findAll();
		if (vaccineInventoryList.size() == 0) {
			throw new VaccineInventoryNotFoundException("List empty, need to add Inventory first!");
		}
		List<VaccineInventory> foundedvaccineInventoryList = new ArrayList<>();
		int count = 0;
		for (VaccineInventory vaccineInventory : vaccineInventoryList) {

			List<VaccineCount> vaccineCountList = vaccineInventory.getVaccinecount();
			if (vaccineCountList.size() == 0) {
				throw new VaccineInventoryNotFoundException("List empty, need to add VaccineCount first!");
			}

			for (VaccineCount vaccineCount : vaccineCountList) {

				if (!(vaccineCount.getVaccine() == null)) {
					if (vaccineCount.getVaccine().getVaccinename().equalsIgnoreCase(vaccineName)) {
						foundedvaccineInventoryList.add(vaccineInventory);
						count++;
					}
				}
			}
		}
		if (count == 0) {
			throw new VaccineNotFoundException("Vaccine not found by name: " + vaccineName);
		}

		return foundedvaccineInventoryList;
		
		
		
	}

}
>>>>>>> 61b90d825034b95bc04c067ac06722c5a9da5473
