package com.ayushkaam.controller;

import javax.validation.Valid;
import java.util.List;

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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ayushkaam.exception.LogInException;
import com.ayushkaam.exception.MemberException;
import com.ayushkaam.exception.VaccinationCenterException;
import com.ayushkaam.model.Member;
import com.ayushkaam.model.MemberLogInDTO;
import com.ayushkaam.model.MemberSession;
import com.ayushkaam.model.VaccinationCenter;
import com.ayushkaam.model.VaccineRegistration;
import com.ayushkaam.service.MemberLogInService;
import com.ayushkaam.service.MemberService;
import com.ayushkaam.service.VaccinationCenterService;
import com.ayushkaam.service.VaccineRegistrationService;

@RestController
@RequestMapping("/api/v1/user")
public class MemberController {
	
	@Autowired
	private MemberLogInService logInService;
	
	@Autowired
	private MemberService memberService;

	
	@Autowired
	private VaccinationCenterService vaccinationService;
	
	
	@Autowired
	private VaccineRegistrationService vaccineRegistrationService;
	
	
	
	//Vaccine Registration
	
	
	//get registered member by mobile number
	@GetMapping("/registeredMember/{mobNo}")
	public ResponseEntity<Member> getRegisteredMemberByMobileNumber(@PathVariable("mobNo") String mobNo ) {
		
		return new ResponseEntity<Member>(vaccineRegistrationService.getRegisteredMemberByMobileNumber(mobNo), HttpStatus.FOUND);
	
	}
	
	// vaccination registration
	@PostMapping("/vaccine_registration/{mobNo}")
	public ResponseEntity<VaccineRegistration> saveVaccineRegistrationHandler(@PathVariable("mobNo") String mobNo ) {

		return new ResponseEntity<VaccineRegistration>(vaccineRegistrationService.addVaccineRegistration(mobNo ),
				HttpStatus.CREATED);

	}
	//get vaccine registration
	@GetMapping("/vaccine_registration/{mobNo}")
	public ResponseEntity<VaccineRegistration> getVaccineRegistration(@PathVariable("mobNo") String mobNo ) { 
		
		return new ResponseEntity<VaccineRegistration>(vaccineRegistrationService.getVaccineRegistration(mobNo ),
				HttpStatus.FOUND);
	
	}
	//update vaccination registration
	@PutMapping("/vaccine_registration/{mobNo}")
	public ResponseEntity<VaccineRegistration> updateVaccineRegistration(@PathVariable("mobNo") String mobNo,
			@RequestBody VaccineRegistration reg ) {
		
		return new ResponseEntity<VaccineRegistration>(
				vaccineRegistrationService.updateVaccineRegistration( mobNo, reg.getMobileNo() ), HttpStatus.OK);
	
	}
	
	//delete vaccine registration
	@DeleteMapping("/vaccine_registration/{mobNo}")
	public ResponseEntity<Boolean> deleteVaccineRegistration(@PathVariable("mobNo") String mobNo ) {
		
		return new ResponseEntity<Boolean>(vaccineRegistrationService.deleteVaccineRegistration( mobNo ), HttpStatus.OK); 
	
	}
	
	
	

	@PostMapping("/")    
	public ResponseEntity<Member> registerMemberHandler(@Valid @RequestBody Member member) throws MemberException {
	        
		return new ResponseEntity<Member>(memberService.registerAsMember(member),HttpStatus.OK);
	}
	

	
	@GetMapping("/member/{id}")
	public ResponseEntity<Member> getMemberByIdHandler(@PathVariable("id") Long id,@RequestParam("token") String key) throws MemberException {
	        
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
	public ResponseEntity<Member> updateMemberHandler(@Valid @RequestBody Member member,@PathVariable("key") String key) throws MemberException {
	       
		return new ResponseEntity<Member>(memberService.updateMemberDetails(member,key),HttpStatus.OK);
	    
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<MemberSession> userLogInHandler(@Valid @RequestBody MemberLogInDTO memberLogInDTO) throws LogInException{
		
		
		return new ResponseEntity<MemberSession>(logInService.loginAsMember(memberLogInDTO.getMobileNumber(), memberLogInDTO.getPassword()) , HttpStatus.OK);
	}
	
	@GetMapping("/logout/{token}")
	public ResponseEntity<String> userLogOutHandler(@PathVariable("token") String key) throws LogInException{
		
		
		
		return new ResponseEntity<String>(logInService.logOutMember(key) , HttpStatus.OK);
	}
	
	@GetMapping("/vaccinecenters/{key}")
	public ResponseEntity<List<VaccinationCenter>> getAllVaccinationCenterHandler(@PathVariable("key") String key) throws VaccinationCenterException , MemberException{
		
		
		return new ResponseEntity<List<VaccinationCenter>>(vaccinationService.getAllVaccineCenters(key), HttpStatus.OK);
	}
}
