//package com.movie_phoenix.MoviePhoenix;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.client.RestTemplate;
//
//
//
//public class GoogleService {
//
//	@Value("${google.client_secret}")
//	String clientSecret;
//
//	RestTemplate rt = new RestTemplate();
//
//	// Make an HTTP request to Github's server, using
//	// the temp code to get the access token
//	public String getGithubAccessToken(String code) {
//		Map<String, String> params = new HashMap<>();
//		params.put("code", code);
//		params.put("client_id", "bc6e75b4c9b96459b06e");
//		params.put("client_secret", clientSecret);
//
//		Map<String, String> response = rt.postForObject("https://google.com/login/oauth/access_token", params,
//				Map.class);
//
//		return response.get("access_token");
//
//	}

//	public GitHubUser getUserFromGithub(String accessToken) {
//		// we are using the url required from the documentation and 
//		// adding the access token when we make the method call
//		String url = "https://api.github.com/user?access_token=" + accessToken;
//		GitHubUser userDetails = rt.getForObject(url, GitHubUser.class);
//		
//
//		return userDetails;
//	}


	
//}
