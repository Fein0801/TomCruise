package com.movie_phoenix.MoviePhoenix.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component // this helps us use Spring's Dependency Injection
public class GoogleService {

	
	private static final String OUR_URL = "http://localhost:8080/";
	/*
	 * The @Value annotation allows us to pull values from the
	 * application.properties
	 * 
	 * Remember to add the application.properties to .gitignore before working on
	 * the application
	 */
	@Value("${google.client_secret}")
	String clientSecret;

	RestTemplate rt = new RestTemplate();

}