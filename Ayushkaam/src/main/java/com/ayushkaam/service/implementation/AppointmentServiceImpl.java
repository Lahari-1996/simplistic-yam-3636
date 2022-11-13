package com.ayushkaam.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ayushkaam.exception.AppointmentException;
import com.ayushkaam.exception.AppointmentNotFoundException;
import com.ayushkaam.model.Appointment;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.model.Member;
import com.ayushkaam.model.MemberSession;
import com.ayushkaam.model.VaccinationCenter;
import com.ayushkaam.model.VaccineRegistration;
import com.ayushkaam.repository.AppointmentDao;
import com.ayushkaam.repository.CurrentAdminDao;
import com.ayushkaam.repository.MemberSessionDao;
import com.ayushkaam.service.AppointmentService;
import com.ayushkaam.service.VaccineRegistrationService;

public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private CurrentAdminDao currentAdminDao;
	
	@Autowired
	private AppointmentDao appointmentDao;
	
	@Autowired
	private MemberSessionDao memberSessionDao;
	
	@Autowired
	private VaccineRegistrationService registrationService;
	
	@Autowired
	private VaccineRegistrationService vaccinationCenterService;
	
	@Override
	public List<Appointment> getAllAppointment() throws AppointmentException {
		
		
		Optional<List<CurrentAdminSession>> optCurrAdmin= Optional.of(currentAdminDao.findAll());
		
		if(!optCurrAdmin.isPresent()) {
			
			throw new RuntimeException("Unauthorised access");
		}
		
	List<Appointment> appointments = appointmentDao.findAll();
	if (appointments.size() > 0)
		return appointments;
	else
		throw new AppointmentException("No appointment found");
		
	}

	@Override
	public Appointment getAppointmentByBookingId(Integer bookingId, String key) throws AppointmentNotFoundException {
	
		Optional<CurrentAdminSession> optCurrAdmin=currentAdminDao.findById(bookingId);
		 Optional<MemberSession> optCurrUser= memberSessionDao.findById(bookingId);
			
			if(!optCurrAdmin.isPresent()&&!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			
		return appointmentDao.findById(bookingId)
				.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found by same booking id!"));
		
	}

	@Override
	public Appointment addAppointment(Appointment app, Integer memId, String key) throws AppointmentException {
		
		 Optional<MemberSession> optCurrUser= memberSessionDao.findById(memId);
			
			if(!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	

		VaccineRegistration reg = registrationService.addVaccineRegistration(app.getMobileNo(), key);
		if (reg == null)
			throw new AppointmentException("First do the registration...");
		else {
			List<Member> list = (List<Member>) reg.getMember();
			for (Member m : list) {
				if (m.getMemberId() == memId) {
					app.setMember(m);
					app.setDateofbooking(LocalDate.now());
					app.setBookingStatus(true);
					Integer id = app.getVaccinationCenter().getCode();
					VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccineCenter(id,key);
					app.setVaccinationCenter(vaccinationCenter);
					Appointment a = appointmentDao.save(app);
					m.getAppointments().add(a);
					memberService.updateMember(m, m.getMemberid(),key);
					return a;
				}
			}
			throw new AppointmentExcepation("Member not found...");
		}
		
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

}
