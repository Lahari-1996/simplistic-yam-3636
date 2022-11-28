package com.ayushkaam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayushkaam.model.User;



@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	public User findByMobileNo(String mobileNo);
}
