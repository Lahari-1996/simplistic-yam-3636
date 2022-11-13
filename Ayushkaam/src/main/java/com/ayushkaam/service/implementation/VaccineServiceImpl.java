package com.ayushkaam.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.VaccineNotFoundException;
import com.ayushkaam.model.Appointment;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.model.MemberSession;
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
	
		Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		Optional<MemberSession> optMembSession = memberSessionDAO.findByToken(key);
		
		if(!optCurrAdmin.isPresent()&&!optMembSession.isPresent()) {
			
			throw new RuntimeException("Unauthorised access");
		}
		
		List<Vaccine> list = dao.findAll();

		if (list.size() > 0)
			return list;
		else
			throw new VaccineNotFoundException("No Vaccines Available");
	}

	@Override
	public Vaccine getVaccineByName(String VaccineName, String key) {
		
		Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		if(!optCurrAdmin.isPresent()) {
			throw new RuntimeException("Unauthorised access");
		}
		
       Optional<Vaccine> vaccine = dao.findByvaccinename(VaccineName);
		
		if(vaccine != null) return vaccine.get();
		else throw new VaccineNotFoundException("Vaccine with name " + VaccineName + " in not available");
		
		
	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId, String key) {
		
      Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		if(!optCurrAdmin.isPresent()) {
			throw new RuntimeException("Unauthorised access");
		}
		Optional<Vaccine> opt = dao.findById(vaccineId);

		if (opt.isPresent())
			return opt.get();

		else
			throw new VaccineNotFoundException("Vaccine with Id " + vaccineId + " is not available");
		
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine, String key) {
	
		 Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
			
			if(!optCurrAdmin.isPresent()) {
				throw new RuntimeException("Unauthorised access");
			}
			Optional<Vaccine> vacc = dao.findByvaccinename(vaccine.getVaccinename());
			
			if(vacc.get() == null) {


	            return dao.save(vaccine);
			}
			throw new RuntimeException("Vaccine already exists!");	
		
	}

	
	@Override
	public Vaccine updateVaccine(Vaccine vaccine, String key) {
	
		Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		if(!optCurrAdmin.isPresent()) {
			throw new RuntimeException("Unauthorised access");
		}
		
		Optional<Vaccine> opt = dao.findById(vaccine.getVaccineId());

		if (opt.isPresent()) {
			return dao.save(vaccine);
		} else
			throw new VaccineNotFoundException("The vaccine you want to update does not exist!");
		
	}

	
	
	@Override
	public boolean deleteVaccine(Vaccine vaccine, String key) {
		
		
		Optional<Appointment> optCurrAdmin = appointmentDAO.findByMembers(key);
		
		if(!optCurrAdmin.isPresent()) {
			throw new RuntimeException("Unauthorised access");
		}
		Optional<Vaccine> opt = dao.findById(vaccine.getVaccineId());

		if (opt.isPresent()) {
			dao.delete(vaccine);
			return true;
		} else
			throw new VaccineNotFoundException("The vaccine you want to delete does not exist!");
	}
	
	
	}


