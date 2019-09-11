package com.movie_phoenix.MoviePhoenix.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

@Component // this helps us use Spring's Dependency Injection
public class GoogleService {

	private static final String OUR_URL = "http://localhost:8080/";
	@Value("${google.client_secret}")
	String clientSecret;

	@Value("${google.client_id}")
	String clientId;

	RestTemplate rt = new RestTemplate();
	
	public GoogleTokenResponse getTokenResponse(GoogleAuthorizationCodeTokenRequest request) throws IOException {
		return request.setRedirectUri("http://localhost:8080/verify").execute();
	}

	/**
	 * Starting point for a token request
	 * 
	 * @param code
	 * @return
	 */
	public GoogleAuthorizationCodeTokenRequest getTokenRequest(String code) {
		GoogleAuthorizationCodeFlow authCodeFlow = new GoogleAuthorizationCodeFlow(new NetHttpTransport(),
				JacksonFactory.getDefaultInstance(), clientId, clientSecret, getScopes());
		GoogleAuthorizationCodeTokenRequest request = authCodeFlow.newTokenRequest(code);
		return request;
	}

	public String getAccessToken(GoogleTokenResponse response) {
		return response.getAccessToken();
	}
	
	public GoogleIdToken getIdToken(GoogleTokenResponse response) throws IOException {
		return response.parseIdToken();
	}

//	public String getAccessToken(String code) {
//		Map<String, String> params = new HashMap<>();
//		params.put("code", code);
//		params.put("client_id", clientId);
//		params.put("client_secret", clientSecret);
//		params.put("redirect_uri", "http://localhost:8080/verify");
//		params.put("grant_type", "authorization_code");
//		
//		Map<String, String> response = rt.postForObject("https://www.googleapis.com/oauth2/v4/token", params, Map.class);
//		return response.get("access_token");
//	}

	private List<String> getScopes() {
		List<String> scopes = new ArrayList<>();
		scopes.add("https://www.googleapis.com/auth/calendar");
		scopes.add("email");
		scopes.add("profile");
		scopes.add("openid");
		return scopes;
	}

	public String getScopesUrlString() {
		List<String> scopes = getScopes();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < scopes.size(); i++) {
			builder.append(scopes.get(i));
			if (i < scopes.size() - 1) {
				builder.append(" ");
			}
		}

		return builder.toString();
	}

//	public GoogleAuthorizationCodeRequestUrl getGoogleAuthCodeUrl() throws IOException {
//		List<String> scopes = getScopes();
//		String redirectUri = OUR_URL;
//		GoogleAuthorizationCodeFlow a = new GoogleAuthorizationCodeFlow(new NetHttpTransport(), JacksonFactory.getDefaultInstance(),
//				clientId, clientSecret, scopes);
//		a.loadCredential(generateUserId());
//		GoogleAuthorizationCodeRequestUrl authCodeUrl = a.newAuthorizationUrl();
//		authCodeUrl.setRedirectUri(redirectUri);
//		return authCodeUrl;
//	}
//
//	private String generateUserId() {
//		Random rand = new Random();
//		return "mp" + rand.nextInt();
//	}

}