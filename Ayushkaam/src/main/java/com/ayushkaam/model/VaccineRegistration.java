package com.ayushkaam.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class VaccineRegistration {
	
	@Id
	@Size(max=10,message="Moblie Number length should be 10!")
	@Pattern(regexp = "^[6-9][0-9]{9}$",message="Mobile No is Invalid!")
	private String mobileNo;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
//	@NotNull(message = "Date of Registration should not be Null")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofregistration;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "vaccineRegistration")
	private Member member;

}
