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
import com.ayushkaam.service.MemberLogInService;
import com.ayushkaam.service.MemberService;
import com.ayushkaam.service.VaccinationCenterService;
import com.ayushkaam.service.VaccineRegistrationService;
import com.ayushkaam.service.VaccineService;
import com.ayushkaam.service.VaccinationInventoryService;


    
    
import org.springframework.web.bind.annotation.PathVariable;

import com.ayushkaam.exception.LogInException;
import com.ayushkaam.exception.MemberException;
import com.ayushkaam.exception.VaccinationCenterException;
import com.ayushkaam.model.Admin;
import com.ayushkaam.model.AdminDTO;
import com.ayushkaam.model.Member;
import com.ayushkaam.model.MemberLogInDTO;
import com.ayushkaam.model.MemberSession;
import com.ayushkaam.model.VaccinationCenter;


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
	private MemberLogInService memberLogInService;
	
	@Autowired
	private VaccinationInventoryService vaccinationInventoryService;
	
	@Autowired
	private VaccinationCenterService vaccineCenterService;
	
	@Autowired
	private VaccineRegistrationService vaccineRegistrationService;
	
	@Autowired
	private VaccineService vaccineService;
	
	
	
//	@PostMapping("/member/login")
//	public ResponseEntity<MemberSession> memberLogInHandler(@RequestBody MemberLogInDTO memberLogInDTO) throws LogInException {
//		
//		
//		
//		return new ResponseEntity<MemberSession>(memberLogInService.loginAsMember(memberLogInDTO), HttpStatus.OK);
//	}
//	
//	
//	@GetMapping("/member/logout")
//	public ResponseEntity<String> memberLogOutHandler(@PathVariable("key") String key) throws LogInException {
//		
//		
//		
//		return new ResponseEntity<String>(memberLogInService.logOutMember(key), HttpStatus.OK);
//	}
	
	
	
	
	//To get all VaccinationCenters
	@GetMapping("/vaccination_centers")
    public ResponseEntity<List<VaccinationCenter>> getVaccineCenters(@RequestParam("token") String key) throws VaccinationCenterException{
		
        return new ResponseEntity<List<VaccinationCenter>>(vaccineCenterService.getAllVaccineCenters(key), HttpStatus.OK);
   
	}
	
	
	//To Register a new VaccinationCenter.
    @PostMapping("/vaccination_center")
    public ResponseEntity<VaccinationCenter> addVaccineCenter(@RequestBody VaccinationCenter center,@RequestParam("token") String key) throws VaccinationCenterException{
       
    	
    	return new ResponseEntity<VaccinationCenter>(vaccineCenterService.addVaccinationCenter(center,key),
    			HttpStatus.CREATED); 
   
    
    }
    
    
    //To get a VaccinationCenter details by Id Of the Center.
    @GetMapping("/vaccination_center/{id}")
    public ResponseEntity<VaccinationCenter> addVaccineCenter(@PathVariable("id") Integer id,@RequestParam("token") String key) throws VaccinationCenterException {
        
    	
    	return new ResponseEntity<VaccinationCenter>(vaccineCenterService.getvaccineCenter(id,key), HttpStatus.FOUND);
   
    }

    
    //To Update existing VaccinationCenter details. 	
    @PutMapping("/vaccination_center")
    public ResponseEntity<VaccinationCenter> updateVaccineCenter(@RequestBody VaccinationCenter center,@RequestParam("token") String key) throws VaccinationCenterException {
        
    	
    	return new ResponseEntity<VaccinationCenter>(vaccineCenterService.updateVaccinationCenter(center,key), HttpStatus.OK);
    
    }

    
    //To delete an existing vaccinationCenter.
    @DeleteMapping("/vaccination_center")
    public ResponseEntity<String> deleteVaccineCenter(@RequestBody VaccinationCenter center, @RequestParam String key) throws VaccinationCenterException{
       
    	
    	return new ResponseEntity<>("vaccine center deleted : " + vaccineCenterService.deleteVaccineCenter(center,key),
                HttpStatus.OK); 
    
    
    }

	
    
    
//	members
	
	@GetMapping("/members/{key}")
	public ResponseEntity<List<Member>> getAllMembersHandler(@PathVariable("key") String key) throws MemberException {
		
		List<Member> members =  memberService.getAllMembers(key);

		return new ResponseEntity<List<Member>>(members , HttpStatus.OK);
	}
	 
	
	    
	@GetMapping("/members/{id}")
	public ResponseEntity<Member> getMemberByIdHandler(@PathVariable("id") Long id,@RequestParam("token") String key) throws MemberException {
	        
		return new ResponseEntity<Member>(memberService.getMemberById(id, key),HttpStatus.OK);  
	}

	    
	@GetMapping("/members/aadhar/{aadharNo}")
	public ResponseEntity<Member> getMemberByAadharHandler(@PathVariable("aadharNo") Long aadharNo , @RequestParam("token")String key) throws MemberException {
	    
		return new ResponseEntity<Member>(memberService.getMemberByAadharNumber(aadharNo , key),HttpStatus.OK);
	    
	}

	  

	    
	@DeleteMapping("/members/{id}")
	    
	public ResponseEntity<String> deleteMemberRecordByIdHandler(@PathVariable("id") Long memberId , @RequestParam("token")String key) throws MemberException{
	    	
		return new ResponseEntity<String>("Member record deleted successfully..."+memberService.deleteMemberById(memberId , key),HttpStatus.OK);
	       
	    
	}
	
	// create admin and update admin
		@PostMapping("/admin")    
		public ResponseEntity<Admin> createAdminHandler(@RequestBody Admin admin)  {
		        
			return new ResponseEntity<Admin>(adminService.createAdmin(admin),HttpStatus.OK);
		}
		
		@PutMapping("/admin")
		public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin)  {
		       
			return new ResponseEntity<Admin>(adminService.updateAdmin(admin),HttpStatus.OK);
		    
		}


//Log In and Log Out Admin
		
		@PostMapping("/login")
		public ResponseEntity<String> adminLogInHandler(@RequestBody Admin admin) throws LogInException{
			return new ResponseEntity<String>("Admin Logged In Successfully..."+adminService.logIntoAccount(admin) , HttpStatus.OK);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<String> adminLogOutHandler(@PathVariable("id") Integer adminId,@RequestParam("password") String password ) throws LogInException{
			return new ResponseEntity<String>("Admin Logged Out"+adminService.logOutAccount(adminId,password) , HttpStatus.OK);
		}
	
}
