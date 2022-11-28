package com.ayushkaam.service;

import com.ayushkaam.exception.IdCardException;
import com.ayushkaam.exception.UserException;
import com.ayushkaam.model.Idcard;

public interface IdCardService {

	public Idcard getPanCardByNumber(String panNo, String key) throws IdCardException, UserException;

	public Idcard getAdharCardByNo(Long adharNo, String key) throws IdCardException, UserException;

	public Idcard addIdCard(Idcard idCard, String key) throws IdCardException, UserException;
	
}
