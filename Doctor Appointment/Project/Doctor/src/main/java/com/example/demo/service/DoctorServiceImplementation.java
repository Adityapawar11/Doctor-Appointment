package com.example.demo.service;

import java.util.Iterator;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorServiceImplementation implements DoctorService{
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorServiceImplementation.class);
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public Doctor addDoctor(Doctor doctor) {
		LOGGER.info("add method in Service");
		return doctorRepository.save(doctor);
	}
	@Override
	public List<Doctor> viewAllDoctors() {
		LOGGER.info("viewAll method in Service");
		return doctorRepository.findAll();
	}

	@Override
	public Doctor viewDoctorById(int doctorId) {
		LOGGER.info("viewDoctorById method in Service");
		return doctorRepository.findById(doctorId).get();
	}

	@Override
	public String deleteDoctorById(int doctorId) {
		LOGGER.info("deleteDoctorById method in Service");
		doctorRepository.deleteById(doctorId);
		return "Deleted Doctor of Id : " +doctorId;
		
	}

	@Override
	public Doctor updateDoctorById(Doctor doctor) {
		LOGGER.info("updateDoctorById method in Service");
		Doctor dr= doctorRepository.findById(doctor.getDoctorId()).get();
		 dr.setDoctorName(doctor.getDoctorName());
         dr.setSpecialization(doctor.getSpecialization());
         dr.setEmailAddress(doctor.getEmailAddress());
         dr.setPassword(doctor.getPassword());
         dr.setPhoneNumber(doctor.getPhoneNumber());
		 dr.setCity(doctor.getCity());
		 dr.setExperience(doctor.getExperience());
		 dr.setAvailable(doctor.getAvailable());
		 dr.setPrescrition(doctor.getPrescrition());
		 return doctorRepository.save(dr);

	}
	public Doctor addDoctorAvailabilityById(Doctor doctor) {
		LOGGER.info("addDoctorAvailabilityById method in Service");
		Doctor dr= doctorRepository.findById(doctor.getDoctorId()).get();
		 dr.setDoctorName(doctor.getDoctorName());
       dr.setSpecialization(doctor.getSpecialization());
       dr.setEmailAddress(doctor.getEmailAddress());
       dr.setPassword(doctor.getPassword());
       dr.setPhoneNumber(doctor.getPhoneNumber());
		 dr.setCity(doctor.getCity());
		 dr.setExperience(doctor.getExperience());
		 dr.setAvailable(doctor.getAvailable());
		 dr.setPrescrition(doctor.getPrescrition());
		 return doctorRepository.save(dr);

	}
	
	public Doctor updateDoctorAvailabilityById(Doctor doctor) {
		LOGGER.info("updateDoctorAvailabilityById method in Service");
		Doctor dr= doctorRepository.findById(doctor.getDoctorId()).get();
		 dr.setDoctorName(doctor.getDoctorName());
        dr.setSpecialization(doctor.getSpecialization());
        dr.setEmailAddress(doctor.getEmailAddress());
        dr.setPassword(doctor.getPassword());
        dr.setPhoneNumber(doctor.getPhoneNumber());
		 dr.setCity(doctor.getCity());
		 dr.setExperience(doctor.getExperience());
		 dr.setAvailable(doctor.getAvailable());
		 dr.setPrescrition(doctor.getPrescrition());
		 return doctorRepository.save(dr);
	}
	@Override
	public Doctor addPrescritionById(Doctor doctor) {
		LOGGER.info("addPrescritionById method in Service");
		Doctor dr= doctorRepository.findById(doctor.getDoctorId()).get();
		 dr.setDoctorName(doctor.getDoctorName());
       dr.setSpecialization(doctor.getSpecialization());
       dr.setEmailAddress(doctor.getEmailAddress());
       dr.setPassword(doctor.getPassword());
       dr.setPhoneNumber(doctor.getPhoneNumber());
		 dr.setCity(doctor.getCity());
		 dr.setExperience(doctor.getExperience());
		 dr.setAvailable(doctor.getAvailable());
		 dr.setPrescrition(doctor.getPrescrition());
		 return doctorRepository.save(dr);
	}
	@Override
	public List<Doctor> viewBySpecialization(String specialization) {
		LOGGER.info("viewBySpecialization method in Service");
		return doctorRepository.viewBySpecialization(specialization);
		
	}
	@Override
	public List<Doctor> viewDoctorByName(String doctorName) {
		LOGGER.info("viewDoctorByName method in Service");
		return doctorRepository.viewDoctorByName(doctorName);
	}
	@Override
	public String deleteDoctorByName(String doctorName) {
		LOGGER.info("deleteDoctorByName method in Service");
		List<Doctor> doctor=this.doctorRepository.findAll();
			int  doctorId;
			Iterator<Doctor> iterator = doctor.iterator();
			boolean s=false;
			while(iterator.hasNext()) {
				Doctor dr=iterator.next();
				if(dr.getDoctorName().equalsIgnoreCase(doctorName)) {
					doctorRepository.deleteById(dr.getDoctorId());
					s=true;
					break;
				}
			}
			if(s) {
			return "deleted doctor of name : " +doctorName;
			}
			else {
				return "doctor name not found : " +doctorName;
			}
		
	}
}

