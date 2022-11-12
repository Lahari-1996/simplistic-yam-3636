package com.ayushkaam.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class VaccineInventory {
	
	@Id
	private Integer inventoryId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@NotNull(message ="Date should not be Null")
	private LocalDate  date;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="vaccineInventory")
	private List<VaccinationCenter> vaccinationCenter;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="vaccineInventory")
	private List<VaccineCount> vaccinecount = new ArrayList<>();

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<VaccinationCenter> getVaccinationCenter() {
		return vaccinationCenter;
	}

	public void setVaccinationCenter(List<VaccinationCenter> vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

	public List<VaccineCount> getVaccinecount() {
		return vaccinecount;
	}

	public void setVaccinecount(List<VaccineCount> vaccinecount) {
		this.vaccinecount = vaccinecount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, inventoryId, vaccinationCenter, vaccinecount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VaccineInventory other = (VaccineInventory) obj;
		return Objects.equals(date, other.date) && Objects.equals(inventoryId, other.inventoryId)
				&& Objects.equals(vaccinationCenter, other.vaccinationCenter)
				&& Objects.equals(vaccinecount, other.vaccinecount);
	}
	
	 public VaccineInventory() {
		 super();
		// TODO Auto-generated constructor stub
	}

	public VaccineInventory(Integer inventoryId, @NotNull(message = "Date should not be Null") LocalDate date,
			List<VaccinationCenter> vaccinationCenter, List<VaccineCount> vaccinecount) {
		super();
		this.inventoryId = inventoryId;
		this.date = date;
		this.vaccinationCenter = vaccinationCenter;
		this.vaccinecount = vaccinecount;
	}
	
	
	

}
