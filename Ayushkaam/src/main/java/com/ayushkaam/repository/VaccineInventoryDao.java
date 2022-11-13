package com.ayushkaam.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.VaccineInventory;

@Repository
public interface VaccineInventoryDao extends JpaRepository<VaccineInventory, Integer> {

	public List<VaccineInventory> findByDate(LocalDate date);
}
