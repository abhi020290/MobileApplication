package com.mobileApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Incident {

	@Id
	private String id;
	private String number;
	private String priority;
	private String severity;
	private String short_description;
	private String incident_state;
	private String assignment_group;
	
	public Incident() {
	}

	public Incident( String number, String priority, String severity, String short_Description,
			String incident_State, String assignment_Group) {
		setNumber(number);
		setPriority(priority);
		setSeverity(severity);
		setAssignment_Group(assignment_Group);
		setIncident_State(incident_State);
		setShort_Description(short_Description);
	
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getPriority() {
		return priority;
	}



	public void setPriority(String priority) {
		this.priority = priority;
	}



	public String getSeverity() {
		return severity;
	}



	public void setSeverity(String severity) {
		this.severity = severity;
	}



	public String getShort_Description() {
		return short_description;
	}



	public void setShort_Description(String short_Description) {
		this.short_description = short_Description;
	}



	public String getIncident_State() {
		return incident_state;
	}



	public void setIncident_State(String incident_State) {
		this.incident_state = incident_State;
	}



	public String getAssignment_Group() {
		return assignment_group;
	}



	public void setAssignment_Group(String assignment_Group) {
		this.assignment_group = assignment_Group;
	}
	
	public String toString() {
		System.out.print("Inside Model");
		String merge =  "[" + getIncident_State()
				+ ", " + getAssignment_Group()
				+ ", " + getPriority()
				+ ", " + getSeverity()
				+ ", " + getShort_Description()
				+ ", " + getNumber()
				+ "]";
		System.out.print("Inside Model");
		return merge;
	}
	
	
}
