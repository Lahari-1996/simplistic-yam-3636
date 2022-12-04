package com.ayushkaam.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.model.Admin;
import com.ayushkaam.model.AdminLogin;
import com.ayushkaam.model.CurrentAdminSession;
import com.ayushkaam.model.CurrentUserSession;
import com.ayushkaam.model.User;
import com.ayushkaam.model.UserLogin;
import com.ayushkaam.repository.AdminDao;
import com.ayushkaam.repository.AdminSessionDao;
import com.ayushkaam.repository.UserDao;
import com.ayushkaam.repository.UserSessionDao;
import com.ayushkaam.service.LoginService;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDao uDao;
	@Autowired
	private UserSessionDao usDao;
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AdminSessionDao adminSDao;
	
	@Override
	public String logIntoAccount(UserLogin login) throws LoginException {
		
      User existingUser=uDao.findByMobileNo(login.getMobileNo());
		
		if(existingUser==null) {
			throw new LoginException("Please enter a valid mobile number");
		}
		
		Optional<CurrentUserSession> opt=usDao.findById(existingUser.getUserId());
		
		if(opt.isPresent()) {
			throw new LoginException("User already logged in with this number");
		}
		
		if(existingUser.getPassword().equals(login.getPassword())) {
			String key=RandomString.make(6);
			CurrentUserSession currentUserSession=new CurrentUserSession(existingUser.getUserId(),key,LocalDateTime.now());
			usDao.save(currentUserSession);
			return currentUserSession.toString();
		}else {
			throw new LoginException("Please Enter a valid password");
		}
		
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		
      CurrentUserSession validUserSession = usDao.findByuuid(key);
		
		
		if(validUserSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		usDao.delete(validUserSession);
		
		
		return "Logged Out Successfully!";
		
	}

	@Override
	public String logIntoAdmin(AdminLogin adl) throws LoginException {
		
     Admin existingUser=adminDao.findByMobile(adl.getMobileNo());
		
		if(existingUser==null) {
			throw new LoginException("Please enter a valid mobile number");
		}
		
		Optional<CurrentAdminSession> opt=adminSDao.findById(existingUser.getAdminId());
		
		if(opt.isPresent()) {
			throw new LoginException("Admin already logged in with this number");
		}
		
		if(existingUser.getPassword().equals(adl.getPassword())) {
			String key=RandomString.make(6);
			CurrentAdminSession currentAdminSession=new CurrentAdminSession(existingUser.getAdminId(),existingUser.getName(),existingUser.getMobile(),key,LocalDateTime.now());
			adminSDao.save(currentAdminSession);
			return currentAdminSession.toString();
		}else {
			throw new LoginException("Please Enter a valid password");
		}
		
	}

	@Override
	public String logOutAdmin(String key) throws LoginException {

        CurrentAdminSession validUserSession = adminSDao.findByuuid(key);
		
		
		if(validUserSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		adminSDao.delete(validUserSession);
		
		
		return "Logged Out Successfully!";
		
	}

}
