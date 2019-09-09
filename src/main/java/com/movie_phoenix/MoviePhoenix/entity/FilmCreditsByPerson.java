package com.movie_phoenix.MoviePhoenix.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmCreditsByPerson {
	
	private Integer Id;
	private ArrayList<Movie> cast;
	private ArrayList<Movie> crew;
	public FilmCreditsByPerson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public ArrayList<Movie> getCast() {
		return cast;
	}
	public void setCast(ArrayList<Movie> cast) {
		this.cast = cast;
	}
	public ArrayList<Movie> getCrew() {
		return crew;
	}
	public void setCrew(ArrayList<Movie> crew) {
		this.crew = crew;
	}
	

}
