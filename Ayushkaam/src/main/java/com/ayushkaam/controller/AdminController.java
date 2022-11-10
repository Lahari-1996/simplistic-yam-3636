package com.ayushkaam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private VaccinationInventoryService vaccinationInventoryService;
	
	@Autowired
	private VaccinCenterService vaccineCenterService;
	
	@Autowired
	private VaccinRegistrationService vaccineRegistrationService;
	
	@Autowired
	private VaccinService vaccineService;
	
	
	
//	Vaccine Inventory

    @PostMapping("/vaccine_inventory")
    public ResponseEntity<VaccineInventory> saveVaccineHandler(@RequestBody VaccineInventory vaccineInventory) {

        return new ResponseEntity<VaccineInventory>(vaccineService.saveVaccineInventory(vaccineInventory),HttpStatus.CREATED);
    }
    
    
    @GetMapping("/vaccine_inventory")
    public ResponseEntity<List<VaccineInventory>> getAllInventoryHandler() {
        return new ResponseEntity<List<VaccineInventory>>(vaccineService.allVaccineInventory(), HttpStatus.FOUND);
    }
    
    
    
}
