package com.movie_phoenix.MoviePhoenix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

@Component // this helps us use Spring's Dependency Injection
public class GoogleService {

<<<<<<< HEAD
	
	private static final String OUR_URL = "http://localhost:8080/";
=======
	private static final String OUR_URL = "https://movie-phoenix.herokuapp.com/";
>>>>>>> 060fe695e5e40769e41af561aadcec99b90b5372
	/*
	 * The @Value annotation allows us to pull values from the
	 * application.properties
	 * 
	 * Remember to add the application.properties to .gitignore before working on
	 * the application
	 */
<<<<<<< HEAD
//	@Value("${google.client_secret}")
//	String clientSecret;
//
//	
//	@Value("${google.client_id}")
//	String clientId;
//	RestTemplate rt = new RestTemplate();
=======
	@Value("${google.client_secret}")
	String clientSecret;

	@Value("${google.client_id}")
	String clientId;
>>>>>>> 060fe695e5e40769e41af561aadcec99b90b5372

	RestTemplate rt = new RestTemplate();

//	public void getGoogleAccessToken() {
//		String scopes=;
//		String authCodeUrl = "https://accounts.google.com/o/oauth2/auth?client_id="+clientId+"&redirect_uri="+OUR_URL+"search&scopes=" + scopes;
//		try {
//			GoogleTokenResponse response = new GoogleAuthorizationCodeTokenRequest(new NetHttpTransport(), new JsonFactory(), clientId, clientSecret, code, redirectUri)
//		} catch (TokenResponseException e) {
//			// TODO: handle exception
//		}
//	}
	
	private List<String> getScopes() {
		List<String> scopes = new ArrayList<>();
		scopes.add("https://www.googleapis.com/auth/calendar");
		scopes.add("https://www.googleapis.com/auth/userinfo.email");
		scopes.add("https://www.googleapis.com/auth/userinfo.profile");
		return scopes;
	}
	
	public String getScopesUrlString() {
		List<String> scopes = getScopes();
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < scopes.size(); i++) {
			builder.append(scopes.get(i));
			if(i < scopes.size() - 1) {
				builder.append(" ");
			}
		}
		
		
		return builder.toString();
	}
	
	public GoogleAuthorizationCodeRequestUrl getGoogleAuthCode() {
		
		List<String> scopes = getScopes();
		String redirectUri = OUR_URL;
		GoogleAuthorizationCodeFlow a = new GoogleAuthorizationCodeFlow(new NetHttpTransport(), new JacksonFactory(), clientId, clientSecret, scopes);
		GoogleAuthorizationCodeRequestUrl authCodeUrl = a.newAuthorizationUrl();
		authCodeUrl.setRedirectUri(redirectUri);
		return authCodeUrl;
	}

}