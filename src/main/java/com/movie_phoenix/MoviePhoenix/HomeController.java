/**
 * 
 */
package com.movie_phoenix.MoviePhoenix;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ben Feinstein
 * @author Kevin Busch
 */

@Controller
public class HomeController {

	@Value("${TMDbAPI.key}")
	private String tmdbKey;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index", "key", tmdbKey);
	}
	
}
