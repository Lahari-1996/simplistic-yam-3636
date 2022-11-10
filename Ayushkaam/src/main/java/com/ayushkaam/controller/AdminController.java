package com.ayushkaam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayushkaam.exception.MemberException;
import com.ayushkaam.model.Member;
import com.ayushkaam.service.MemberService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

	@Autowired
	private MemberService memberServiceImpl;
	
	
	@GetMapping("/members/{key}")
	public ResponseEntity<List<Member>> getAllMembersHandler(@PathVariable("key") String key) throws MemberException {
		
		List<Member> members =  memberServiceImpl.getAllMembers(key);

		return new ResponseEntity<List<Member>>(members , HttpStatus.OK);
	}
	
	
	
}
