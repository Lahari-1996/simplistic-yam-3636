package com.ayushkaam.repository;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ayushkaam.model.Admin;
import com.ayushkaam.model.CurrentAdminSession;


@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

	public Admin findByMobile(String mobileNo);

}