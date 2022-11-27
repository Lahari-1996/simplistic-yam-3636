//package com.ayushkaam.model;
//
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//
//
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
//@Entity
//public class VaccinationCenter {
//
//	
//	@Id
//	private Integer code;
//
//	@NotNull(message = "Center name should not be null")
//	@NotBlank(message = "Center name is Mandatory")
//	private String centreName;
//
//	@NotNull(message = "City should not be null")
//	@NotBlank(message = "City name is Mandatory")
//	private String city;
//
//	@NotNull(message = "Address should not be null")
//	@NotBlank(message = "Address is Mandatory")
//	private String Address;
//
//	@NotNull(message = "State name should not be null")
//	@NotBlank(message = "State name is Mandatory")
//	private String state;
//
//	@NotNull(message = "Pincode should not be null")
//	@NotBlank(message = "Pincode is Mandatory")
//	@Size(min = 6, max = 8)
//	private String pincode;
//
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccinationCenter")
//	private List<Appointment> appointments;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
//	private VaccineInventory vaccineInventory;
//
//	
//	
//	
//	
//}
