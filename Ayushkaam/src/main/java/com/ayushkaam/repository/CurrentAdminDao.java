package com.ayushkaam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ayushkaam.model.CurrentAdminSession;

@Repository
public interface CurrentAdminDao extends JpaRepository<CurrentAdminSession, Integer>{
	
	 
	public Optional<CurrentAdminSession> findByAdminName(String adminName);
	public Optional<CurrentAdminSession> findByAdminMobile(String mobileNumber ); 
	
}
