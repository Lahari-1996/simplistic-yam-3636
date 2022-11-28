package com.ayushkaam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.ayushkaam.model.VaccinationCenter;

@Repository
public interface VaccinationCenterDao extends JpaRepository<VaccinationCenter, Integer> {
	
	//public List<VaccinationCenter> findByPincode(String pincode);
	
	@Query("select c from VaccinationCenter c where c.centername=?1")
	public VaccinationCenter findVaccinationCenterByName(String centername, String key);

	@Query("select c from VaccinationCenter c where c.code = ?1")
	public VaccinationCenter getVaccineCenterById(Integer vcId);
}
