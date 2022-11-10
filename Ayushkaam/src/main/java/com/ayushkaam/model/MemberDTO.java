package com.ayushkaam.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class MemberDTO {


    private Integer memberId;

    private String memberName;

    private String mobileNumber;

    private Address address;

    private LocalDate dateOfBirth;

	public MemberDTO(Integer memberId, String memberName, String mobileNumber, Address address, LocalDate dateOfBirth) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}
    
   
}
