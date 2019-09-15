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
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.movie_phoenix.MoviePhoenix.entity.MediaType;
import com.movie_phoenix.MoviePhoenix.entity.Person;
import com.movie_phoenix.MoviePhoenix.entity.PersonResults;
import com.movie_phoenix.MoviePhoenix.entity.movie.FilmCreditsByPerson;
import com.movie_phoenix.MoviePhoenix.entity.movie.Movie;
import com.movie_phoenix.MoviePhoenix.entity.movie.MovieResults;
import com.movie_phoenix.MoviePhoenix.entity.tv.TvCreditsByPerson;
import com.movie_phoenix.MoviePhoenix.entity.tv.TvShow;
import com.movie_phoenix.MoviePhoenix.entity.tv.TvShowResults;
import com.movie_phoenix.MoviePhoenix.repo.UserRepo;
import com.movie_phoenix.MoviePhoenix.service.GoogleService;
import com.movie_phoenix.MoviePhoenix.service.GoogleUser;

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
	private GoogleService gSuite;

	@Autowired
	private UserRepo repo;
	private GoogleUser currentUser;
	private String currentUserName;
	private static com.google.api.services.calendar.Calendar server;
	private static GoogleCredential userCredentials;

//	TvShow tvShow1 = new TvShow();

	private RestTemplate rt = new RestTemplate();

	// The base url for api
	public static final String BASE_URL = "https://api.themoviedb.org/3";

	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		StringBuilder urlParams = new StringBuilder(
				"?scope=profile https://www.googleapis.com/auth/calendar&client_id=");
		urlParams.append(clientId);
		urlParams.append("&redirect_uri=http://localhost:8080/verify&response_type=code&access_type=offline");
		mv.addObject("params", urlParams.toString());

		return mv;
	}

	@RequestMapping("/verify")
	public ModelAndView verify(@RequestParam("code") String code) {
		ModelAndView mv = new ModelAndView("index", "accessCode", code);
		String test = "";
		try {
			// These three lines shall never be deleted! We need id tokens!!!
			GoogleAuthorizationCodeTokenRequest request = gSuite.getTokenRequest(code);
			GoogleTokenResponse response = gSuite.getTokenResponse(request);
			GoogleIdToken idToken = gSuite.getIdToken(response);
			String refreshToken = gSuite.getRefreshToken(response);
			gSuite.setRefreshToken(refreshToken);
			GoogleCredential credentials = gSuite.authorize();
			userCredentials = credentials;
			server = getCalendarServer();

			String name = idToken.getPayload().get("given_name").toString();
			mv.addObject("name", name);

			GoogleUser user = gSuite.parseGoogleUser(idToken);
			currentUser = user;
			currentUserName = user.getName();

			if (!repo.existsByName(user.getName())) {
				Calendar cal = new Calendar();

				cal.setSummary("Movie Phoenix");
				cal.setTimeZone("America/Detroit");

				Calendar createdCal = server.calendars().insert(cal).execute();
				user.setCalendarId(createdCal.getId());
				repo.save(user);
			} else {
				user = repo.findByName(user.getName());
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("What's going on?");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

//		String s = tvShow1.getFirstAirDate();

		try {
//			String englishDate = DateConverter.getEnglishDate(s);
//			tvShow1.setFirstAirDate(englishDate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.addObject("tvResults", response.getResults());

		return mv;
	}

	@RequestMapping("/person-details")
	public ModelAndView personDetails(@RequestParam("id") String id, @RequestParam("credit_type") MediaType type) {
		ModelAndView mv = new ModelAndView("person-details");
		String url1 = BASE_URL + "/person/" + id + "?api_key=" + mainKey;
		Person response = rt.getForObject(url1, Person.class);
		mv.addObject("pDeets", response);
		if (type == MediaType.MOVIE) {
			// Film credits are a separate url
			String url2 = BASE_URL + "/person/" + id + "/movie_credits?api_key=" + mainKey;
			FilmCreditsByPerson response1 = rt.getForObject(url2, FilmCreditsByPerson.class);
			mv.addObject("pKnown", response1);
		} else {
			String url2 = BASE_URL + "/person/" + id + "/tv_credits?api_key=" + mainKey;
			TvCreditsByPerson response1 = rt.getForObject(url2, TvCreditsByPerson.class);
			mv.addObject("pKnown", response1);
		}
		mv.addObject("creditType", type.ordinal());

		return mv;
	}

	@RequestMapping("/movie-details")
	public ModelAndView movieDetails(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("movie-details");
		String url = BASE_URL + "/movie/" + id + "?api_key=" + mainKey;
		Movie response = rt.getForObject(url, Movie.class);
		mv.addObject("movieDeets", response);
		return mv;
	}

	@RequestMapping("/tv-details")
	public ModelAndView tvDetails(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView("tv-details");
		String url = BASE_URL + "/tv/" + id + "?api_key=" + mainKey;
		TvShow response = rt.getForObject(url, TvShow.class);
		mv.addObject("tvDeets", response);
		return mv;
	}

	@RequestMapping("/home-page")
	public ModelAndView home() {
		return new ModelAndView("index");
	}

	@RequestMapping("/calendar-test")
	public ModelAndView calTest() {
		return new ModelAndView("calendar-test");
	}

	@RequestMapping("/add-event")
	public ModelAndView event(@RequestParam("title") String summary, @RequestParam("startTime") String startTime,
			@RequestParam("endTime") String endTime, @RequestParam("description") String description)
			throws IOException {
		System.out.println(currentUserName);

		currentUser = repo.findByName(currentUserName);
		String calendarId = currentUser.getCalendarId();

		Event event = new Event();
//		startTime and endTime return in format "2019-09-21T16:00", half of what we need, so we add
//		seconds and time zone.
		DateTime startDateTime = new DateTime(startTime + ":00-04:00");
		EventDateTime start = new EventDateTime().setDateTime(startDateTime).setTimeZone("America/Detroit");
		event.setStart(start);

		DateTime endDateTime = new DateTime(endTime + ":00-04:00");
		EventDateTime end = new EventDateTime().setDateTime(endDateTime).setTimeZone("America/Detroit");
		event.setEnd(end);

		event.setSummary(summary);
		event.setDescription(description);
		event = server.events().insert(calendarId, event).execute();
		return new ModelAndView("index");
	}

	public static com.google.api.services.calendar.Calendar getCalendarServer() {
		if (server == null) {
			server = new com.google.api.services.calendar.Calendar.Builder(new NetHttpTransport(),
					JacksonFactory.getDefaultInstance(), userCredentials).setApplicationName("Movie Phoenix").build();
		}
		return server;
	}

}
