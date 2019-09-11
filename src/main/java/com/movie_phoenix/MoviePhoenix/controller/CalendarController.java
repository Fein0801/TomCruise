package com.movie_phoenix.MoviePhoenix.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarRequestInitializer;

@Controller
public class CalendarController {
	
	@Value("${googleAPI.key}")
	private static String googleKey;
	
	public static final GoogleClientRequestInitializer KEY_INITIALIZER = new CalendarRequestInitializer(googleKey);
	private static Calendar client;
	
	
	public void getCalendar() {
		
	}
}
