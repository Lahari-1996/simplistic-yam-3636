package com.masai.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayushkaam.exception.IdCardException;
import com.ayushkaam.exception.UserException;
import com.ayushkaam.model.CurrentUserSession;
import com.ayushkaam.model.Idcard;
import com.ayushkaam.repository.IdCardDao;
import com.ayushkaam.repository.UserSessionDao;
import com.ayushkaam.service.IdCardService;

@Service
public class IdCardServiceImpl implements IdCardService{

	@Autowired
	private IdCardDao idCardDao;

	@Autowired
	private UserSessionDao userSessionDao;
	
	@Override
	public Idcard getPanCardByNumber(String panNo, String key) throws IdCardException, UserException {
		
		CurrentUserSession currentUser = userSessionDao.findByuuid(key);

		if (currentUser != null) {

			Idcard idcard = idCardDao.findByPanCardNo(panNo);
			if (idcard != null) {
				return idcard;
			} else {
				throw new IdCardException("Id card not found with pan no - " + panNo);
			}
		} else
			throw new UserException("Opps...!!! Login as a user first.");
		
	}

	@Override
	public Idcard getAdharCardByNo(Long adharNo, String key) throws IdCardException, UserException {
		
		CurrentUserSession currentUser = userSessionDao.findByuuid(key);

		if (currentUser != null) {

			Idcard idcard = idCardDao.findByAdharCardNo(adharNo);
			if (idcard != null) {
				return idcard;
			} else {
				throw new IdCardException("Id card not found with adhar no - " + adharNo);
			}
		} else
			throw new UserException("Opps...!!! Login as a user first.");
		
	}

	@Override
	public Idcard addIdCard(Idcard idCard, String key) throws IdCardException, UserException {
		
		CurrentUserSession currentUser = userSessionDao.findByuuid(key);

		if (currentUser != null) {

			Idcard idcard = idCardDao.save(idCard);
			if (idcard != null) {
				return idcard;
			} else {
				throw new IdCardException("Id card not added");
			}
		} else
			throw new UserException("Opps...!!! Login as a user first.");
		
	}

}
