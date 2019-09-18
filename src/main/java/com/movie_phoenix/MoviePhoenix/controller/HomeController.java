/**
 * 
 */
package com.movie_phoenix.MoviePhoenix.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
import com.movie_phoenix.MoviePhoenix.entity.FavsActor;
import com.movie_phoenix.MoviePhoenix.entity.ResultType;
import com.movie_phoenix.MoviePhoenix.entity.Person;
import com.movie_phoenix.MoviePhoenix.entity.PersonResults;
import com.movie_phoenix.MoviePhoenix.entity.movie.Credits;
import com.movie_phoenix.MoviePhoenix.entity.movie.FavsMovie;
import com.movie_phoenix.MoviePhoenix.entity.movie.FilmCreditsByPerson;
import com.movie_phoenix.MoviePhoenix.entity.movie.Movie;
import com.movie_phoenix.MoviePhoenix.entity.movie.MovieCast;
import com.movie_phoenix.MoviePhoenix.entity.movie.MovieCrew;
import com.movie_phoenix.MoviePhoenix.entity.movie.MovieResults;
import com.movie_phoenix.MoviePhoenix.entity.tv.FavsTv;
import com.movie_phoenix.MoviePhoenix.entity.tv.TvCast;
import com.movie_phoenix.MoviePhoenix.entity.tv.TvCredits;
import com.movie_phoenix.MoviePhoenix.entity.tv.TvCreditsByPerson;
import com.movie_phoenix.MoviePhoenix.entity.tv.TvCrew;
import com.movie_phoenix.MoviePhoenix.entity.tv.TvShow;
import com.movie_phoenix.MoviePhoenix.entity.tv.TvShowResults;
import com.movie_phoenix.MoviePhoenix.repo.FavActorRepo;
import com.movie_phoenix.MoviePhoenix.repo.FavMovieRepo;
import com.movie_phoenix.MoviePhoenix.repo.FavTvRepo;
import com.movie_phoenix.MoviePhoenix.repo.UserRepo;
import com.movie_phoenix.MoviePhoenix.service.GoogleService;
import com.movie_phoenix.MoviePhoenix.service.GoogleUser;
import com.movie_phoenix.MoviePhoenix.util.DateConverter;

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
	private UserRepo userRepo;

	@Autowired
	private FavActorRepo actorRepo;
	
	@Autowired
	private FavMovieRepo movieRepo;
	
	@Autowired
	private FavTvRepo tvRepo;
	private DateConverter dc;

	private GoogleUser currentUser;
	private String currentUserName;
	private static com.google.api.services.calendar.Calendar server;
	private static GoogleCredential userCredentials;

	private LocalDate today;

//	TvShow tvShow1 = new TvShow();

	private RestTemplate rt = new RestTemplate();

	// The base url for api
	public static final String BASE_URL = "https://api.themoviedb.org/3";

	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		String redirectUri = "http://localhost:8080/verify";
//		String redirectUri = "https://movie-phoenix.herokuapp.com/verify";
		StringBuilder urlParams = new StringBuilder(
				"?scope=profile email https://www.googleapis.com/auth/calendar&client_id=");
		urlParams.append(clientId);
		urlParams.append("&redirect_uri=" + redirectUri + "&response_type=code&access_type=offline");
		mv.addObject("params", urlParams.toString());

		return mv;
	}

	@RequestMapping("/verify")
	public ModelAndView verify(@RequestParam("code") String code) {
		ModelAndView mv = new ModelAndView("redirect:/home-page");
		String test = "";
		try {
			today = LocalDate.now();
			// These three lines shall never be deleted! We need id tokens!!!
			GoogleAuthorizationCodeTokenRequest request = gSuite.getTokenRequest(code);
			GoogleTokenResponse response = gSuite.getTokenResponse(request);
			GoogleIdToken idToken = gSuite.getIdToken(response);
			String refreshToken = gSuite.getRefreshToken(response);
			gSuite.setRefreshToken(refreshToken);
			GoogleCredential credentials = gSuite.authorize();
			userCredentials = credentials;
			server = getCalendarServer();

			GoogleUser user = gSuite.parseGoogleUser(idToken);
			currentUserName = user.getFirstName();
			System.out.println(user.getEmail());

			if (!userRepo.existsByEmail(user.getEmail())) {
				Calendar cal = new Calendar();

				cal.setSummary("Movie Phoenix");
				cal.setTimeZone("America/Detroit");

				Calendar createdCal = server.calendars().insert(cal).execute();
				user.setCalendarId(createdCal.getId());
				userRepo.save(user);
			} else {
				user = userRepo.findByEmail(user.getEmail());
			}
			currentUser = user;

		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("What's going on?");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/test")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView("test-page");
		return mv;
	}

	@RequestMapping("/person-search")
	public ModelAndView personResult(@RequestParam("query") String query) {
		ModelAndView mv = new ModelAndView("person-results");
		mv.addObject("name", currentUser.getFirstName());
		mv.addObject("dc", dc);
		mv.addObject("query", query);
		String url = BASE_URL + "/search/person?api_key=" + mainKey + "&query=" + query;
		PersonResults response = rt.getForObject(url, PersonResults.class);
		mv.addObject("personResults", response.getResults());
		return mv;
	}

	@RequestMapping("/movie-search")
	public ModelAndView movieResult(@RequestParam("query") String query) {
		ModelAndView mv = new ModelAndView("movie-results");
		mv.addObject("name", currentUser.getFirstName());
		mv.addObject("dc", dc);
		mv.addObject("query", query);
		String url = BASE_URL + "/search/movie?api_key=" + mainKey + "&query=" + query;
		MovieResults response = rt.getForObject(url, MovieResults.class);
		mv.addObject("movieResults", response.getResults());
		return mv;
	}

	@RequestMapping("/tv-search")
	public ModelAndView tvResult(@RequestParam("query") String query) {
		ModelAndView mv = new ModelAndView("tv-results");
		mv.addObject("dc", dc);
		mv.addObject("name", currentUser.getFirstName());
		mv.addObject("query", query);
		String url = BASE_URL + "/search/tv?api_key=" + mainKey + "&query=" + query;
		TvShowResults response = rt.getForObject(url, TvShowResults.class);
		mv.addObject("tvResults", response.getResults());

		return mv;
	}

	@RequestMapping("/person-details")
	public ModelAndView personDetails(@RequestParam("id") Integer id, @RequestParam("credit_type") ResultType type) {
		ModelAndView mv = new ModelAndView("person-details");
		mv.addObject("name", currentUser.getFirstName());
		mv.addObject("dc", dc);
		String url1 = BASE_URL + "/person/" + id + "?api_key=" + mainKey;
		Person response = rt.getForObject(url1, Person.class);
		mv.addObject("pDeets", response);
		if (type == ResultType.MOVIE) {
			// Film credits are a separate url
			String url2 = BASE_URL + "/person/" + id + "/movie_credits?api_key=" + mainKey;
			FilmCreditsByPerson response1 = rt.getForObject(url2, FilmCreditsByPerson.class);
			ArrayList<Movie> cast = response1.getCast();
			Collections.sort(cast, Collections.reverseOrder());
//			mv.addObject("unreleased", unreleased);
			mv.addObject("cast", cast);
		} else {
			String url2 = BASE_URL + "/person/" + id + "/tv_credits?api_key=" + mainKey;
			TvCreditsByPerson response1 = rt.getForObject(url2, TvCreditsByPerson.class);
			mv.addObject("pKnown", response1);
		}
		mv.addObject("creditType", type.ordinal());
		

		return mv;
	}

	@RequestMapping("/movie-details")
	public ModelAndView movieDetails(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView("movie-details");
		mv.addObject("name", currentUser.getFirstName());
		String unrecognizedChar = "’";
		Movie returnedMovie = getMovieById(id);
		String summary = returnedMovie.getOverview().replace(unrecognizedChar, "\'");
		returnedMovie.setOverview(summary);
		mv.addObject("movieDeets", returnedMovie);
		boolean upcoming = false;
		String releaseDate = returnedMovie.getReleaseDate();
		if(releaseDate != null && !releaseDate.equals("") && today.compareTo(LocalDate.parse(releaseDate)) <= 0) {
			upcoming = true;
		}
		mv.addObject("upcoming", upcoming);
		returnedMovie.setReleaseDate(dc.getEnglishDate(releaseDate));
		
		System.out.println(upcoming);
		String url1 = BASE_URL + "/movie/" + id + "/credits?api_key=" + mainKey;
		Credits response1 = rt.getForObject(url1, Credits.class);
		ArrayList<MovieCast> cast = response1.getCast();
		mv.addObject("actors", cast);
		// No need to call the api twice lol. If it turns out I'm wrong, we can add those lines back in.
//		String url2 = BASE_URL + "/movie/" + id + "/credits?api_key=" + mainKey;
//		Credits response2 = rt.getForObject(url2, Credits.class);
		ArrayList<MovieCrew> crew = response1.getCrew();
		mv.addObject("crewMen", crew);
		return mv;
	}

	@RequestMapping("/tv-details")
	public ModelAndView tvDetails(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView("tv-details");
		mv.addObject("name", currentUser.getFirstName());
		mv.addObject("dc", dc);
		TvShow response = getTvShowById(id);
		mv.addObject("tvDeets", response);
		String url1 = BASE_URL + "/tv/" + id + "/credits?api_key=" + mainKey;
		TvCredits response1 = rt.getForObject(url1, TvCredits.class);
		ArrayList<TvCast> cast = response1.getCast();
		mv.addObject("actors", cast);
		String url2 = BASE_URL + "/tv/" + id + "/credits?api_key=" + mainKey;
		TvCredits response2 = rt.getForObject(url2, TvCredits.class);
		ArrayList<TvCrew> crew = response2.getCrew();
		mv.addObject("crewMen", crew);
		return mv;
	}
	@RequestMapping("/all-search")
	public ModelAndView searchAll(@RequestParam("query")String query) {
		ModelAndView mv = new ModelAndView("all-search");
		mv.addObject("dc", dc);
		mv.addObject("name", currentUser.getFirstName());
		mv.addObject("query", query);
		String url = BASE_URL + "/search/tv?api_key=" + mainKey + "&query=" + query;
		TvShowResults response = rt.getForObject(url, TvShowResults.class);
		mv.addObject("tvResults", response.getResults());
		String url1 = BASE_URL + "/search/movie?api_key=" + mainKey + "&query=" + query;
		MovieResults response1 = rt.getForObject(url1, MovieResults.class);
		mv.addObject("movieResults", response1.getResults());
		String url2 = BASE_URL + "/search/person?api_key=" + mainKey + "&query=" + query;
		PersonResults response2 = rt.getForObject(url2, PersonResults.class);
		mv.addObject("personResults", response2.getResults());
		return mv;
	}

	@RequestMapping("/home-page")
	public ModelAndView home() {
		if (currentUser != null) {
			return new ModelAndView("index", "name", currentUser.getFirstName());
		} else {
			return new ModelAndView("index");
		}
	}

	@RequestMapping("/calendar-test")
	public ModelAndView calTest() {
		return new ModelAndView("calendar-test");
	}

	@RequestMapping("/add-event")
	public ModelAndView event(@RequestParam("title") String summary, @RequestParam("startTime") String startTime,
			@RequestParam("endTime") String endTime, @RequestParam("description") String description, @RequestParam("date") String date)
			throws IOException {
		
		String calendarId = "";
		if(currentUser != null) {
			calendarId = currentUser.getCalendarId();
		}

		Event event = new Event();
//		startTime and endTime return in format "2019-09-21T16:00", half of what we need, so we add
//		seconds and time zone.
		DateTime startDateTime = new DateTime(date + "T" + startTime + ":00-04:00");
		System.out.println("start time: " + startTime);
		EventDateTime start = new EventDateTime().setDateTime(startDateTime).setTimeZone("America/Detroit");
		event.setStart(start);
		

		DateTime endDateTime = new DateTime(date + "T" + endTime + ":00-04:00");
		System.out.println("end time: "+ endTime);
		EventDateTime end = new EventDateTime().setDateTime(endDateTime).setTimeZone("America/Detroit");
		event.setEnd(end);
		

		event.setSummary(summary);
		event.setDescription(description);
		event = server.events().insert(calendarId, event).execute();
		System.out.println(event.toString());
		return new ModelAndView("index");
	}

	public static com.google.api.services.calendar.Calendar getCalendarServer() {
		if (server == null) {
			server = new com.google.api.services.calendar.Calendar.Builder(new NetHttpTransport(),
					JacksonFactory.getDefaultInstance(), userCredentials).setApplicationName("Movie Phoenix").build();
		}
		return server;
	}

	@RequestMapping("/add-fav")
	public ModelAndView addFav(@RequestParam("type") String type, @RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", currentUser.getFirstName());
		Integer userId = currentUser.getEntryId();
		if (type.equals("person")) {
			String url1 = BASE_URL + "/person/" + id + "?api_key=" + mainKey;
			Person response = rt.getForObject(url1, Person.class);
			List<FavsActor> faves = actorRepo.findByUserAndActor(id, userId);
			if (faves.size() == 0) {
				FavsActor favAct = new FavsActor(id, response.getName(), response.getImageUrl(), currentUser);
				actorRepo.save(favAct);
			}
			mv.setViewName("redirect:/person-details?id=" + id + "&credit_type=MOVIE");
		} else if (type.equals("movie")) {
			String url = BASE_URL + "/movie/" + id + "?api_key=" + mainKey;
			Movie response = rt.getForObject(url, Movie.class);
			List<FavsMovie> faves = movieRepo.findByUserAndMovie(id, userId);
			if(faves.size() == 0) {
				FavsMovie favMov = new FavsMovie(id, userId, response.getTitle(), response.getPosterUrl());
				movieRepo.save(favMov);
			}
			mv.setViewName("redirect:/movie-details?id=" + id);
		} else if (type.equals("tv")) {
			String url = BASE_URL + "/tv/" + id + "?api_key=" + mainKey;
			TvShow response = rt.getForObject(url, TvShow.class);
			List<FavsTv> faves = tvRepo.findByUserAndShow(id, userId);
			if(faves.size() == 0) {
				FavsTv favTv = new FavsTv(id, response.getName(), userId, response.getImageUrl());
				tvRepo.save(favTv);
			}
			mv.setViewName("redirect:/tv-details?id=" + id);
		}
		return mv;
	}

	@RequestMapping("/view-favs")
	public ModelAndView displayFavs() {
		ModelAndView mv = new ModelAndView("favorites");
		mv.addObject("name", currentUser.getFirstName());
		mv.addObject("favActors", actorRepo.findByUser(currentUser));
		mv.addObject("favMovies", movieRepo.findByUserId(currentUser.getEntryId()));
		mv.addObject("favTv", tvRepo.findByUserId(currentUser.getEntryId()));
		return mv;
	}
	
	@RequestMapping("/schedule-viewing")
	public ModelAndView scheduleViewing(@RequestParam("movie_id") Integer movieId) {
		ModelAndView mv = new ModelAndView("schedule-movie-date");
		Movie movie = getMovieById(movieId);
		mv.addObject("movie", movie);
		return mv;
	}
	
	@RequestMapping("/remove-favorite")
	public ModelAndView removeFavorite(@RequestParam("id") Integer entryId, @RequestParam("type") ResultType type) {
		if(type == ResultType.MOVIE) {
			movieRepo.deleteById(entryId);
		} else if (type == ResultType.PERSON) {
			actorRepo.deleteById(entryId);
		} else if (type == ResultType.TV) {
			tvRepo.deleteById(entryId);
		}
		return new ModelAndView("redirect:/view-favs"); //TODO stuff
	}
	
	public Movie getMovieById(int id) {
		String url = BASE_URL + "/movie/" + id + "?api_key=" + mainKey;
		Movie response = rt.getForObject(url, Movie.class);
		return response;
	}
	
	public TvShow getTvShowById(int id) {
		String url = BASE_URL + "/tv/" + id + "?api_key=" + mainKey;
		TvShow response = rt.getForObject(url, TvShow.class);
		return response;
	}
	
	public Person getPersonById(int id) {
		String url1 = BASE_URL + "/person/" + id + "?api_key=" + mainKey;
		Person response = rt.getForObject(url1, Person.class);
		return response;
	}
	@RequestMapping("/check-calendar")
	public ModelAndView fCal() {
		ModelAndView mv = new ModelAndView("face");
		return mv;
	}

}
