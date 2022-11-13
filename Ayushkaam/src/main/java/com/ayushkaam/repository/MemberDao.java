package com.ayushkaam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.Member;
import com.ayushkaam.model.MemberSession;


@Repository
public interface MemberDao extends JpaRepository<Member, Integer>{

	
	public  Optional<Member> findByMobileNumber(String mobileNumber);
}
