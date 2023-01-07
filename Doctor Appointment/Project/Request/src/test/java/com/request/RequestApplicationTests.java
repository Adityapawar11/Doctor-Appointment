package com.request;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Collections;
import java.util.List;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.junit.jupiter.MockitoExtension;

import com.request.model.Request;
import com.request.repository.RequestRepository;
import com.request.service.RequestServiceImpl;
import com.request.service.SequenceGeneratorService;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class RequestApplicationTests {

	@Test
	void contextLoads() {
	}
	@InjectMocks
	@Autowired
	private SequenceGeneratorService service;

	@InjectMocks
	@Autowired
	RequestServiceImpl requestServiceImpl;

	@Mock
	RequestRepository requestRepository;

	
	@Test
	public void addRequestTest() {
		Date ddate = new Date();

		Request request = new Request(5, "adi", "neck", 20, "kiran", "sjndjs", "jsdbhjs", "pending",ddate);
		when(requestRepository.save(request)).thenReturn(request);
		assertEquals(request, requestServiceImpl.createRequest(request));
	}

	@Test
	public void getAllRequestTest() {
		Date ddate = new Date();
		when(requestRepository.findAll()).thenReturn(Stream
						.of(new Request(6,"pawar","neck",1020,"kiran","null","null","pending",ddate),
						new Request(1,"adi pawar","neck",100,"kiran","null","null","pending",ddate))
						.collect(Collectors.toList()));
		assertEquals(2, requestServiceImpl.getAllRequest().size());
	}

	@Test
	public void deleteEmployeeDetailsById() {
		Date ddate = new Date();
		Request request = new Request(5, "adi", "neck", 20, "kiran", "sjndjs", "jsdbhjs", "pending",ddate);	
		requestRepository.save(request);
		requestRepository.deleteById(request.getId());
		Optional optional = requestRepository.findById(request.getId());
		assertEquals(Optional.empty(), optional);
	}

	@Test
	public void getRequestByIdTest() {
		Date ddate = new Date();
		Request request = new Request(5, "adi", "neck", 20, "kiran", "sjndjs", "jsdbhjs", "pending",ddate);
		when(requestRepository.findById(request.getId())).thenReturn(Optional.of(request));
		Request expected = requestServiceImpl.getRequestById(request.getId());
		verify(requestRepository).findById(request.getId());
	}

	@Test
	public void getRequestStatusbyid() {
		Date ddate = new Date();
		Request request = new Request(5, "adi", "neck", 20, "kiran", "sjndjs", "jsdbhjs", "pending",ddate);		
		when(requestRepository.findById(request.getId())).thenReturn(Optional.of(request));
		assertEquals("pending",requestServiceImpl.getStatusOfRequestById(request.getId()));
	}
	@Test
	public void getReasonRequestCancellationByid() {
		Date ddate = new Date();
		Request request = new Request(5, "adi", "neck", 20, "kiran", "sjndjs", "jsdbhjs", "pending",ddate);		
		when(requestRepository.findById(request.getId())).thenReturn(Optional.of(request));
		String expected = requestServiceImpl.getReasonForCancellationById(request.getId());
		verify(requestRepository).findById(request.getId());
	}
		@Test 
	public void updateRequest() {
		Date ddate = new Date();
		Request request = new Request(5, "adi", "neck", 20, "kiran", "sjndjs", "jsdbhjs", "pending",ddate);
		Request updateRequest=new Request();
		updateRequest.setDoctorId(101);
		updateRequest.setPatientId(10001);
		when(requestRepository.findById(request.getId())).thenReturn(Optional.of(request));
		requestServiceImpl.updateRequest(updateRequest, request.getId());
		verify(requestRepository).findById(request.getId());
		assertEquals(101,request.getDoctorId());
	}
}
