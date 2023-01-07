package com.patient.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patient.model.Patient;
import com.patient.service.PatientService;


@RestController
@CrossOrigin("http://localhost:4200/")
public class PatientController {
	
	@Autowired
	public PatientService patientService;
	private static final Logger LOGGER= LoggerFactory.getLogger(PatientService.class);
	
	
	@PostMapping("/addPatient")
	public Patient add(@RequestBody Patient patient) {
		LOGGER.info("Add the new patient");
		return patientService.addPatient(patient);
	}
	@GetMapping("/findPatientByid/{patientId}")
	public Patient getPatientById(@PathVariable int patientId) {
		LOGGER.info("Find patient by id");
		return patientService.getPatientById(patientId);
	}
	@GetMapping("/findAllPatients")
	public List<Patient> getAllPatients(){
		LOGGER.info("Find all patients");
		return patientService.getAllPatients();
	}
	@GetMapping("/findPatientByName/{patientName}")
	public List<Patient> getPatientByName(@PathVariable String patientName) {
		LOGGER.info("Find patient by name");
		return patientService.getPatientByName(patientName);
	}
	@DeleteMapping("/deletePatientById/{patientId}")
	public void deletePatientById(@PathVariable int patientId) {
		LOGGER.info("Delete patient by id");
		patientService.deletePatientById(patientId);
	}
	@DeleteMapping("/deletePatientByName/{patientName}")
	public void deletePatientByName(@PathVariable String patientName) {
		LOGGER.info("Delete patient by name");
		patientService.deletePatientByName(patientName);
	}
	@PutMapping("/updatePatientById/{patientId}")
	public ResponseEntity<Patient>updatePatient(@RequestBody Patient patient, @PathVariable Integer patientId){
		LOGGER.info("Update patient by id");
		Patient updatePatient=this.patientService.updatePatient(patient, patientId);
		return ResponseEntity.ok(updatePatient);
	}
}
