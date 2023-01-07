package com.patient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.patient.model.Patient;
import com.patient.repository.PatientRepository;
import com.patient.service.PatientService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PatientApplicationTests {

	@Test
	void contextLoads() {
	}
	@InjectMocks
	private PatientService patientService;
	
	@Mock
	private PatientRepository patientRepository;
	
	
	
	
	
	
	@Test
	public void savePatientTest() {
		Patient patient=new Patient(1,"kirran","kirranraj@gmail.com","ironman",981156217,"chennai",24,	"headache",	"male");
		when(patientRepository.save(patient)).thenReturn(patient);
		assertEquals(patient, patientService.addPatient(patient));
	}
	
	@Test
	public void getPatientTest() {
		Patient patient= new Patient(3,"raj","kirran@gmail.com","ironman",981156217,"chennai",24,	"headache",	"male");
		when(patientRepository.findAll()).thenReturn(Stream.of(new Patient(2,"kirranraj","kirranraj3@gmail.com","ironman",981156217,"chennai",24,	"headache",	"male"),
																new Patient(3,"raja","raja@gmail.com","iron",98116217,"hyderabad",23,	"fever",	"male"))
																.collect(Collectors.toList()));
		assertEquals(2,patientService.getAllPatients().size());
	}

	@Test
	public void getPatientByIdTest() {
		Patient patient= new Patient(5,"raju","raju@gmail.com","batman",981156217,"chennai",24,	"headache",	"male");
		when(patientRepository.findById(patient.getPatientId())).thenReturn(Optional.of(patient));
		
		Patient exp=patientService.getPatientById(patient.getPatientId());
		verify(patientRepository).findById(patient.getPatientId());
	}
	
	@Test
	public void getPatientByNameTest() {
		Patient patient= new Patient(5,"raju","raju@gmail.com","batman",981156217,"chennai",24,	"headache",	"male");
		when(patientRepository.findById(patient.getPatientId())).thenReturn(Optional.of(patient));
		
		Patient exp=patientService.getPatientById(patient.getPatientId());
		verify(patientRepository).findById(patient.getPatientId());
	}
	
	@Test
	public void deletePatientTest() {
		Patient patient=new Patient(1,"kirran","kirranraj@gmail.com","ironman",981156217,"chennai",24,	"headache",	"male");
		patientService.deletePatientById(patient.getPatientId());
		verify(patientRepository, times(1)).deleteById(patient.getPatientId());
	}
	
	@Test
	public void deletePatientByNameTest() {
		Patient patient=new Patient(1,"kirran","kirranraj@gmail.com","ironman",981156217,"chennai",24,	"headache",	"male");
		patientService.deletePatientById(patient.getPatientId());
		verify(patientRepository, times(1)).deleteById(patient.getPatientId());
	}
	
	@Test
	public void updatePatientTest() {
		Patient patient=new Patient(1,"kirran","kirranraj@gmail.com","ironman",981156217,"chennai",24,	"headache",	"male");
		Patient patientOne=new Patient();
		patientOne.setAge(75);
		patientOne.setCity("madurai");
		patientOne.setEmailAddress("raju@gmail.com");
		patientOne.setGender("female");
		patientOne.setPassword("superman");
		patientOne.setPatientName("ramesh");
		patientOne.setPhoneNumber(99484038);
		patientOne.setProblems("cough");
		when(patientRepository.findById(patient.getPatientId())).thenReturn(Optional.of(patient));
		patientService.updatePatient(patientOne, patient.getPatientId());
		verify(patientRepository).findById(patient.getPatientId());
		assertEquals(75, patient.getAge());
		assertEquals("madurai", patient.getCity());
		assertEquals("raju@gmail.com", patient.getEmailAddress());
		assertEquals("female", patient.getGender());
		assertEquals("superman", patient.getPassword());
		assertEquals("ramesh", patient.getPatientName());
		assertEquals(99484038, patient.getPhoneNumber());
		assertEquals("cough", patient.getProblems()); 
	}
}
