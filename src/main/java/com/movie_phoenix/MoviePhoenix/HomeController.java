/**
 * 
 */
package com.movie_phoenix.MoviePhoenix;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ben Feinstein
 * @author Kevin Busch
 */

@Controller
public class HomeController {

	@Value("${TMDbAPI.key}")
	private static String mainKey;
	// The base url for api
	public static final String BASE_URL = "https://api.themoviedb.org/3";
	private RestTemplate rt = new RestTemplate();
	
	//Temporary
	private String[] queries = {
			"/search/person?api_key=" + mainKey + "&query=tom cruise", // Search for actor "tom cruise"
//			"/search/movie?api_key=" + TMDB_KEY + "&query=avengers", // Search for movie "avengers"
//			"/person/500/movie_credits?api_key=" + TMDB_KEY, // Search for Tom Cruise's filmography
//			"/search/tv?api_key=" + TMDB_KEY + "&query=ncis" // Search for tv show "ncis"
			};
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index", "key", mainKey);
	}
	
	@RequestMapping("/test")
	public ModelAndView test() {
		ArrayList<String> finalResponses = new ArrayList<>();
		
		ModelAndView mv = new ModelAndView("test-page");
//		for (String query: queries) {
			String url = "https://api.themoviedb.org/3/search/person?api_key=7046655d3800539fad2d63f235a07e6e&query=tom cruise";
			String response = rt.getForObject(url, String.class);
			System.out.println(response);
//		}
		mv.addObject("JSON", finalResponses);
		return mv;
	}
	
}
