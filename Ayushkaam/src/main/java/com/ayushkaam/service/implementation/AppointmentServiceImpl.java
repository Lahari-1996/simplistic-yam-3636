package com.ayushkaam.service.implementation;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.AppointmentException;
import com.ayushkaam.exception.AppointmentNotFoundException;
import com.ayushkaam.model.Admin;
import com.ayushkaam.model.Appointment;
//import com.ayushkaam.model.CurrentAdminSession;
//import com.ayushkaam.model.CurrentUserSession;
import com.ayushkaam.model.Member;
import com.ayushkaam.model.MemberSession;
import com.ayushkaam.model.VaccinationCenter;
import com.ayushkaam.model.VaccineRegistration;
import com.ayushkaam.repository.AdminDao;
//import com.ayushkaam.repository.AminSessionDao;
import com.ayushkaam.repository.AppointmentDao;
import com.ayushkaam.repository.MemberSessionDao;
import com.ayushkaam.service.AppointmentService;
//import com.ayushkaam.repository.UserSessionDAO;
import com.ayushkaam.service.MemberService;
import com.ayushkaam.service.VaccinationCenterService;
import com.ayushkaam.service.VaccineRegistrationService;

@Service
public class AppointmentServiceImpl implements AppointmentService {
//
	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	private VaccineRegistrationService registrationService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private VaccinationCenterService vaccinationCenterService;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private MemberSessionDao memberSessionDao;

//	@Override
//	public List<Appointment> getAllAppointment() throws AppointmentException {
//		
//			 Optional<MemberSession> optMember= MemberSessionDao.f;
//				
//				if(!optAdmin.isPresent()) {
//					
//					throw new RuntimeException("Unauthorised access");
//				}
//				
//			List<Appointment> appointments = appointmentDao.findAll();
//			if (appointments.size() > 0)
//				return appointments;
//			else
//				throw new AppointmentException("No appointment found");
//		}
//	}

//	@Override
//	public Appointment getAppointmentByMobileNumber(String mobileNumber) throws AppointmentNotFoundException {
//		
//		Optional<MemberSession> optMember= memberSessionDao.findByMobileNumber(mobileNumber);
//			
//			if(!optMember.isPresent()) {
//				
//				throw new RuntimeException("Unauthorised access");
//			}
//			
//			
//		return appointmentDao.findByMember(mobileNumber)
//				.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found by same booking id!"));
//		
//	}

	@Override
	public Appointment addAppointment(Appointment app, Integer memId, String key) throws AppointmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment updateAppointment(Appointment app, String key) throws AppointmentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAppointment(Long bookingId, String key) throws AppointmentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Appointment getAppointmentByMobileNumber(String mobileNumber) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
