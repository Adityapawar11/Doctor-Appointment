package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Doctor 
{
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	
	private int doctorId;
	private String doctorName;
	private String specialization;
	private String emailAddress;
	private String password;
	private long phoneNumber;
	private String city;
	private String experience;
	private String available;
	private String prescrition;
	
	public Doctor() {
		super();
	}

	public Doctor(int doctorId, String doctorName, String specialization, String emailAddress, String password,
			long phoneNumber, String city, String experience, String available, String prescrition) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.emailAddress = emailAddress;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.experience = experience;
		this.available = available;
		this.prescrition = prescrition;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getPrescrition() {
		return prescrition;
	}
	public void setPrescrition(String prescrition) {
		this.prescrition = prescrition;
	}
	
	

}
