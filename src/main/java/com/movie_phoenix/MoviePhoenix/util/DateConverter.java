package com.movie_phoenix.MoviePhoenix.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;

/**
 * A class for converting dates between different formats. Why? So we can
 * display dates in any format
 * 
 * @author Ben Feinstein
 */
public class DateConverter {

	/**
	 * Converts a date in format "yyyy-mm-dd" to "mm/dd/yyyy"
	 * 
	 * @param s
	 * @return date in format "mm/dd/yyyy", returns the original string if incorrect
	 *         format
	 */
	public String dashToSlash(String s) {
		if (s.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
			try {
				LocalDate date = LocalDate.parse(s);
				int month = date.getMonthValue();
				int year = date.getYear();
				int day = date.getDayOfMonth();
				return String.format("%02d", month) + "/" + String.format("%02d", day) + "/"
						+ String.format("%04d", year);
			} catch (DateTimeParseException e) {
			}
		}
		return s;
	}

	/**
	 * Converts a date in format "mm/dd/yyyy" to "yyyy-mm-dd"
	 * 
	 * @param s
	 * @return date in format "yyyy-mm-dd", returns original string if incorrect
	 *         format
	 */
	public String slashToDash(String s) {
		if (s.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
			String[] parts = s.split("/");
			int year = Integer.parseInt(parts[2]);
			int month = Integer.parseInt(parts[0]);
			int day = Integer.parseInt(parts[1]);
			return String.format("%04d", year) + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
		}
		return s;
	}

	/**
	 * Converts a valid date to an english date. Example: January 1st, 2019. Can
	 * convert either "mm/dd/yyyy" or "yyyy-mm-dd"
	 * 
	 * @param s
	 * @return Date in english. Returns original string if incorrect format.
	 */
	public String getEnglishDate(String s) {
		LocalDate date;
		if (isValidDate(s) && s.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
			date = LocalDate.parse(s);
		} else if (isValidDate(s)) {
			date = LocalDate.parse(slashToDash(s));
		} else {
			return s;
		}
		String capitalizedMonth = getCapitalizedWord(date.getMonth().toString().toLowerCase());
		String dayOfMonth = getRankedNumber(date.getDayOfMonth());
		return capitalizedMonth + " " + dayOfMonth + ", " + date.getYear();
	}

	/**
	 * Validates a date based on the DateTimeParseException
	 * 
	 * @param s
	 * @return true if the date is valid by the java.time.LocalDate class, false if
	 *         the date is invalid
	 */
	public boolean isValidDate(String s) {
		try {
			if (s.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
				s = slashToDash(s);
			}
			@SuppressWarnings("unused")
			LocalDate date = LocalDate.parse(s);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		} catch(NullPointerException e) {
			return false;
		}
	}

	/**
	 * Takes a string in valid date format, and converts it to english month and
	 * day. Example: August 29th
	 * 
	 * @param date
	 * @return English month and day
	 */
	public String getEnglishMonthAndDay(String date) {
		LocalDate dateFormat;
		if (date.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
			dateFormat = LocalDate.parse(slashToDash(date));
		}

		try {
			dateFormat = LocalDate.parse(date);
		} catch (DateTimeParseException e) {
			return date;
		}
		return getCapitalizedWord(dateFormat.getMonth().toString().toLowerCase()) + " "
				+ getRankedNumber(dateFormat.getDayOfMonth());
	}

	/**
	 * Takes Integers for month and day, then converts them. Using this method is
	 * discouraged, as it will convert any number passed into the day parameter. You
	 * could get an invalid output, like January 32nd
	 * 
	 * @param month
	 * @param day
	 * @return
	 */
	public String getEnglishMonthAndDay(int month, int day) {
		return getCapitalizedWord(Month.of(month).toString().toLowerCase()) + " " + getRankedNumber(day);
	}

	/**
	 * Returns the year from a valid date in format "yyyy-mm-dd". Returns -1 if the
	 * string does not match the above format
	 * 
	 * @param date
	 * @return year
	 */
	public int getYearFromDate(String date) {
		try {
			LocalDate d = LocalDate.parse(date);
			return d.getYear();
		} catch (DateTimeParseException e) {
			return -1;
		}
	}

	/**
	 * Converts a number to its "ranked" form
	 * 
	 * examples: 4 becomes 4th, 2 becomes 2nd, 1 becomes 1st
	 * 
	 * @param dayOfMonth
	 * @return
	 */
	public String getRankedNumber(int dayOfMonth) {
		String str = Integer.toString(dayOfMonth);

		if (str.endsWith("1")) {
			return str + "st";
		} else if (str.endsWith("2")) {
			return str + "nd";
		} else if (str.endsWith("3")) {
			return str + "rd";
		} else {
			return str + "th";
		}
	}

	/**
	 * Converts word to lower case and then capitalizes the first letter
	 * 
	 * @param word
	 * @return
	 */
	public String getCapitalizedWord(String word) {
		if (word.length() < 2) {
			return word;
		}
		return word.substring(0, 1).toUpperCase() + word.toLowerCase().substring(1);
	}

}