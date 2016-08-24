package com.mobileApp.rest.responses;

import java.util.List;

import com.mobileApp.model.Incident;

public class MultipleIncidentResponse {

	private boolean success;
	private List<Incident> incidents;
	
	public MultipleIncidentResponse() {
	}

	public MultipleIncidentResponse(boolean success, List<Incident> incidents) {
		this.success = success;
		this.incidents = incidents;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<Incident> getIncidents() {
		return incidents;
	}
	public void setIncidents(List<Incident> incidents) {
		this.incidents = incidents;
	}
	
	
	
}
