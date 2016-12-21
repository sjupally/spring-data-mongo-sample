package com.mongo.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;

@Configuration
public class SpringMongoConfig {
	@Value("${mongo.host.name}")
	private String host;
	
	@Value("${mongo.credentials.username}")
	private String user;
	
	@Value("${mongo.credentials.password}")
	private String password;

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		UserCredentials userCredentials = new UserCredentials(user, password);
		return new SimpleMongoDbFactory(new Mongo(), "cart", userCredentials);
	}

	@Bean(name = "mongoTemplate")
	public MongoOperations mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}
}