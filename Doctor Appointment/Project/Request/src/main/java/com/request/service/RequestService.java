package com.request.service;

import java.util.List;

import com.request.model.Request;

public interface RequestService {
	public Request createRequest(Request request) ;
	public void deleteRequestById(Integer requestId);
	public void deleteAllRequest();
	public Request updateRequest(Request request,Integer requestId);
	public Request getRequestById(Integer requestId);
	public String getStatusOfRequestById(Integer requestId);
	//public Request updateRequestById(Integer requestId);
	public String getReasonForCancellationById(Integer requestId);
	public List<Request> getAllRequest();
}
