package com.movie_phoenix.MoviePhoenix.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TvCreditsByTitle {
	@JsonProperty("Id")
	private Integer filmId;
	private ArrayList<Person> cast;
	private ArrayList<Person> crew;
	public TvCreditsByTitle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return filmId;
	}
	public void setId(Integer id) {
		filmId = id;
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

}
