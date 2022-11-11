package com.ayushkaam.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ayushkaam.model.Appointment;
import com.ayushkaam.model.Member;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long> {
	List<Appointment> findByMember(String mobileNumber);
}