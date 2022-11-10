package com.ayushkaam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayushkaam.model.VaccineInventory;
import com.ayushkaam.service.AdminService;
import com.ayushkaam.service.AppointmentService;
import com.ayushkaam.service.MemberService;
import com.ayushkaam.service.VaccinCenterService;
import com.ayushkaam.service.VaccinRegistrationService;
import com.ayushkaam.service.VaccinService;
import com.ayushkaam.service.VaccinationInventoryService;


    
    
import org.springframework.web.bind.annotation.PathVariable;


import com.ayushkaam.exception.MemberException;
import com.ayushkaam.model.Member;


@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	
	
	@Autowired
	private VaccinationInventoryService vaccinationInventoryService;
	
	@Autowired
	private VaccinCenterService vaccineCenterService;
	
	@Autowired
	private VaccinRegistrationService vaccineRegistrationService;
	
	@Autowired
	private VaccinService vaccineService;
	
	
	
//	Vaccine Inventory

	
	
//	Vaccine
	
	
	
//	Vaccine Centre
    
    
//	members
	
	@GetMapping("/members/{key}")
	public ResponseEntity<List<Member>> getAllMembersHandler(@PathVariable("key") String key) throws MemberException {
		
		List<Member> members =  memberService.getAllMembers(key);

		return new ResponseEntity<List<Member>>(members , HttpStatus.OK);
	}
	 @PutMapping("/member")
	    public ResponseEntity<Member> registerMemberHandler(@RequestBody Member member) throws MemberException {
	        return new ResponseEntity<Member>(memberService.registerAsMember(member),HttpStatus.OK);
	    }
	

	    @GetMapping("/member/{id}")
	    public ResponseEntity<Member> getMemberByIdHandler(@PathVariable("id") Long id,@RequestParam String key) throws MemberException {
	        return new ResponseEntity<Member>(memberService.getMemberById(id, key),HttpStatus.OK);
	    }

	    @GetMapping("/member/aadhar/{aadharNo}")
	    public ResponseEntity<Member> getMemberByAadharHandler(@PathVariable("aadharNo") Long aadharNo) throws MemberException {
	    return new ResponseEntity<Member>(memberService.getMemberByAadharNumber(aadharNo),HttpStatus.OK);
	    }

	  

	    @DeleteMapping("/member/{id}")
	    public ResponseEntity<String> deleteMemberRecordByIdHandler(@PathVariable("id") Long memberId) throws MemberException{
	    	return new ResponseEntity<String>("Member record deleted successfully..."+memberService.deleteMemberById(memberId),HttpStatus.OK);
	       
	    }

	    @PutMapping("/member/{key}")
	    public ResponseEntity<Member> updateMemberHandler(@RequestBody Member member,@PathVariable("key") String key) throws MemberException {
	       return new ResponseEntity<Member>(memberService.updateMemberDetails(member,key),HttpStatus.OK);
	    }
	

}
