package com.patient.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.model.Patient;
import com.patient.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	public PatientRepository patientRepository;
	private static final Logger LOGGER= LoggerFactory.getLogger(PatientService.class);
	
	public Patient addPatient(Patient patient){
		LOGGER.info("Add the new patient");
		return patientRepository.save(patient);
	}
	public Patient getPatientById(int patientId) {
		LOGGER.info("Find patient by id");
		return patientRepository.findById(patientId).orElse(null);
	}
/*	public List<Patient> getPatientByName(String patientName) {
		return patientRepository.findByName(patientName);
	} */
	public List<Patient> getAllPatients(){
		LOGGER.info("Find all patients");
		return patientRepository.findAll();
	}
	public List<Patient> getPatientByName(String patientName){
		LOGGER.info("Find patient by name");
		List<Patient> patient=this.patientRepository.findAll();
			List<Patient> patientList = new ArrayList<Patient>();
			Iterator<Patient> iterator = patient.iterator();
			while(iterator.hasNext()) {
				Patient p=iterator.next();
				if(p.getPatientName().equalsIgnoreCase(patientName))
					patientList.add(p);
			}
			return patientList;
		}
	
	public void deletePatientById(int patientId) {
		LOGGER.info("Delete patient by id");
		patientRepository.deleteById(patientId);
		//return "Deleted "+patientId;
	}
	
	public String deletePatientByName(String patientName) {
		LOGGER.info("Delete patient by name");
		List<Patient> patientList=this.patientRepository.findAll();
		Iterator<Patient> iterator= patientList.iterator();
		boolean bool=false;
		while(iterator.hasNext()) {
			Patient p=iterator.next();
			if(p.getPatientName().equalsIgnoreCase(patientName)) {
				patientRepository.deleteById(p.getPatientId());
				bool=true;
				break;
			}
		}
		if(bool) {
			return "Delete doctor of name"+ patientName;
		}
		else {
			return "Doctor name not found"+ patientName;

		}
	}
	public Patient updatePatient(Patient patient, Integer patiendId) {
		LOGGER.info("Update patient by id");
		Patient newPatient=this.patientRepository.findById(patiendId).orElseThrow();
		newPatient.setPatientName(patient.getPatientName());
		newPatient.setAge(patient.getAge());
		newPatient.setCity(patient.getCity());
		newPatient.setEmailAddress(patient.getEmailAddress());
		newPatient.setGender(patient.getGender());
		newPatient.setPassword(patient.getPassword());
		newPatient.setPhoneNumber(patient.getPhoneNumber());
		newPatient.setProblems(patient.getProblems());
		Patient updatePatient= this.patientRepository.save(newPatient);
		return updatePatient;
	}
	
}
