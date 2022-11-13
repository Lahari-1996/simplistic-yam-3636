package com.ayushkaam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.Vaccine;
import com.ayushkaam.model.VaccineCount;

@Repository
public interface VaccineCountDao extends JpaRepository<VaccineCount, Integer>  {

	
	VaccineCount findByvaccine(Vaccine vaccine);

	VaccineCount findByvaccineId(Integer vaccineid);
}
