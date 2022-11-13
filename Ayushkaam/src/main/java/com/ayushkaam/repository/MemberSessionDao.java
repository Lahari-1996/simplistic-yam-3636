package com.ayushkaam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.MemberSession;


@Repository
public interface MemberSessionDao extends JpaRepository<MemberSession, Long>{

	
	public Optional<MemberSession> findByToken(String token);
	
	public  Optional<MemberSession> findByMobileNumber(String mobileNumber);

}
