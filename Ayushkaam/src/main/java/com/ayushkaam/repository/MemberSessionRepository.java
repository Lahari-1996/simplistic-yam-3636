package com.ayushkaam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.MemberSession;


@Repository
public interface MemberSessionRepository extends JpaRepository<MemberSession, Long>{

	public MemberSession findByToken(String token);

}
