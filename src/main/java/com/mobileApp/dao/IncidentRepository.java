package com.mobileApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mobileApp.model.Incident;



@Repository
public class IncidentRepository {

	public static final String INCIDENT_COLLECTION_NAME = "incident";
	
	@Autowired
    private MongoTemplate mongo;
	
	
/*	public List<Incident> getIncidentsAll(String Priority) {
		System.out.println("Inside repo class enter "+Priority);
		System.out.println(mongo.getDb());
		System.out.println(mongo.getCollectionNames());
		System.out.println("Query String "+Query.query(Criteria.where("Priority").is(Priority)).toString());
		System.out.println("Criteria "+Criteria.where("Priority").is(Priority).toString());
		System.out.println(mongo.count(null, INCIDENT_COLLECTION_NAME));
		return  mongo.find(Query.query(Criteria.where("Priority").is(Priority)), Incident.class, INCIDENT_COLLECTION_NAME);
	}*/

	public List<Incident> getIncidentsAll(String Priority) {
		System.out.println("Inside repo class enter "+Priority);
		System.out.println(mongo.getDb());
		System.out.println(mongo.getCollectionNames());
		System.out.println("Query String ="+Query.query(Criteria.where("Number").is(Priority)).toString());
		System.out.println(mongo.count(null, INCIDENT_COLLECTION_NAME));
		//return mongo.findAll(null,Incident.class, INCIDENT_COLLECTION_NAME);
		return  mongo.find(Query.query(Criteria.where("number").is(Priority)), Incident.class, INCIDENT_COLLECTION_NAME);
	}
	
	public List<Incident> getIncidentsSeverity(String severity) {
		System.out.println("Inside repo class enter "+severity);
		System.out.println(mongo.getDb());
		System.out.println(mongo.getCollectionNames());
		System.out.println("Query String ="+Query.query(Criteria.where("severity").is(severity)).toString());
		System.out.println(mongo.count(null, INCIDENT_COLLECTION_NAME));
		//return mongo.findAll(null,Incident.class, INCIDENT_COLLECTION_NAME);
		return  mongo.find(Query.query(Criteria.where("severity").is(severity)), Incident.class, INCIDENT_COLLECTION_NAME);
	}
	
	public List<Incident> getIncidentsPriority(int priority) {
		System.out.println("Inside repo class getIncidentsPriority "+priority);
		System.out.println(mongo.getDb());
		System.out.println(mongo.getCollectionNames());
		System.out.println("Query String ="+Query.query(Criteria.where("priority").is(priority)).toString());
		System.out.println(mongo.count(null, INCIDENT_COLLECTION_NAME));
		//return mongo.findAll(null,Incident.class, INCIDENT_COLLECTION_NAME);
		return  mongo.find(Query.query(Criteria.where("priority").is(priority)), Incident.class, INCIDENT_COLLECTION_NAME);
	}
	
	
	
    }
	

