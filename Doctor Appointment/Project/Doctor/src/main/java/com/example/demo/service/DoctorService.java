package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Doctor;

public interface DoctorService {
	public Doctor addDoctor(Doctor doctor);
	public List<Doctor> viewAllDoctors();
	public Doctor viewDoctorById(int doctorId);
	public String deleteDoctorById(int doctorId);
	public Doctor updateDoctorById(Doctor doctor);
	public Doctor addDoctorAvailabilityById(Doctor doctor);
	public Doctor updateDoctorAvailabilityById(Doctor doctor);
	public Doctor addPrescritionById(Doctor doctor);
	public List<Doctor> viewBySpecialization(String specialization);
	public List<Doctor> viewDoctorByName(String doctorName);
	public String deleteDoctorByName(String doctorName);

}
