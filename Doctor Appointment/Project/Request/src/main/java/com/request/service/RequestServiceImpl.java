package com.request.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.request.model.Request;
import com.request.repository.RequestRepository;

@Service
public class RequestServiceImpl implements RequestService {
	@Autowired
	private RequestRepository requestRepo;
	@Autowired
	private SequenceGeneratorService service;

	@Override
	public Request createRequest(Request request) {

		request.setId(service.getSequenceNumber(request.SEQUENCE_NAME));
		return this.requestRepo.save(request);
	}

	@Override
	public void deleteRequestById(Integer requestId) {

		Request deleteRequest = this.requestRepo.findById(requestId).orElse(null);
		this.requestRepo.delete(deleteRequest);

	}

	@Override
	public void deleteAllRequest() {
		this.requestRepo.deleteAll();

	}

	@Override
	public Request updateRequest(Request request, Integer requestId) {
		// TODO Auto-generated method stub
		Request newRequest = this.requestRepo.findById(requestId).orElse(null);
		newRequest.setDoctorId(request.getDoctorId());
		newRequest.setDoctorName(request.getDoctorName());
		newRequest.setDoctorSpeciality(request.getDoctorSpeciality());
		newRequest.setPatientId(request.getPatientId());
		newRequest.setPatientName(request.getPatientName());
		newRequest.setDiseaseDescription(request.getDiseaseDescription());
		newRequest.setReasonForCancellation(request.getReasonForCancellation());
		newRequest.setRequestStatus(request.getRequestStatus());
		// newRequest.setRequestDate(request.getRequestDate());

		return requestRepo.save(newRequest);
	}

	@Override
	public Request getRequestById(Integer requestId) {
		// TODO Auto-generated method stub
		Request request = this.requestRepo.findById(requestId).orElse(null);
		return request;
	}

	@Override
	public String getStatusOfRequestById(Integer requestId) {
		// TODO Auto-generated method stub
		Request request = this.requestRepo.findById(requestId).orElse(null);

		return request.getRequestStatus();
	}

	@Override
	public List<Request> getAllRequest() {
		// TODO Auto-generated method stub

		return requestRepo.findAll();
	}

	@Override
	public String getReasonForCancellationById(Integer requestId) {
		Request request = this.requestRepo.findById(requestId).orElse(null);

		return request.getReasonForCancellation();
	}

}
