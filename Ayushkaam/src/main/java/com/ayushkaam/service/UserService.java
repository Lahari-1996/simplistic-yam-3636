package com.ayushkaam.service;

import com.ayushkaam.exception.UserException;
import com.ayushkaam.model.User;

public interface UserService {

	public User createCustomer(User user) throws UserException;

	public User updateCustomer(User user, String key) throws UserException;
	
}
