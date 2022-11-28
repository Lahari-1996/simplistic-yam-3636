package com.ayushkaam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.CurrentUserSession;



@Repository
public interface UserSessionDao extends JpaRepository<CurrentUserSession, Integer>{
	public CurrentUserSession findByuuid(String uuid);

}
