/**
 * 
 */
package com.movie_phoenix.MoviePhoenix.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.movie_phoenix.MoviePhoenix.entity.Person;
import com.movie_phoenix.MoviePhoenix.entity.PersonResults;
import com.movie_phoenix.MoviePhoenix.entity.movie.FilmCreditsByPerson;
import com.movie_phoenix.MoviePhoenix.entity.movie.Movie;
import com.movie_phoenix.MoviePhoenix.entity.movie.MovieResults;
import com.movie_phoenix.MoviePhoenix.entity.tv.TvShow;
import com.movie_phoenix.MoviePhoenix.entity.tv.TvShowResults;
import com.movie_phoenix.MoviePhoenix.service.GoogleService;

/**
 * @author Ben
 * @author kevinbusch
 * @author Atiba
 */

@Controller
public class HomeController {

	@Value("${TMDbAPI.key}")
	private String mainKey;
	
	@Value("${google.client_id}")
	private String clientId;
	
	@Autowired
	GoogleService gSuite;
	
	// The base url for api
	public static final String BASE_URL = "https://api.themoviedb.org/3";
	private RestTemplate rt = new RestTemplate();
	
	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		StringBuilder urlParams = new StringBuilder("?scope=profile https://www.googleapis.com/auth/calendar&client_id=");
		urlParams.append(clientId);
		urlParams.append("&redirect_uri=http://localhost:8080/verify&response_type=code&access_type=offline");
		mv.addObject("params", urlParams.toString());
		
		return mv;
	}
	
	@RequestMapping("/verify")
	public ModelAndView verify(@RequestParam("code") String code) {
			ModelAndView mv = new ModelAndView("index", "accessCode", code);
			String test = "Oh god";
			try {
				GoogleAuthorizationCodeTokenRequest request = gSuite.getTokenRequest(code);
				GoogleTokenResponse response = gSuite.getTokenResponse(request);
				GoogleIdToken idToken = gSuite.getIdToken(response);
				Payload p = idToken.getPayload();
				test = idToken.toString();
			} catch (NullPointerException e) {
				System.out.println("Oh shit");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mv.addObject("token", test);
			return mv;
	}

//	@RequestMapping("/")
//	public ModelAndView search(@RequestParam("code") String code) {
//		return new ModelAndView("index", "key", mainKey);
//	}

	@RequestMapping("/test")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView("test-page");
		return mv;
	}

	@RequestMapping("/person-search")
	public ModelAndView personResult(@RequestParam("query") String query) {
		ModelAndView mv = new ModelAndView("person-results");
		String url = BASE_URL + "/search/person?api_key=" + mainKey + "&query=" + query;
		PersonResults response = rt.getForObject(url, PersonResults.class);
		mv.addObject("personResults", response.getResults());
		return mv;
	}

	@RequestMapping("/movie-search")
	public ModelAndView movieResult(@RequestParam("query") String query) {
		ModelAndView mv = new ModelAndView("movie-results");
		String url = BASE_URL + "/search/movie?api_key=" + mainKey + "&query=" + query;
		MovieResults response = rt.getForObject(url, MovieResults.class);
		mv.addObject("movieResults", response.getResults());
		return mv;
	}

	@RequestMapping("/tv-search")
	public ModelAndView tvResult(@RequestParam("query") String query) {
		ModelAndView mv = new ModelAndView("tv-results");
		String url = BASE_URL + "/search/tv?api_key=" + mainKey + "&query=" + query;
		TvShowResults response = rt.getForObject(url, TvShowResults.class);
		mv.addObject("tvResults", response.getResults());
		return mv;
	}

	@RequestMapping("/person-details")
	public ModelAndView personDetails(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("person-details");
		String url1 = BASE_URL + "/person/" + id + "?api_key=" + mainKey;
		Person response = rt.getForObject(url1, Person.class);
		mv.addObject("pDeets", response);
		String url2 =  BASE_URL + "/person/"+ id+"/movie_credits?api_key=" + mainKey;
		FilmCreditsByPerson response1 = rt.getForObject(url2, FilmCreditsByPerson.class);
		mv.addObject("pKnown", response1);
		return mv;
	}
	@RequestMapping("/movie-details")
	public ModelAndView movieDetails(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("movie-details");
		String url = BASE_URL + "/movie/"+id+"?api_key=" + mainKey;
		Movie response = rt.getForObject(url, Movie.class);
		mv.addObject("movieDeets", response);
		return mv;
	}
	@RequestMapping("/tv-details")
	public ModelAndView tvDetails(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("tv-details");
		String url = BASE_URL + "/tv/"+id+"?api_key=" + mainKey;
		TvShow response = rt.getForObject(url,TvShow.class);
		mv.addObject("tvDeets", response);
		return mv;
	}
	
//	@RequestMapping("search")
//	public ModelAndView backToHome() {
//		return new ModelAndView("redirect:/");
//	}

}
