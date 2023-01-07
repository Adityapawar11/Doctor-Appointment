package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	@Query(value= "select * from doctor  where specialization=:s",nativeQuery=true)
	public List<Doctor> viewBySpecialization(@Param("s") String specialization);
	
	@Query(value= "select * from doctor where doctor_name=:doctorName",nativeQuery=true)
	public List<Doctor> viewDoctorByName(@Param("doctorName") String doctorName);
	
	@Query(value= "delete  from doctor where doctor_name=:doctorName",nativeQuery=true)
	public String deleteDoctorByName(@Param("doctorName") String doctorName);
	
}
