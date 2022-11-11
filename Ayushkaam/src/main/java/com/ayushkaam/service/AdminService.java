package com.ayushkaam.service;

import com.ayushkaam.exception.LogInException;
import com.ayushkaam.model.MemberLogInDTO;
import com.ayushkaam.model.MemberSession;

public interface AdminService {
 

	public MemberSession logIntoAccount(MemberLogInDTO memberLogInDTO) throws LogInException;

	public String logOutAccount(String key) throws LogInException;
}
