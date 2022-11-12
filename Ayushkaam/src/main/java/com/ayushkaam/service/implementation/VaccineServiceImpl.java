package com.ayushkaam.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.model.Vaccine;
import com.ayushkaam.repository.AppointmentDao;
import com.ayushkaam.repository.MemberSessionDao;
import com.ayushkaam.repository.VaccinDao;
import com.ayushkaam.service.VaccineService;

@Service
public class VaccineServiceImpl implements VaccineService{

	@Autowired
	private VaccinDao dao;
	
	@Autowired
	private AppointmentDao appointmentDAO;
	
	@Autowired
	private MemberSessionDao memberSessionDAO;

	@Override
	public List<Vaccine> allVaccine(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine getVaccineByName(String VaccineName, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteVaccine(Vaccine vaccine, String key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	}


