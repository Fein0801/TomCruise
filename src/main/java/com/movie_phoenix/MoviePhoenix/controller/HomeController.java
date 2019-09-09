/**
 * 
 */
package com.movie_phoenix.MoviePhoenix.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.movie_phoenix.MoviePhoenix.entity.Person;
import com.movie_phoenix.MoviePhoenix.entity.PersonResults;
import com.movie_phoenix.MoviePhoenix.entity.movie.FilmCreditsByPerson;

/**
 * @author Ben
 * @author kevinbusch
 * @author Atiba
 */

@Controller
public class HomeController {

	@Value("${TMDbAPI.key}")
	private String mainKey;
	// The base url for api
	public static final String BASE_URL = "https://api.themoviedb.org/3";
	private RestTemplate rt = new RestTemplate();

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index", "key", mainKey);
	}

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
		PersonResults response = rt.getForObject(url, PersonResults.class);
		mv.addObject("movieResults", response.getResults());
		return mv;
	}
	@RequestMapping("/tv-search")
	public ModelAndView tvResult(@RequestParam("query") String query) {
		ModelAndView mv = new ModelAndView("tv-results");
		String url = BASE_URL + "/search/tv?api_key=" + mainKey + "&query=" + query;
		PersonResults response = rt.getForObject(url, PersonResults.class);
		mv.addObject("tvResults", response.getResults());
		return mv;
	}
	@RequestMapping("/person-details")
	public ModelAndView personDetails(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("person-details");
		String url1 = BASE_URL + "/person/"+ id+"?api_key=" + mainKey;
		Person response = rt.getForObject(url1, Person.class);
		mv.addObject("pDeets", response);
		String url2 =  BASE_URL + "/person/"+ id+"movie_credits?api_key=" + mainKey;
		FilmCreditsByPerson response1 = rt.getForObject(url2, FilmCreditsByPerson.class);
		mv.addObject("pKnown", response1);
		return mv;
	}
	
	
}
