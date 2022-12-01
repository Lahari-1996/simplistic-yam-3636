package com.ayushkaam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayushkaam.exception.LoginException;
import com.ayushkaam.model.AdminLogin;
import com.ayushkaam.model.UserLogin;
import com.ayushkaam.service.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController

public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/loginuser")
	public ResponseEntity<String> logInCustomer(@RequestBody UserLogin dto) throws LoginException {

		String result = loginService.logIntoAccount(dto);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@DeleteMapping("/logoutuser")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		return loginService.logOutFromAccount(key);

	}

	@PostMapping("/loginadmin")
	public ResponseEntity<String> logInAdmin(@RequestBody AdminLogin dto) throws LoginException {

		String result = loginService.logIntoAdmin(dto);

		return new ResponseEntity<String>(result, HttpStatus.OK);

	}

	@DeleteMapping("/logoutadmin")
	public String logoutAdmin(@RequestParam(required = false) String key) throws LoginException {
		return loginService.logOutAdmin(key);

	}
	
}
