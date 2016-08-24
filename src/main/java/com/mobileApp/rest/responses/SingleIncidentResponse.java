package com.mobileApp.rest.responses;

import com.mobileApp.model.Incident;

//	http://CodeArsenal.net/2015/10/java-spring-restful-web-service-mongodb.html

public class SingleIncidentResponse {

	private boolean success;
	private Incident incident;
	
	public SingleIncidentResponse(boolean success, Incident incident) {
		this.success = success;
		this.incident = incident;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Incident getIncident() {
		return incident;
	}
	public void setIncident(Incident Incident) {
		this.incident = Incident;
	}
}
