package com.ayushkaam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayushkaam.model.VaccinationCenter;

public interface VaccinationCenterDao extends JpaRepository<VaccinationCenter, Integer> {
	
	

}
