package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.service.DoctorServiceImplementation;

@SpringBootTest
class Projectdoctor1ApplicationTests {

	@Test
	void contextLoads() {
	}
	@InjectMocks
	private DoctorServiceImplementation doctorServiceImplementation;
	
	@Mock
	private DoctorRepository doctorRepository;
	
	@Test
	public void addDoctorTest() {
		Doctor doctor = new Doctor(1 , "Bhaskar","ENT" , "bhaskar@gmail.com","abc123" , 9999 , "Hyd" , "1Yr" , "Yes" , "Paracitmol");
		when(doctorRepository.save(doctor)).thenReturn(doctor);
		assertEquals(doctor, doctorServiceImplementation.addDoctor(doctor));
	}
	
	@Test
	public void viewAllDoctors() {
		Doctor doctor = new Doctor(1 , "Bhaskar","ENT" , "bhaskar@gmail.com","abc123" , 9999 , "Hyd" , "1Yr" , "Yes" , "Paracitmol");
		when(doctorRepository.findAll()).thenReturn( Stream.of(new Doctor(2 , "Shankar" , "Brain" , "shankar@gmail.com" , "abc111" , 8888 , "viz" , "1Yr" , "Yes" , "Paracitmol"),
															new Doctor(3 , "Krishna" , "Heart" , "krishna@gmail.com" , "dce321" , 0000 , "viz" , "2Yr" , "Yes" , "Zincold"))
															.collect(Collectors.toList()));
		assertEquals(2,doctorServiceImplementation.viewAllDoctors().size());

	}
	
	@Test
	public void viewDoctorById() {
		Doctor doctor = new Doctor(1 , "Bhaskar","ENT" , "bhaskar@gmail.com","abc123" , 9999 , "Hyd" , "1Yr" , "Yes" , "Paracitmol");
		when(doctorRepository.findById(doctor.getDoctorId())).thenReturn(Optional.of(doctor));
		Doctor expected =doctorServiceImplementation.viewDoctorById(doctor.getDoctorId());
		verify(doctorRepository).findById(doctor.getDoctorId());
	}
	
	@Test
	public void deleteDoctorById() {
		Doctor doctor = new Doctor (1 , "Bhaskar","ENT" , "bhaskar@gmail.com","abc123" , 9999 , "Hyd" , "1Yr" , "Yes" , "Paracitmol");
		doctorRepository.save(doctor);
		doctorRepository.deleteById(doctor.getDoctorId());
		Optional optional = doctorRepository.findById(doctor.getDoctorId());
		assertEquals(Optional.empty(),optional);
	}
	
	@Test
	public void updateDoctorById() {
		Doctor doctor = new Doctor (1 , "Bhaskar","ENT" , "bhaskar@gmail.com","abc123" , 9999 , "Hyd" , "1Yr" , "Yes" , "Paracitmol");
		when(doctorRepository.save(doctor)).thenReturn(doctor);
		when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));
		doctor.setDoctorName("Testing doctor name");
		doctor.setSpecialization("Update Specialization");
		doctor.setEmailAddress("Update Email");
		doctor.setPassword("Update Password");
		doctor.setPhoneNumber(9999);
		doctor.setCity("Testing City");
		doctor.setExperience("Testing Experience");
		doctor.setAvailable("Testing Availability");
		doctor.setPrescrition("Testing Prescription");
		Doctor updatedDoctor = doctorServiceImplementation.updateDoctorById(doctor);
		assertThat(updatedDoctor.getDoctorName()).isEqualTo("Testing doctor name");
		assertThat(updatedDoctor.getSpecialization()).isEqualTo("Update Specialization");
		assertThat(updatedDoctor.getEmailAddress()).isEqualTo("Update Email");
		assertThat(updatedDoctor.getPassword()).isEqualTo("Update Password");
		assertThat(updatedDoctor.getPhoneNumber()).isEqualTo(9999);
		assertThat(updatedDoctor.getCity()).isEqualTo("Testing City");
		assertThat(updatedDoctor.getExperience()).isEqualTo("Testing Experience");
		assertThat(updatedDoctor.getAvailable()).isEqualTo("Testing Availability");
		assertThat(updatedDoctor.getPrescrition()).isEqualTo("Testing Prescription");

	}
	
	@Test
	public void addDoctorAvailabilityById() {
		Doctor doctor = new Doctor(1 , "Bhaskar","ENT" , "bhaskar@gmail.com","abc123" , 9999 , "Hyd" , "1Yr" , "Yes" , "Paracitmol");
		when(doctorRepository.save(doctor)).thenReturn(doctor);
		when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));
		assertEquals(doctor, doctorServiceImplementation.addDoctorAvailabilityById(doctor));
		
	}
	
	@Test
	public void updateDoctorAvailabilityById() {
		Doctor doctor = new Doctor (1 , "Bhaskar","ENT" , "bhaskar@gmail.com","abc123" , 9999 , "Hyd" , "1Yr" , "Yes" , "Paracitmol");
		when(doctorRepository.save(doctor)).thenReturn(doctor);
		when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));
		doctor.setDoctorName("Testing doctor name");
		doctor.setSpecialization("Update Specialization");
		doctor.setEmailAddress("Update Email");
		doctor.setPassword("Update Password");
		doctor.setPhoneNumber(9999);
		doctor.setCity("Testing City");
		doctor.setExperience("Testing Experience");
		doctor.setAvailable("Testing Availability");
		doctor.setPrescrition("Testing Prescription");
		Doctor updatedDoctor = doctorServiceImplementation.updateDoctorById(doctor);
		assertThat(updatedDoctor.getDoctorName()).isEqualTo("Testing doctor name");
		assertThat(updatedDoctor.getSpecialization()).isEqualTo("Update Specialization");
		assertThat(updatedDoctor.getEmailAddress()).isEqualTo("Update Email");
		assertThat(updatedDoctor.getPassword()).isEqualTo("Update Password");
		assertThat(updatedDoctor.getPhoneNumber()).isEqualTo(9999);
		assertThat(updatedDoctor.getCity()).isEqualTo("Testing City");
		assertThat(updatedDoctor.getExperience()).isEqualTo("Testing Experience");
		assertThat(updatedDoctor.getAvailable()).isEqualTo("Testing Availability");
		assertThat(updatedDoctor.getPrescrition()).isEqualTo("Testing Prescription");

	}
	
	@Test
	public void addPrescritionById() {
		Doctor doctor = new Doctor(1 , "Bhaskar","ENT" , "bhaskar@gmail.com","abc123" , 9999 , "Hyd" , "1Yr" , "Yes" , "Paracitmol");
		when(doctorRepository.save(doctor)).thenReturn(doctor);
		when(doctorRepository.findById(1)).thenReturn(Optional.of(doctor));
		assertEquals(doctor, doctorServiceImplementation.addPrescritionById(doctor));
		
	}
	
	@Test
	public void viewBySpecialization() {
		Doctor doctor = new Doctor(1 , "Bhaskar","ENT" , "bhaskar@gmail.com","abc123" , 9999 , "Hyd" , "1Yr" , "Yes" , "Paracitmol");
		when(doctorRepository.findById(doctor.getDoctorId())).thenReturn(Optional.of(doctor));
		Doctor expected =doctorServiceImplementation.viewDoctorById(doctor.getDoctorId());
		verify(doctorRepository).findById(doctor.getDoctorId());
	}
	
	@Test
	public void viewDoctorByName() {
		Doctor doctor = new Doctor(1 , "Bhaskar","ENT" , "bhaskar@gmail.com","abc123" , 9999 , "Hyd" , "1Yr" , "Yes" , "Paracitmol");
		when(doctorRepository.findById(doctor.getDoctorId())).thenReturn(Optional.of(doctor));
		Doctor expected =doctorServiceImplementation.viewDoctorById(doctor.getDoctorId());
		verify(doctorRepository).findById(doctor.getDoctorId());
	}
	
	@Test
	public void deleteDoctorByName() {
		Doctor doctor = new Doctor(1 , "Bhaskar","ENT" , "bhaskar@gmail.com","abc123" , 9999 , "Hyd" , "1Yr" , "Yes" , "Paracitmol");
		doctorRepository.deleteById(doctor.getDoctorId());
		//Doctor expected =doctorServiceImplementation.viewDoctorById(doctor.getDoctorId());
		verify(doctorRepository,times(1)).deleteById(doctor.getDoctorId());
	}

}
