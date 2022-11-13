package com.ayushkaam.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ayushkaam.Enum.Slots;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


	//@Data
	//@AllArgsConstructor
	//@NoArgsConstructor
	//@ToString
	//@EqualsAndHashCode
	@Entity
	public class Appointment {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long bookingId;
		
		@NotBlank(message = "Mobile Number is Mandatory")
		@Size(max=10,message="Moblie Number length should be 10!")
		@Pattern(regexp = "^[6-9][0-9]{9}$",message="Mobile No is Invalid!")
		private String  mobileNo;
		
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
		private LocalDate dateofbooking;
		
		 Slots slot;
		 
		private boolean bookingStatus;
		
		
		@JsonIgnore
		@ManyToOne(cascade = CascadeType.ALL)
		private Member members;

		@ManyToOne(cascade = CascadeType.ALL)
		private VaccinationCenter vaccinationCenter;

		public long getBookingId() {
			return bookingId;
		}

		public void setBookingId(long bookingId) {
			this.bookingId = bookingId;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public LocalDate getDateofbooking() {
			return dateofbooking;
		}

		public void setDateofbooking(LocalDate dateofbooking) {
			this.dateofbooking = dateofbooking;
		}

		public Slots getSlot() {
			return slot;
		}

		public void setSlot(Slots slot) {
			this.slot = slot;
		}

		public boolean isBookingStatus() {
			return bookingStatus;
		}

		public void setBookingStatus(boolean bookingStatus) {
			this.bookingStatus = bookingStatus;
		}

		public Member getMember() {
			return members;
		}

		public void setMember(Member members) {
			this.members = members;
		}

		public VaccinationCenter getVaccinationCenter() {
			return vaccinationCenter;
		}

		public void setVaccinationCenter(VaccinationCenter vaccinationCenter) {
			this.vaccinationCenter = vaccinationCenter;
		}

		@Override
		public int hashCode() {
			return Objects.hash(bookingId, bookingStatus, dateofbooking, members, mobileNo, slot, vaccinationCenter);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Appointment other = (Appointment) obj;
			return bookingId == other.bookingId && bookingStatus == other.bookingStatus
					&& Objects.equals(dateofbooking, other.dateofbooking) && Objects.equals(members, other.members)
					&& Objects.equals(mobileNo, other.mobileNo) && slot == other.slot
					&& Objects.equals(vaccinationCenter, other.vaccinationCenter);
		}

		@Override
		public String toString() {
			return "Appointment [bookingId=" + bookingId + ", mobileNo=" + mobileNo + ", dateofbooking=" + dateofbooking
					+ ", slot=" + slot + ", bookingStatus=" + bookingStatus + ", member=" + members + ", vaccinationCenter="
					+ vaccinationCenter + "]";
		}

		public Appointment() {
			super();
			
		}

		public Appointment(long bookingId, String mobileNo, LocalDate dateofbooking, Slots slot, boolean bookingStatus,
				Member members, VaccinationCenter vaccinationCenter) {
			super();
			this.bookingId = bookingId;
			this.mobileNo = mobileNo;
			this.dateofbooking = dateofbooking;
			this.slot = slot;
			this.bookingStatus = bookingStatus;
			this.members = members;
			this.vaccinationCenter = vaccinationCenter;
		}
	
}
