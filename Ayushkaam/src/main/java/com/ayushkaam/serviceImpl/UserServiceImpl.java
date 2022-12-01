package com.ayushkaam.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.UserException;
import com.ayushkaam.model.CurrentUserSession;
import com.ayushkaam.model.User;
import com.ayushkaam.repository.UserDao;
import com.ayushkaam.repository.UserSessionDao;
import com.ayushkaam.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao uDao;
	
	@Autowired
	private UserSessionDao usDao;
	
	@Override
	public User createCustomer(User user) throws UserException {
		
		User existingUser=uDao.findByMobileNo(user.getMobileNo());
		if(existingUser==null) {
			return uDao.save(user);
		}else {
			throw new UserException("User already registered with mobile number");
		}
		
	}

	@Override
	public User updateCustomer(User user, String key) throws UserException {
		
		CurrentUserSession loggedInUser=usDao.findByuuid(key);
		if(loggedInUser==null) {
			throw new UserException("Please provide a valid key to update a user");
		}
		
		if(user.getUserId()==loggedInUser.getUserId()) {
			return uDao.save(user);
		}else {
			throw new UserException("Invalid user details , please login first");
		}
		
	}

}
