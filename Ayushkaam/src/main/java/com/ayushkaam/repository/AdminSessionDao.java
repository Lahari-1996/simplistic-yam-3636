package com.ayushkaam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.CurrentAdminSession;



@Repository
public interface AdminSessionDao extends JpaRepository<CurrentAdminSession, Integer> {
	public CurrentAdminSession findByuuid(String uuid);
}

