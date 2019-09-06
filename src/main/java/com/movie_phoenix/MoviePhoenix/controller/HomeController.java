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

/**
 * @author Ben Feinstein
 * @author Kevin Busch
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
	
	@RequestMapping("/search-result")
	public ModelAndView personResult(@RequestParam("PersonResults") String PersonResults) {
		ModelAndView mv = new ModelAndView("index");
		String url = BASE_URL + "/search/person?api_key=" + mainKey + "&query=" + PersonResults;
		String response = rt.getForObject(url, String.class);
		mv.addObject("search-results", response);
		return mv;
	}
}
