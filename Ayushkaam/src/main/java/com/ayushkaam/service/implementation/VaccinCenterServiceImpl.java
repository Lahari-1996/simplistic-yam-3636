package com.ayushkaam.service.implementation;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.VaccinationCenterException;
import com.ayushkaam.model.MemberSession;
import com.ayushkaam.model.VaccinationCenter;
import com.ayushkaam.repository.MemberSessionRepository;
import com.ayushkaam.repository.VaccinationCenterDao;
import com.ayushkaam.service.VaccinCenterService;



@Service
public class VaccinCenterServiceImpl implements VaccinCenterService {
	
	@Autowired
	public MemberSessionRepository loggedMembersDetails;
	
	
	@Autowired
	public MemberSessionRepository loggedAdminDetails;
	
	
	@Autowired
	public VaccinationCenterDao vaccineCenterDao;
	

	@Override
	public List<VaccinationCenter> getAllVaccineCenters(String key) throws VaccinationCenterException {
		
		
		Optional<MemberSession> member = loggedMembersDetails.findByToken(key);
		Optional<MemberSession> admin = loggedAdminDetails.findByToken(key);
		
		if(!member.isPresent() && !admin.isPresent()) {
			
			throw new VaccinationCenterException("unauthorized user....");
			
			
		}
		
		List<VaccinationCenter> listOfCenters = new ArrayList<>();
		
		listOfCenters = vaccineCenterDao.findAll();
		
		if(listOfCenters.isEmpty()) {
			
			throw  new VaccinationCenterException("No Centers Found...");
		}
		
		
		return listOfCenters;
		
		
	}

	@Override
	public VaccinationCenter getvaccineCenter(Integer centerId, String key) throws VaccinationCenterException {
		
		Optional<MemberSession> member = loggedMembersDetails.findByToken(key);
		Optional<MemberSession> admin = loggedAdminDetails.findByToken(key);
		
		if(!member.isPresent() && !admin.isPresent()) {
			
			throw new VaccinationCenterException("unauthorized user....");
			
			
		}
		
		Optional<VaccinationCenter> center = vaccineCenterDao.findById(centerId);
		
		if(!center.isPresent()) {
			
			throw new VaccinationCenterException("No Vaccine Centers found with the given ID...");
			
		}
		
		
		
		
		return center.get();
		
		
	}

	@Override
	public VaccinationCenter addVaccinationCenter(VaccinationCenter center, String key) throws VaccinationCenterException {
		
		Optional<MemberSession> admin = loggedAdminDetails.findByToken(key);
		
		if(!admin.isPresent()) {
			
			throw new VaccinationCenterException("unauthorized user....");
			
			
		}
		
		Optional<VaccinationCenter> found = vaccineCenterDao.findById(center.getCode());
		
		if(found.isPresent()) {
			
			throw new VaccinationCenterException("Center with the same Id already exists....");
		}
		
		
		return vaccineCenterDao.save(center);
		
	}

	@Override
	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center, String key) throws VaccinationCenterException {
		
		Optional<MemberSession> admin = loggedAdminDetails.findByToken(key);
		
		if(admin.isPresent()) {
			
			throw new VaccinationCenterException("unauthorized user....");
			
			
		}
		
		 Optional<VaccinationCenter> found = vaccineCenterDao.findById(center.getCode());
		
		 if(!found.isPresent()) {
			 
			 throw new VaccinationCenterException("Vaccination center not found with Id provided, Unable to update...");
			 
		 }
		 
		 
		
		 return vaccineCenterDao.save(center);
		 
	}

	@Override
	public boolean deleteVaccineCenter(VaccinationCenter center, String key) throws VaccinationCenterException {
		
		Optional<MemberSession> admin = loggedAdminDetails.findByToken(key);
		
		if(!admin.isPresent()) {
			
			throw new VaccinationCenterException("unauthorized user....");
			
			
		}
		
		Optional<VaccinationCenter> found = vaccineCenterDao.findById(center.getCode());
		
		if(!found.isPresent()) {
			
			throw new VaccinationCenterException("Vaccination Center not there with ID provided, Unable to delete...");
		}
		
		vaccineCenterDao.delete(center);
		
		return true;
	
	}
	
	
	


}
