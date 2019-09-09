package com.movie_phoenix.MoviePhoenix.entity.movie;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie_phoenix.MoviePhoenix.entity.Person;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmCreditsByTitle {
	@JsonProperty("Id")
	private Integer filmId;
	private ArrayList<Person> cast;
	private ArrayList<Person> crew;
	public FilmCreditsByTitle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Person> getCast() {
		return cast;
	}
	public void setCast(ArrayList<Person> cast) {
		this.cast = cast;
	}
	public ArrayList<Person> getCrew() {
		return crew;
	}
	public void setCrew(ArrayList<Person> crew) {
		this.crew = crew;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}
	

}
