package com.request.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import lombok.ToString;

@Document(collection="request")
@Data

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Request {
	
	@Transient
    public static final String SEQUENCE_NAME = "request_sequence";
	@Id
	private int id;
	
	private int doctorId;
	
	private String doctorName;
	
	private String doctorSpeciality;
	
	private int patientId;
	
	private String patientName;
	
	private String diseaseDescription;
	
	private String reasonForCancellation;
	
	private String requestStatus;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date requestDate;

	
	public Request(int doctorId, String doctorName, String doctorSpeciality, int patientId, String patientName,
			String diseaseDescription, String reasonForCancellation, String requestStatus,Date date) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpeciality = doctorSpeciality;
		this.patientId = patientId;
		this.patientName = patientName;
		this.diseaseDescription = diseaseDescription;
		this.reasonForCancellation = reasonForCancellation;
		this.requestStatus = requestStatus;
		this.requestDate = date;
	}
	public Request () {}
	
		public void setId(int requestId) {
		this.id = requestId;
	}
	public int getId() {
		return id;
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
	public String getDoctorSpeciality() {
		return doctorSpeciality;
	}
	public void setDoctorSpeciality(String doctorSpeciality) {
		this.doctorSpeciality = doctorSpeciality;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDiseaseDescription() {
		return diseaseDescription;
	}
	public void setDiseaseDescription(String diseaseDescription) {
		this.diseaseDescription = diseaseDescription;
	}
	public String getReasonForCancellation() {
		return reasonForCancellation;
	}
	public void setReasonForCancellation(String reasonForCancellation) {
		this.reasonForCancellation = reasonForCancellation;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}


}
