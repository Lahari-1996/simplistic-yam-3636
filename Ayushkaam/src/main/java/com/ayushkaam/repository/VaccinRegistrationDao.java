package com.ayushkaam.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.VaccineRegistration;

@Repository
public interface VaccinRegistrationDao  extends JpaRepository<VaccineRegistration, Integer> {
	
	//public Optional<VaccineRegistration> findByMobileNo(String mobileNo);
	
	public VaccineRegistration findByMobileno(Long mobileno);
	
	
	

}