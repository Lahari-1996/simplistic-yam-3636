package com.ayushkaam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.Member;


@Repository
public interface MemberDao extends JpaRepository<Member, Long>{

}
