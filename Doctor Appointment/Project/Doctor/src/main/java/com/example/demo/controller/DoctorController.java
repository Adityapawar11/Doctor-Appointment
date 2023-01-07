package com.example.demo.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorServiceImplementation;

@RestController
//@CrossOrigin("http://localhost:4200")
@CrossOrigin(origins="http://localhost:4200")
public class DoctorController {

	Logger logger = LoggerFactory.getLogger(DoctorController.class);
	@Autowired
	private DoctorServiceImplementation doctorServiceImplementation;
	
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		logger.info("add method in controller");
		return doctorServiceImplementation.addDoctor(doctor);
	}
	
	@GetMapping("/viewAllDoctors")
	public List<Doctor> viewAllDoctors() {
		logger.info("viewAll method in controller");
		return doctorServiceImplementation.viewAllDoctors();
	}
	
	@GetMapping("/viewDoctorById/{doctorId}")
	public Doctor viewDoctorById(@PathVariable int doctorId) {
		logger.info("viewDoctorById method in controller");
		return doctorServiceImplementation.viewDoctorById(doctorId);
	}
	
	@DeleteMapping("/deleteDoctorById/{doctorId}")
	public String deleteDoctorById(@PathVariable int doctorId) {
		logger.info("deleteDoctorById method in controller");
		doctorServiceImplementation.deleteDoctorById(doctorId);
		return "Deleted Doctor of Id : " +doctorId;
	}
	
	@PutMapping("/updateDoctorById/{doctorId}")
	public Doctor updateDoctorById(@RequestBody Doctor doctor) {
		logger.info("updateDoctorById method in controller");
		return doctorServiceImplementation.updateDoctorById(doctor);
	}
	
	@PutMapping("/addDoctorAvailabilityById/{doctorId}")
	public Doctor addDoctorAvailabilityById(@RequestBody Doctor doctor) {
		logger.info("addAvaliability method in controller");
		return doctorServiceImplementation.addDoctorAvailabilityById(doctor);
	}
	
	@PutMapping("/updateAvaliabilityById/{doctorId}")
	public Doctor updateDoctorAvailabilityById(@RequestBody Doctor doctor) {
		logger.info("updateAvaliabilityById method in controller");
		return doctorServiceImplementation.updateDoctorAvailabilityById(doctor);
	}
	
	@PostMapping("/addPrescritionById/{doctorId}")
	public Doctor addPrescritionById(@RequestBody Doctor doctor) {
		logger.info("addPrescrition method in controller");
		return doctorServiceImplementation.addPrescritionById(doctor);
	}
	
	@GetMapping("/viewBySpecialization/{specialization}")
	public List<Doctor> viewBySpecialization(@PathVariable String specialization){
		logger.info("viewBySpecialization method in controller");
		return doctorServiceImplementation.viewBySpecialization(specialization);
	}
	
	@GetMapping("/viewDoctorByName/{doctorName}")
	public List<Doctor> viewDoctorByName(@PathVariable String doctorName) {
		logger.info("viewDoctorByName method in controller");
		return doctorServiceImplementation.viewDoctorByName(doctorName);
	}

	@DeleteMapping("/deleteDoctorByName/{doctorName}")
	public String deleteDoctorByName(@PathVariable String doctorName) {
		logger.info("deleteDoctorByName method in controller");
		return doctorServiceImplementation.deleteDoctorByName(doctorName);
		//return "Deleted Doctor of Name : " +doctorName;

	}
}
