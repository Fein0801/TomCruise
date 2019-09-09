package com.movie_phoenix.MoviePhoenix.util;

/**
 * Converts time between different formats
 * 
 * @author Ben
 */
public class TimeConverter {
	/**
	 * Converts time in minutes to hours and minutes 
	 * 
	 * @param minutes
	 * @return
	 */
	public static String minutesToHoursMinutes(int minutes) {
		int hours = minutes / 60;
		minutes = minutes % 60;
		
		return hours + " h, " + minutes + " m";
	}
}
