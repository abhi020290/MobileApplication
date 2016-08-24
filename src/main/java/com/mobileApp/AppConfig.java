package com.mobileApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;


@Configuration
@ComponentScan(basePackages = { "com.mobileApp.*" })
@PropertySource(value="classpath:config.properties", ignoreResourceNotFound=true)
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {

		String db_host = env.getProperty("mongodb.host");		
		String db_port = env.getProperty("mongodb.port");
		String db_name = env.getProperty("mongodb.db");
		
		System.out.println(db_host);
		System.out.println(db_port);
		System.out.println(db_name);
		
		MongoClient mongo = new MongoClient(db_host, Integer.valueOf(db_port));
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, db_name);
		return new MongoTemplate(mongoDbFactory);

	}
}
