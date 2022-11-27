//package com.ayushkaam.service.implementation;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ayushkaam.exception.MemberException;
//import com.ayushkaam.exception.VaccineRegistrationException;
//import com.ayushkaam.model.CurrentAdminSession;
//import com.ayushkaam.model.Member;
//import com.ayushkaam.model.MemberSession;
//import com.ayushkaam.model.VaccineRegistration;
//import com.ayushkaam.repository.CurrentAdminDao;
//import com.ayushkaam.repository.MemberDao;
//import com.ayushkaam.repository.MemberSessionDao;
//import com.ayushkaam.repository.VaccinRegistrationDao;
//import com.ayushkaam.service.VaccineRegistrationService;
//
//@Service
//public class VaccinRegistrationServiceImpl implements VaccineRegistrationService{
//	
//	@Autowired
//	public VaccinRegistrationDao vaccinRegistrationRepo; 
//	
//	@Autowired
//	public MemberSessionDao loggedMembersDetails;
//	
//	@Autowired
//	public CurrentAdminDao loggedAdminDetails;
//	
//	
//	@Autowired
//	public MemberDao memberDetails;
//	
//	
//	@Override
//	public List<VaccineRegistration> allVaccineRegistration(String mobileNo) {
//		
//		Optional<MemberSession> user = loggedMembersDetails.findByMobileNumber(mobileNo);
//		Optional<CurrentAdminSession> admin = loggedAdminDetails.findByAdminMobile(mobileNo);
//
//		
//		if(!user.isPresent() && !admin.isPresent()) { 
//			
//			throw new VaccineRegistrationException("Unauthorized user...");
//			
//		}
//		
//		List<VaccineRegistration> listOfVaccineRegistrations = vaccinRegistrationRepo.findAll();
//		
//		
//		if(listOfVaccineRegistrations.isEmpty()) {
//			
//			throw new VaccineRegistrationException("No Registrations found with this Mobile Number...");
//			
//		}
//		
//		return listOfVaccineRegistrations;
//	
//	
//	}
//
//	@Override
//	public VaccineRegistration getVaccineRegistration( String mobileNo) { 
//		
//		Optional<MemberSession> user = loggedMembersDetails.findByMobileNumber(mobileNo);
//		Optional<CurrentAdminSession> admin = loggedAdminDetails.findByAdminMobile(mobileNo);
//
//		
//			if(!user.isPresent() && !admin.isPresent() ){ 
//			
//				throw new VaccineRegistrationException("Unauthorized user...");
//			
//			}
//			
//			Optional<VaccineRegistration> registration = vaccinRegistrationRepo.findByMobileNo(mobileNo);
//			
//			if(!registration.isPresent()) {
//				
//				throw new VaccineRegistrationException("No Registrations Found with : "+mobileNo);
//				
//			}
//			
//			
//		return registration.get();
//		
//	
//	}
//
//	@Override
//	public Member getRegisteredMemberByMobileNumber (String mobileNo) {
//		
//		
//		Optional<MemberSession> user = loggedMembersDetails.findByMobileNumber(mobileNo);
//		Optional<CurrentAdminSession> admin = loggedAdminDetails.findByAdminMobile(mobileNo);
//
//		
//		if( !user.isPresent() && !admin.isPresent() ) { 
//		
//			throw new VaccineRegistrationException("Unauthorized user...");
//		
//		}
//		
//		Optional<VaccineRegistration> registration = vaccinRegistrationRepo.findByMobileNo(mobileNo);
//		
//		if(!registration.isPresent()) {
//			
//			throw new VaccineRegistrationException("No registtration found with mobile number : "+mobileNo);
//			
//		}
//		
////		VaccineRegistration foundVaccineRegistration = registration.get();
////		
////		Member vaccinationRegistrationMembers = foundVaccineRegistration.getMember();
//
//		
//	
//	return registration.get().getMember(); 
//	
//	}
//	
//	
//
//	@Override
//	public VaccineRegistration addVaccineRegistration( String mobileNo) { 
//		
//		Optional<MemberSession> user = loggedMembersDetails.findByMobileNumber(mobileNo); 
//		Optional<CurrentAdminSession> admin = loggedAdminDetails.findByAdminMobile(mobileNo);
//
//		
//			if(!user.isPresent() && !admin.isPresent() ) { 
//		
//				throw new VaccineRegistrationException("Unauthorized user...");
//		
//			}
//			
//			Optional<VaccineRegistration> registration = vaccinRegistrationRepo.findByMobileNo(mobileNo);
//			
//			if(registration.isPresent()) {
//				
//				throw new VaccineRegistrationException("Vaccination Registration present with the mobile Number...");
//				
//			}
//			
//			
//			
//			
//			
//			VaccineRegistration newRegister = new VaccineRegistration();
//			
//			newRegister.setMobileNo(mobileNo);
//			newRegister.setDateofregistration(LocalDate.now());
//			newRegister.setMember( memberDetails.findByMobileNumber(mobileNo).get());
//			
//		
//			
//		return vaccinRegistrationRepo.save(newRegister);
// 		
//		 
//	}
//
//	@Override
//	public VaccineRegistration updateVaccineRegistration(String mobileNo, String newMobileNo) {
//		
//		
//		Optional<MemberSession> user = loggedMembersDetails.findByMobileNumber(mobileNo);
//		Optional<CurrentAdminSession> admin = loggedAdminDetails.findByAdminMobile(mobileNo);
//
//		
//			if(!user.isPresent() && !admin.isPresent() ) { 
//		
//				throw new VaccineRegistrationException("Unauthorized user...");
//		
//			}
//			
//			Optional<VaccineRegistration> registration = vaccinRegistrationRepo.findById(mobileNo);
//			
//			if(!registration.isPresent()) {
//				
//				throw new VaccineRegistrationException("Registration Not found with Mobile Number : "+mobileNo);
//				
//			}
//			
//			VaccineRegistration update = registration.get();
//			
//			update.setMobileNo(newMobileNo);
//			update.setDateofregistration(LocalDate.now());
//			
//			VaccineRegistration ans  = vaccinRegistrationRepo.save(update);
//		
//		return ans;
//	
//	
//	}
//
//	@Override
//	public boolean deleteVaccineRegistration(String mobileNo ) {
//		
//		
//		Optional<MemberSession> user = loggedMembersDetails.findByMobileNumber(mobileNo);
//		Optional<CurrentAdminSession> admin = loggedAdminDetails.findByAdminMobile(mobileNo);
//
//		
//			if(!user.isPresent() && !admin.isPresent()) { 
//		
//				throw new VaccineRegistrationException("Unauthorized user...");
//		
//			}
//			
//			Optional<VaccineRegistration> registration =  vaccinRegistrationRepo.findByMobileNo(mobileNo);
//			
//			if(!registration.isPresent()) {
//				
//				throw new VaccineRegistrationException("Registration not found with mobile Number : "+mobileNo);
//				
//				
//			}
//			
//			vaccinRegistrationRepo.deleteById(registration.get().getMobileNo());
//			
//			return true;
//		
//		
//		
//	}
//
//}
