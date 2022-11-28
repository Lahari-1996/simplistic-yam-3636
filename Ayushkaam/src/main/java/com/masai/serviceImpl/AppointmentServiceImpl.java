package com.masai.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.AppointmentException;
import com.ayushkaam.exception.UserException;
import com.ayushkaam.model.Appointment;
import com.ayushkaam.model.CurrentUserSession;
import com.ayushkaam.repository.AppointmentDao;
import com.ayushkaam.repository.UserSessionDao;
import com.ayushkaam.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	public AppointmentDao appointmentDao;

	@Autowired
	private UserSessionDao userSessionDao;
	
	
	@Override
	public List<Appointment> getAllAppoinments() throws AppointmentException {
		
		List<Appointment> appointments = appointmentDao.findAll();

		if (appointments.size() > 0)
		{
			return appointments;
		}
		else {
			throw new AppointmentException("No appointments found");
		}
	}

	@Override
	public Appointment addAppoinment(Appointment app, String key) throws AppointmentException, UserException {
		
		CurrentUserSession currentUser = userSessionDao.findByuuid(key);

		if (currentUser != null) {
			Appointment appointment = appointmentDao.save(app);
			if (appointment != null) {
				return appointment;
			} else {
				throw new AppointmentException("Appointment not Scheduled! Please try after some time!");
			}
		} else {
			throw new UserException("Opps...!!! Login as a user first.");
		}
		
	}

	@Override
	public Appointment getAppoinment(Integer bookingId, String key) throws AppointmentException, UserException {
		
		CurrentUserSession currentUser = userSessionDao.findByuuid(key);

		if (currentUser != null) {
			return appointmentDao.findById(bookingId)
					.orElseThrow(() -> new AppointmentException("Appointment not found with booking id :" + bookingId));
		} else {
			throw new UserException("Opps...!!! Login as a user first.");
		}
	}

	@Override
	public Appointment updateAppoinment(Appointment app, String key) throws AppointmentException, UserException {

		CurrentUserSession currentUser = userSessionDao.findByuuid(key);

		if (currentUser != null) {

			Optional<Appointment> appointment = appointmentDao.findById(app.getBookingid());

			if (appointment.isPresent()) {

				appointmentDao.save(app);

				return appointment.get();
			} else {
				throw new AppointmentException("No Appointment found!");
			}
		} else {
			throw new UserException("Opps...!!! Login as a user first.");
		}
	}

	@Override
	public boolean deleteAppoinment(Appointment app, String key) throws AppointmentException, UserException {

		CurrentUserSession currentUser = userSessionDao.findByuuid(key);

		if (currentUser != null) {
			Appointment appointment = appointmentDao.findById(app.getBookingid())
					.orElseThrow(() -> new AppointmentException("Appointment not found!"));

			appointmentDao.delete(appointment);

			return true;

		} else
			throw new UserException("Opps...!!! Login as a user first.");
	}
		
	}


