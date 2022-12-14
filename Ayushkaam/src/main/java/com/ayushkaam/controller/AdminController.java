package com.ayushkaam.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayushkaam.exception.AdminException;
import com.ayushkaam.exception.LoginException;
import com.ayushkaam.exception.MemberException;
import com.ayushkaam.exception.VaccineCenterException;
import com.ayushkaam.exception.VaccineException;
import com.ayushkaam.exception.VaccineRegistrationException;
import com.ayushkaam.model.Admin;
import com.ayushkaam.model.Member;
import com.ayushkaam.model.VaccinationCenter;
import com.ayushkaam.model.Vaccine;
import com.ayushkaam.model.VaccineInventory;
import com.ayushkaam.model.VaccineRegistration;
import com.ayushkaam.service.AdminService;
import com.ayushkaam.service.MemberService;
import com.ayushkaam.service.VaccinationCenterService;
import com.ayushkaam.service.VaccineInventoryService;
import com.ayushkaam.service.VaccineRegistrationService;
import com.ayushkaam.service.VaccineService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;




@RestController
@RequestMapping("/admin")
public class AdminController {


	@Autowired
	private AdminService adminService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private VaccineService vaccineService;

	@Autowired
	private VaccinationCenterService vcService;

	@Autowired
	private VaccineRegistrationService vrService;

	@Autowired
	private VaccineInventoryService viService;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin) throws AdminException {

		Admin savedCustomer = adminService.createAdmin(admin);

		return new ResponseEntity<Admin>(savedCustomer, HttpStatus.CREATED);
	}

	@PutMapping("/admin")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin, @RequestParam(required = false) String key)
			throws AdminException {

		Admin updatedCustomer = adminService.updateAdmin(admin, key);

		return new ResponseEntity<Admin>(updatedCustomer, HttpStatus.OK);

	}

	// member method

	@GetMapping(value = "/members")
	public ResponseEntity<List<Member>> getAllMembers() throws MemberException {

		List<Member> members = memberService.getAllMembers();

		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);

	}

	@GetMapping(value = "/members/{memberId}")
	public ResponseEntity<Member> getMemberById(@PathVariable("memberId") Integer memberId,
			@RequestParam(required = false) String key) throws MemberException, LoginException {

		Member member = memberService.getMemberById(memberId, key);

		return new ResponseEntity<Member>(member, HttpStatus.OK);

	}

	@GetMapping(value = "/membersbyaadhar/{aadhar}")
	public ResponseEntity<Member> getMemberByAadharNo(@PathVariable("aadhar") Long aadharNo,
			@RequestParam(required = false) String key) throws MemberException, LoginException {

		Member member = memberService.getMemberByAadharNo(aadharNo, key);

		return new ResponseEntity<Member>(member, HttpStatus.OK);

	}

	@GetMapping(value = "/membersbypan/{pan}")
	public ResponseEntity<Member> getMemberByPanNo(@PathVariable("pan") String panNo,
			@RequestParam(required = false) String key) throws MemberException, LoginException {

		Member member = memberService.getMemberByPanNo(panNo, key);

		return new ResponseEntity<Member>(member, HttpStatus.OK);

	}

	@PostMapping(value = "/members")
	public ResponseEntity<Member> addMember(@RequestBody Member member, @RequestParam(required = false) String key)
			throws MemberException, LoginException {

		Member addedMember = memberService.addMember(member, key);

		return new ResponseEntity<Member>(addedMember, HttpStatus.OK);

	}

	@PutMapping(value = "/members")
	public ResponseEntity<Member> updateMember(@RequestBody Member member, @RequestParam(required = false) String key)
			throws MemberException, LoginException {

		Member updatedMember = memberService.updateMember(member, key);

		return new ResponseEntity<Member>(updatedMember, HttpStatus.OK);

	}

	@DeleteMapping(value = "/members")
	public ResponseEntity<Boolean> deleteMember(@RequestBody Member member, @RequestParam(required = false) String key)
			throws MemberException, LoginException {

		Boolean ans = memberService.deleteMember(member, key);

		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);

	}

	// vaccine method

	@GetMapping("/vaccines")
	public ResponseEntity<List<Vaccine>> allVaccineController() throws VaccineException {

		List<Vaccine> vaccines = vaccineService.allVaccines();

		return new ResponseEntity<List<Vaccine>>(vaccines, HttpStatus.OK);
	}

	@GetMapping("/vaccine")
	public ResponseEntity<List<Vaccine>> getVaccineByNameController(@RequestParam("vaccineName") String vaccineName,
			@RequestParam(required = false) String key) throws VaccineException, LoginException {

		List<Vaccine> vaccines = vaccineService.getVaccineByName(vaccineName, key);

		return new ResponseEntity<List<Vaccine>>(vaccines, HttpStatus.OK);
	}

	@GetMapping("/vaccine/{vaccineId}")
	public ResponseEntity<Vaccine> getVaccineByIdController(@PathVariable("vaccineId") Integer vaccineId,
			@RequestParam(required = false) String key) throws VaccineException, LoginException {

		Vaccine vaccine = vaccineService.getVaccineById(vaccineId, key);

		return new ResponseEntity<Vaccine>(vaccine, HttpStatus.OK);
	}

	@PostMapping("/vaccines")
	public ResponseEntity<Vaccine> addVaccineController(@RequestBody Vaccine vaccine,
			@RequestParam(required = false) String key) throws VaccineException, LoginException {

		Vaccine vacc = vaccineService.addVaccine(vaccine, key);

		return new ResponseEntity<Vaccine>(vacc, HttpStatus.CREATED);
	}

	@PutMapping("/vaccines")
	public ResponseEntity<Vaccine> updateVaccineController(@RequestBody Vaccine vaccine,
			@RequestParam(required = false) String key) throws VaccineException, LoginException {

		Vaccine vacc = vaccineService.updateVaccine(vaccine, key);

		return new ResponseEntity<Vaccine>(vacc, HttpStatus.OK);
	}

	@DeleteMapping("/vaccines/{vaccineId}")
	public ResponseEntity<Boolean> deleteVaccineController(@PathVariable("vaccineId") Integer vaccineId,
			@RequestParam(required = false) String key) throws VaccineException, LoginException {

		Boolean ans = vaccineService.deleteVaccine(vaccineId, key);

		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);
	}

	// vaccine center

	@GetMapping("/getVaccineCenter")
	public List<VaccinationCenter> getAllVaccineCenters() throws VaccineCenterException {

		List<VaccinationCenter> allvaclist = vcService.getAllVaccineCenters();

		if (allvaclist.size() == 0) {
			throw new VaccineCenterException("No Vaccine Centers availavle");
		}

		return allvaclist;
	}

	@GetMapping("/getVaccCenter/{centerId}")
	public VaccinationCenter getVaccineCenter(@PathVariable("centerId") Integer centerId,
			@RequestParam(value = "key", required = false) String key) throws VaccineCenterException, LoginException {

		VaccinationCenter vc = vcService.getVaccineCenter(centerId, key);

		if (vc == null) {

			throw new VaccineCenterException("Vaccination Center does not found with center id :" + centerId);

		}

		return vc;
	}

	@PostMapping("/addVaccCenter")
	public VaccinationCenter addVaccinationCenter(@RequestBody VaccinationCenter center,
			@RequestParam(value = "key", required = false) String key) throws VaccineCenterException, LoginException {

		VaccinationCenter vc = vcService.addVaccinationCenter(center, key);

		if (vc != null) {
			return vc;
		}

		throw new VaccineCenterException("sorry this Vaccination center already exist");

	}

	@PutMapping("/updateVaccCenter")
	public VaccinationCenter updateVaccinationCenter(@RequestBody VaccinationCenter center,
			@RequestParam(value = "key", required = false) String key) throws VaccineCenterException, LoginException {

		VaccinationCenter vc = vcService.updateVaccinationCenter(center, key);

		if (vc == null)
			return vc;

		throw new VaccineCenterException("Vaccination Center does not exist to update");

	}

	@DeleteMapping("/deleteVaccCenter")
	public boolean deleteVaccinationCenter(@RequestBody VaccinationCenter center,
			@RequestParam(value = "key", required = false) String key) throws VaccineCenterException, LoginException {

		boolean flag = vcService.deleteVaccinationCenter(center, key);

		if (flag)
			return flag;

		throw new VaccineCenterException("Vaccination Center cannot be deleted ");

	}

	// vaccine registration

	@GetMapping("/vaccineRegistration/{moblineno}")
	public ResponseEntity<VaccineRegistration> getVaccineRegistrationHandler(@PathVariable("moblineno") Long mobileno,
			@RequestParam(value = "key", required = false) String key)
			throws VaccineRegistrationException, LoginException {

		VaccineRegistration vaccineRegistration = vrService.getVaccineRegistration(mobileno, key);

		return new ResponseEntity<VaccineRegistration>(vaccineRegistration, HttpStatus.OK);

	}

	@PutMapping("/vaccineRegisrations")
	public ResponseEntity<VaccineRegistration> updateVaccineRegistrationHandler(
			@RequestBody VaccineRegistration vaccineRegistration,
			@RequestParam(value = "key", required = false) String key)
			throws VaccineRegistrationException, LoginException {

		VaccineRegistration updateVR = vrService.updateVaccineRegistration(vaccineRegistration, key);

		return new ResponseEntity<VaccineRegistration>(updateVR, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/vaccineRegistration/{registrationNo}")
	public ResponseEntity<Boolean> deleteVaccineRegistrationHandler(
			@PathVariable("registrationNo") Integer registrationNo,
			@RequestParam(value = "key", required = false) String key)
			throws VaccineRegistrationException, LoginException {
		Boolean deleteVR = vrService.deleteVaccineRegistration(registrationNo, key);

		return new ResponseEntity<Boolean>(deleteVR, HttpStatus.OK);
	}

	// vaccine inventory

	@PostMapping("addVaccineInventory")
	public ResponseEntity<VaccineInventory> addVaccineInventory(@RequestBody VaccineInventory vaccineInventory,
			@RequestParam(value = "key", required = false) String key) throws VaccineException, LoginException {

		VaccineInventory addedVCInventory = viService.addVaccineInventory(vaccineInventory, key);

		return new ResponseEntity<VaccineInventory>(addedVCInventory, HttpStatus.OK);

	}

	@GetMapping("/getInvByCenter/{centerid}")
	public ResponseEntity<VaccineInventory> getVaccineInventoryByCenter(@PathVariable("centerid") Integer centerid,
			@RequestParam(value = "key", required = false) String key) throws VaccineException, LoginException {

		VaccineInventory vaccineinventory = viService.getVaccineInventoryByCenter(centerid, key);

		return new ResponseEntity<VaccineInventory>(vaccineinventory, HttpStatus.OK);
	}

	@PutMapping("/addVaccCountInv/{count}")
	public ResponseEntity<VaccineInventory> addVaccineCount(@RequestBody VaccineInventory vinv,
			@PathVariable("count") Integer count, @RequestParam(value = "key", required = false) String key)
			throws VaccineException, LoginException {

		VaccineInventory vaccineinventory = viService.addVaccineCount(vinv, count, key);

		return new ResponseEntity<VaccineInventory>(vaccineinventory, HttpStatus.OK);

	}

	@PutMapping("/updateVaccInv/vinv")
	public ResponseEntity<VaccineInventory> updateVaccineInventory(@RequestBody VaccineInventory vinv,
			@RequestParam(value = "key", required = false) String key) throws VaccineException, LoginException {

		VaccineInventory vaccineinventory = viService.updateVaccineInventory(vinv, key);

		return new ResponseEntity<VaccineInventory>(vaccineinventory, HttpStatus.OK);

	}

	@DeleteMapping("/deleteInv")
	public boolean deleteVaccineInventory(@RequestBody VaccineInventory vinv,
			@RequestParam(value = "key", required = false) String key) throws VaccineException, LoginException {

		boolean flag = viService.deleteVaccineInventory(vinv, key);

		if (flag) {
			return flag;
		}

		throw new VaccineException("VaccineInventory cannot be deleted ");

	}

	@GetMapping("/getVaccinvByDate/{ld}")
	public ResponseEntity<List<VaccineInventory>> getVaccineInventoryByDate(@PathVariable("ld") LocalDate ld,
			@RequestParam(value = "key", required = false) String key) throws VaccineException, LoginException {

		List<VaccineInventory> invlist = viService.getVaccineInventoryByDate(ld, key);

		if (invlist.size() == 0) {
			throw new VaccineException("list is empty ");
		}

		return new ResponseEntity<List<VaccineInventory>>(invlist, HttpStatus.OK);

	}

	@GetMapping("/getinvByVaccname")
	public ResponseEntity<VaccineInventory> getVaccineInventoryByVaccine(@RequestBody Vaccine vc,
			@RequestParam(value = "key", required = false) String key) throws VaccineException, LoginException {

		VaccineInventory invList = viService.getVaccineInventoryByVaccine(vc, key);

		if (invList == null) {

			throw new VaccineException("inventory List is empty");
		}

		return new ResponseEntity<VaccineInventory>(invList, HttpStatus.OK);

	}
	    
		    
		    
}
