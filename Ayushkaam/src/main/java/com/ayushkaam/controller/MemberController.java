package com.ayushkaam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayushkaam.exception.LogInException;
import com.ayushkaam.exception.MemberException;
import com.ayushkaam.model.Member;
import com.ayushkaam.model.MemberLogInDTO;
import com.ayushkaam.model.MemberSession;
import com.ayushkaam.service.MemberLogInService;
import com.ayushkaam.service.MemberService;

@RestController
@RequestMapping("/api/v1/user")
public class MemberController {
	
	@Autowired
	private MemberLogInService logInService;
	
	@Autowired
	private MemberService memberService;

	
	

	@PutMapping("/")    
	public ResponseEntity<Member> registerMemberHandler(@RequestBody Member member) throws MemberException {
	        
		return new ResponseEntity<Member>(memberService.registerAsMember(member),HttpStatus.OK);
	}
	

	
	@GetMapping("/member/{id}")
	public ResponseEntity<Member> getMemberByIdHandler(@PathVariable("id") Long id,@RequestParam String key) throws MemberException {
	        
		return new ResponseEntity<Member>(memberService.getMemberById(id, key),HttpStatus.OK);  
	}

	    
	@GetMapping("/member/aadhar/{aadharNo}")
	public ResponseEntity<Member> getMemberByAadharHandler(@PathVariable("aadharNo") Long aadharNo , @RequestParam("token")String key) throws MemberException {
	    
		return new ResponseEntity<Member>(memberService.getMemberByAadharNumber(aadharNo , key),HttpStatus.OK);
	    
	}

	  

	    
	@DeleteMapping("/member/{id}")
	    
	public ResponseEntity<String> deleteMemberRecordByIdHandler(@PathVariable("id") Long memberId , @RequestParam("token")String key) throws MemberException{
	    	
		return new ResponseEntity<String>("Member record deleted successfully..."+memberService.deleteMemberById(memberId , key),HttpStatus.OK);
	       
	    
	}
	
    
	@PutMapping("/member/{key}")
	public ResponseEntity<Member> updateMemberHandler(@RequestBody Member member,@PathVariable("key") String key) throws MemberException {
	       
		return new ResponseEntity<Member>(memberService.updateMemberDetails(member,key),HttpStatus.OK);
	    
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<MemberSession> userLogInHandler(@RequestBody MemberLogInDTO memberLogInDTO) throws LogInException{
		
		
		return new ResponseEntity<MemberSession>(logInService.loginAsMember(memberLogInDTO.getMobileNumber(), memberLogInDTO.getPassword()) , HttpStatus.OK);
	}
	
	@GetMapping("/logout/{token}")
	public ResponseEntity<String> userLogOutHandler(@PathVariable("token") String key) throws LogInException{
		
		
		
		return new ResponseEntity<String>(logInService.logOutMember(key) , HttpStatus.OK);
	}
}
