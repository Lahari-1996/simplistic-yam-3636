package com.ayushkaam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.Admin;
import com.ayushkaam.model.MemberSession;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	 public Optional<Admin> findByAdminId(Integer adminId);
	 
	public Optional<Admin> findByAdminName(String mobileNo);
	
	public Optional<Admin> findByMobileNumber(String mobileNumber);
	
}
