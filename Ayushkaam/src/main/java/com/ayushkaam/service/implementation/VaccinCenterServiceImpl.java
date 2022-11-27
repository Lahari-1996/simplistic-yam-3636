//package com.ayushkaam.service.implementation;
//
//import java.util.ArrayList;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ayushkaam.exception.MemberNotFoundException;
//import com.ayushkaam.exception.VaccinationCenterException;
//import com.ayushkaam.model.CurrentAdminSession;
//import com.ayushkaam.model.Member;
//import com.ayushkaam.model.MemberSession;
//import com.ayushkaam.model.VaccinationCenter;
//import com.ayushkaam.repository.AdminDao;
//import com.ayushkaam.repository.CurrentAdminDao;
//import com.ayushkaam.repository.MemberDao;
//import com.ayushkaam.repository.MemberSessionDao;
//import com.ayushkaam.repository.VaccinationCenterDao;
//import com.ayushkaam.service.VaccinationCenterService;
//
//
//
//@Service
//public class VaccinCenterServiceImpl implements VaccinationCenterService {
//	
//	@Autowired
//	public MemberSessionDao loggedMembersDetails;
//	
//	
//	@Autowired
//	public CurrentAdminDao loggedAdminDetails;
//	
//	
//	@Autowired
//	public VaccinationCenterDao vaccineCenterDao;
//	
//	
////	@Autowired
////	public AdminDao memberDao;
//	
//
//	@Override
//	public List<VaccinationCenter> getAllVaccineCenters(String mobileNo) throws VaccinationCenterException , MemberNotFoundException{
//		
//		
//		Optional<MemberSession> member = loggedMembersDetails.findByMobileNumber(mobileNo);
//		Optional<CurrentAdminSession> admin = loggedAdminDetails.findByAdminMobile(mobileNo);
//
//		
//		if( !member.isPresent() && !admin.isPresent() ) {
//			
//			throw new VaccinationCenterException("unauthorized user....");
//			
//			
//		}
//		
//		
//		
//		
//		List<VaccinationCenter> listOfVaccinationCenter = vaccineCenterDao.findAll();
//		
//		if(listOfVaccinationCenter.isEmpty()) {
//			
//			throw new VaccinationCenterException("NO vaccination centerss found...");
//		}
//		
//		
//		
//		
//		return listOfVaccinationCenter;
//		
//	}
//
//	@Override
//	public VaccinationCenter getvaccineCenter(Integer centerId, String mobileNo) throws VaccinationCenterException {
//		
//		Optional<MemberSession> member = loggedMembersDetails.findByMobileNumber(mobileNo);
//		Optional<CurrentAdminSession> admin = loggedAdminDetails.findByAdminMobile(mobileNo);
//
//		
//		if( !member.isPresent() && !admin.isPresent() ) {
//			
//			throw new VaccinationCenterException("unauthorized user....");
//			
//			
//		}
//		
//		Optional<VaccinationCenter> center = vaccineCenterDao.findById(centerId);
//		
//		if(!center.isPresent()) {
//			
//			throw new VaccinationCenterException("No Vaccine Centers found with the given ID...");
//			
//		}
//		
//		
//		
//		
//		return center.get();
//		
//		
//	}
//
//	@Override
//	public VaccinationCenter addVaccinationCenter(VaccinationCenter center, String mobileNo) throws VaccinationCenterException {
//		
//		Optional<MemberSession> member = loggedMembersDetails.findByMobileNumber(mobileNo);
//		Optional<CurrentAdminSession> admin = loggedAdminDetails.findByAdminMobile(mobileNo);
//
//		
//		if( !member.isPresent() && !admin.isPresent() ) {
//			
//			throw new VaccinationCenterException("unauthorized user....");
//			
//			
//		}
//		
//		
//		
//		Optional<VaccinationCenter> found = vaccineCenterDao.findById(center.getCode());
//		
//		if(found.isPresent()) {
//			
//			throw new VaccinationCenterException("Center with the same Id already exists....");
//		}
//		
//		
//		return vaccineCenterDao.save(center);
//		
//	}
//
//	@Override
//	public VaccinationCenter updateVaccinationCenter(VaccinationCenter center, String mobileNo) throws VaccinationCenterException {
//		
//		Optional<MemberSession> member = loggedMembersDetails.findByMobileNumber(mobileNo);
//		Optional<CurrentAdminSession> admin = loggedAdminDetails.findByAdminMobile(mobileNo);
//
//		
//		if( !member.isPresent() && !admin.isPresent() ) {
//			
//			throw new VaccinationCenterException("unauthorized user....");
//			
//			
//		}
//		
//		 Optional<VaccinationCenter> found = vaccineCenterDao.findById(center.getCode());
//		
//		 if(!found.isPresent()) {
//			 
//			 throw new VaccinationCenterException("Vaccination center not found with Id provided, Unable to update...");
//			 
//		 }
//		 
//		 
//		
//		 return vaccineCenterDao.save(center);
//		 
//	}
//
//	@Override
//	public boolean deleteVaccineCenter(VaccinationCenter center, String mobileNo) throws VaccinationCenterException {
//		
//		Optional<MemberSession> member = loggedMembersDetails.findByMobileNumber(mobileNo);
//		Optional<CurrentAdminSession> admin = loggedAdminDetails.findByAdminMobile(mobileNo);
//
//		
//		if( !member.isPresent() && !admin.isPresent() ) {
//			
//			throw new VaccinationCenterException("unauthorized user....");
//			
//			
//		}
//		
//		Optional<VaccinationCenter> found = vaccineCenterDao.findById(center.getCode());
//		
//		if(!found.isPresent()) {
//			
//			throw new VaccinationCenterException("Vaccination Center not there with ID provided, Unable to delete...");
//		}
//		
//		vaccineCenterDao.delete(center);
//		
//		return true;
//	
//	}
//	
//	
//	
//
//
//}
