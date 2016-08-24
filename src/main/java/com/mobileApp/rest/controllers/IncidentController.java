package com.mobileApp.rest.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.mobileApp.dao.IncidentRepository;
import com.mobileApp.model.Incident;
import com.mobileApp.rest.responses.MultipleIncidentResponse;
import com.mobileApp.rest.responses.SingleIncidentResponse;



@Controller
public class IncidentController {
	private static final Logger logger = LoggerFactory.getLogger(IncidentController.class);

	@Autowired
	private IncidentRepository incidentRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String home(Locale locale, Model model) {
		logger.info("This is Default Home REST page.\n\n The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "status";
	}
	
	@RequestMapping(value = "/incidents/{priority}", method = RequestMethod.GET)
	@ResponseBody
	public MultipleIncidentResponse getAllIncidents(@PathVariable("priority") String Priority) {
		logger.info("getAllPersons()...");
		System.out.println("Inside Controller : Enter ");
		System.out.println("Provided Number : "+Priority);
		List<Incident> incidents = incidentRepository.getIncidentsAll(Priority);
		System.out.println(incidents.size());
		MultipleIncidentResponse resp = new MultipleIncidentResponse(true, incidents);
		logger.info("...getAllPersons()");
		System.out.println("Inside Controler : Exit ");
		return resp;
	}	

	@RequestMapping(value = "/incidents/severity/{severity}", method = RequestMethod.GET)
	@ResponseBody
	public MultipleIncidentResponse getIncidentsSeverity(@PathVariable("severity") String severity) {
		logger.info("getAllPersons()...");
		System.out.println("Inside Controller : Enter ");
		System.out.println("Provided Number : "+severity);
		List<Incident> incidents = incidentRepository.getIncidentsSeverity(severity);
		System.out.println(incidents.size());
		MultipleIncidentResponse resp = new MultipleIncidentResponse(true, incidents);
		logger.info("...getAllPersons()");
		System.out.println("Inside Controler : Exit ");
		return resp;
	}
	
	@RequestMapping(value = "/incidents/priority/{priority}", method = RequestMethod.GET)
	@ResponseBody
	public MultipleIncidentResponse getIncidentsPriority(@PathVariable("priority") int priority) {
		logger.info("getIncidentsPriority()...");
		System.out.println("getIncidentsPriority : Enter ");
		System.out.println(" getIncidentsPriority Provided Number : "+priority);
		List<Incident> incidents = incidentRepository.getIncidentsPriority(priority);
		System.out.println(incidents.size());
		MultipleIncidentResponse resp = new MultipleIncidentResponse(true, incidents);
		logger.info("...getIncidentsPriority()");
		System.out.println("getIncidentsPriority : Exit ");
		return resp;
	}
	
	
	
}
