package com.ayushkaam.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.exception.VaccineException;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.model.VaccinationCenter;
import com.ayushkaam.model.Vaccine;
import com.ayushkaam.model.VaccineCount;
import com.ayushkaam.model.VaccineInventory;
import com.ayushkaam.repository.AdminSessionDao;
import com.ayushkaam.repository.VaccinationCenterDao;
import com.ayushkaam.repository.VaccineDao;
import com.ayushkaam.repository.VaccineInventoryDao;
import com.ayushkaam.service.VaccineInventoryService;

@Service
public class VaccineInventoryServiceImpl implements VaccineInventoryService{

	@Autowired
	private VaccineInventoryDao viDao;

	@Autowired
	private VaccineDao vDao;

	@Autowired
	private AdminSessionDao adminDao;

	@Autowired
	private VaccinationCenterDao vcDao;
	
	
	@Override
	public VaccineInventory addVaccineInventory(VaccineInventory vaccineInventory, String key)
			throws VaccineException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		if (currentSessionAdmin != null) {

			return viDao.save(vaccineInventory);

		} else {
			throw new LoginException("Oops...! Login as admin first.");
		}
		
		
	}

	@Override
	public VaccineInventory addVaccineCount(VaccineInventory vinv, Integer count, String key)
			throws VaccineException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		if (currentSessionAdmin != null) {

			Optional<VaccineInventory> opt = viDao.findById(vinv.getInventoryId());

			if (opt.isPresent()) {

				VaccineInventory vi = opt.get();

				if (count >= 0) {

					VaccineCount vcCount = vi.getVaccineCount();

					Integer update = vcCount.getQuantity() + count;

					Double price = vcCount.getPrice();

					vcCount.setQuantity(update);
					vcCount.setPrice(price);

					vi.setVaccineCount(vcCount);

					return viDao.save(vi);
				} else {
					throw new VaccineException("Count must be greater than 0.");
				}
			} else {
				throw new VaccineException("Vaccine Inventory not found.");
			}
		} else {
			throw new LoginException("Oops...! Login as admin first.");
		}

		
	}

	@Override
	public VaccineInventory getVaccineInventoryByCenter(Integer Centerid, String key)
			throws VaccineException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		if (currentSessionAdmin != null) {

			VaccinationCenter vc = vcDao.getVaccineCenterById(Centerid);

			if (vc != null) {
				System.out.println(vc.getCode() + " " + vc.getVaccineInventory());
				return vc.getVaccineInventory();
			} else {
				throw new VaccineException("Enter valid center id");
			}

		} else {
			throw new LoginException("Oops...! Login as admin first.");
		}
		
	}

	@Override
	public List<VaccineInventory> getVaccineInventoryByDate(LocalDate ld, String key)
			throws VaccineException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		if (currentSessionAdmin != null) {

			List<VaccineInventory> inventorylist = viDao.findByDate(ld);

			if (inventorylist.size() > 0) {

				return inventorylist;
			} else
				throw new VaccineException("Vaccine inventory not found");
		} else {
			throw new LoginException("Oops...! Login as admin first.");
		}
		
	}

	@Override
	public VaccineInventory getVaccineInventoryByVaccine(Vaccine vc, String key)
			throws VaccineException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		if (currentSessionAdmin != null) {
			VaccineInventory inventorylist = viDao.getVaccineInventoryByVaccine(vc.getVaccineId());

			if (inventorylist != null) {
				return inventorylist;
			} else {
				throw new VaccineException("Vaccine inventory not found vaccine id - " + vc.getVaccineId());
			}
		} else {
			throw new LoginException("Oops...! Login as admin first.");
		}
		
	}

	@Override
	public VaccineInventory updateVaccineInventory(VaccineInventory vinv, String key)
			throws VaccineException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		if (currentSessionAdmin != null) {

			// TODO Auto-generated method stub
			Optional<VaccineInventory> opt = viDao.findById(vinv.getInventoryId());

			if (opt.isPresent()) {

				VaccineInventory vi = opt.get();

				vi.setDate(vinv.getDate());
				vi.setInventoryId(vinv.getInventoryId());
				vi.setLocation(vinv.getLocation());
				vi.setVaccinationCenters(vinv.getVaccinationCenters());
				vi.setVaccineCount(vinv.getVaccineCount());

				return vi;
			} else
				throw new VaccineException("Vaccine inventory not found");
		} else {
			throw new LoginException("Oops...! Login as admin first.");
		}
		
	}

	@Override
	public boolean deleteVaccineInventory(VaccineInventory vinv, String key) throws VaccineException, LoginException {
		
		CurrentAdminSession currentSessionAdmin = adminDao.findByuuid(key);

		if (currentSessionAdmin != null) {

			Optional<VaccineInventory> opt = viDao.findById(vinv.getInventoryId());

			if (opt != null) {

				VaccineInventory vi = opt.get();

				viDao.delete(vi);

				return true;
			} else
				return false;

		} else {
			throw new LoginException("Oops...! Login as admin first.");
		}
		
		
	}

}
