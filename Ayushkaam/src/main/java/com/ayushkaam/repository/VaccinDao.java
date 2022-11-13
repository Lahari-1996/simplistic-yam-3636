package com.ayushkaam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.Vaccine;

@Repository
public interface VaccinDao extends JpaRepository<Vaccine, Integer>{

}
