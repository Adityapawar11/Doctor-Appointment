package com.request.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.request.model.Request;
import com.request.service.RequestServiceImpl;

@RestController
public class RequestController {
	private static final Logger logger = LoggerFactory.getLogger(RequestController.class);
	@Autowired
	RequestServiceImpl requestRepo;
	
	@PostMapping("/request")
	public String addRequest(@RequestBody Request request) {
		requestRepo.createRequest(request);
		logger.info("In create Request controller{}",request);
		return "Request added succesfully";
	}
	
	@GetMapping("/getAllRequest")
	public List<Request> getRequest() {
		logger.info("In getRequest controller()");

		return requestRepo.getAllRequest();
		
	}
	@DeleteMapping("/deleteAllRequest")
	public String deleteRequest() {
		 requestRepo.deleteAllRequest();
			logger.info("In deleteRequest controller()");

		 return "Deleted Succesfully";
		
	}
	@DeleteMapping("/deleteRequestById/{id}")
	public String deleteRequestbyid(@PathVariable Integer id) {
		 requestRepo.deleteRequestById(id);
			logger.info("In delteRequest controller()",id);

		 return "Deleted Succesfully";
		
	}
	@GetMapping("/getRequestById/{id}")
	public Request getRequestById(@PathVariable Integer id) {
		logger.info("In getRequest controller()",id);

		return requestRepo.getRequestById(id);
	}
	@GetMapping("/requestStatusById/{id}")
	public String getRequestStatusbyid(@PathVariable Integer id) {
		logger.info("In getRequestStatusById controller()",id);

		return requestRepo.getStatusOfRequestById(id);
		
	}
	@GetMapping("/getReasonOfCancellationById/{id}")
	public String getReasonRequestCancellationByid(@PathVariable Integer id) {
		logger.info("In getReasonOfCancellationById controller()",id);

		return requestRepo.getReasonForCancellationById(id);
		
	}
	@PutMapping("/updateRequestById/{rId}")
	public Request updateRequest(@RequestBody Request request ,@PathVariable Integer rId ) {
		logger.info("In updateRequest controller()",request,rId);

		return requestRepo.updateRequest(request,rId);
		
	}

}
