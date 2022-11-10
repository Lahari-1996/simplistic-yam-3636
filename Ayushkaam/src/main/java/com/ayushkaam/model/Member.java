package com.ayushkaam.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Member {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	
	@NotNull
	private String memberName;
	
	@Pattern(regexp="(^$[789]|[0-9]{10})")
	@Column(unique = true)
	private String mobileNumber;
	
	@NotNull
	@Pattern(regexp = "^(Male|Female|Others)")
	private String gender;
	
	
	private boolean dose1 = false;
	
	private boolean dose2 = false;
	
	private LocalDate dose1Date;
	
	private LocalDate dose2Date;
	
	
	@NotNull
	@Past
	private LocalDate dateOfBirth;  
	
	@NotNull
	@Embedded
	private Address address;
	
	
	@NotNull
	@Embedded
	private AadharCard aadharCard;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Appointment> appointments;



	public Member(@NotNull String memberName, @Pattern(regexp = "(^$[789]|[0-9]{10})") String mobileNumber,
				  @NotNull @Pattern(regexp = "^(Male|Female|Others)") String gender,
				  @NotNull @Past LocalDate dateOfBirth, @NotNull Address address,
				  @NotNull AadharCard aadharCard) {
		super();
		this.memberName = memberName;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.aadharCard = aadharCard;
	}






}
