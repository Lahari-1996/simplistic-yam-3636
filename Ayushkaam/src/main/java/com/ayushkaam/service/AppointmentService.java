package com.ayushkaam.service;

import java.util.List;

import com.ayushkaam.exception.AppointmentException;
import com.ayushkaam.exception.UserException;
import com.ayushkaam.model.Appointment;

public interface AppointmentService {
	

	
	public List<Appointment> getAllAppoinments() throws AppointmentException;

	public Appointment addAppoinment(Appointment app, String key) throws AppointmentException, UserException;
	
	public Appointment getAppoinment(Integer bookingId, String key) throws AppointmentException, UserException;

	public Appointment updateAppoinment(Appointment app, String key) throws AppointmentException, UserException;

	public boolean deleteAppoinment(Appointment app, String key) throws AppointmentException, UserException;
	
}
